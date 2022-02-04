package com.tef.rabbitmq.controller;


import com.tef.librabbitmq.constantes.RabbitMQConstantes;
import com.tef.librabbitmq.dto.EstoqueDTO;
import com.tef.rabbitmq.services.RabbitmqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/estoques")
public class EstoqueController
{

	@Autowired
	private RabbitmqService rabbitmqService;


	@PutMapping
	public ResponseEntity<EstoqueDTO> update(@RequestBody EstoqueDTO estoqueDTO)
	{
		rabbitmqService.enviaMsg(RabbitMQConstantes.FILA_ESTOQUE, estoqueDTO);
		return new ResponseEntity(HttpStatus.OK);
	}


}

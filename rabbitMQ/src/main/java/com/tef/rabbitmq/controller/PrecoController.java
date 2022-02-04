package com.tef.rabbitmq.controller;


import com.tef.librabbitmq.constantes.RabbitMQConstantes;
import com.tef.librabbitmq.dto.PrecoDTO;
import com.tef.rabbitmq.services.RabbitmqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/precos")
public class PrecoController
{


	@Autowired
	private RabbitmqService rabbitmqService;

	@PutMapping
	public ResponseEntity<PrecoDTO> update(@RequestBody PrecoDTO precoDTO)
	{
		rabbitmqService.enviaMsg(RabbitMQConstantes.FILA_PRECO, precoDTO);
		return new ResponseEntity(HttpStatus.OK);
	}


}

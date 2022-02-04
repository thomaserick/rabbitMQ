package com.tef.estoqueconsumer.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tef.librabbitmq.constantes.RabbitMQConstantes;
import com.tef.librabbitmq.dto.EstoqueDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EstoqueConsumer
{

	@RabbitListener(queues = RabbitMQConstantes.FILA_ESTOQUE)
	private void consumidor(String msg) throws InterruptedException, JsonProcessingException
	{
		EstoqueDTO estoqueDTO = new ObjectMapper().readValue(msg,EstoqueDTO.class);


		System.out.println(estoqueDTO.getCodigoProduto());
		System.out.println(estoqueDTO.getQuantidade());
		System.out.println("----------------------------");

		Thread.sleep(120000);

	}
}

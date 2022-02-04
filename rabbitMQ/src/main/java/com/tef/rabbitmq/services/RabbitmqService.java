package com.tef.rabbitmq.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitmqService
{

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private ObjectMapper objectMapper;


	public void enviaMsg(String nomeFila, Object msg)
	{
		try
		{
			String jsonData = objectMapper.writeValueAsString(msg);
			rabbitTemplate.convertAndSend(nomeFila, jsonData);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}

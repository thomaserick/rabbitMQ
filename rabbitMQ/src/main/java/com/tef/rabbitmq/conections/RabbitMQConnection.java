package com.tef.rabbitmq.conections;


import com.tef.librabbitmq.constantes.RabbitMQConstantes;
import javax.annotation.PostConstruct;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConnection
{

	private AmqpAdmin amqpAdmin;

	public RabbitMQConnection(AmqpAdmin amqpAdmin)
	{
		this.amqpAdmin = amqpAdmin;
	}

	private Queue fila(String nomeFila)
	{
		return new Queue(nomeFila, true, false, false);
	}


	//Troca direta
	//Recebe as mensagam e direcionar especificamente para a fila
	private DirectExchange exchange()
	{
		return new DirectExchange(RabbitMQConstantes.NOME_EXCHANGE);
	}

	//Relacionamento com a Fila
	private Binding relacionamento(Queue fila, DirectExchange exchange)
	{
		return 	new Binding(fila.getName(), Binding.DestinationType.QUEUE, exchange.getName(), fila.getName(),
			null);
	}


	@PostConstruct
	private void adiciona()
	{
		Queue filaEstoque = this.fila(RabbitMQConstantes.FILA_ESTOQUE);
		Queue filaPreco = this.fila(RabbitMQConstantes.FILA_PRECO);

		DirectExchange troca = this.exchange();

		Binding ligacaoEstoque = this.relacionamento(filaEstoque,troca);
		Binding ligacaoPreco = this.relacionamento(filaPreco,troca);

		this.amqpAdmin.declareQueue(filaEstoque);
		this.amqpAdmin.declareQueue(filaPreco);

		this.amqpAdmin.declareExchange(troca);
		this.amqpAdmin.declareBinding(ligacaoEstoque);
		this.amqpAdmin.declareBinding(ligacaoPreco);
	}
}

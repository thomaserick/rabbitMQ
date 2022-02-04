# Microserviço em Java Spring Boot com RabbitMQ

Este projeto é a criação de um microserviço reponsável por receber requisições e gerar mensagens para os demais microsserviços, que são os consumidores da mensagem.
Dividido em 3 projetos:

1.librebbitmq = contém os nomes das constantes e DTOs
2.rabbitmq = Cria as filas e envia as mensagens ao servidor RabbitMQ
3.estoque-consumer = consome as mensagens (processa) 



### Spring
- Serializable - Possibilita que objeto seja transformado em uma sequência de bytes


### RabbitMQ
- Precisa configurar um container docker para subir o servidor rabbitMQ

- Perfecth Count
  - É um limitador de mensagens não confirmadas a serem enviadas a consumidores que 
  - ficara em um buffer em memória
  - Calcular ~ (T.entrega + T.volta) / T.processamento
- ACK
  - Confirmação de leitura da mensagem


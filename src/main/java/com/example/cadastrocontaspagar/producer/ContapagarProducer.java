package com.example.cadastrocontaspagar.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.cadastrocontaspagar.config.RabbitConfig;
import com.example.cadastrocontaspagar.model.Contaspagar; // <-- add this, adjust package as needed

@Component
public class ContapagarProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendContapagar(Contaspagar contapagar) {
        String json = "{ \"id\": " + contapagar.getId() +
                    ", \"descricao\": \"" + contapagar.getDescricao() +
                    "\", \"valor\": " + contapagar.getValor() +
                    ", \"dataVencimento\": \"" + contapagar.getDataVencimento() + "\"}";
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, RabbitConfig.ROUTING_KEY, json);
    }
}
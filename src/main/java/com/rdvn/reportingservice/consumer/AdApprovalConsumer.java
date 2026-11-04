package com.rdvn.reportingservice.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class AdApprovalConsumer {
    @RabbitListener(queues = "ad-approval-queue")
    public void processOrder(Long id){
        System.out.println("Onaylanan ilan ID: " + id);
    }


}

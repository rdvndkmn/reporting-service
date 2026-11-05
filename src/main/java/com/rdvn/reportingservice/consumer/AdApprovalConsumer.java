package com.rdvn.reportingservice.consumer;

import com.rdvn.reportingservice.service.ReportService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class AdApprovalConsumer {

    private final ReportService reportService;

    public AdApprovalConsumer(ReportService reportService) {
        this.reportService = reportService;
    }

    @RabbitListener(queues = "ad-approval-queue")
    public void processOrder(Long id) {
        System.out.println("Onaylanan ilan ID: " + id);

        reportService.createReport(id);
    }
}
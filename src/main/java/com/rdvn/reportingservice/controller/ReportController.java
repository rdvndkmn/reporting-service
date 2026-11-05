package com.rdvn.reportingservice.controller;

import com.rdvn.reportingservice.entity.Report;
import com.rdvn.reportingservice.service.ReportService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/{adId}")
    public Report getReport(@PathVariable Long adId) {
        return reportService.getReport(adId);
    }

    @PutMapping("/{adId}")
    public Report updateReport(@PathVariable Long adId) {
        return reportService.updateReport(adId);
    }
}
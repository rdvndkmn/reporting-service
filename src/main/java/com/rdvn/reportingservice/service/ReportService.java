package com.rdvn.reportingservice.service;

import com.rdvn.reportingservice.client.AdServiceClient;
import com.rdvn.reportingservice.dto.AdDetailResponse;
import com.rdvn.reportingservice.entity.Report;
import com.rdvn.reportingservice.repository.ReportRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class ReportService {

    private final AdServiceClient adServiceClient;
    private final ReportRepository reportRepository;

    public ReportService(AdServiceClient adServiceClient,
                         ReportRepository reportRepository) {
        this.adServiceClient = adServiceClient;
        this.reportRepository = reportRepository;
    }

    public void createReport(Long adId) {

        AdDetailResponse adDetail = adServiceClient.getIlan(adId);

        String reportText = buildReportText(adDetail);

        Report report = new Report(adId, reportText);

        reportRepository.save(report);
    }

    public Report getReport(Long adId) {

        return reportRepository.findByAdId(adId)
                .orElseThrow(() ->
                        new RuntimeException("Bu ilana ait rapor bulunamadı"));
    }

    public Report updateReport(Long adId) {

        Report report = reportRepository.findByAdId(adId)
                .orElseThrow(() -> new RuntimeException("Bu ilana ait rapor bulunamadı"));//eğer değer varsa bana ver yoksa hata fırlat

        AdDetailResponse adDetail = adServiceClient.getIlan(adId);

        String updatedReportText = buildReportText(adDetail);

        report.setReportText(updatedReportText);
        report.setUpdatedAt(LocalDateTime.now());

        return reportRepository.save(report);
    }

    private String buildReportText(AdDetailResponse adDetail) {

        long dayDifference = ChronoUnit.DAYS.between(
                adDetail.getCreatedAt(),
                LocalDateTime.now()
        );

        return adDetail.getTitle()
                + " ilanı "
                + adDetail.getUserName()
                + " kullanıcısı tarafından "
                + dayDifference
                + " gün önce oluşturulmuştur. İlan "
                + adDetail.getViewCount()
                + " kere görüntülenmiştir.";
    }
}
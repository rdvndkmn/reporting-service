package com.rdvn.reportingservice.entity;

import jakarta.persistence.*;
import org.w3c.dom.Text;

import java.time.LocalDateTime;

@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long adId;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String reportText;
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    public Report() {
    }

    public Report(Long adId, String reportText) {
        this.adId = adId;
        this.reportText = reportText;
    }

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public Long getAdId(){return adId;}
    public void setAdId(Long adId){this.adId=adId;}
    public String getReportText(){return reportText;}
    public void setReportText(String reportText){this.reportText=reportText;}
    public LocalDateTime getCreatedAt(){return createdAt;}
    public void setCreatedAt(LocalDateTime createdAt){this.createdAt=createdAt;}
    public LocalDateTime getUpdatedAt(){return updatedAt;}
    public void setUpdatedAt(LocalDateTime updatedAt){this.updatedAt=updatedAt;}


}

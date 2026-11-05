package com.rdvn.reportingservice.client;

import com.rdvn.reportingservice.dto.AdDetailResponse;
import org.springframework.web.client.RestClient;
import org.springframework.stereotype.Component;

@Component
public class AdServiceClient {
    private final RestClient restClient;

    public AdServiceClient(RestClient restClient){
        this.restClient= restClient;

    }

    public AdDetailResponse getIlan(Long adId){

        return restClient.get()
                .uri("/api/internal/ads/{id}/report-detail", adId)
                .retrieve()//isteği gönder ve response'u al
                .body(AdDetailResponse.class);//gelen JSON'u AdDetailResponse nesnesine çevir

    }


}

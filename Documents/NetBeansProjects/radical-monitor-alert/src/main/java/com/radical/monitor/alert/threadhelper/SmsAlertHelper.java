/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.radical.monitor.alert.threadhelper;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.radical.monitor.alert.model.EmailMessage;
import com.radical.monitor.alert.model.MessageDetails;
import java.awt.PageAttributes;
import java.util.Collections;
import java.util.List;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author emmanuel.idoko
 */
//@Component
public class SmsAlertHelper {

    private static final Logger logger = LoggerFactory.getLogger(SmsAlertHelper.class);
    RestTemplate restTemplate = new RestTemplate();
    private final String username = "emmanuel.idoko";
    private final String password = "Password@1";
    private final String smsUrl = "http://localhost:8080/api/radicalmonitor/v1/sendbulktext";

    public void sendSingleTextMessage(MessageDetails message) throws UnirestException {
        Gson gson = new Gson();
        String payload = gson.toJson(message);
        HttpResponse<JsonNode> jsonResponse = Unirest.post(smsUrl)
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(payload)
                .asJson();
        //Gson gson = new Gson();
        //String payload = gson.toJson(message);

        //String response = restTemplate.postForObject(smsUrl, payload, String.class);
        logger.info("response from the endpoint::" + jsonResponse.getStatus());

    }
    public void sendBulkTextMessage(List<MessageDetails> messages) throws UnirestException {
        Gson gson = new Gson();
        String payload = gson.toJson(messages);
        HttpResponse<JsonNode> jsonResponse = Unirest.post(smsUrl)
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(payload)
                .asJson();
        //Gson gson = new Gson();
        //String payload = gson.toJson(message);

        //String response = restTemplate.postForObject(smsUrl, payload, String.class);
        logger.info("response from the endpoint::" + jsonResponse.getStatus());

    }
    
    public void sendSingleEmailMessage(EmailMessage message) throws UnirestException {
        Gson gson = new Gson();
        String payload = gson.toJson(message);
        HttpResponse<JsonNode> jsonResponse = Unirest.post(smsUrl)
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(payload)
                .asJson();
        //Gson gson = new Gson();
        //String payload = gson.toJson(message);

        //String response = restTemplate.postForObject(smsUrl, payload, String.class);
        logger.info("response from the single email endpoint::" + jsonResponse.getStatus());

    }
    
    public void sendBulkEmailMessage(EmailMessage message) throws UnirestException {
        Gson gson = new Gson();
        String payload = gson.toJson(message);
        HttpResponse<JsonNode> jsonResponse = Unirest.post(smsUrl)
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(payload)
                .asJson();
        //Gson gson = new Gson();
        //String payload = gson.toJson(message);

        //String response = restTemplate.postForObject(smsUrl, payload, String.class);
        logger.info("response from the bulk email endpoint::" + jsonResponse.getStatus());

    }

    public void querySentMessages() {
        String endpoint = "http://107.20.199.106/restapi/sms/1/reports";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "Basic " + Util.getEncodeCredentials(username, password));
        Response resp = restTemplate.getForObject(endpoint, Response.class);
        HttpEntity<String> entity = new HttpEntity<>(headers);

    }
}

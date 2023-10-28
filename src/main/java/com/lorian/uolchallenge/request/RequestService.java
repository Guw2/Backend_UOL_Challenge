package com.lorian.uolchallenge.request;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import jakarta.annotation.PostConstruct;
import lombok.Getter;

@Service
@Getter
public class RequestService {
    
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    Environment environment;

    private List<String> codinomesAvengers = new ArrayList<>();
    private List<String> codinomesJL = new ArrayList<>();

    @PostConstruct
    public void captureRequestApiJSON(){

        try{
            String codinome = restTemplate.getForObject(environment.getProperty("avengers"), String.class);

            JsonNode jsonNode = objectMapper.readTree(codinome);

            ArrayNode nodes = (ArrayNode) jsonNode.get("vingadores");

            for(JsonNode jn : nodes){
                codinomesAvengers.add(jn.get("codinome").asText());
            }

        }catch(Exception e){
            e.printStackTrace();
        }

    };

    @PostConstruct
    public void captureRequestApiXML(){
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(environment.getProperty("justice.league"));

            NodeList nodes = document.getElementsByTagName("codinome");

            for(int i = 0; i < nodes.getLength(); i++){
                codinomesJL.add(nodes.item(i).getTextContent());
            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}

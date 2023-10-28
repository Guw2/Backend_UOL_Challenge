package com.lorian.uolchallenge.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lorian.uolchallenge.enums.GroupType;

@Component
public class RequestHandler {

    @Autowired
    RequestService service;

    public String findCodinome(GroupType groupType){
        if(groupType == GroupType.AVENGERS){
            String codinome = service.getCodinomesAvengers().stream().findFirst().orElseThrow();
            service.getCodinomesAvengers().remove(codinome);
            return codinome;
        }
        String codinome = service.getCodinomesJL().stream().findFirst().orElseThrow();
        service.getCodinomesJL().remove(codinome);
        return codinome;
    }

}

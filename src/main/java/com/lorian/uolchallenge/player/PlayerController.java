package com.lorian.uolchallenge.player;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")
public class PlayerController {
    
    @Autowired
    PlayerService service;

    @PutMapping
    public ResponseEntity<Player> createPlayer(@RequestBody @Valid PlayerDTO dto){
        return new ResponseEntity<>(service.createPlayer(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Player>> listPlayers(){
        return new ResponseEntity<>(service.findAllPlayers(), HttpStatus.OK);
    }

}

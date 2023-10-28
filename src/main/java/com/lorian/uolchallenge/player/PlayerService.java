package com.lorian.uolchallenge.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    
    @Autowired
    PlayerRepository repository;

    public PlayerDTO createPlayer(PlayerDTO dto){
        Player player = new Player(dto);
        repository.save(player);
        return entityToDto(player);
    }

    private PlayerDTO entityToDto(Player entity){
        return new PlayerDTO(entity.getName(), entity.getEmail(), entity.getPhone(), entity.getGroupType());
    }

}

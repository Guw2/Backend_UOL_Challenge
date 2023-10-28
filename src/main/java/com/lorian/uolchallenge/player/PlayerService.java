package com.lorian.uolchallenge.player;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lorian.uolchallenge.exceptions.throwable.NoCodinomeLeftException;
import com.lorian.uolchallenge.request.RequestHandler;

@Service
public class PlayerService {
    
    @Autowired
    PlayerRepository repository;

    @Autowired
    RequestHandler requestHandler;

    public List<Player> findAllPlayers() {
        return repository.findAll();
    }

    public Player createPlayer(PlayerDTO dto){
        try{
            Player player = new Player(dto);
            player.setCodinome(requestHandler.findCodinome(dto.grouptype()));
            repository.save(player);
            return player;
        }catch(NoSuchElementException e){
            throw new NoCodinomeLeftException();
        }
    }
}

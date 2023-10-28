package com.lorian.uolchallenge.player;

import com.lorian.uolchallenge.enums.GroupType;

public record PlayerDTO(
    
    String name,
    String email,
    String phone,
    GroupType grouptype

) {}

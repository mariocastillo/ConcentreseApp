package com.example.mario.concentreseapp;

import java.io.Serializable;

public class Player implements Serializable {
    String name;
    int score;
    public Player(String name,int score){
        this.name=name;
        this.score=score;
    }
}

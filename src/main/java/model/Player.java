package model;

import model.logic.Round;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public String name;
    public Round round;
    public List<Integer> currentCards;

    public Player(String name, Round round) {
        this.name = name;
        this.round = round;
        currentCards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Integer> getCurrentCards() {
        return currentCards;
    }
}

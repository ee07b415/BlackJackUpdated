package model.logic;

import game.BlackJack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlayerRound implements Round {
    private BlackJack bj;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public PlayerRound(BlackJack bj) {
        this.bj = bj;
    }

    public String printCurrentCard(){
        String currentCard = "";
        for(int card : bj.player1.getCurrentCards()){
            currentCard += card + " ";
        }
        return currentCard;
    }

    @Override
    public void round() {
        int total = 0;
        for(int card: bj.player1.getCurrentCards()){
            total += card;
        }
        if (total > 21){
            System.out.println("Already more than 21, can't continue\n");
            return;
        }
        System.out.println("You already have: " + printCurrentCard() + "\n");
        System.out.println("Draw another card? Y/N \n");
        String input = "N";
        try {
            input = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(input.equals("Y")){
            bj.player1.currentCards.add(bj.deck.get(0));
            bj.deck.remove(0);
            round();
        }
    }
}

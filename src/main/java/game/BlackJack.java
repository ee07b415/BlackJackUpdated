package game;

import model.*;
import model.logic.AIRound;
import model.logic.PlayerRound;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BlackJack implements Game {
    public List<Integer> deck = new ArrayList<>();
    public Player player1, player2;

    public BlackJack() {

        for(int i = 0; i < 4; i++){
            for(int j = 1; j <= 13; j++){
                deck.add(j);
            }
        }
        Collections.shuffle(deck);

        player1 = new Player("player", new PlayerRound(this));
        player2 = new Player("AI", new AIRound(this));
    }

    public Result getResult(){
        int player1_total = 0;
        for(int card: player1.getCurrentCards()){
            player1_total += card;
        }

        int player2_total = 0;
        for(int card: player2.getCurrentCards()){
            player2_total += card;
        }

        if (player1_total <= 21 && player2_total <= 21 && player1_total > player2_total){
            return Result.Win;
        } else if (player1_total <= 21 && player2_total <= 21 && player1_total < player2_total){
            return Result.Lose;
        } else if(player1_total <= 21 && player2_total <= 21 && player1_total == player2_total) {
            return Result.Draw;
        } else if(player1_total > 21 && player2_total <= 21) {
            return Result.Lose;
        } else if(player1_total <= 21 && player2_total > 21) {
            return Result.Win;
        } else {
            return Result.Draw;
        }
    }

    @Override
    public void play() {
        System.out.println("Lets play BlackJACK!\n");
        BlackJack bj = new BlackJack();

        bj.player1.currentCards.add(bj.deck.get(0));
        bj.deck.remove(0);
        bj.player1.currentCards.add(bj.deck.get(0));
        bj.deck.remove(0);
        bj.player2.currentCards.add(bj.deck.get(0));
        bj.deck.remove(0);
        bj.player2.currentCards.add(bj.deck.get(0));
        bj.deck.remove(0);

        bj.player2.round.round();
        bj.player1.round.round();

        Result rs = bj.getResult();

        int player1_total = 0;
        for(int card: bj.player1.getCurrentCards()){
            player1_total += card;
        }

        int player2_total = 0;
        for(int card: bj.player2.getCurrentCards()){
            player2_total += card;
        }

        System.out.println("Your total is " + player1_total + " \n");
        System.out.println("AI total is " + player2_total + " \n");
        System.out.println("You " + rs + "!");
    }
}

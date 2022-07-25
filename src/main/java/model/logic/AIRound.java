package model.logic;

import game.BlackJack;

public class AIRound implements Round {
    private BlackJack bj;

    public AIRound(BlackJack bj) {
        this.bj = bj;
    }

    @Override
    public void round() {
        int total = 0;
        for(int card: bj.player2.getCurrentCards()){
            total += card;
        }
        if(total < 17){
            bj.player2.currentCards.add(bj.deck.get(0));
            bj.deck.remove(0);
            round();
        }
    }
}

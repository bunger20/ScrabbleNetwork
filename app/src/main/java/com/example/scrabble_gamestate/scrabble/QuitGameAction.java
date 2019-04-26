package com.example.scrabble_gamestate.scrabble;

import com.example.scrabble_gamestate.game.GamePlayer;
import com.example.scrabble_gamestate.game.actionMsg.GameAction;

import java.io.Serializable;

/**
 *Class that quits the game, reverting the local game state to the original game state.
 *
 * @author Sydney Wells
 * @author Sarah Bunger
 * @author Kavya Mandla
 * @author Meredith Marcinko
 * @version February 2019
 */
public class QuitGameAction extends GameAction implements Serializable {
    /**
     * constructor
     *
     * @param player the player who created the action
     */
    public QuitGameAction(GamePlayer player) {
        super(player);
    }
}

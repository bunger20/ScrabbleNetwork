package com.example.scrabble_gamestate.scrabble;

import com.example.scrabble_gamestate.game.Board;
import com.example.scrabble_gamestate.game.GameHumanPlayer;
import com.example.scrabble_gamestate.game.GameMainActivity;
import com.example.scrabble_gamestate.R;
import com.example.scrabble_gamestate.game.actionMsg.GameAction;
import com.example.scrabble_gamestate.game.infoMsg.GameInfo;

import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 *
 */
public class ScrabbleHumanPlayer extends GameHumanPlayer {

    /* instance variables */

    // The TextView the displays the current counter value
    private TextView counterValueTextView;

    // the most recent game state, as given to us by the ScrabbleLocalGame
    private ScrabbleGameState state;

    // the android activity that we are running
    private GameMainActivity myActivity;

    private Board surface;

    //TODO for after alpha, deal with the unusual case where players can't get rid of their letters
    //bool skipped  start it out as false; everytime they skip, check to see if true (if so, forfiet); pop up yes/no
    //dialog asking if they actually want to forfiet, then send a quitgameaction instead

    /**
     * constructor
     * @param name
     * 		the player's name
     */
    public ScrabbleHumanPlayer(String name) {
        super(name);
    }

    /**
     * Returns the GUI's top view object
     *
     * @return
     * 		the top object in the GUI's view hierarchy
     */
    public View getTopView() {
        return myActivity.findViewById(R.id.top_gui_layout);
    }

    /**
     * sets the counter value in the text view
     */
    protected void updateDisplay() {

        // set the text in the appropriate widget
        //counterValueTextView.setText("" + state.getCounter());
    }

    /**
     * callback method when we get a message (e.g., from the game)
     *
     * @param info
     * 		the message
     */
    @Override
    public void receiveInfo(GameInfo info) {
        // ignore the message if it's not a ScrabbleGameState message
        if (!(info instanceof ScrabbleGameState)) return;

        // update our state; then update the display
        this.state = (ScrabbleGameState) info;
        updateDisplay();
    }

    /**
     * callback method--our game has been chosen/rechosen to be the GUI,
     * called from the GUI thread
     *
     * @param activity
     * 		the activity under which we are running
     */
    public void setAsGui(GameMainActivity activity) {

        // remember the activity
        myActivity = activity;

        // Load the layout resource for our GUI
        activity.setContentView(R.layout.activity_main);

        TextView ourScore = activity.findViewById(R.id.playerScore);
        TextView opponentScore = activity.findViewById(R.id.opponentScore);

        ScrabbleController theController = new ScrabbleController(ourScore, opponentScore, state);

        //sets the listeners for the gameplay buttons
        ImageButton swapTileButton = activity.findViewById(R.id.swapTileButtton);
        swapTileButton.setOnClickListener(theController);

        ImageButton skipButton = activity.findViewById(R.id.passImageButton);
        skipButton.setOnClickListener(theController);

        ImageButton shuffleTileButton = activity.findViewById(R.id.shuffleImageButton);
        shuffleTileButton.setOnClickListener(theController);

        ImageButton dictionaryButton = activity.findViewById(R.id.dictionaryButton);
        dictionaryButton.setOnClickListener(theController);

        ImageButton playButton = activity.findViewById(R.id.playButton);
        playButton.setOnClickListener(theController);

        //sets the listeners for the player hand tiles for drag and drop
        ImageButton tileOneButton = activity.findViewById(R.id.tileOneButton);
        tileOneButton.setOnDragListener(theController);

        ImageButton tileTwoButton = activity.findViewById(R.id.tileTwoButton);
        tileTwoButton.setOnDragListener(theController);

        ImageButton tileThreeButton = activity.findViewById(R.id.tileThreeButton);
        tileThreeButton.setOnDragListener(theController);

        ImageButton tileFourButton = activity.findViewById(R.id.tileFourButton);
        tileFourButton.setOnDragListener(theController);

        ImageButton tileFiveButton = activity.findViewById(R.id.tileFiveButton);
        tileFiveButton.setOnDragListener(theController);

        ImageButton tileSixButton = activity.findViewById(R.id.tileSixButton);
        tileSixButton.setOnDragListener(theController);

        ImageButton tileSevenButton = activity.findViewById(R.id.tileSevenButton);
        tileSevenButton.setOnDragListener(theController);

        // remember the field that we update to display the counter's value
        /*this.counterValueTextView =
                (TextView) activity.findViewById(R.id.counterValueTextView);*/

        surface = myActivity.findViewById(R.id.surfaceView);
        //setContentView(R.layout.activity_main);

        // if we have a game state, "simulate" that we have just received
        // the state from the game so that the GUI values are updated
        if (state != null) {
            receiveInfo(state);
        }
    }

}// class CounterHumanPlayer



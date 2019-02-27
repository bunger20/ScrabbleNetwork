package com.example.scrabble_gamestate;

import java.util.ArrayList;
import java.util.Collections;

/**
 *The State of the game. Includes values for all tiles, the tile bag, and each square on the board.
 *
 *
 * @author Sydney Wells
 * @author Sarah Bunger
 * @author Kavva Mandla
 * @author Meredith Marcinko
 * @version February 2019
 */
public class GameState {

    //constants: the point value of each tile
    final int A_VAL = 1;
    final int B_VAL = 3;
    final int C_VAL = 3;
    final int D_VAL = 2;
    final int E_VAL = 1;
    final int F_VAL = 4;
    final int G_VAL = 2;
    final int H_VAL = 4;
    final int I_VAL = 1;
    final int J_VAL = 8;
    final int K_VAL = 5;
    final int L_VAL = 1;
    final int M_VAL = 3;
    final int N_VAL = 1;
    final int O_VAL = 1;
    final int P_VAL = 3;
    final int Q_VAL = 10;
    final int R_VAL = 1;
    final int S_VAL = 1;
    final int T_VAL = 1;
    final int U_VAL = 1;
    final int V_VAL = 4;
    final int W_VAL = 4;
    final int X_VAL = 8;
    final int Y_VAL = 4;
    final int Z_VAL = 10;
    final int BLANK_VAL = 0;

    //instance variable
    int playerOneScore;
    int playerTwoScore;

    int playerOneId;
    int playerTwoId;

    ArrayList<Tile> tileBag = new ArrayList<Tile>(100);
    ArrayList<Tile> hand1 = new ArrayList<Tile>(7);
    ArrayList<Tile> hand2 = new ArrayList<Tile>(7);

    Tile[][] board = new Tile[15][15];

    //indicates which players turn it is; 1 for player 1, 2 for player 2, etc.
    int turn;

    /**
     * Constructor for objects of class GameState
     */
    public GameState(){
        playerOneScore = 0;
        playerTwoScore = 0;

        playerOneId = 1;
        playerTwoId = 2;

        turn = 1;

        //set entire array to null, representing board with no tiles played
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 15; j++){
                board[i][j] = null;
            }
        }

        makeTileBag();
        shuffleTileBag();

        //add seven tiles to each player's hand
        for(int i=0; i < 7; i++)
        {
            drawTile(hand1);
            drawTile(hand2);
        }

    }//constructor

    /**
     * makeTileBag
     * Method to make the bag of tiles for a new game
     */
    public void makeTileBag() {

        //blank tiles
        //TODO Get blank tile images from Sydney and add

        //a tiles
        tileBag.add(new Tile(A_VAL, 'a', R.drawable.tile_a, false));
        tileBag.add(new Tile(A_VAL, 'a', R.drawable.tile_a_2, false));
        tileBag.add(new Tile(A_VAL, 'a', R.drawable.tile_a_3, false));
        tileBag.add(new Tile(A_VAL, 'a', R.drawable.tile_a_4, false));
        tileBag.add(new Tile(A_VAL, 'a', R.drawable.tile_a_5, false));
        tileBag.add(new Tile(A_VAL, 'a', R.drawable.tile_a_6, false));
        tileBag.add(new Tile(A_VAL, 'a', R.drawable.tile_a_7, false));
        tileBag.add(new Tile(A_VAL, 'a', R.drawable.tile_a_8, false));
        tileBag.add(new Tile(A_VAL, 'a', R.drawable.tile_a_9, false));

        //b tiles
        tileBag.add(new Tile(B_VAL, 'b', R.drawable.tile_b, false));
        tileBag.add(new Tile(B_VAL, 'b', R.drawable.tile_b_2, false));

        //c tiles
        tileBag.add(new Tile(C_VAL, 'c', R.drawable.tile_c, false));
        tileBag.add(new Tile(C_VAL, 'c', R.drawable.tile_c_2, false));

        //d tiles
        tileBag.add(new Tile(D_VAL, 'd', R.drawable.tile_d, false));
        tileBag.add(new Tile(D_VAL, 'd', R.drawable.tile_d_2, false));
        tileBag.add(new Tile(D_VAL, 'd', R.drawable.tile_d_3, false));
        tileBag.add(new Tile(D_VAL, 'd', R.drawable.tile_d_4, false));

        //e tiles
        tileBag.add(new Tile(E_VAL, 'e', R.drawable.tile_e, false));
        tileBag.add(new Tile(E_VAL, 'e', R.drawable.tile_e_2, false));
        tileBag.add(new Tile(E_VAL, 'e', R.drawable.tile_e_3, false));
        tileBag.add(new Tile(E_VAL, 'e', R.drawable.tile_e_4, false));
        tileBag.add(new Tile(E_VAL, 'e', R.drawable.tile_e_5, false));
        tileBag.add(new Tile(E_VAL, 'e', R.drawable.tile_e_6, false));
        tileBag.add(new Tile(E_VAL, 'e', R.drawable.tile_e_7, false));
        tileBag.add(new Tile(E_VAL, 'e', R.drawable.tile_e_8, false));
        tileBag.add(new Tile(E_VAL, 'e', R.drawable.tile_e_9, false));
        tileBag.add(new Tile(E_VAL, 'e', R.drawable.tile_e_10, false));
        tileBag.add(new Tile(E_VAL, 'e', R.drawable.tile_e_11, false));
        tileBag.add(new Tile(E_VAL, 'e', R.drawable.tile_e_12, false));

        //f tiles
        tileBag.add(new Tile(F_VAL, 'f', R.drawable.tile_f, false));
        tileBag.add(new Tile(F_VAL, 'f', R.drawable.tile_f_2, false));

        //g tiles
        tileBag.add(new Tile(G_VAL, 'g', R.drawable.tile_g, false));
        tileBag.add(new Tile(G_VAL, 'g', R.drawable.tile_g_2, false));
        tileBag.add(new Tile(G_VAL, 'g', R.drawable.tile_g_3, false));

        //h tiles
        tileBag.add(new Tile(H_VAL, 'h', R.drawable.tile_h, false));
        tileBag.add(new Tile(H_VAL, 'h', R.drawable.tile_h_2, false));

        //i tiles
        tileBag.add(new Tile(I_VAL, 'i', R.drawable.tile_i, false));
        tileBag.add(new Tile(I_VAL, 'i', R.drawable.tile_i_2, false));
        tileBag.add(new Tile(I_VAL, 'i', R.drawable.tile_i_3, false));
        tileBag.add(new Tile(I_VAL, 'i', R.drawable.tile_i_4, false));
        tileBag.add(new Tile(I_VAL, 'i', R.drawable.tile_i_5, false));
        tileBag.add(new Tile(I_VAL, 'i', R.drawable.tile_i_6, false));
        tileBag.add(new Tile(I_VAL, 'i', R.drawable.tile_i_7, false));
        tileBag.add(new Tile(I_VAL, 'i', R.drawable.tile_i_8, false));
        tileBag.add(new Tile(I_VAL, 'i', R.drawable.tile_i_9, false));

        //j tile
        tileBag.add(new Tile(J_VAL, 'j', R.drawable.tile_j, false));

        //k tile
        tileBag.add(new Tile(K_VAL, 'k', R.drawable.tile_k, false));

        //l tiles
        tileBag.add(new Tile(L_VAL, 'l', R.drawable.tile_l, false));
        tileBag.add(new Tile(L_VAL, 'l', R.drawable.tile_l_2, false));
        tileBag.add(new Tile(L_VAL, 'l', R.drawable.tile_l_3, false));
        tileBag.add(new Tile(L_VAL, 'l', R.drawable.tile_l_4, false));

        //m tiles
        tileBag.add(new Tile(M_VAL, 'm', R.drawable.tile_m, false));
        tileBag.add(new Tile(M_VAL, 'm', R.drawable.tile_m_2, false));

        //n tiles
        tileBag.add(new Tile(N_VAL, 'n', R.drawable.tile_n, false));
        tileBag.add(new Tile(N_VAL, 'n', R.drawable.tile_n_2, false));
        tileBag.add(new Tile(N_VAL, 'n', R.drawable.tile_n_3, false));
        tileBag.add(new Tile(N_VAL, 'n', R.drawable.tile_n_4, false));
        tileBag.add(new Tile(N_VAL, 'n', R.drawable.tile_n_5, false));
        tileBag.add(new Tile(N_VAL, 'n', R.drawable.tile_n_6, false));

        //o tiles
        tileBag.add(new Tile(O_VAL, 'o', R.drawable.tile_o, false));
        tileBag.add(new Tile(O_VAL, 'o', R.drawable.tile_o_2, false));
        tileBag.add(new Tile(O_VAL, 'o', R.drawable.tile_o_3, false));
        tileBag.add(new Tile(O_VAL, 'o', R.drawable.tile_o_4, false));
        tileBag.add(new Tile(O_VAL, 'o', R.drawable.tile_o_5, false));
        tileBag.add(new Tile(O_VAL, 'o', R.drawable.tile_o_6, false));
        tileBag.add(new Tile(O_VAL, 'o', R.drawable.tile_o_7, false));
        tileBag.add(new Tile(O_VAL, 'o', R.drawable.tile_o_8, false));

        //p tiles
        tileBag.add(new Tile(P_VAL, 'p', R.drawable.tile_p, false));
        tileBag.add(new Tile(P_VAL, 'p', R.drawable.tile_p_2, false));

        //q tile
        tileBag.add(new Tile(Q_VAL, 'q', R.drawable.tile_q, false));

        //r tiles
        tileBag.add(new Tile(R_VAL, 'r', R.drawable.tile_r, false));
        tileBag.add(new Tile(R_VAL, 'r', R.drawable.tile_r_2, false));
        tileBag.add(new Tile(R_VAL, 'r', R.drawable.tile_r_3, false));
        tileBag.add(new Tile(R_VAL, 'r', R.drawable.tile_r_4, false));
        tileBag.add(new Tile(R_VAL, 'r', R.drawable.tile_r_5, false));
        tileBag.add(new Tile(R_VAL, 'r', R.drawable.tile_r_6, false));

        //s tiles
        tileBag.add(new Tile(S_VAL, 's', R.drawable.tile_s, false));
        tileBag.add(new Tile(S_VAL, 's', R.drawable.tile_s_2, false));
        tileBag.add(new Tile(S_VAL, 's', R.drawable.tile_s_3, false));
        tileBag.add(new Tile(S_VAL, 's', R.drawable.tile_s_4, false));

        //t tiles
        tileBag.add(new Tile(T_VAL, 't', R.drawable.tile_t, false));
        tileBag.add(new Tile(T_VAL, 't', R.drawable.tile_t_2, false));
        tileBag.add(new Tile(T_VAL, 't', R.drawable.tile_t_3, false));
        tileBag.add(new Tile(T_VAL, 't', R.drawable.tile_t_4, false));
        tileBag.add(new Tile(T_VAL, 't', R.drawable.tile_t_5, false));
        tileBag.add(new Tile(T_VAL, 't', R.drawable.tile_t_6, false));

        //u tiles
        tileBag.add(new Tile(U_VAL, 'u', R.drawable.tile_u, false));
        tileBag.add(new Tile(U_VAL, 'u', R.drawable.tile_u_2, false));
        tileBag.add(new Tile(U_VAL, 'u', R.drawable.tile_u_3, false));
        tileBag.add(new Tile(U_VAL, 'u', R.drawable.tile_u_4, false));

        //v tiles
        tileBag.add(new Tile(V_VAL, 'v', R.drawable.tile_v, false));
        tileBag.add(new Tile(V_VAL, 'v', R.drawable.tile_v_2, false));

        //w tiles
        tileBag.add(new Tile(W_VAL, 'w', R.drawable.tile_w, false));
        tileBag.add(new Tile(W_VAL, 'w', R.drawable.tile_w_2, false));

        //x tile
        tileBag.add(new Tile(X_VAL, 'x', R.drawable.tile_x, false));

        //y tiles
        tileBag.add(new Tile(Y_VAL, 'y', R.drawable.tile_y, false));
        tileBag.add(new Tile(Y_VAL, 'y', R.drawable.tile_y_2, false));

        //z tile
        tileBag.add(new Tile(Z_VAL, 'z', R.drawable.tile_z, false));

    }//makeTileBag

    /**
     * Method to shuffle the tiles in the bag
     */
    public void shuffleTileBag()
    {
        //Collections.shuffle - shuffles an arrayList
        Collections.shuffle(tileBag);

    }//shuffleTileBag

    /**
     * Method to add a tile to a specific hand
     *
     * @param hand  The hand to add the tile to
     */
    public void drawTile(ArrayList<Tile> hand)
    {
        hand.add(tileBag.get(0));
        tileBag.remove(0);

        //TODO Add in conditions

    }//drawTile

    @Override
    public String toString(){
        System.out.println("Player One's Score: " + playerOneScore);
        System.out.println("Player Two's Score: " + playerTwoScore);
        System.out.println("Player One's ID: " + playerOneId);
        System.out.println("Player Two's ID: " + playerTwoId);
        System.out.println("Turn: " + turn);

        System.out.println("Tile Bag: " + tileBag);
        System.out.println("Tiles in Player One Hand: " + hand1);
        System.out.println("Tiles in Player Two Hand: "  + hand2);

        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 15; j++){
                System.out.println("Tiles on board: " + board[i][j]);
            }
        }

        //TODO Ensure that this actually prints desired things.

        return null;
    }

    /**
     *Method that halts the game, reverting it to the original game state
     * after pushing quit button.
     *
     */
    public boolean quitGame(){
        return true; //should always remain true, because you should be able to quit whenever

    }

    /**
     * Method that checks if it's your turn and the selected location is a valid point on the board
     * -i.e. both free of other tiles and within the boundaries of the board. It then creates an
     * instance of the placeTileAction class and updates the player's view.
     * @param turnId the id of the player whose turn it is currently
     */
    public boolean placeTile(int turnId, ArrayList<board> position, Tile tile){
        if(turnId == player
        return false;
    }

    /**
     * Method that checks if it's the player's turn, and if so, pulls all the placed but not
     * confirmed tiles from the board.
     * @param turnId the id of the player whose turn it is currently
     */
    public boolean recallTiles(int turnId){

        return false;
    }

    /**
     * Method that checks if it's the player's turn, and if so, resets the game state to match the
     * current view of the board when the player presses the "Play" button.
     * @param turnId the id of the player whose turn it is currently
     */
    public boolean playWord(int turnId){
        return false;

    }

    /**
     * Method that checks if it's the player's turn, and if so, calls the skipTurnAction class,
     * which changes the turn id to that of the other player.
     * @param turnId the id of the player whose turn it is currently
     */
    public boolean skipTurn(int turnId){
        return false;

    }

    /**
     * @param turnId the id of the player whose turn it is currently
     */
    public boolean shuffleTiles(int turnId){

        return false;
    }

    /**
     * @param turnId the id of the player whose turn it is currently
     */
    public boolean exchangeTile(int turnId){
        return false;

    }

    /**
     * @param turnId the id of the player whose turn it is currently
     */
    public boolean selectBlankTileLetter(int turnId){

        return false;
    }
    /**
     * @param turnId the id of the player whose turn it is currently
     */
    public boolean checkDictionary(int turnId){

        return false;
    }
}

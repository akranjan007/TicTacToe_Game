package com.example.dummy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive = true;
    //States Meaning
    //0 -> O
    //1 -> X
    //2 -> null
    int activePlayer = 1;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] winPosition = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};

    public void resetGame(View view){
        gameActive = true;
        activePlayer = 1;
        for(int i=0;i<gameState.length;i++) gameState[i] = 2;
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        TextView status = findViewById(R.id.status);
        status.setText(R.string.status0);
    }
    public void playerTap(View view){
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(!gameActive){
            gameReset(view);
        }
        if(gameState[tappedImage]==2){
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer == 1){
                img.setImageResource(R.drawable.cross);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText(R.string.status1);
            }
            else{
                img.setImageResource(R.drawable.zero);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText(R.string.status);
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }

        //win condition
        for(int[] win : winPosition){
            if(gameState[win[0]] == gameState[win[1]]  &&  gameState[win[1]] == gameState[win[2]]  &&  gameState[win[0]]!=2) {
                String winner;
                gameActive = false;
                if (gameState[win[0]] == 1) {
                    winner = "X has WON..!!";
                } else {
                    winner = "O has WON..!!";
                }
                TextView status = findViewById(R.id.status);
                status.setText(winner);
            }
        }
    }

    public void gameReset(View view){
        gameActive = true;
        activePlayer = 1;
        for(int i=0;i<gameState.length;i++) gameState[i] = 2;
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        TextView status = findViewById(R.id.status);
        status.setText(R.string.status0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
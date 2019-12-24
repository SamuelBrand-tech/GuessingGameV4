package com.example.guessinggamev4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mainTv;
    private TextView counter;
    private EditText input;
    private TextView resultTv;
    private Button guessButton;
    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainTv = (TextView) findViewById(R.id.mainTV);
        counter = (TextView) findViewById(R.id.counter);
        input = (EditText) findViewById(R.id.input);
        guessButton = (Button) findViewById(R.id.guessButton);
        GameDataPersist gameData = GameDataPersist.getInstance(getApplicationContext());
        game = new Game(gameData.getNumberOfLives(), gameData.getLevel());

        fillControllersInUI();

        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputElement = input.getText().toString();
                if(!input.getText().toString().matches("")){
                    try {
                        int inputNumber = Integer.parseInt(inputElement);
                        if(inputNumber < game.getCurrentNumberToGuess() && inputNumber > 0){
                            if(inputNumber == game.getCurrentNumberToGuess()){
                                game.goToNextLevel();
                                if(game.isWon()){
                                    // alert game won
                                    // start new game
                                }
                            }
                            else{
                                game.reduceLives();
                                if(game.getNumberOfLivesLeft() == 0){
                                    // alert game over
                                    // start new game
                                }
                            }
                            fillControllersInUI();
                        }
                        else{
                            // alert user - number not in range
                        }
                    } catch (NumberFormatException e) {
                        // alert user - not a number input
                    }
                }
                else{
                    // alert user - no input found
                }
            }
        });

    }

    protected void onStop() {

        super.onStop();
        GameDataPersist.getInstance(getApplicationContext())
                .saveValues(this.game.getNumberOfLivesLeft(), this.game.getLevel());

    }

    private void fillControllersInUI() {
        counter.setText(String.format("Lives: %s", game.getNumberOfLivesLeft()));
        resultTv.setText(String.format("Enter a number between 0 - %s", game.getClass()));
    }

}

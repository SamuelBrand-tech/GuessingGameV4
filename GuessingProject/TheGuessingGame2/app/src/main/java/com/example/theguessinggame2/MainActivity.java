package com.example.theguessinggame2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final int maxNum1 = 11;
    public static final int maxNum2 = 11;
    public static final int maxNum3 = 21;
    private static int  numOfTries,numOfTries2,numToFind,numToFind2,numToFind3;

    public static final Random randomNum = new Random();

    private EditText numEntered;

    private EditText msgTv;

    private Button validate;

    private EditText counter;

    private TextView instruction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msgTv =(EditText) findViewById(R.id.answer);
        numEntered = (EditText) findViewById(R.id.input);
        validate = (Button) findViewById(R.id.guessButton);
        validate.setOnClickListener(this);
        counter = (EditText) findViewById(R.id.counter) ;
        instruction =(TextView) findViewById(R.id.mainText);
        instruction.setText(R.string.level1);

        newGame();
        msgTv.setText(R.string.start_msg);
        counter.setText(R.string.numOfTries1);
        numOfTries = 5;

    }



    @Override
    public void onClick(View view) {
        if(view == validate){
            validate();
        }
    }

    private void validate(){


        int num = Integer.parseInt(numEntered.getText().toString());


        if(num == numToFind3){
            //Toast.makeText(this, "You win!!!!"
            //        + numToFind , Toast.LENGTH_SHORT).show();
            msgTv.setText(R.string.correct);
            youWin3();
        }
        if(num == numToFind2){
            //Toast.makeText(this, "You win!!!!"
            //        + numToFind , Toast.LENGTH_SHORT).show();
            msgTv.setText(R.string.correct);
            youWin2();
        }
        if (numOfTries==0){
            msgTv.setText(R.string.start_msg);
            youLost();
        }
        if(num == numToFind){
            //Toast.makeText(this, "You win!!!!"
            //        + numToFind , Toast.LENGTH_SHORT).show();
            msgTv.setText(R.string.correct);
            youWin();
        }
        else {
            //Toast.makeText(this,"Wrong!try again",Toast.LENGTH_SHORT).show();
            msgTv.setText(R.string.wrong);
            tryAgain();
        }

        numOfTries--;

        Toast.makeText(this,"You have more " + numOfTries +
                " attempts left", Toast.LENGTH_SHORT ).show();

    }

    private void youWin3() {
        numToFind = randomNum.nextInt(maxNum1);
        msgTv.setText(R.string.correct);
        Level3();
    }

    private void youWin2() {
        numToFind = randomNum.nextInt(maxNum1);
        msgTv.setText(R.string.correct);
        Level3();
    }

    private void Level3() {
        numToFind3 =randomNum.nextInt(maxNum3);
        msgTv.setText(R.string.start_msg);
        instruction.setText(R.string.level3);
        Toast.makeText(this,"level 3",Toast.LENGTH_SHORT).show();
        numOfTries2 =11;
    }

    private void youLost() {
        msgTv.setText(R.string.youLost);
        numOfTries=5;
        numToFind = randomNum.nextInt(maxNum1);
        Toast.makeText(this,R.string.youLost,Toast.LENGTH_SHORT).show();
        newGame();
    }

    private void tryAgain() {
        msgTv.setText(R.string.wrong);
        numToFind = randomNum.nextInt(maxNum1);
        newGame();
    }

    private void youWin() {
        numToFind = randomNum.nextInt(maxNum1);
        msgTv.setText(R.string.correct);
        Level2();
    }

    private void Level2() {
        numToFind2 =randomNum.nextInt(maxNum2);
        msgTv.setText(R.string.start_msg);
        instruction.setText(R.string.level2);
        Toast.makeText(this,"level 2",Toast.LENGTH_SHORT).show();
        numOfTries2 =11;
    }

    private void newGame(){
        numToFind = randomNum.nextInt(maxNum1);
    }



}

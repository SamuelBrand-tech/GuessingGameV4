package com.example.guessinggamev4;

import android.content.Context;

import java.util.Random;

public class Game {



    private int numberOfTriesLeft;
    private Level level;
    private boolean isWon = false;


    public Level getLevel() {
        return level;
    }

    public int getCurrentNumberToGuess() {
        int currentNumberToGuess;
        switch (this.level) {
            case FIRST:
                currentNumberToGuess = generateRandomNum(10);
                break;
            case SECOND:
                currentNumberToGuess = generateRandomNum(10);
                break;
            case THIRD:
                currentNumberToGuess = generateRandomNum(20);
                break;
            default:
                currentNumberToGuess = 0;
        }
        return currentNumberToGuess;
    }

    public int getNumberOfLivesLeft() {
        return numberOfTriesLeft;
    }

    public Game(int lives, Level level) {
        this.numberOfTriesLeft = lives;
        this.level = level;
    }

    private int generateRandomNum(int bound) {
        return new Random().nextInt(bound +1);
    }

    public void goToNextLevel() {
        switch (this.level) {
            case FIRST:
                this.level = Level.SECOND;
                break;
            case SECOND:
                this.level = Level.THIRD;
                break;
            case THIRD:
                this.level = Level.FIRST;
                this.isWon = true;
                break;
        }
    }

    public void reduceLives() {
        this.numberOfTriesLeft--;
    }

    public boolean isWon(){
        return this.isWon;
    }
}

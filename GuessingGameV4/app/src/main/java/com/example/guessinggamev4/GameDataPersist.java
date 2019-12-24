package com.example.guessinggamev4;

import android.content.Context;
import android.content.SharedPreferences;

public class GameDataPersist {

    private static GameDataPersist instance;
    private Context applicationContext;

    final static String GAMEDATA ="Game Data";
    final static String LIVES = "Lives";
    final static String LEVEL = "level";

    private GameDataPersist(Context applicationContext){
        this.applicationContext = applicationContext;
    };

    public static GameDataPersist getInstance(Context applicationContext) {
        if(instance ==  null){
            instance = new GameDataPersist(applicationContext);
        }
        return instance;
    }

    public int getNumberOfLives() {
        SharedPreferences preferences = applicationContext.getSharedPreferences
                (GAMEDATA, Context.MODE_PRIVATE);
        preferences.getString(LIVES,);
        editor.putInt(LEVEL, preferences.getInt("livesCount", 0));
    }

    public Level getLevel() {
    }

    public void saveValues(int numOfLives, Level level){
        SharedPreferences preferences = applicationContext.getSharedPreferences
                (GAMEDATA, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(LIVES, preferences.getInt("livesCount", 0));
        editor.putInt(LEVEL, preferences.getInt("livesCount", 0));
    }
}

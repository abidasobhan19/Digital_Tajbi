package com.forbitbd.islam.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class AppPreference {

    private static final String SP_NAME ="AppPreference";
    private static final String COUNTER ="COUNTER";

    private SharedPreferences userLocalDatabase;

    private static com.forbitbd.islam.utils.AppPreference instance;


    private AppPreference(Context context){
        userLocalDatabase = context.getSharedPreferences(SP_NAME,0);
    }

    public static com.forbitbd.islam.utils.AppPreference getInstance(Context context) {
        if (instance == null) {
            instance = new com.forbitbd.islam.utils.AppPreference(context);
        }
        return instance;
    }


    public void increaseCounter(){
        int prev = userLocalDatabase.getInt(COUNTER,1);

        Log.d("jjjjj", "increaseCounter: "+prev);
        prev++;
        userLocalDatabase.edit().putInt(COUNTER,prev).apply();



    }
    public int getCounter(){
        return userLocalDatabase.getInt(COUNTER,1);
    }



    public void resetCounter(){
        userLocalDatabase.edit().putInt(COUNTER,0).apply();
    }

}

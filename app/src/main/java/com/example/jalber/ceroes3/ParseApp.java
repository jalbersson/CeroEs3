package com.example.jalber.ceroes3;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by Jalber on 29/09/2015.
 */
public class ParseApp extends Application
{
    public void onCreate()
    {
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "T1w9ltVNc2SnjQFatnLxqg7sMriF4D0fYHgyfQG4", "IuKiE8lKFJ8XqYdAnCmGm8FF1QgASiqhkqCkQce7");
    }
}

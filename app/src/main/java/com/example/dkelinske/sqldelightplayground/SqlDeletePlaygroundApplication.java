package com.example.dkelinske.sqldelightplayground;

import android.app.Application;

import com.facebook.stetho.Stetho;

public class SqlDeletePlaygroundApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}

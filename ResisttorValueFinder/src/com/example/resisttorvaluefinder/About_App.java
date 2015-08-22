package com.example.resisttorvaluefinder;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class About_App extends Activity{
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

}

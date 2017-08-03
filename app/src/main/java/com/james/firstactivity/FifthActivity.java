package com.james.firstactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FifthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fifth_activity_layout);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}

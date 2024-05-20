package com.example.myproud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myproud.internetmodel.InternetManager;
import com.example.myproud.internetmodel.beans.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String TAG = "zhangrui-saluo";
    private InternetManager internetManager;
    private String  baseUrl = "https://api.vvhan.com/";
    private User myuser = null;
    private TextView tester = null;
    private ImageView imager = null;
    RelativeLayout relative = null;
    private final int fresh_ui = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
        tester = (TextView) findViewById(R.id.tester);
        imager = (ImageView) findViewById(R.id.imager);
        relative = (RelativeLayout) findViewById(R.id.relative);
        internetManager = new InternetManager(baseUrl);
        internetManager.getRequest(tester,relative,imager,this);
        handler.sendEmptyMessage(fresh_ui);

    }
    Handler handler = new Handler() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what){
                case fresh_ui:
                    if(internetManager == null){
                        internetManager = new InternetManager(baseUrl);
                    }
                    internetManager.getRequest(tester,relative,imager,MainActivity.this);
                    handler.sendEmptyMessageDelayed(fresh_ui,5000);
                    break;
            }
        };
    };
}
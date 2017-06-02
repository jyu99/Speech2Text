package com.jyu7499.speechtotext;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private  String TAG="MainActivity";
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.PLAY_BTN);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Log.d(TAG,"onClick");
        Intent intent = new Intent(MainActivity.this, AudioService.class);
        intent.putExtra(IPCConstant.SERVICE_COMMAND,IPCConstant.AUDIO_PLAY_REQ);
        startService(intent);


    }
}

package com.example.stickbroadcast;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button registerStickbt;
    Button registerNormalbt;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendStickyBroadcast(new Intent("com.example.stickbroadcast.stickybrocast"));  //发送粘性广播
        sendBroadcast(new Intent("com.example.stickbroadcast.normalbrocast"));       //发送普通广播
        registerStickbt = (Button) findViewById(R.id.registerstick);
        registerNormalbt = (Button) findViewById(R.id.registernormal);
        mTextView = (TextView) findViewById(R.id.result);
        registerStickbt.setOnClickListener(this);
        registerNormalbt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.registerstick:
                registerReceiver(stickreceiver, new IntentFilter("com.example.stickbroadcast.stickybrocast")); //注册粘性广播接收器
                break;
            case R.id.registernormal:
                registerReceiver(normalreceiver, new IntentFilter("com.example.stickbroadcast.normalbrocast"));//注册普通广播接收器
                break;

            default:
                break;
        }

    }

    BroadcastReceiver stickreceiver = new BroadcastReceiver() {            //粘性广播接收器
        public void onReceive(android.content.Context context, Intent intent) {
            mTextView.setText("recevier stick broadcast!");
        }
    };

    BroadcastReceiver normalreceiver = new BroadcastReceiver() {          //普通广播接收器
        public void onReceive(android.content.Context context, Intent intent) {
            mTextView.setText("recevier normal broadcast!");
        }
    };
}

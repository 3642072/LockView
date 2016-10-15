package com.example.darren.lockview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.darren.guesture.views.Lock9View;
import com.example.darren.utils.SharedPreferencesUtil;

public class MainActivity extends AppCompatActivity {

    protected Lock9View lock9View;
    private SharedPreferencesUtil sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = SharedPreferencesUtil.getinstance(this);
        lock9View = (Lock9View) findViewById(R.id.lock_9_view);
        lock9View.setCallBack(new Lock9View.CallBack() {
            @Override
            public void onFinish(boolean result, String password) {
                Toast.makeText(MainActivity.this, password, Toast.LENGTH_SHORT).show();
                sp.setString("password", password);
                sp.setBoolean("isSavePassword", false);
                //启动Activity
                Intent intent =new Intent(MainActivity.this,ResultActivity.class);
                intent.putExtra("password",password);
                startActivity(intent);
            }
        });
    }
}

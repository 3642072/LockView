package com.chinazyjr.fanxindai;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.darren.guesture.views.GestureHandler;
import com.darren.guesture.views.GestureLockView;
import com.darren.guesture.views.LockPassWordUtil;
import com.darren.utils.AppConfig;

public class MainActivity extends Activity {
    private TextView tv_title;
    private ImageView iv_back;
    private TextView tv_gesture;
    private GestureLockView gestureLockView;
    private View sg;
    private String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_title = (TextView) findViewById(R.id.tv_title);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        tv_gesture = (TextView) findViewById(R.id.tv_gesture);
        gestureLockView = (GestureLockView) findViewById(R.id.gl);
        sg = (View) findViewById(R.id.sg);
        iv_back.setVisibility(View.GONE);
        GestureHandler.init();
        if (LockPassWordUtil.getPasswordStatus(this)) {
            tv_title.setText("手势登录");
            GestureHandler.setIsGone(sg);
            gestureLockView.setKey(LockPassWordUtil.getPassword(this));
        } else {
            //设置密码
            tv_title.setText("设置手势密码");
            gestureLockView.setKey("");
        }
        tv_gesture.setText("绘制手势密码");
        //绘制手势密码
        gestureLockView.setAnamition();
        //手势绘制后
        gestureLockView.setOnGestureFinishListener(new GestureLockView.OnGestureFinishListener() {
            @Override
            public void OnGestureFinish(boolean success, String key) {
                //判断手势密码个数
                if (GestureHandler.islimitNum(gestureLockView, key)) {
                    return;
                }
                //判断状态
                if (LockPassWordUtil.getPasswordStatus(MainActivity.this)) {
                    //登录
                    if (GestureHandler.loginGestureLock(gestureLockView, sg, tv_gesture, key)) {
                        //登陆成功
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    if (GestureHandler.getNum() >= AppConfig.limitloginPwdNum) {
                        GestureHandler.setNumOf0();//置零
                        //登录失败，跳到用户登录页面


                        finish();
                    }
                    return;
                } else {
                    //设置手势
                    if (GestureHandler.setGestureLock(gestureLockView, sg, tv_gesture, key)) {
                        //设置手势成功
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });
    }
}

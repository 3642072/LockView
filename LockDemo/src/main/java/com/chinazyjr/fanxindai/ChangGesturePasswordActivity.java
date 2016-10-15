package com.chinazyjr.fanxindai;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.darren.guesture.views.GestureHandler;
import com.darren.guesture.views.GestureLockView;
import com.darren.guesture.views.LockPassWordUtil;

import java.util.ArrayList;
import java.util.List;

public class ChangGesturePasswordActivity extends Activity implements GestureLockView.OnGestureFinishListener, View.OnClickListener {

    private List<ImageView> views = new ArrayList<ImageView>();
    private TextView tv_gesture;
    private GestureLockView gestureLockView;
    private View sg;
    private Animation animation;
    private ImageView iv_ChangGesturePassword_Back;
    private TextView tv_ChangGesturePassword_Title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changgesturepwd);
        init();
        setData();
        setListener();
    }


    public void init() {
        tv_ChangGesturePassword_Title = (TextView) findViewById(R.id.tv_title);
        tv_ChangGesturePassword_Title.setText("设置手势密码");
        iv_ChangGesturePassword_Back = (ImageView) findViewById(R.id.iv_back);
        tv_gesture = (TextView) findViewById(R.id.tv_gesture);
        gestureLockView = (GestureLockView) findViewById(R.id.gestureLockView);
        gestureLockView.setAnamition();
        sg = (View) findViewById(R.id.sg);
        GestureHandler.setIsGone(sg);
    }

    public void setListener() {
        iv_ChangGesturePassword_Back.setOnClickListener(this);

    }

    public void setData() {
        tv_gesture.setText("请输入原手势密码");
        animation = new TranslateAnimation(-20, 20, 0, 0);
        animation.setDuration(50);
        animation.setRepeatCount(2);
        animation.setRepeatMode(Animation.REVERSE);
        //获取密码
        gestureLockView.setKey(LockPassWordUtil.getPassword(this));
        //手势完成后回
        gestureLockView.setOnGestureFinishListener(this);
    }


    @Override
    public void OnGestureFinish(boolean success, String key) {
        if (GestureHandler.islimitNum(gestureLockView, key)) {
            return;
        }
        //验证原密码
        if (!GestureHandler.getFlag() && !GestureHandler.modifyChvalidate(gestureLockView, tv_gesture, key)) {
            //验证不通过
            return;
        }
        //设置新密码
        if (GestureHandler.modifyGestureLock(gestureLockView, sg, tv_gesture, key)) {
            Toast.makeText(this, "修改成功", Toast.LENGTH_LONG).show();
            finish();
        }
    }

    @Override
    public void onClick(View v) {

    }
}

package com.chinazyjr.fanxindai;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.darren.guesture.views.LockPassWordUtil;
import com.darren.guesture.views.ToggleView;
import com.darren.utils.Logger;

/**
 * Created by Forever on 2016/2/17.
 */
public class HomeActivity extends Activity implements ToggleView.OnToggleChangeListener, View.OnClickListener {
    ToggleView tv ;
    private LinearLayout layout_update_gesturespwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changeguture);
        tv = (ToggleView) findViewById(R.id.tv_toggle);
        layout_update_gesturespwd = (LinearLayout) findViewById(R.id.layout_update_gesturespwd);
        layout_update_gesturespwd.setVisibility(View.GONE);
        tv.setOnToggleChangeListener(this);
        layout_update_gesturespwd.setOnClickListener(this);
        tv.setIsOpen(LockPassWordUtil.getPasswordStatus(this));
        Logger.d("open",""+ LockPassWordUtil.getPasswordStatus(this));
    }

    @Override
    public void onChange(ToggleView v, boolean isOpen) {
        boolean open = isOpen;
        if (open) {
            layout_update_gesturespwd.setVisibility(View.VISIBLE);
            open = true;
            LockPassWordUtil.setPasswordStatus(this, true);
        } else if (!open) {
            layout_update_gesturespwd.setVisibility(View.GONE);
            open = false;
            LockPassWordUtil.setPasswordStatus(this, false);
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.layout_update_gesturespwd:
                intent = new Intent(HomeActivity.this, ChangGesturePasswordActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}

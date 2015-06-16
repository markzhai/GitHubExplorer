package cn.zhaiyifan.github.ui.base;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import cn.zhaiyifan.github.R;
import roboguice.activity.RoboActionBarActivity;

public class BaseActivity extends RoboActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
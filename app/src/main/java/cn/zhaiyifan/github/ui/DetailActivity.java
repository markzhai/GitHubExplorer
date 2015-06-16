package cn.zhaiyifan.github.ui;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.view.View;

import cn.zhaiyifan.github.R;
import cn.zhaiyifan.github.ui.base.BaseActivity;
import roboguice.inject.ContentView;

@ContentView(R.layout.activity_detail)
public class DetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(getResources().getString(R.string.repositories));
    }

    public void checkin(View view) {
        Snackbar.make(view, "checkin success!", Snackbar.LENGTH_SHORT).show();
    }
}
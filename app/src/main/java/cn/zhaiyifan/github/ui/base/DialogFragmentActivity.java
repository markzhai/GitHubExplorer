package cn.zhaiyifan.github.ui.base;

import android.os.Bundle;

import com.github.kevinsawicki.wishlist.ViewFinder;

import java.io.Serializable;

import cn.zhaiyifan.github.ui.listener.DialogResultListener;

/**
 * Base activity that display dialogs
 */
public abstract class DialogFragmentActivity extends BaseActivity implements DialogResultListener {

    /**
     * Finder bound to this activity's view
     */
    protected ViewFinder finder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        finder = new ViewFinder(this);
    }

    /**
     * Get intent extra
     *
     * @return serializable
     */
    @SuppressWarnings("unchecked")
    protected <V extends Serializable> V getSerializableExtra(final String name) {
        return (V) getIntent().getSerializableExtra(name);
    }

    protected int getIntExtra(final String name) {
        return getIntent().getIntExtra(name, -1);
    }

    protected int[] getIntArrayExtra(final String name) {
        return getIntent().getIntArrayExtra(name);
    }

    protected boolean[] getBooleanArrayExtra(final String name) {
        return getIntent().getBooleanArrayExtra(name);
    }

    protected String getStringExtra(final String name) {
        return getIntent().getStringExtra(name);
    }

    protected String[] getStringArrayExtra(final String name) {
        return getIntent().getStringArrayExtra(name);
    }

    protected CharSequence[] getCharSequenceArrayExtra(final String name) {
        return getIntent().getCharSequenceArrayExtra(name);
    }

    @Override
    public void onDialogResult(int requestCode, int resultCode, Bundle arguments) {
        // Intentionally left blank
    }
}
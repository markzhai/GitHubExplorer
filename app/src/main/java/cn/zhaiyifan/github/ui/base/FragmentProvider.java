package cn.zhaiyifan.github.ui.base;

import android.support.v4.app.Fragment;

/**
 * Provides a fragment
 */
public interface FragmentProvider {

    /**
     * Get selected fragment
     *
     * @return fragment
     */
    Fragment getSelected();
}
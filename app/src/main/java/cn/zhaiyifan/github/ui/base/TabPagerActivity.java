package cn.zhaiyifan.github.ui.base;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TabHost;

import com.github.kevinsawicki.wishlist.ViewUtils;

import cn.zhaiyifan.github.R;
import roboguice.inject.InjectView;

/**
 * Activity with tabbed pages
 *
 * @param <V>
 */
public abstract class TabPagerActivity<V extends PagerAdapter & FragmentProvider>
        extends PagerActivity implements TabHost.OnTabChangeListener, TabHost.TabContentFactory {

    @InjectView(R.id.tabs)
    protected TabLayout mTabLayout;

    @InjectView(R.id.viewpager)
    protected ViewPager mViewPager;

    /**
     * Pager adapter
     */
    protected V adapter;

    @Override
    public void onPageSelected(final int position) {
        super.onPageSelected(position);
    }

    @Override
    public void onTabChanged(String tabId) {
    }

    @Override
    public View createTabContent(String tag) {
        return ViewUtils.setGone(new View(getApplication()), true);
    }

    /**
     * Create pager adapter
     *
     * @return pager adapter
     */
    protected abstract V createAdapter();

    /**
     * Get title for position
     *
     * @return title
     */
    protected String getTitle(final int position) {
        return adapter.getPageTitle(position).toString();
    }

    /**
     * Get icon for position
     *
     * @return icon
     */
    protected String getIcon(final int position) {
        return null;
    }

    /**
     * Set tab and pager as gone or visible
     *
     * @return this activity
     */
    protected TabPagerActivity<V> setGone(boolean gone) {
        ViewUtils.setGone(mTabLayout, gone);
        ViewUtils.setGone(mViewPager, gone);
        return this;
    }

    /**
     * Set current item to new position
     * <p/>
     * This is guaranteed to only be called when a position changes and the
     * current item of the pager has already been updated to the given position
     * <p/>
     * Sub-classes may override this method
     *
     * @param position
     */
    protected void setCurrentItem(final int position) {
        // Intentionally left blank
    }

    private void updateCurrentItem(final int newPosition) {
        //if (newPosition > -1 && newPosition < adapter.getCount()) {
        ////    mViewPager.setItem(newPosition);
        //    setCurrentItem(newPosition);
        //}
    }

    private void createPager() {
        adapter = createAdapter();
        invalidateOptionsMenu();
        mViewPager.setAdapter(adapter);
    }

    public void updateTabs() {
        //mTabLayout.setViewPager(pager);
    }

    /**
     * Configure tabs and pager
     */
    protected void configureTabPager() {
        if (adapter == null) {
            createPager();
            updateTabs();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setSupportActionBar((android.support.v7.widget.Toolbar) findViewById(R.id.toolbar));

        // On Lollipop, the action bar shadow is provided by default, so have to remove it explicitly
        //getSupportActionBar().setElevation(0);

       // mViewPager.setOnPageChangeListener(this);
        //mTabLayout.setCustomTabView(R.layout.tab, R.id.tv_tab);
        //mTabLayout.setSelectedIndicatorColors(getResources().getColor(android.R.color.white));
       // mTabLayout.setDividerColors(0);
    }

    @Override
    protected FragmentProvider getProvider() {
        return adapter;
    }
}
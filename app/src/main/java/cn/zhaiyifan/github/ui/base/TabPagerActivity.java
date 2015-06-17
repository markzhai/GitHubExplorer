package cn.zhaiyifan.github.ui.base;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.widget.TabHost;

import com.github.kevinsawicki.wishlist.ViewUtils;

import cn.zhaiyifan.github.R;
import cn.zhaiyifan.github.ui.widget.ViewPager;
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
    protected V mPagerAdapter;

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
        return mPagerAdapter.getPageTitle(position).toString();
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
     */
    protected void setCurrentItem(final int position) {
        // Intentionally left blank
    }

    private void updateCurrentItem(final int newPosition) {
        if (newPosition > -1 && newPosition < mPagerAdapter.getCount()) {
            mViewPager.setItem(newPosition);
            setCurrentItem(newPosition);
        }
    }

    private void createPager() {
        mPagerAdapter = createAdapter();
        invalidateOptionsMenu();
        mViewPager.setAdapter(mPagerAdapter);
    }

    public void updateTabs() {
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabsFromPagerAdapter(mPagerAdapter);
    }

    /**
     * Configure tabs and pager
     */
    protected void configureTabPager() {
        mViewPager.addOnPageChangeListener(this);
        int tabTextColor = getResources().getColor(R.color.titleTextColor);
        mTabLayout.setTabTextColors(tabTextColor, tabTextColor);

        if (mPagerAdapter == null) {
            createPager();
            updateTabs();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        configureTabPager();
    }

    @Override
    protected FragmentProvider getProvider() {
        return mPagerAdapter;
    }
}
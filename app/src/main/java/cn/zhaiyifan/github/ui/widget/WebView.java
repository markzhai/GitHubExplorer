package cn.zhaiyifan.github.ui.widget;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Web view extension with scrolling fixes
 */
public class WebView extends android.webkit.WebView {

    public WebView(final Context context, final AttributeSet attrs,
                   final int defStyle, final boolean privateBrowsing) {
        super(context, attrs, defStyle, privateBrowsing);
    }

    public WebView(final Context context, final AttributeSet attrs,
                   final int defStyle) {
        super(context, attrs, defStyle);
    }

    public WebView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    public WebView(final Context context) {
        super(context);
    }

    private boolean canScrollCodeHorizontally(final int direction) {
        final int range = computeHorizontalScrollRange()
                - computeHorizontalScrollExtent();
        if (range == 0)
            return false;

        if (direction < 0)
            return computeHorizontalScrollOffset() > 0;
        else
            return computeHorizontalScrollOffset() < range - 1;
    }

    @Override
    public boolean canScrollHorizontally(final int direction) {
        return super.canScrollHorizontally(direction);
    }
}

package com.github.scrobot.coctaildb.ui.drinks;

import android.content.Context;
import android.graphics.*;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.github.scrobot.coctaildb.R;

public class BadgeDrawable extends Drawable {

    private Paint mBadgePaint;
    private boolean mWillDraw;

    public BadgeDrawable(Context context) {
        mBadgePaint = new Paint();
        mBadgePaint.setColor(ContextCompat.getColor(context.getApplicationContext(), R.color.filter_badge));
        mBadgePaint.setAntiAlias(true);
        mBadgePaint.setStyle(Paint.Style.FILL);
    }

    @Override
    public void draw(Canvas canvas) {

        if (!mWillDraw) {
            return;
        }
        Rect bounds = getBounds();
        float width = bounds.right - bounds.left;
        float height = bounds.bottom - bounds.top;

        // Position the badge in the top-right quadrant of the icon.

        /*Using Math.max rather than Math.min */

        float radius = ((Math.max(width, height) / 2)) / 2;
        float centerX = (width - radius - 1) +5;
        float centerY = radius -5;
        canvas.drawCircle(centerX, centerY, (int)(radius), mBadgePaint);
    }

    public void setmWillDraw(boolean mWillDraw) {
        this.mWillDraw = mWillDraw;
    }

    @Override
    public void setAlpha(int alpha) {
        // do nothing
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        // do nothing
    }

    @Override
    public int getOpacity() {
        return PixelFormat.UNKNOWN;
    }
}

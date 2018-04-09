package com.hencoder.hencoderpracticedraw6.practice.practice08;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.hencoder.hencoderpracticedraw6.R;

import static com.hencoder.hencoderpracticedraw6.Utils.dpToPixel;
import static com.hencoder.hencoderpracticedraw6.Utils.spToPixel;

public class Practice08ObjectAnimatorView extends View {
    final float radius = dpToPixel(80);

    RectF arcRectF = new RectF();
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint contentPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    float progress = 0;

    public Practice08ObjectAnimatorView(Context context) {
        super(context);
    }

    public Practice08ObjectAnimatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice08ObjectAnimatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setTextSize(spToPixel(40));
        paint.setTextAlign(Paint.Align.CENTER);

        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(spToPixel(20));

        contentPaint.setColor(Color.WHITE);
        contentPaint.setTextSize(spToPixel(14));
        contentPaint.setTextAlign(Paint.Align.CENTER);
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
        invalidate();
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float centerX = getWidth() / 2;
        float centerY = getHeight() / 2;

        paint.setColor(Color.parseColor("#F4F4F4"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(dpToPixel(15));
        canvas.drawCircle(centerX, centerY, radius, paint);

        paint.setColor(Color.parseColor("#21A2DE"));
        paint.setStrokeCap(Paint.Cap.ROUND);
        arcRectF.set(centerX - radius, centerY - radius, centerX + radius, centerY + radius);
        canvas.drawArc(arcRectF, -110, progress * 3.6f, false, paint);

        String text = (int) progress + "";
        float processY = centerY + (paint.descent() - paint.ascent() - (contentPaint.descent() - contentPaint.ascent()))/2-10;
        float contentTextY = centerY + (paint.descent() - paint.ascent() + (contentPaint.descent() - contentPaint.ascent()))/2;

        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
//        canvas.drawText(text, centerX, centerY - (paint.ascent() + paint.descent()) / 2, paint);
//        canvas.drawText("%", centerX + paint.measureText(text) / 2,
//                centerY - (paint.ascent() + paint.descent()) / 2, smallTextPaint);

        canvas.drawText(text, centerX, processY, paint);
        canvas.drawText("%", centerX + paint.measureText(text) / 2, processY, textPaint);

        canvas.drawText(getResources().getString(R.string.info_recently_report),
                centerX, contentTextY, contentPaint);

    }
}

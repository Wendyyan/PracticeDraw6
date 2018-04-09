package com.hencoder.hencoderpracticedraw6;

import android.content.res.Resources;
import android.util.DisplayMetrics;

public class Utils {
    public static float dpToPixel(float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        return dp * metrics.density;
    }

    public static float spToPixel(float sp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        return sp * metrics.scaledDensity;
    }
}

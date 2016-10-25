package com.example.tuananh.gridviewcustom.utils;

import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * Created by framgia on 25/10/2016.
 */
public class Utils {
    public static int convertDpToPx(int dp) {
        return Math.round(dp * Resources.getSystem().getDisplayMetrics().densityDpi /
            DisplayMetrics.DENSITY_DEFAULT);
    }
}

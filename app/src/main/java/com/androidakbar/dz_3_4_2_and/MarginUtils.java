package com.androidakbar.dz_3_4_2_and;

import android.app.Activity;
import android.content.Intent;

public class MarginUtils {
    private static int sTheme = R.style.AppTheme;

    public static void changeToTheme(Activity activity, int theme) {
        sTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    public static void onActivityCreateSetTheme(Activity activity) {
        activity.setTheme(sTheme);
    }
}

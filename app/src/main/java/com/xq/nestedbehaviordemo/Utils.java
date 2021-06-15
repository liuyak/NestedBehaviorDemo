package com.xq.nestedbehaviordemo;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<String> getCommonItems(int count) {
        List<String> items = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            items.add(String.valueOf(i));
        }
        return items;
    }

    public static float dipToPix(Context context, float dip) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, metrics);
    }
} 
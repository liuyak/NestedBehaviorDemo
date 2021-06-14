package com.xq.nestedbehaviordemo;

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
} 
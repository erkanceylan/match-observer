package com.erkanceylan.match_watcher_v_01.Utilities;

import android.graphics.Color;

/**
 * Created by ERKAN on 26.11.2016.
 */

public class COLOR
{
    public static int getColor(String abr)
    {
        switch (abr)
        {
            case "PL":
                return Color.rgb(13,71,161);
            case "ELC":
                return Color.rgb(244,67,54);
            case "BL1":
                return Color.rgb(76,175,80);
            case "DED":
                return Color.rgb(255,87,34);
            case "FL1":
                return Color.rgb(96,125,139);
            case "SA":
                return Color.rgb(0,188,212);
            case "PPL":
                return Color.rgb(156,39,176);
            default:
                return Color.CYAN;
        }
    }
}

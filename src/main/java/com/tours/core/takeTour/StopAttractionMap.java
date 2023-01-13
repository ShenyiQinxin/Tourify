package com.tours.core.takeTour;

import java.util.Map;

public class StopAttractionMap {
    public static Map<Integer, Attraction> stopAttractionMap = Map.of(
            1, new Museum(null, ""),
            2, new Park(null, ""),
            3, new Memorial(null, ""));
}

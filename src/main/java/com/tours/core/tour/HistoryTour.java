package com.tours.core.tour;

import com.tours.core.towns.TownName;

public class HistoryTour extends Tour {
    public HistoryTour(TownName location, TourSchedule tourSchedule, String name, Double price) {
        super(location, tourSchedule, name, price);
    }

    @Override
    public int getNumberOfTourToday() {
        return 0;
    }
}

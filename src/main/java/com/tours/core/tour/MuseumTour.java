package com.tours.core.tour;

import com.tours.core.towns.TownName;

public class MuseumTour extends Tour{
    public MuseumTour(TownName location, TourSchedule tourSchedule, String name, Double price) {
        super(location, tourSchedule, name, price);
    }

    @Override
    public int getNumberOfTourToday() {
        return 0;
    }
}

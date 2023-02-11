package com.tours.core.tour;

import com.tours.core.towns.AlexandriaTourism;
import com.tours.core.towns.ArlingtonTourism;
import com.tours.core.towns.TownName;

public class TourFactory {
    private static volatile TourFactory tourFactory;

    private TourFactory () {}

    public static TourFactory getInstance() {
        if (tourFactory == null) {
            synchronized (TourFactory.class) {
                if (tourFactory == null) {
                    tourFactory = new TourFactory();
                }
            }
        }
        return tourFactory;
    }

    public Tour createTourAtLocation(TourType tourType, TownName townName) {
        return switch (townName) {
            case ALEXANDRIA -> new AlexandriaTourism().createTour(tourType);
            case ARLINGTON -> new ArlingtonTourism().createTour(tourType);
        };
    }
}

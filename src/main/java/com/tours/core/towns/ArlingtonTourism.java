package com.tours.core.towns;

import com.tours.core.hospitality.Hospitality;
import com.tours.core.hospitality.HospitalityType;
import com.tours.core.tour.*;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ArlingtonTourism implements Tourism{
    private static final TownName townName = TownName.ARLINGTON;

    private static volatile ArlingtonTourism arlingtonTourism;


    public static ArlingtonTourism getInstance() {
        if (arlingtonTourism == null) {
            synchronized (AlexandriaTourism.class) {
                if (arlingtonTourism == null) {
                    arlingtonTourism = new ArlingtonTourism();
                }
            }
        }
        return arlingtonTourism;
    }


    @Override
    public Tour createTour(TourType tourType) {
        return switch (tourType) {
            case HISTORY -> new HistoryTour(townName, null, null, null);
            case GHOST -> new GhostTour(townName, null, null, null);
            case MUSEUM -> new MuseumTour(townName, null, null, null);
        };
    }

    @Override
    public Hospitality createHospitality(HospitalityType hospitalityType) {
        return null;
    }
}

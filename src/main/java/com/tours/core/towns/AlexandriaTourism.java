package com.tours.core.towns;

import com.tours.core.hospitality.Hospitality;
import com.tours.core.hospitality.HospitalityType;
import com.tours.core.tour.*;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class AlexandriaTourism implements Tourism {
    private static final TownName townName = TownName.ALEXANDRIA;
    private static volatile AlexandriaTourism alexandriaTourism;


    public static AlexandriaTourism getInstance() {
        if (alexandriaTourism == null) {
            synchronized (AlexandriaTourism.class) {
                if (alexandriaTourism == null) {
                    alexandriaTourism = new AlexandriaTourism();
                }
            }
        }
        return alexandriaTourism;
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

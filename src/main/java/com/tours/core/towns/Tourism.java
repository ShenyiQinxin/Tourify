package com.tours.core.towns;

import com.tours.core.hospitality.Hospitality;
import com.tours.core.hospitality.HospitalityType;
import com.tours.core.tour.Tour;
import com.tours.core.tour.TourType;

public interface Tourism {


    Tour createTour(TourType tourType);

    Hospitality createHospitality(HospitalityType hospitalityType);
}

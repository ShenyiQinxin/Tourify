package com.tours.core.tour;

import com.tours.core.towns.TownName;
import lombok.Data;

@Data
public abstract class Tour {
    protected final TownName location;
    protected final TourSchedule tourSchedule;
    protected final String name;
    protected final Double price;

    public abstract int getNumberOfTourToday();
}

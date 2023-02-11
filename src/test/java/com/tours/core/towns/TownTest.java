package com.tours.core.towns;

import com.tours.common.TourException;
import com.tours.core.tour.GhostTour;
import com.tours.core.tour.Tour;
import com.tours.core.tour.TourFactory;
import com.tours.core.tour.TourType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class TownTest {
    private final TourFactory tourFactory = TourFactory.getInstance();



    @Test
    void createTown() throws TourException {
        Tour alexGhostTour = tourFactory.createTourAtLocation(TourType.GHOST, TownName.ALEXANDRIA);
        Assertions.assertThat(alexGhostTour).isInstanceOf(GhostTour.class);

    }

    @Test
    void createNullTown() throws TourException {
        Assertions.assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> tourFactory.createTourAtLocation(TourType.HISTORY, TownName.valueOf(null)))
                .withMessage("Name is null");
    }

    @Test
    void createIllegalTown() throws TourException {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> tourFactory.createTourAtLocation(TourType.MUSEUM, TownName.valueOf("anything")));


    }
}

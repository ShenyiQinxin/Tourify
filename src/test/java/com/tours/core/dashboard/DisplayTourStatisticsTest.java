package com.tours.core.dashboard;

import com.tours.core.tour.GhostTour;
import com.tours.core.towns.TownName;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DisplayTourStatisticsTest {

    private TourStatistics tourStatistics;
    private DataDisplay dataDisplay;
    private GhostTour ghostTour;

    @BeforeEach
    void setUp() {
        ghostTour = new GhostTour(TownName.ALEXANDRIA, null, "Test_tour", 10.0);
        tourStatistics = new TourStatistics(ghostTour);
        dataDisplay = new DataDisplay();

    }

    @Test
    void displayUpdatedTourCount() {
        // Given observer dataDisplay
        Assertions.assertThat(dataDisplay.getTourCount()).isEqualTo(0);
        // And register the dataDisplay and notify the dataDisplay
        tourStatistics.registerObserver(dataDisplay);
        tourStatistics.notifyObserver();
        // Then dataDisplay has the tour count of the ghost tour
        Assertions.assertThat(dataDisplay.getTourCount())
                .isEqualTo(ghostTour.getNumberOfTourToday())
                .isEqualTo(10);

        tourStatistics.removeObserver(dataDisplay);
        Assertions.assertThat(tourStatistics.getObservers().size()).isEqualTo(0);

    }
}

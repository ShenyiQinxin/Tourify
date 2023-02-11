package com.tours.core.takeTour;

import com.tours.tourist.*;
import org.junit.jupiter.api.Test;

public class VisitAttractionsTest {

    @Test
    void visitAttraction() {
        Itinerary newItinerary = new Itinerary();
        Attraction attractionChain = new Park(new Museum(new Memorial(null, "National Memorial"), "Fireworks Museum"), "Waterfront Park");
        newItinerary.setAttractionChain(attractionChain);
        newItinerary.visitAttraction(1);
        newItinerary.visitAttraction(2);
        newItinerary.visitAttraction(3);
    }
}

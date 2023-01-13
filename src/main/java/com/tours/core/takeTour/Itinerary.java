package com.tours.core.takeTour;

public class Itinerary {
    private Attraction attractionChain;


    public void setAttractionChain(Attraction attractionChain) {
        this.attractionChain = attractionChain;
    }

    public void visitAttraction(int stopNumber) {
        attractionChain.visitAttraction(stopNumber);
    }
}

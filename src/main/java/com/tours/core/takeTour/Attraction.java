package com.tours.core.takeTour;

public abstract class Attraction {
    private Attraction nextAttraction;
    public Attraction(Attraction nextAttraction) {
        this.nextAttraction = nextAttraction;
    }

    public void visitAttraction(int stopNumber) {
        if (nextAttraction != null) {
            nextAttraction.visitAttraction(stopNumber);
        }
    }
}

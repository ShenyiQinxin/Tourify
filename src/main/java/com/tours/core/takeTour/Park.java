package com.tours.core.takeTour;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Park extends Attraction{
    private final String name;
    public Park(Attraction nextAttraction, String name) {
        super(nextAttraction);
        this.name = name;
    }

    @Override
    public void visitAttraction(int stopNumber) {
        if (StopAttractionMap.stopAttractionMap.get(stopNumber) instanceof Park) {
            log.info("Visiting a park at stop {}", stopNumber);
        } else {
            super.visitAttraction(stopNumber);
        }

    }
}

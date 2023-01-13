package com.tours.core.takeTour;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Museum extends Attraction{
    private final String name;
    public Museum(Attraction nextAttraction, String name) {
        super(nextAttraction);
        this.name = name;
    }

    @Override
    public void visitAttraction(int stopNumber) {
        if (StopAttractionMap.stopAttractionMap.get(stopNumber) instanceof Museum) {
            log.info("Visiting a museum at stop {}", stopNumber);
        } else {
            super.visitAttraction(stopNumber);
        }


    }

}

package com.tours.core.takeTour;

import lombok.Data;

@Data
public class Stop {
    public Stop(int stopNumber) {
        this.stopNumber = stopNumber;
    }

    private int stopNumber;

}

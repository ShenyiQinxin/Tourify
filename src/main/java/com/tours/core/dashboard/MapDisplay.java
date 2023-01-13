package com.tours.core.dashboard;

import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@Log4j2
@ToString
public class MapDisplay implements Observer{
    @Override
    public void update(int count) {
        log.info("The latest count {}", count);
    }

}

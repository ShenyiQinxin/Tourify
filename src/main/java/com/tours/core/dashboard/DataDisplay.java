package com.tours.core.dashboard;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
public class DataDisplay implements Observer{
    private int tourCount;
    @Override
    public void update(int count) {
        log.info("The latest count {}", count);
        tourCount = count;

    }
}

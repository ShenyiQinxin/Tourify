package com.tours.core.dashboard;

import com.tours.core.tour.Tour;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Log4j2
@Getter
@Setter
public class TourStatistics implements Publisher {

    private final List<Observer> observers;
    private final Tour tour;

    public TourStatistics(Tour tour) {
        this.observers = new ArrayList<>();
        this.tour = tour;
    }


    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);

    }

    @Override
    public void removeObserver(Observer observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
        } else {
            throw new IllegalArgumentException("The observer does not exists " + observer.toString());
        }

    }

    @Override
    public void notifyObserver() {
        for (Observer observer: observers
             ) {
            log.info("Notifying observers on the change of today's tour count");
            observer.update(tour.getNumberOfTourToday());
        }

    }


}

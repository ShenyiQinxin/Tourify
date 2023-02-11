package com.tours.core.dashboard;

public interface Publisher {

    public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObserver();
}

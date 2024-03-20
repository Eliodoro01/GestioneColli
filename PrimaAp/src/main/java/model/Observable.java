package model;

import java.util.ArrayList;
import java.util.List;

import util.Observer;

public class Observable {
	private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Collo collo) {
        for (Observer observer : observers) {
            observer.update(collo);
        }
    }
}

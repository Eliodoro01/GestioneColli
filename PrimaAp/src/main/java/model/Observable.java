package model;

import java.util.ArrayList;
import java.util.List;

import util.Observer;

public class Observable {
	
	//essendo che noi andiamo a gestire una persistenza nel DB andiamo a gestire un collo alla volta 
	private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(int id, String stato) {
        for (Observer observer : observers) {
            observer.updateStato(id, stato);
        }
    }
}

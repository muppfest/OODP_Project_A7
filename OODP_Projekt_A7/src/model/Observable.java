package model;

import java.util.List;

import view.Observer;

public abstract class Observable {
	public abstract void registerObserver(Observer observer);
	public abstract void notifyObservers();
	public abstract List<String> getLastUpdate();  
}

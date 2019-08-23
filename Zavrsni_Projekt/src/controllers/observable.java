package controllers;

public interface observable {

	void add(observer o);

	void remove(observer o);

	void notifyObs();

}

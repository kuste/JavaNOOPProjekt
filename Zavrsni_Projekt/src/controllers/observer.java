package controllers;

import java.util.List;

import models.User;

public interface observer {

	void subscribe(observable o);

	void update(List<User> userList);
}

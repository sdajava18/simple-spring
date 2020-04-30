package org.websparrow;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDatabase {

    private List<User> users = new ArrayList<>();

    public UserDatabase() {
        users.add(new User("Jan", "Kowalski", 26));
        users.add(new User("Karol", "Nowak", 30));
        users.add(new User("Anna", "Kowalska", 18));
    }

    public Optional<User> getUserByName(String name){
        return this.users.stream()
                .filter(user -> user.getName().equals(name))
                .findFirst();
    }
}

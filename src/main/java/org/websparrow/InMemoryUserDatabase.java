package org.websparrow;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryUserDatabase implements IUserDatabase, InitializingBean, DisposableBean {

    private List<User> users;

    public InMemoryUserDatabase() {
        User user1 = new User("Jan", "Kowalski", 25);
        User user2 = new User("Karol", "Nowak", 25);
        User user3 = new User("Brutus", "Kowalski", 25);

        users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
    }

    @Override
    public Optional<User> getByName(String name) {
        for(User user: users){
            if(user.getName().equals(name)){
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean zainicjowany " + this.getClass().getSimpleName());
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Bean prawie zniszczony" + this.getClass().getSimpleName());
    }
}

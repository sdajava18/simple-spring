package org.websparrow;

import java.util.Optional;

public interface IUserDatabase {

    Optional<User> getByName(String name);

}

package model.builder;

import model.User;
import model.UserType;

import java.util.Date;

/**
 * @author Negin Mousavi
 */
public class UserBuilder {
    private final User user = new User();

    public static UserBuilder getBuilder() {
        return new UserBuilder();
    }

    public User build() {
        return user;
    }

    public UserBuilder withFirstName(String name) {
        user.setFirstName(name);
        return this;
    }

    public UserBuilder withLastName(String name) {
        user.setLastName(name);
        return this;
    }

    public UserBuilder withNationalCode(String NationalCode) {
        user.setNationalCode(NationalCode);
        return this;
    }

    public UserBuilder withCreationDate(Date date) {
        user.setCreationDate(date);
        return this;
    }

    public UserBuilder withType(UserType type) {
        user.setType(type);
        return this;
    }
}

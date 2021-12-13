package ru.pcs.web.services;


import ru.pcs.web.forms.UserForm;
import ru.pcs.web.models.User;

import java.util.List;

public interface UsersService {
    List<User> getAllUsers();
    User getUser(Integer userId);
    void deleteUser(Integer userId);
    void update(Integer userId, UserForm userForm);
}

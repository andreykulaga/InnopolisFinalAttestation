package ru.pcs.web.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.pcs.web.forms.UserForm;
import ru.pcs.web.models.User;
import ru.pcs.web.repositories.UsersRepository;

import java.util.List;

@RequiredArgsConstructor
@Component
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public User getUser(Integer userId) {
        return usersRepository.getById(userId);
    }

    @Override
    public void deleteUser(Integer userId) {
        usersRepository.deleteById(userId);
    }

    @Override
    public void update(Integer userId, UserForm form) {
        User user = usersRepository.getById(userId);
        user.setRole(form.getRole());
        usersRepository.save(user);
    }
}

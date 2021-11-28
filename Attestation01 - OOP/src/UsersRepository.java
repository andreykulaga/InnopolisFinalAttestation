import java.util.List;

public interface UsersRepository {
    List<User> findAll();
    User findById(int id);
    void update(User user);

}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


public class UsersRepositoryFileImpl implements UsersRepository {

    private String fileName;

    public UsersRepositoryFileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();

            while (line != null) {
                String[] parts = line.split("\\|");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                boolean isWorker = Boolean.parseBoolean(parts[3]);
                User newUser = new User(id, name, age, isWorker);
                users.add(newUser);
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return users;
    }

    @Override
    public User findById(int id) {
        List<User> users = findAll();
        User tempUser = users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
        if (tempUser == null) {
            System.out.println("Пользователь не найден");
        }
        return tempUser;

    }

    @Override
    public void update(User user) {
        List<User> users = findAll();
        ListIterator<User> it = users.listIterator();

        try (Writer writer = new FileWriter(fileName); BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            while (it.hasNext()) {
                User tempUser = it.next();
                if (tempUser.getId() == user.getId()) {
                    tempUser = user;
                }
                bufferedWriter.write(tempUser.getId() + "|" + tempUser.getName() + "|" + tempUser.getAge() + "|" + tempUser.isWorker());
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}

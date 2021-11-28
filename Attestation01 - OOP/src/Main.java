import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UsersRepository usersRepository = new UsersRepositoryFileImpl("src/users.txt");
        Scanner scanner = new Scanner(System.in);

        List<User> users = usersRepository.findAll();
        for (User user : users) {
            System.out.println(user.getId() + " " + user.getAge() + " " + user.getName() + " " + user.isWorker());
        }


        System.out.println("Введите ID пользователя, которого хотите изменить");
        int id = Integer.parseInt(scanner.nextLine());
        User userForChange = usersRepository.findById(id);
        if (userForChange != null) {

            System.out.println("Введите новое имя");
            String newName = scanner.nextLine();
            userForChange.setName(newName);
            System.out.println("Введите новый возраст");
            int newAge = scanner.nextInt();
            userForChange.setAge(newAge);
            System.out.println(userForChange.getId() + " " + userForChange.getAge() + " " + userForChange.getName() + " " + userForChange.isWorker());
            usersRepository.update(userForChange);
        }
    }
}


package repository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UsersRepository usersRepository = new UsersRepositoryFileImpl("src/users");

        List<User> users = usersRepository.findAll();
        for (User user : users) {
            System.out.println(user.getAge() + " " + user.getName() + " " + user.isWorker());
        }
        System.out.println();

        List<User> users33 = usersRepository.findByAge(33);
        System.out.println("33-летние пользователи:");
        for (User user : users33) {
            System.out.println(user.getName() + " " + user.isWorker());
        }
        System.out.println();

        List<User> workers = usersRepository.findByIsWorkerIsTrue();
        System.out.println("Работающие пользователи:");
        for (User user : workers) {
            System.out.println(user.getAge() + " " + user.getName());
        }

        //User user = new User("Игорь", 33, true);
        //usersRepository.save(user);
    }
}


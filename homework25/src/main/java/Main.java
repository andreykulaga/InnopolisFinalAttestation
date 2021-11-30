import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class Main {
    public static void main(String[] args) {
        DataSource dataSource = new DriverManagerDataSource("jdbc:postgresql://localhost:5432/ProductsRepository", "postgres", "gor2set");
        ProductRepository usersRepository = new ProductsRepositoryJdbcTemplateImpl(dataSource);

        System.out.println("Все товары");
        System.out.println(usersRepository.findAll());

        System.out.println("Товары с ценой 1000");
        System.out.println(usersRepository.findAllByPrice(1000));

        System.out.println("Товары заказанные 3 раза");
        System.out.println(usersRepository.findAllByOrdersCount(3));


    }
}

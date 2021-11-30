import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class ProductsRepositoryJdbcTemplateImpl implements ProductRepository {

    //language=SQL
    private static final String SQL_INSERT = "INSERT INTO product (title, price, amount) VALUES (?, ?, ?)";

    //language=SQL
    private static final String SQL_SELECT_ALL = "SELECT * FROM product ORDER BY id";

    //language=SQL
    private static final String SQL_SELECT_BY_PRICE = "SELECT * FROM product WHERE price = ";

    //language=SQL
    private static final String SQL_SELECT_BY_ORDERS_COUNT = "select id, title, price, amount from (select id, title, price, amount, count(id) from product join orders on product.id = orders.good_id group by id) as foo where count = ";


    private JdbcTemplate jdbcTemplate;

    public ProductsRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final RowMapper<Product> userRowMapper = (row, rowNumber) -> {
        int id = row.getInt("id");
        String title = row.getString("title");
        Double price = row.getDouble("price");
        int amount = row.getInt("amount");
        return new Product(id, title, price, amount);
    };

    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, userRowMapper);
    }

    @Override
    public List<Product> findAllByPrice(double price) {
        return jdbcTemplate.query(SQL_SELECT_BY_PRICE + price, userRowMapper);
    }

    @Override
    public List<Product> findAllByOrdersCount(int ordersCount) {
        return jdbcTemplate.query(SQL_SELECT_BY_ORDERS_COUNT + ordersCount, userRowMapper);
    }

    @Override
    public void save(Product product) {
        jdbcTemplate.update(SQL_INSERT, product.getTitle(), product.getPrice(), product.getAmount());

    }





}

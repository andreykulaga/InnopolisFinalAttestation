import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Product {

    private int id;
    private String title;
    private double price;
    private int amount;
}

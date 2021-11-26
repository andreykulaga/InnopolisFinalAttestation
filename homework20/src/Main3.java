import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.OptionalDouble;

public class Main3 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/cars.txt"))) {
            String model = "Camry";

            OptionalDouble averagePrice = reader.lines()
                    .filter(line -> {
                        if (!line.equals("")) {
                            String[] parts = line.split("\\|");
                            return parts[1].equals(model);
                        } else {
                            return false;
                        }
                    })
                    .map(line -> {
                        String[] parts = line.split("\\|");
                        return Double.parseDouble(parts[4]);
                    })
                    .mapToDouble(c -> c.doubleValue())
                    .average();

            System.out.print("Средняя стоимость модели " + model + " - ");
            averagePrice.ifPresent(System.out::println);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}

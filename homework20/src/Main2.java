import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

import static java.util.Comparator.*;

public class Main2 {
    public static void main(String[] args) {

        System.out.print("Цвет автомобиля с минимальной стоимостью: ");

        try (BufferedReader reader = new BufferedReader(new FileReader("src/cars.txt"))) {
                    Optional<String> colour = reader.lines()
                    .min(comparing(line -> {
                        if (!line.equals("")) {
                            String[] parts = line.split("\\|");
                            return Integer.parseInt(parts[4]);
                        } else {
                            return 100000000;
                        }
                    }))
                    .map(line -> {
                        String[] parts = line.split("\\|");
                        return parts[2];
                    });
            colour.ifPresent(System.out::println);

        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}

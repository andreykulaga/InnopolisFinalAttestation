import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static java.util.Comparator.*;

public class Main2 {
    public static void main(String[] args) {

        System.out.println("Цвет автомобиля с минимальной стоимостью:");

        // я не понимаю, почему он выводит "Optional[Red]", а не просто "RED"

        try (BufferedReader reader = new BufferedReader(new FileReader("src/cars.txt"))) {
            System.out.println(
                    reader.lines()
                    .min(comparing(line -> {
                        if (!line.equals("")) {
                            String[] parts = line.split("\\|");
                            return Integer.parseInt(parts[3]);
                        } else {
                            return 100000000;
                        }
                    }))
                    .map(line -> {
                        String[] parts = line.split("\\|");
                        return parts[2];
                    })
            );
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}

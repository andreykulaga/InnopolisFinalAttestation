import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        System.out.println("Номера всех автомобилей, имеющих черный цвет или нулевой пробег:");
        try (BufferedReader reader = new BufferedReader(new FileReader("src/cars.txt"))) {
            reader.lines()
                    .filter(line -> line.contains("Black") || line.contains("|0|"))
                    .map(line -> {
                        String[] parts = line.split("\\|");
                        return parts[0];
                    })
                    .forEach(line -> System.out.println(line));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}

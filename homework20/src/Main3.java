import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main3 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/cars.txt"))) {
            String model = "Camry";
            System.out.print("Средняя стоимость модели " + model + " - ");

            //тоже не знаю как убрать "Optional" при выводе средней стоимости

            System.out.println(
                    reader.lines()
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
                        return parts[4];
                    })
                    .reduce((line1, line2) -> String.valueOf((Double.parseDouble(line1) + Double.parseDouble(line2))/2))
            );

        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main1 {
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("src/cars.txt"))) {
            long count = reader.lines()
                    .filter(line -> {
                        if (!line.equals("")) { //так как возвращает пустую строку в конце файла
                            String[] parts = line.split("\\|");
                            int x = Integer.parseInt(parts[4]);
                            return x >= 700000 && x <= 800000;
                            } else {
                            return false;
                        }
                    })
                    .map(line -> {
                        String[] parts = line.split("\\|");
                        return parts[1];
                    })
                    .distinct()
                    .count();
            System.out.println("Уникальных моделей в ценовом диапазоне от 700 до 800 тыс.: " + count);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}

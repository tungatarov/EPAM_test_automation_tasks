import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 1.   Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.

public class CollectionsFirst {
    public static void main(String[] args) {
        File file = new File("./src/files", "first.txt");
        List<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                lines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found.");
        }
        Collections.reverse(lines);
        try (PrintWriter writer = new PrintWriter(file)) {
            for (String line : lines) {
                writer.println(line);
            }
            System.out.println("The lines were saved to the file in reverse order.");
        } catch (IOException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
        }
    }
}

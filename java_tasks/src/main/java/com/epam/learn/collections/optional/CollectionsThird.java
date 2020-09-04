import java.io.File;
import java.util.Arrays;
import java.util.List;

// 3.   Создать список из элементов каталога и его подкаталогов.

public class CollectionsThird {
    public static void main(String[] args) {
        String path = "./src";
        File file = new File(path);
        List<String> list = Arrays.asList(file.list());
        System.out.println("List of catalog items and its subdirectories:");
        System.out.println(list);
    }
}


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

// suppose a Java application called Sort sorts lines in a file.
public class Sort {

    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.out.println("please supply an argument: file name");
            return;
        }

        Path path = Paths.get(args[0]);

        if (!Files.exists(path)) {
            System.out.println("no such file : " + path.toString());
            return;
        }

        List<String> lines = Files.readAllLines(path);

        Collections.sort(lines);

        for (String s : lines)
            System.out.println(s);
        
    }
}
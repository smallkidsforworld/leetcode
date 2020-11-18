import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WriteIntoFile {
    
    public static boolean writeFile(String url, List<String> data) throws Exception {
        return writeFile(url, (String[]) data.toArray());
    }

    public static boolean writeFile(String url, String... data) throws Exception {
        File file = new File(url);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            for (String str : data)
                bw.write(str + "\n");
            bw.write("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public static List<String> readFile(String url) throws Exception {
        File file = new File(url);
        List<String> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            data.addAll(br.lines().collect(Collectors.toList()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

}
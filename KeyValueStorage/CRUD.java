import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CRUD {
    static String fileName="C://Users//arun_bhati//Desktop//KVStorage//data-layer//TextFile.txt";
    public static String search(String key){//reading from down
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            List<String> list=stream.collect(Collectors.toList());

            for(int i=list.size()-1;i>=0;--i){
                String line=list.get(i);
                String keyFromFile=line.split(":")[0];
                if(key.equals(keyFromFile)){
                    return line.split(":")[1];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    static void insert(String key,String value){ //Inserting at bottom
        try {
            File file = new File(fileName);
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write(key+":"+value);
            bw.close();          
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    static void delete(String key){ // marking the line as deleted
        try {
            Path path = Paths.get(fileName);
            Stream <String> lines = Files.lines(path);
            List <String> replaced = lines.map(line -> {
                if(line.split(":")[0].equals(key)){
                    return "#"+line;
                }
                return line;
            }).collect(Collectors.toList());
            Files.write(path, replaced);
            lines.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        insert("PM2", "MOdi2");
        System.out.println(search("PM"));
        delete("PM2");
        System.out.println(search("PM2"));
    }
}

//
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class Main {
    ArrayList <Object> city = new ArrayList<>();
    String filePath = "C:\\Users\\User\\Sber\\city_ru.CSV";

    public Object excelCreate () throws IOException {
        FileReader fileReader;
        {
            try {
                fileReader = new FileReader(filePath);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNext()){
                String str = scanner.nextLine();

                List<String>  list = Arrays.asList(str.split(";"));
                if (list.size()==4){
                    list = new ArrayList<>(list);
                    list.add("No information");
                }
               ArrayList arrayList = new ArrayList<>();
                arrayList.add("name="+list.get(0));
                arrayList.add("region="+ list.get(1));
                arrayList.add("district="+ list.get(2));
                arrayList.add("population="+  list.get(3));
                arrayList.add("foundation="+ list.get(4));
                city.add(arrayList);
            }
            fileReader.close();
        }
        return city;
    }
    public static void main(String[] args) throws IOException {
       Main main = new Main();
        main.excelCreate();
        for (Object obj : main.city){
            System.out.println(obj);
        }
    }
}
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileOperation {


    public ArrayList<String> readFile(String fileName) {


        ArrayList<String> list = new ArrayList<String>();
        File myObj = new File(fileName);
        try {
            Scanner scanner = new Scanner(myObj);
            while(scanner.hasNextLine()){
                list.add(scanner.nextLine());

            }

            scanner.close();
            return list;
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }

        return list;
    }
    public void writeData(String fileName,String data){
        try {
            FileWriter writer = new FileWriter(fileName,true);
            writer.append(data+" \n");

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

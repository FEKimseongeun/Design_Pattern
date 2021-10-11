package decoratorPattern;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;

public class LoadHudDisplays implements LoadDisplayInterface{
    String filename;
    LoadHudDisplays(String filename){
        this.filename = filename;
    }

    public ArrayList<String> load(){
        ArrayList<String> list = new ArrayList<String>();
        try {
            File file = new File(filename);
            BufferedReader inFile = new BufferedReader(new FileReader(file));
            String line = "";
            while( (line = inFile.readLine()) != null ) {
                System.out.println(line);
                list.add(line);
            }
            inFile.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }


}

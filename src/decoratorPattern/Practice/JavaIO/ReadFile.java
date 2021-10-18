package decoratorPattern.Practice.JavaIO;

import java.io.*;

public class ReadFile {
    public static void main(String[] args) {
        try{
            LineNumberReader readme=new LineNumberReader(new FileReader("readme.txt"));
            String line=readme.readLine();
            System.out.println("line + " + readme.getLineNumber()+ " = "+line);
        }catch (Exception e){
            e.printStackTrace();
        }

//        try{
//            BufferedReader readme=new BufferedReader(new FileReader("readme.txt"));
//            String line=readme.readLine();
//            System.out.println("line = "+ line);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

//        try{
//            BufferedInputStream readme=new BufferedInputStream(new FileInputStream ("readme.txt"));
//            int b= readme.read();
//            System.out.println("b = "+ b);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

//        try{
//            FileInputStream readme=new FileInputStream("readme.txt");
//            int b = readme.read();
//            System.out.println("b+ = " + b);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }
}

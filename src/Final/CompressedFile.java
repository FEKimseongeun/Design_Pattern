
import java.util.ArrayList;
import java.util.List;



public class CompressedFile {
    private String name;
    private int compressedRate;
    private File inFile;
    public CompressedFile(String name, int compressedRate){
        this.name=name;
        this.compressedRate=compressedRate;
    }


    public void addFile(File f){
        this.inFile=f;
    }

    public void equals(File f){
        if(f.getFileName().equals(inFile.getFileName())){
            System.out.println("같음");
        }
    }

    public void uncompress(){
        System.out.println(inFile.getFileSize() +  " 바이트 파일 "+inFile.getFileName()+ " 를 압축 해제");
    }

    public File getFile(int num){
        return inFile;
    }

    public int getFileSize(){
        return inFile.getFileSize();
    }


}

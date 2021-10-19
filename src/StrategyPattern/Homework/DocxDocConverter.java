package StrategyPattern.Homework;

public class DocxDocConverter extends DocConverter {
    public DocxDocConverter() {
        super("docx");
    }

    public void save(String fileName) {
        System.out.println(fileName + getExtension() + "濡� 蹂��솚�빐�꽌 ���옣�빀�땲�떎.");
    }
}

package StrategyPattern.Homework;

import java.util.HashMap;
import java.util.Map;

public class WordProcessor {
    private ISpellChecker spellChecker;
    private Map<String, DocConverter> map;
    private String fileName;

    public WordProcessor(String name) {
        fileName = name;
        map = new HashMap<String, DocConverter>();
    }

    public void addDocConverter(DocConverter converter) {
        map.put(converter.getExtension(), converter);
    }

    public void convertDocTo(String ext) {
        if (map.containsKey(ext)) {
            DocConverter converter = map.get(ext);
            converter.save(fileName);
        }
        else {
            System.out.println(ext + "파일 형식을 지원하는 DocConverter가 없습니다");
        }
    }

    public void setSpellChecker(ISpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }

    public void checkSpelling() {
        if (spellChecker != null) {
            spellChecker.check();
        }
    }
}

package StrategyPattern.Practice;

public class CompareSize implements Comparable {
    @Override
    public int compareTo(Object o1, Object o2) {
        FileInfo size1=(FileInfo) o1;
        FileInfo size2=(FileInfo) o2;
        return size1.getSize()-size2.getSize();
    }
}

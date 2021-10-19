package StrategyPattern.Practice;

public class CompareModifiedDate implements Comparable {
    @Override
    public int compareTo(Object o1, Object o2) {
        FileInfo date1=(FileInfo) o1;
        FileInfo date2=(FileInfo) o2;
        return date1.getType().compareTo(date2.getType());
    }
}

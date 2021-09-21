public class CompareFileName implements Comparable {
    @Override
    public int compareTo(Object o1, Object o2){
        FileInfo name1=(FileInfo) o1;
        FileInfo name2=(FileInfo) o2;
        return name1.getName().compareTo(name2.getName());
    }
}

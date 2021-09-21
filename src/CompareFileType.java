public class CompareFileType implements Comparable {
    @Override
    public int compareTo(Object o1, Object o2) {
        FileInfo type1=(FileInfo) o1;
        FileInfo type2=(FileInfo) o2;
        return type1.getType().compareTo(type2.getType());
    }
}

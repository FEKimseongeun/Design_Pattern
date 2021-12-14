package DAOPattern.AddressBookWithList;

public class Person {
    private static int counter = 1; //객체를 생성할때마다 셀 수 이쎄
    private int id; // 고유id
    private String name;
    private String address;
    Person(String name, String address){
        this.name = name;
        this.address = address;
        id = counter;
        counter++;
    }
    //데이터 베이스를 읽고난 뒤 설정해주기위한 생성자(이미 있는 데이터를 받도록 하는)
    Person(int id, String name, String address) {
        this.name = name;
        this.address = address;
        this.id = id;
    }
    public String toString() {
        return "" + id + ", " + name + ", " + address;
    }
    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getAddress() { return address; }
    public void setAddress(String address) {
        this.address = address;
    }
}

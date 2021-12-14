package DAOPattern.AddressBookWithDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements PersonDao {
    final static String DB_FILE_NAME = "addrbook.db";
    final static String DB_TABLE_NAME = "persons";
    Connection connection = null;
    ResultSet rs = null;
    Statement statement = null;

    public PersonDaoImpl() {
        final String table = " (ID INTEGER PRIMARY KEY AUTOINCREMENT, name text, address text)";
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + DB_FILE_NAME);
            statement = connection.createStatement();
            // set timeout to 30 sec.
            statement.setQueryTimeout(30);
            // 테이블 만들기
            statement.executeUpdate("DROP TABLE IF EXISTS " +
                    DB_TABLE_NAME);
            statement.executeUpdate("CREATE TABLE " +
                    DB_TABLE_NAME + table);
        }
        catch (SQLException e) { e.printStackTrace(); }
    }
    public void insert(Person p) { //데이터를 넣기위한 함수
        try {
            String fmt = "INSERT INTO %s VALUES(%d, '%s', '%s')"; //포맷 맞춰서 들어갈 수 있도록 코딩
            String q = String.format(fmt, DB_TABLE_NAME,
                    p.getId(), p.getName(), p.getAddress());
            statement.execute(q);
        }
        catch (SQLException e) { e.printStackTrace(); }
    }
    public List<Person> findAll() {
        //하나씩 들어올때마다 그걸 Person에 추가해주는 방식으로 할 예정
        ArrayList<Person> persons = new ArrayList<Person>();
        try {
            rs = statement.executeQuery("SELECT * FROM " + DB_TABLE_NAME);
            //id, name, address 다 받아서 person이라는 list에 추가해주는 과정
            while (rs.next()) {
                persons.add(new Person(rs.getInt("id"), rs.getString("name"), rs.getString("address")));
            }
        }
        catch (SQLException e) { e.printStackTrace(); }
        return persons;
    }
    public Person findById(int id) {
        Person person = null;
        try {
            String fmt = "SELECT * FROM %s WHERE id = %d";
            String q = String.format(fmt, DB_TABLE_NAME, id);
            rs = statement.executeQuery(q);//데이터가 있는지의 여부를 확인
            if (rs.next()) {
                person = new Person(rs.getInt("id"), rs.getString("name"), rs.getString("address"));
            }
        }
        catch (SQLException e) { e.printStackTrace(); }
        return person;
    }
    public void update(int id, Person p) {
        Person person = findById(id);
        if (person != null) {
            try {
                String fmt = "UPDATE %s SET name = '%s', address = '%s' WHERE id = %d";
                String q = String.format(fmt, DB_TABLE_NAME,
                        p.getName(), p.getAddress(), p.getId());
                statement.execute(q);
            }
            catch (SQLException e) { e.printStackTrace(); }
        }
    }
    public void delete(int id) {
        try {
            String fmt = "DELETE FROM %s WHERE id = %d";
            String q = String.format(fmt, DB_TABLE_NAME, id);
            statement.execute(q);
        }
        catch (SQLException e) { e.printStackTrace(); }
    }
    public void delete(Person p) { delete(p.getId()); } //여기서 Person을 객체로 p를 불러왔을때 getId를 하면 id가 자동으로 불어와지고 그걸
    //delete에 보냈으니 id로 구분해서 delete할 수 있게 하는 것이다.
}

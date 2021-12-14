package DAOPattern.AddressBookWithList;
//DAO 인터페이스
import java.util.List;
public interface PersonDao {
    public void insert(Person p);
    public List<Person> findAll();
    public Person findById(int id);
    public void update(int id, Person p);
    public void delete(int id);
    public void delete(Person p);
}

//DAO 뒤에 배경이 데이터베이스가 됐던 Collection이 됐던 상관이 없음
// 똑같은 인터페이스를 가지고 클라이언트 코드는 고치지 않고 뒤에 백엔드만 수정할 수 있도록
//만들어보고 싶은데 이걸 DAO 패턴을 활용하는 것임.
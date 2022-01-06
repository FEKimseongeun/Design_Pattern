package Singleton;

public class Singleton {
    private static Singleton uniqueInstance;
    private Singleton() { }
    public static synchronized Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }
// 나머지 멤버 함수 코드
}



//public class Singleton {
//    // Singleton 클래스의 유일한 인스턴스를 저장
//    private static Singleton uniqueInstance;
//    // 기타 멤버 변수
//    private Singleton() { }
//    public static Singleton getInstance() {
//        if (uniqueInstance == null) {
//            uniqueInstance = new Singleton();
//        }
//        return uniqueInstance;
//    }
//// 기타 메소드
//}
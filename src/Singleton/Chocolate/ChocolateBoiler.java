package Singleton.Chocolate;

public class ChocolateBoiler {
    private static ChocolateBoiler uniqueInstance;
    private boolean empty;
    private boolean boiled;
    private ChocolateBoiler() {
        empty = true; // 보일러가 비어있을 때만 동작
        boiled = false;
    }
    public static ChocolateBoiler getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ChocolateBoiler();
        }
        return uniqueInstance;
    }
    public boolean isEmpty() {
        return empty;
    }
    public boolean isBoiled() {
        return boiled;
    }
    public void fill() {
        if (isEmpty()) { // 비어있을 때에만 재료 넣음
            empty = false;
            boiled = false;
            // 보일러에 우유/초콜릿 혼합 재료 넣음
        }
    }
    // 보일러가 가득 차있고, 다 끓여진 상태에서만 보일러
    // 에 있는 재료를 다음 단계로 넘기고 보일러를 비움
    public void drain() {
        if (!isEmpty() && isBoiled()) {
            // 끓인 재료를 다음 단계로 넘김
            empty = true;
        }
    }
    // 보일러가 가득 차있고, 아직 끓지 않은 상태면 끓임
    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            // 재료를 끓임
            boiled = true;
        }
    }
}
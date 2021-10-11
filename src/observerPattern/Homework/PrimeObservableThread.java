package observerPattern.Homework;

import java.util.ArrayList;

public class PrimeObservableThread implements Runnable {
    static final int SLEEPTIME = 500;
    ArrayList<Observer> observers;

    int primeNumber;
    int numCount;
    boolean first = true;
    boolean stopRunning = false;

    PrimeObservableThread() {
        observers = new ArrayList<Observer>();
    }

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(primeNumber);
        }
    }

    public void stopRunning() {
        stopRunning = true;
    }

    public void generatePrimeNumber() {
        while (stopRunning == false) {
            if (first) {
                first = false;
                primeNumber = 2;
                notifyObservers(); // 첫 번째 소수는 2
                numCount = 1;     // 다음 단계부터는 2를 더해서 홀수만 확인하므로 numCount는 1부터 시작해서 다음 숫자는 3이 되어야 함
            } else {
                numCount += 2; // 2를 제외한 짝수는 소수가 될 수 없음. 따라서 홀수만 검사
                if (isPrimeNumber(numCount)) {
                    primeNumber = numCount;
                    notifyObservers();
                }
            }
            try {
                Thread.sleep(SLEEPTIME);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isPrimeNumber(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void run() {
        generatePrimeNumber();
    }
}
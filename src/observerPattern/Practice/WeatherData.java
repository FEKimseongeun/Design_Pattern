package observerPattern.Practice;

import java.util.ArrayList;

public class WeatherData implements Subject{
    private ArrayList<Observer> observers;
    private float temp;//온도
    private float humidity; // 습도
    private float pressure; //압력

    public WeatherData(){
        observers=new ArrayList<Observer>();
    }

    public void registerObserver(Observer o){
        observers.add(o);
    }

    public void removeObserver(Observer o){
        int i=observers.indexOf(o);
        if(i>=0){
            observers.remove(i);
        }
    }

    public void notifyObservers(){
        for(int i=0; i<observers.size(); i++){
            Observer observer=observers.get(i);
            observer.update(temp,humidity,pressure);
        }
        /* for-each 문
        for(Observer observer : observers){
        observer.update(tmperature, humidity,pressure);
        * */
    }
    public void measurementsChanged(){
       notifyObservers();
    }
    public void setMeasurements(float temp, float humidity, float pressure){
        this.temp=temp;
        this.humidity=humidity;
        this.pressure=pressure;
        measurementsChanged();
    }
}

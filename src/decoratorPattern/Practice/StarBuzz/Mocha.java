package decoratorPattern.Practice.StarBuzz;
//데코레이터 역할을 하는 모카 클래스
public class Mocha extends CondimentDecorator{
    Beverage beverage;
    public Mocha(Beverage beverage){
        this.beverage=beverage;
    }

    public String getDescription(){
        return beverage.getDescription() + " 모카";
    }
    public double cost(){
        return beverage.cost() + .20;
    }
}

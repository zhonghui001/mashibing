package factory.pa.hit;

/**
 * 简单工厂
 * 扩展性不太好,很多是死代码
 */
public class SimpleFactory {

    public Car createCar(){
        //before process
        return new Car();
    }

    public Cat createCat(){
        return new Cat();
    }
}

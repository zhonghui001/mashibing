package singleton.pa.hit;

/**
 * 静态内部类
 *
 * 1.定义一个静态内部类,在内部类中new实例
 * 2.在类中定义一个public的返回值是静态内部类中的new出的实例对象
 * 这个是靠jvm自行来实现多线程安全的,jvm在加载类的时候,只会保证加载一次类,所以静态内部类也只会加载一次,这样就只会初始化一次
 */
public class Mgr03 {
    private Mgr03 mgr03;

    private static class Mgr03Hodler{
        static Mgr03 mgr03=new Mgr03();
    }

    public Mgr03 getInstance(){
        return Mgr03Hodler.mgr03;
    }

}

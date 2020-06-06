package singleton.pa.hit;

/**
 * 懒汉模式
 * 有点:简单
 * 缺点:有点浪费内存
 */
public class Mgr01 {
    private static Mgr01 ins = new Mgr01();
    private Mgr01(){}

    public Mgr01 getInstance(){
        return ins;
    }

}

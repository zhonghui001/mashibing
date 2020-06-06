package singleton.pa.hit;

/**
 * 饿汉模式
 *  使用double check模式进行生成
 */
public class Mgr02 {
    private static Mgr02 mgr02;

    public Mgr02() {
    }

    public Mgr02 getInstance(){
        if (mgr02==null){
            synchronized (this){
                if (mgr02==null){
                    mgr02=new Mgr02();
                    return mgr02;
                }
            }
        }
        return mgr02;
    }
}

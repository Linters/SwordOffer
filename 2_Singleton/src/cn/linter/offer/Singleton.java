package cn.linter.offer;


import java.util.HashMap;
import java.util.Map;

/**
 * 懒汉模式 ： 适用于单线程 ，多线程下不安全   会发生创建多个实例的现象
 */
class Singleton1 {

    private static Singleton1 instance;

    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}


/**
 * 懒汉模式的升级版本：多线程下适用 但是效率不高 每一次获取实例对象的时候都需要加锁处理
 * 如果对象以及存在了被创建了 那么在加锁获取 明显效率降低。
 */
class Singleton2 {

    private static Singleton2 instance;

    private Singleton2() {

    }

    public static Singleton2 getInstance() {
        synchronized (Singleton2.class) {
            if (instance == null) {
                instance = new Singleton2();
            }
        }
        return instance;
    }
}

/**
 * 懒汉模式的再升级版本
 * 也叫 Double-Check 双重检索。
 */
class Singleton3 {
    private static Singleton3 instance;

    private Singleton3() {

    }

    public static Singleton3 getInstance() {
        //第一重判断。 避免不必要的同步操作  可以想象成已经实例化了对象 再一次获取该类对象的时候 避免了synchronized的同步。
        if (instance == null) {
            synchronized (Singleton3.class) {
                //第二重判断。 旨在判断instance 是否为null ，如若在多线程下 对象的初始化需要时间，还没初始化完成就将自身的同步锁
                //释放掉  另一个线程直接拿到锁对象 直接初始化该类对象 就会造成单粒模式失效  多线程不安全 因此多加一个判空的条件比较保险
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}

/**
 * 考虑到JVM指令集 重排序的问题 也有可能造成 double check 模式 多线程下失效 。
 * 指令集重排序就是指 代码的执行顺序可能不会按照预先的执行顺序进行，这也就间接的造成了单例模式失效的问题
 * <p>
 * 解决方案： 适用 volatile 修饰需要黄创建的对象变量。   volatile：它的操作非原子性 每次操作都会像主存刷新值，多线程下
 * 保证所修饰的值都是最新的 可见的。
 */
class Singleton4 {
    private static volatile Singleton4 instance;

    private Singleton4() {

    }

    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }

        return instance;
    }
}


/**
 * 枚举方式实现单例模式  , 默认的枚举构造器为private 私有的 外部不可直接调用此构造器
 * 实质： 内部定义的枚举常量都是全局常量 public static final Singleton5 INSTANCE=new Singleton5();
 * 缺点： android中比较耗费内存
 */
enum Singleton5 {

    INSTANCE
}


/**
 * 饿汉模式：随类的调用 一起初始化  线程安全
 * 和懒汉模式的区别在于： 饿汉模式是线程安全的，随类的调用初始化对象  懒汉模式则为一种lazy(懒加载)在首次调用getInstance()时初始化对象，会有多线程下不安全的情况
 */
class Singleton6 {

    private static final Singleton6 INSTANCE = new Singleton6();

    private Singleton6() {

    }

    public static Singleton6 getInstance() {
        return INSTANCE;
    }

}

/**
 * 容器的方式 实现单例模式。
 * 实现方式： 适用java中HashMap集合类   key 代表获取单例对像的标示  value 需要存的单例对象
 * 拓展： 与Android中的  getSystemService()获取系统服务对象 一致
 */
class Singleton7 {

    private static Map<String, Object> container;

    static {
        container = new HashMap<>();
        container.put("singleton", new Singleton7());
    }

    private Singleton7() {

    }


    public static void registerService(String key, Object object) {
        if (!container.containsKey(key)) {
            container.put(key, object);
        }
    }

    public static Object getService(String key) {
        Object instance = null;
        if (container.containsKey(key)) {
            instance = container.get(key);
        }
        return instance;
    }

    public void print() {

        System.out.println("singleton7");
    }
}

/**
 * 静态内部类的方式实现 单例模式
 * 有点： 线程安全  延迟加载
 */
class Singleton8{

    private Singleton8(){
    }

    public static Singleton8 getInstance() {
        return SingletonInnerClass.INSTANCE;
    }

    /**
     * 静态内类方式 实现： 线程安全 延迟加载
     */
    private static  class  SingletonInnerClass{
        private static final Singleton8 INSTANCE = new Singleton8();
    }
}

/**
 * 面试题2:实现Singleton模式
 * 题目： 设计一个类，我们只能生成该类的一个实例
 * <p>
 * Created by linCQ on 2018/5/2.
 */
public class Singleton {

    public static void main(String[] args) {
//        Singleton7 instance = (Singleton7) Singleton7.getService("singleton");
//
//
//        System.out.println(instance);
//        instance.print();
//
//        Singleton7 instance2 = (Singleton7) Singleton7.getService("singleton");
//
//
//        System.out.println(instance2);
//        instance.print();
    }
}

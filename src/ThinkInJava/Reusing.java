package ThinkInJava;

/**
 * 复用类
 */
public class Reusing {
    /**
     * 代码复用
     * 1：有两种方式复用代码
     *    （1）组合，在新的类中产生现有类的对象
     *    （2）继承，采用现有类的形式并在其中添加新代码
     */

    /**
     * 组合语法
     * 1：每个非基本类型的对象都有一个toString方法，当编译器需要String，而只有一个对象，会自动调用
     * 2：初始化引用
     *      （1）在定义对象的时候，意味着在总是在构造器被调用之前
     *      （2）在类的构造器中
     *      （3）在使用对象之前
     *      （4）使用实例初始化
     *
     */

    /**
     * 继承语法
     * 1：java重载运算符只有String对象的+=、+
     * 2：每个类都可以包含main方法，只有命令行调用的类的main方法会运行
     * 3：创建一个导出类的对象时，该对象包含了一个基类的子对象，和直接用基类创建
     * 一个对象的区别是，该子对象包含在导出类对象内部
     * 4：初始化基类，在导出类类的构造器中初始化基类
     *
     */

    /**
     * 代理：通过在类中新建成员对象，然后将成员对象的操作通过一个封装代理，隐藏成员对象的
     * 所有操作，只暴露子集操作
     *
     */


    /**
     * 名称屏蔽
     * 1：在导出类中重新定义基类已重载的方法，并不会屏蔽基类的任何版本，
     */

    /**
     * 组合和继承的区别
     * 1：组合，通常是想使用现有类的功能而非它的接口
     * 2：继承，使用某个现有类，并开发一个它的特殊版本
     */

    /**
     * protected,对导出类的成员来说是可以访问的
     *
     */

    /**
     * 向上转型
     * 1、继承最重要的技术是用来表现新类和基类之间的关系
     * 2、向上转型是从一个较专用类型向较通用类型转换，所有总是很安全的
     * @param args
     */

    /**
     * final关键字
     * 1：final数据
     *      一个永不改变的编译时常量，常量必须是基本类型
     *      在运行时被初始化的值
     * 2：final参数，意味着无法更改参数引用所指向的对象
     *
     *3：final方法
     *  将方法锁定，防止任何继承类覆盖
     *  为了效率，方法指定为final，就是同意编译器将所有调用转为内嵌调用
     *
     *  4：final类，表明不打算继承该类，而且也不允许别人这样做
     */


    /**
     * 初始化及类的加载
     * 1：类的代码在初次使用时才会加载，包括创建一个对象、调用static对象、static方法
     * 2：先加载依赖的编译代码，然后开始创建对象，先将基本类型、对象引用等初始化为默认值，然后开始调用构造函数，有基类构造函数先调用基类构造函数
     * 2：
     */


    public static void main(Strings[]args){
        System.out.println("game start ...");
    }
}

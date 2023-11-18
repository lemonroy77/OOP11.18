package SJ;
// 一、设计三角形类Triangle，有三边，均为正数，且不得任意修改：满足如下要求：
// 1、构造时，若三边不正确，无法创建出对象；若正确，至多构造出3个三角对象；
// 2、增设直角三角、等边三角，其中直角三角至多2个，等边三角至多5个，
//且任一时刻，普通、直角、等边共计不得超过10个。
// ---提示：直角三角、等边三角，不要作为三角的子类
final class Conditions{//final修饰类，表示类不能被改写和继承
     public static boolean limitall(){//使用Conditions来设置不同类的约束条件
         return Triangel.getCount()+RTTriangel.getCount()+DBTriangel.getCount()<10?true:false;
     }
}
class Triangel{
    private double a,b,c;
    private static int count=0;//正常三角形个数
    private Triangel(double x,double y,double z){a=x;b=y;c=z;}
    public static int getCount(){return count;}//因为count被设置为私有变量，需要一个方法来获取值，方便设置约束条件Conditions使用
    public static boolean limit(double x,double y,double z){//同上
        return (Math.abs(x-y)<z)&&(Math.abs(x-z)<y)&&(Math.abs(z-y)<x)&&(x+y>z)&&(x+z>y)&&(z+y>x)&&count<3&&Conditions.limitall()?true:false;
    }
    public static Triangel createTriangel(double x,double y,double z){
           if(limit(x,y,z)==false||count>=3||!Conditions.limitall())return null;//设置条件2个
           count++;
           return new Triangel(x,y,z);//直接返回造的对象，感觉是  满足条件才能构造的方法：构造函数设为私有，再设置一个静态方法，设置条件限制，满足时在方法中构造，因为静态方法也是在类中，私有变量可视

    }
    public String toString(){
        String s="三角形的三边为"+a+" "+b+" "+c;
        return s;
    }
}
class RTTriangel{
    private double a,b,c;
    private static int count=0;//直角三角形个数
    public static int getCount(){return count;}
    private RTTriangel(double x,double y){a=x;b=y;c=Math.sqrt(x*x+y*y);}
    public static RTTriangel  createRTTriangel(double x,double y){//直角
           if(count>=2||!Conditions.limitall())return null;//设置条件2个
           count++;
           return new RTTriangel(x,y);//直接返回造的对象，感觉是  满足条件才能构造的方法：构造函数设为私有，再设置一个静态方法，设置条件限制，满足时在方法中构造，因为静态方法也是在类中，私有变量可视

    }
    public String toString(){
        String s="直角三角形的三边为"+a+" "+b+" "+c;
        return s;
    }
}
class DBTriangel{
    private double a,b,c;
    public static int  count=0;  //等边三角形,必须设置为静态变量，因为createTriangel需要使用，create方法是静态方法，静态方法里面只能使用静态变量
    public static int getCount(){return count;}
    private DBTriangel(double x){a=b=c=x;}
    public static DBTriangel  createDBTriangel(int x){
           if(count>=5||!Conditions.limitall())return null;//设置条件3个
           count++;
           return new DBTriangel(x);//直接返回造的对象，感觉是  满足条件才能构造的方法：构造函数设为私有，再设置一个静态方法，设置条件限制，满足时在方法中构造，因为静态方法也是在类中，私有变量可视

    }
    public String toString(){
        String s="等边三角形的三边为"+a+" "+b+" "+c;
        return s;
    }
}
public class Triangle2 {
    public static void main(String[] args) {
        // 创建3个普通三角形，（其中1个不满足限制，2个满足限制）
        Triangel t1 = Triangel.createTriangel(3, 4, 5); // 满足条件
        Triangel t2 = Triangel.createTriangel(3, 3, 7); // 不满足条件
        Triangel t3 = Triangel.createTriangel(5, 5, 5); // 满足条件

        // 创建2个直角三角形（都满足限制）
        RTTriangel rt1 = RTTriangel.createRTTriangel(3, 4); // 满足条件
        RTTriangel rt2 = RTTriangel.createRTTriangel(5, 12); // 满足条件

        // 创建5个等边三角形（都满足限制）
        DBTriangel db1 = DBTriangel.createDBTriangel(2); // 满足条件
        DBTriangel db2 = DBTriangel.createDBTriangel(3); // 满足条件
        DBTriangel db3 = DBTriangel.createDBTriangel(4); // 满足条件
        DBTriangel db4 = DBTriangel.createDBTriangel(5); // 满足条件
        DBTriangel db5 = DBTriangel.createDBTriangel(6); // 满足条件

        // 打印所有普通三角形信息
        System.out.println("所有普通三角形信息：");
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);

        // 打印所有直角三角形信息
        System.out.println("所有直角三角形信息：");
        System.out.println(rt1);
        System.out.println(rt2);

        // 打印所有等边三角形信息
        System.out.println("所有等边三角形信息：");
        System.out.println(db1);
        System.out.println(db2);
        System.out.println(db3);
        System.out.println(db4);
        System.out.println(db5);

        // 打印不满足限制的三角形信息
        System.out.println("不满足限制的三角形：");
        System.out.println("t2: " + t2);
    }
}




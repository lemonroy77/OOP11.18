// 二、设计一个综合性的形状计算器。功能为：对一组不同的形状（梯形、三角形、圆形、正方形）对象，能正确识别形状类型，显示其周长、面积和对象的个性化信息。例如输出信息为：
// 类型：圆形，周长=XXX，面积=XXX，半径=XXX  或是  
// 类型：梯形，周长=“无法计算”，面积=XXX，上底=XXX 下底=XXX 高=XXX
// 【要求】
// 1、提示：类型的个性化信息，如可考虑toString()；
// 2、若梯形、三角形周长无法计算，则显示“周长=无法计算”
// 3、该形状计算器必须单独提供计算周长、面积的服务。
// 提示：若遇到周长、面积为-1，则提示：“无法计算！”
 class Shape{
    private String type;
    String gettype(){return type;}//因为type设置为私有变量，需要设计函数识别类型
    Shape(String t){type=t;}
    int getmianji(){return -1;}//重写，使用自己的计算面积方法取代超类计算方法
    int getzhouchang(){return -1;}
    public String toString(){
        String s="";
        return s;
    }
 }
 class Shibie{//识别器，运行时要填入对象。即插即用
     //基于超类来编程,因为要识别的是形状，一定是shape类型的变量s来调用getmianji等
     /*重写的实现机制
      * 超类和子类有一模一样的方法，子类中的方法是满足特殊需求的
      * 就近原则，基于对象
      */
      static void regonize(Shape s){
         String zc;
        int x=s.getzhouchang();//都转成字符串
         if(x==-1)zc="无法计算 ";
         else zc=x+" ";
          String mj;
         int y=s.getmianji();
         if(y==-1)mj="无法计算";
         else mj=y+" ";
         System.out.println("类型为"+s.gettype()+s+" 周长"+zc+"面积"+mj);
        
 }//无参的，当子类没有时往超类去找
 }
 class Yuan extends Shape{//超类能用的直接用，子类需求与超类不同的进行重写
     private int r;
     private final int pai=3;//为什么使用private finall
     Yuan(int x){super("圆型");r=x;}//因为Shape类的构造函数需要一个参数且为String类型，所以传进去一个。注意子类构造函数一定会调用超类构造函数
     int getmianji(){return pai*r*r;}//重写，必须用自己的属性值
     int getzhouchang(){return 2*pai*r;}
     public String toString(){
         String s;
         s=" 半径为:"+r;
        return s;
    }
 }
 class JuXing extends Shape{
      private int di,gao;
      JuXing(int x,int y){super("矩形");di=x;gao=y;}                                                                                                                                                                                                                                                                                                                                                                                               
      int getmianji(){
         return di*gao;}   
      int getzhouchang(){return di*gao*2;}
      public String toString(){
             String s="";
             if(this.getzhouchang()==-1)
              s=" 底："+di+" 高："+gao;
        return s;
    }
 }
 class Sanjiao extends Shape{
      private int di,gao;
     Sanjiao(int x,int y){super("三角型");di=x;gao=y;}
     int getmianji(){return di*gao/2;}//重写
     int getZhouChang() {
        return 0; // 设置为0，表示无法计算周长
    }
    public String toString() {
        String s = "";
        if (this.getZhouChang() == 0) {
            s +="底：" + di + " 高：" + gao+ " 只有底和高,";
        } 
        return s;
    }
 }
 class Tixing extends Shape{
      private int updi,downdi,gao;
     Tixing(int x,int y,int z){super("梯型");updi=x;downdi=y;gao=z;}
     int getmianji(){return (updi+downdi)*gao/2;}//重写
        int getZhouChang() {
        return 0; // 设置为0，表示无法计算周长
    }
    public String toString() {
        String s = "";
        if (this.getZhouChang() == 0) {
            s +=  "上底：" + updi + " 下底：" + downdi + " 高：" + gao+" 只有上底，下底和高,";
        } 
        return s;
    }
 }
class App9 {
     public static void main(String[] args){
          Shape[] s={new Yuan(3),new JuXing(3,5),new Sanjiao(3,4),new Tixing(2,4,6)};//创建一组形状 
          //下面将s交给识别器进行识别
          for(Shape x:s)
          Shibie.regonize(x);
         //    用识别器识别对象
 }
}
 
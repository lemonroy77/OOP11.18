class Triangle{
	private int a,b,c;
    public static final int total=3;
	private static int count=0;
	private Triangle(int x,int y,int z){
		a=x;
		b=y;
		c=z;
		count++;
	}
	private static boolean limit(int x,int y,int z){
		return (x>0&&y>0&&z>0&&x+y>z&&x+z>y&&y+z>x&&count<total);
	}
	public static Triangle creatTriangle(int x,int y,int z){
		return(limit(x,y,z)==true)?new Triangle(x,y,z):null;
	}
	public void showCount(){System.out.println("count="+count);}
    public String toString(){return"{"+a+","+b+","+c+"}";}
}
class Triangle1{
	public static void main(String []args){
		int i;
		Triangle[] t=new Triangle[10];
		t[0]=Triangle.creatTriangle(1,2,3);
		t[1]=Triangle.creatTriangle(2,3,4);
		for(i=2;i<t.length;i++)
			t[i]=Triangle.creatTriangle(3,4,5);
			for(i=0;i<t.length;i++)
			System.out.print(t[i]+"、");
			t[1].showCount();
		
	}

}
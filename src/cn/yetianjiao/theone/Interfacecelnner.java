package cn.yetianjiao.theone;

interface outinterface{
	public void f();
}
public class Interfacecelnner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		outerclass2 out=new outerclass2();
		outinterface outer=out.doit();
		outer.f();
	}
}

class outerclass2
{
	private class innerclass implements outinterface{
		innerclass(String s){
			System.out.println(s);
		}
		public void f(){
			System.out.println("访问内部类的f()方法");
		}
	}
	public outinterface doit()
	{
		return new innerclass("访问内部构造的方法");
	}
}
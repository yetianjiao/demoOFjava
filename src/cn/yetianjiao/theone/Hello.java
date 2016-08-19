package cn.yetianjiao.theone;

public class Hello {
	
	public String toString()
	{
		return "在"+getClass().getName()+"类中重写toString方法";
	}
	public static void main(String[] args)
	{
		System.out.println(new Hello());
		System.out.println("xixi");
	}
}

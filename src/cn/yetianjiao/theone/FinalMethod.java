package cn.yetianjiao.theone;

public class FinalMethod {
	public static void main(String[] args)
	{
		sub s=new sub();
		s.doit();
		parents p=s;
//		p.doit();
		p.doit2();
		p.doit3();
	}

}
class parents
{
	private final void doit()
	{
		System.out.println("father.doit()");
	}
	final void doit2()
	{
		System.out.println("father.doit2()");
	}
	public void doit3()
	{
		System.out.println("father.doit3()");
	}
}

class sub extends parents
{
	public final void doit()
	{
		System.out.println("sub.doit()");
	}
//	final void doit2()
//	{
//		System.out.println("father.doit2()");
//	}
	public void doit3()
	{
		System.out.println("sub.doit3()");
	}
}
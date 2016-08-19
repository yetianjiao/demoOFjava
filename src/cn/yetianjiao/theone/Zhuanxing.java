package cn.yetianjiao.theone;
import static java.lang.System.out;
class Fulei
{
	public static void draw()
	{
		out.println("this is father");
	}
}

class anthing
{
	}
public class Zhuanxing extends Fulei
{
	public static void main(String[] args)
	{
//		Zhuanxing x=new Fulei();
//		Zhuanxing x=new Zhuanxing();
		Fulei q=new Zhuanxing();
		Zhuanxing p=(Zhuanxing) q;
		if (q instanceof Zhuanxing)
		q.draw();
		out.println(q instanceof Zhuanxing);
		out.println(myadd(1,'x'));
		
	}
	public static void draw()
	{
		out.println("this is son");
		out.println("haha");
	}
	
	public static int myadd(int ...a)
	{
		int sun=0;
		for (int i=0;i<a.length;i++)
		{
		
			sun=sun+a[i];
		}
		return sun;
	}
	public static int myadd(int x,char xx)
	{
		int y=x*3;
		return y;
	}
	
}
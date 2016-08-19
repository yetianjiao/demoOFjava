package cn.yetianjiao.theone;

import java.util.Random;

public class Myfinal {
	private static Random rand=new Random();
	private final int a1=rand.nextInt(10);
	private final static int a2=rand.nextInt(10);
	public static void main(String[] args)
	{
		Myfinal xx=new Myfinal();
		System.out.println("xx.a1:fianl "+xx.a1);
		System.out.println("xx.a1:static fianl "+xx.a2);
		Myfinal  yy=new Myfinal();
		System.out.println("yy.a1:fianl "+yy.a1);
		System.out.println("yy.a1:static fianl "+yy.a2);
	}

}

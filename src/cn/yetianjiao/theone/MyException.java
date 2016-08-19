package cn.yetianjiao.theone;

public class MyException {
	public static void main(String[] args){
//		try{
//			int age=Integer.parseInt("20l");
//			System.out.println(age);
//		}
//		catch(NumberFormatException e){
//			System.out.println("数据类型转换出错");
//		}
//		System.out.println("hahahahahahaha");
//	}
	
	try{
		System.out.println(avg(3,4));
	}catch(MyException1 e){
		System.out.println(e);	
		}
	}
	static int avg(int num1,int num2)throws MyException1{
		if(num1<num2)
		{
			throw new MyException1("第一个数字比第二个数字大");
		}
		return (num1+num2)/2;
		
	}
}

 class MyException1 extends Exception{
	public MyException1 (String erro1 ){
		super(erro1);
	}
 }
 
 
 
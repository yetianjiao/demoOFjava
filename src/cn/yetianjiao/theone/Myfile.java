package cn.yetianjiao.theone;

import java.io.*;

public class Myfile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file=new File("G:/","hello.java");
		if(file.exists())
		{
			System.out.println(file.getName());
			file.delete();
			System.out.println("it was deleted");
		}else
		{
			try{
				file.createNewFile();
				System.out.println("it was created!");
				System.out.println(file.canWrite());
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}

package cn.yetianjiao.theone;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MyIOstream {
	public static void main(String[] args) {
		File file = new File("word.txt");
		try {
			FileOutputStream out = new FileOutputStream(file);
			byte words[] = "我有一只小毛驴".getBytes();
			out.write(words);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		try{
			FileInputStream in=new FileInputStream(file);
			byte byt[]=new byte[14];
			int len=in.read(byt);
			System.out.println(new String(byt,0,len));
			in.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

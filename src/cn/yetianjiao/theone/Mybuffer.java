package cn.yetianjiao.theone;

import java.awt.datatransfer.StringSelection;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.xml.crypto.Data;

public class Mybuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileOutputStream fs=new FileOutputStream("G:/haha.txt");
			DataOutputStream dos=new DataOutputStream(fs);
			dos.writeUTF("write the data by writeUTF()");
			dos.writeChars("ÄãÊÇÉµ¹ÏÂð  by writeChars()");
			dos.writeBytes("write the data by writeByte()");
			dos.close();
			FileInputStream fis=new FileInputStream("G:/haha.txt");
			DataInputStream dis=new DataInputStream(fis);
			System.out.println(dis.readUTF());
//			String x="write the data by writeChars()";
//			char[] a=x.toCharArray();
//			for(int i=0;i<a.length;i++)
//			System.out.print(a[i]);
			System.out.println(dis.readByte());
		} 
		
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}

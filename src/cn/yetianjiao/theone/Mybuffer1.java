package cn.yetianjiao.theone;

import java.beans.FeatureDescriptor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Mybuffer1 {
	public static void main(String[] args){
		String content[]={"hi","hello","happy"};
		File file =new File("G:/word");
		try {
			FileWriter fw=new FileWriter(file);
//			BufferedWriter bufw=new BufferedWriter(fw);不适用buffer缓存也可，但是会增加系统开销
			for(int i=0;i<content.length;i++){
//				bufw.write(content[i]);
//				bufw.newLine();
				fw.write(content[i]);
				fw.write(",");
			}
//			bufw.close();
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			FileReader fr=new FileReader(file);
			BufferedReader bufr=new BufferedReader(fr);
			String s=null;
			int i=0;
			while((s=bufr.readLine())!=null)
			{
				i++;
				System.out.println("the cline" +i+" is :"+s);
			}
			bufr.close();
			fr.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

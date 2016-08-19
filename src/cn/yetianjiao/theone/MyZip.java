package cn.yetianjiao.theone;
import java.io.*;
import java.util.zip.*;

public class MyZip {
	private void zip(String zipFilename,File inputFile)throws Exception {
		ZipOutputStream out=new ZipOutputStream(new FileOutputStream(zipFilename));
		zip(out,inputFile,"");//������д�ķ���
		System.out.println("ѹ����...");
		out.close();
	}
	private void zip(ZipOutputStream out, File f, String base) throws Exception{
		if(f.isDirectory()) //�жϸó���·�����Ƿ���һ��Ŀ¼
		{
			File[] fl=f.listFiles();
			out.putNextEntry(new ZipEntry(base+"/"));//�����ļ����ļ�ѹ��
			base= base.length()==0 ? "" : base+"/";
			for(int i=0;i<fl.length;i++) //
			{
				zip(out,fl[i],base+fl[i]);
			}
		}else {
			out.putNextEntry(new ZipEntry(base));
			FileInputStream in =new FileInputStream(f);
			int b;
			System.out.println(base);
			while((b=in.read()) != -1){
				out.write(b);
			}
			in.close();
		}
	}
	public static void main(String[] args) {
		MyZip book=new MyZip();
		try {
			book.zip("hello.zip",new File("src"));//ע��·���ϸ���ʱ���ȡ��·���������ʽ
			System.out.println("ѹ�����");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

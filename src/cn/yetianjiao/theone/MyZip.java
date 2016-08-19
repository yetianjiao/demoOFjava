package cn.yetianjiao.theone;
import java.io.*;
import java.util.zip.*;

public class MyZip {
	private void zip(String zipFilename,File inputFile)throws Exception {
		ZipOutputStream out=new ZipOutputStream(new FileOutputStream(zipFilename));
		zip(out,inputFile,"");//调用重写的方法
		System.out.println("压缩中...");
		out.close();
	}
	private void zip(ZipOutputStream out, File f, String base) throws Exception{
		if(f.isDirectory()) //判断该抽象路径名是否是一个目录
		{
			File[] fl=f.listFiles();
			out.putNextEntry(new ZipEntry(base+"/"));//将该文件下文件压缩
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
			book.zip("hello.zip",new File("src"));//注意路径较复杂时候获取的路径数组的形式
			System.out.println("压缩完成");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

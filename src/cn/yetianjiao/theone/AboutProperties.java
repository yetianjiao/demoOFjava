package cn.yetianjiao.theone;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Properties;

import com.mysql.jdbc.JDBC4CallableStatement;

public class AboutProperties {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dealJDBC ytj=new dealJDBC();
		ytj.CreatT();
		try {
			//通过 java.util.Properties来读取properties文件,注意不同的读取方式propeerties文件存放的位置不一样
			InputStream in=new BufferedInputStream(new FileInputStream("source/message.properties"));
			Properties p=new Properties();
			// 从输入流中读取属性列表（键和元素对）
			p.load(in);
			
			//控制台打印内容，并存入数据库
			System.out.println("控制台打印propert内容：");
			System.out.println();
			Enumeration en = p.propertyNames(); //得到配置文件的名字
			ytj.closecommit();
			while(en.hasMoreElements()) {
	            String strKey = (String) en.nextElement();
	            String strValue = p.getProperty(strKey);
	            System.out.println(strKey + "=" + strValue);
	            ytj.WrintintoXML(strKey, strValue);
	        //避免重复写入内容：在创建表格时候使用unique key
			}
			ytj.startcommit();
			System.out.println();
			System.out.println("完成读取properties文件并成功写入数据库！");
			System.out.println();
			//查找功能,根据key“zhaowei”查找
			String values=p.getProperty("zhaowei"); 
			if (values!=null) {
				System.out.println("在properties中查找的结果是："+values);
			} else {
				System.out.println("no result!");
			}
			
			//数据库中查找
			ytj.lookfor();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
class dealJDBC{
	public Connection conn1=null;
	Statement ss1=null;
	PreparedStatement ps1=null;
	ResultSet res=null;
	public dealJDBC(){
	try{
		//Driver manager new 一个驱动，自动注册
		//way1:		
		Class.forName("com.mysql.jdbc.Driver");
		//way2:
		//new com.mysql.jdbc.Driver();
		//链接URL：jdbc:mysql(数据库类型)://localhost:3306（连接端口）/test（要进行操作的数据库） root（用户名），root（密码）
		conn1=DriverManager.getConnection("jdbc:mysql://localhost:3306/ytj","root","root");
		}catch(ClassNotFoundException e){
			System.out.println("ClassNotFoundException");
		}catch(SQLException e1 ){
				System.out.println("ClassNotFoundException");
		}
	}
	public void CreatT(){
 		try{
			
		    String sql1="CREATE TABLE IF NOT EXISTS fromProperties(keyss VARCHAR(255),valuess VARCHAR(255),"
			+"unique key `unique_keyss_valuess` (`keyss`,`valuess`))"; //避免多次运行程序时候重复写入  
		    ps1=conn1.prepareStatement(sql1);
		    ps1.executeUpdate();
		    System.out.println("Created table in given database...");
		    
		}catch(SQLException e1)
		{
			System.out.println("creatT SQLException");
		}
	}
	public void closecommit()
	{
		try {
			conn1.setAutoCommit(false);
			System.out.println("关闭自动提交");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void startcommit()
	{
		try {
			conn1.commit();
			System.out.println("提交数据库成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void WrintintoXML(String s1,String s2)
	{
		
		try {
			String sql1="insert into fromProperties values(?,?)";
			ps1 = conn1.prepareStatement(sql1);
			ps1.setString(1, s1);
			ps1.setString(2, s2);
			ps1.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public void lookfor()
	{
		try {
			res=ps1.executeQuery("select valuess from fromProperties where keyss='zhaowei'");
			int i=1;
			while(res.next())
			{
				String value=res.getString("valuess");
				if (value!=null) {
					System.out.println("在数据库中第"+i+"次找到,此处内容是:"+value);
					i++;
				} else {
					System.out.println("你查找的数据不存在或者值为空");
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeDB()
	{
		try{
			if(ps1!=null){
				ps1.close();
				ps1=null;//便於垃圾收集器隨時回收ps
			}
			if(ss1!=null){
				ss1.close();
				ss1=null;
			}
			if(conn1!=null){
				conn1.close();
				conn1=null;
			}
		}catch(SQLException e)
		{
			
		}
	}
	
}
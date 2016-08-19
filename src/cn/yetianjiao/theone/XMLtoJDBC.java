package cn.yetianjiao.theone;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLtoJDBC{
	public static void main(String arge[]) {
		
		connectJDBC ytj=new connectJDBC();
		ytj.CreatT();
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document xx=db.parse("source/sstruts-alarm.xml");
			NodeList list2=xx.getElementsByTagName("package");
			//遍历package的属性
			org.w3c.dom.Element constant=(org.w3c.dom.Element) list2.item(0);
			//遍历package子节点：
			NodeList Childs = constant.getChildNodes(); 
			for (int k=0;k<Childs.getLength();k++)
			{
				org.w3c.dom.Node nodeChilde = Childs.item(k);  
	            if (nodeChilde.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {  
	            	org.w3c.dom.Element elementChilde = (org.w3c.dom.Element)nodeChilde;  
	                if((elementChilde).getTagName().equals("action")){ 
	                    NodeList Childe=Childs.item(k).getChildNodes();
	                    String s1=elementChilde.getAttribute("name");
                    	String s2=elementChilde.getAttribute("class");
                    	String s3=elementChilde.getAttribute("method");
	                    for(int j=0;j<Childe.getLength();j++){
	                    	org.w3c.dom.Node xx1=Childe.item(j);
	                    	org.w3c.dom.Element constant1=(org.w3c.dom.Element)Childe;
                        	
	                        if(xx1.getNodeName().equals("result")){	
	                        	String s4=((org.w3c.dom.Element) xx1).getAttribute("name");
	                        	String s5=((org.w3c.dom.Element) xx1).getTextContent();
	                        	ytj.WrintIn(s1,s2,s3,s4,s5);
	                        }
	                    }
	                }  
	            }  
			}
			}catch (ParserConfigurationException e1) {
				e1.printStackTrace();
			}catch (SAXException e2) {
				e2.printStackTrace();
			} catch (IOException e3) {
				e3.printStackTrace();
			}
		ytj.closeDB();	
		System.out.println("操作完成，关闭数据库");
		}
		
	}

class connectJDBC{
	Connection conn=null;
	Statement ss=null;
	PreparedStatement ps=null;
	public connectJDBC(){
	try{
		//Driver manager new 一个驱动，自动注册
		//way1:		
		Class.forName("com.mysql.jdbc.Driver");
		//way2:
		//new com.mysql.jdbc.Driver();
		//链接URL：jdbc:mysql(数据库类型)://localhost:3306（连接端口）/test（要进行操作的数据库） root（用户名），root（密码）
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ytj","root","root");
		}catch(ClassNotFoundException e){
			System.out.println("ClassNotFoundException");
			}catch(SQLException e1 ){
				System.out.println("ClassNotFoundException");
			}
		}
	public void CreatT(){
 		try{
			ss=conn.createStatement();
		    String sql = "CREATE TABLE IF NOT EXISTS fromXML" +
		                   "(action_name VARCHAR(255), " +
		                   " action_class VARCHAR(255), " + 
		                   " action_method VARCHAR(255), " + 
		                   " result VARCHAR(255)," + 
		                   " content VARCHAR(255))"; 
		    ss.executeUpdate(sql);
		    System.out.println("Created table in given database...");
		}catch(SQLException e1)
		{
			System.out.println("SQLException");
		}
	}
	
	public void WrintIn(String s1,String s2,String s3,String s4,String s5)
	{
		try {
			String sql1="insert into fromXML values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql1);
			ps.setString(1, s1);
			ps.setString(2, s2);
			ps.setString(3, s3);
			ps.setString(4, s4);
			ps.setString(5, s5);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public void closeDB()
	{
		try{
			if(ps!=null){
				ps.close();
				ps=null;//便於垃圾收集器隨時回收ps
			}
			if(ss!=null){
				ss.close();
				ss=null;
			}
			if(conn!=null){
				conn.close();
				conn=null;
			}
		}catch(SQLException e)
		{
			
		}
	}
	
}
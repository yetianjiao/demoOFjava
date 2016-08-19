package cn.yetianjiao.theone;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;


import org.xml.sax.SAXException;

public class AboutXML{
	public static void main(String arge[]) {
		//准备工作——加载xml文件
		//创建DocumentBuilderFactory对象
		//newInstance(),获取 DocumentBuilderFactory 的新实例。
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		//创建ducumentbuilder
		try {
			
			DocumentBuilder db = dbf.newDocumentBuilder();
			//通过documentbuilder的parse方法加载xml文件到当前项目下，
			//parse解析为一个xml文档返回一个新的 DOM Document 对象。
			Document xx=db.parse("struts-alarm.xml");
			//获得所有constant节点
			// getElementsByTagName()按文档顺序返回包含在文档中且具有给定标记名称的所有 Element 的 NodeList。
			//NodeList 接口提供对节点的有序集合的抽象,
			NodeList list1=xx.getElementsByTagName("constant");
			//遍历每一个constant节点
			System.out.println("the constants' length is :"+list1.getLength());
			for(int i=0;i<list1.getLength();i++)
			{
				//Node表示文件树种的单个节点
				org.w3c.dom.Node constant=list1.item(i);//item()返回集合中的第 index个项。
				//遍历list1所有属性
				//实现 NamedNodeMap接口的对象用于表示可以通过名称访问的节点的集合
				NamedNodeMap attrs=constant.getAttributes();
				System.out.println("the "+(i+1)+"有"+attrs.getLength()+"个属性");
				for(int j=0;j<attrs.getLength();j++)
				{
					//通过item方法获得某一属性
					org.w3c.dom.Node attr=attrs.item(j);
					//获取属性名
					System.out.print("第"+(j+1)+"个属性是"+attr.getNodeName());
					//获取属value
					System.out.println("，属性值为: "+attr.getNodeValue());
				}
			}
			System.out.println();
			
			//遍历package节点
			NodeList list2=xx.getElementsByTagName("package");
			System.out.println("遍历package的属性");
			org.w3c.dom.Element constant=(org.w3c.dom.Element) list2.item(0);
			String attrs1= constant.getAttribute("name");
			System.out.println("name 属性是:"+attrs1);
			String attrs2= constant.getAttribute("extends");
			System.out.println("extends 属性是:"+attrs2);
			//遍历package子节点：
			NodeList Childs = list2.item(0).getChildNodes(); 
			System.out.println("package一共有"+Childs.getLength()+"个子节点");
			for (int k=0;k<Childs.getLength();k++)
			{
				org.w3c.dom.Node nodeChilde = Childs.item(k);  
                if (nodeChilde.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {  
                	org.w3c.dom.Element elementChilde = (org.w3c.dom.Element)nodeChilde;  
                    if((elementChilde).getTagName().equals("action")){  
                        System.out.println(" 已经获取到子节点:"+(k+1)+" "+nodeChilde.getNodeName()+" 子节点属性name值为："+elementChilde.getAttribute("name")+"	class值为："+elementChilde.getAttribute("class")+"	method方法是："+elementChilde.getAttribute("method"));                    
                        NodeList Childe=Childs.item(k).getChildNodes();
                        //遍历每个action子节点
                        for(int j=0;j<Childe.getLength();j++){
                        	org.w3c.dom.Node xx1=Childe.item(j);
	                        org.w3c.dom.Element innerChild=(org.w3c.dom.Element)Childe;
	                      //  System.out.println(xx1.getNodeName());
	                        if(xx1.getNodeName().equals("result")){
						        System.out.println("	"+"action子节点的result的属性是"+((org.w3c.dom.Element) xx1).getAttribute("name")+",内容是"+((org.w3c.dom.Element) xx1).getTextContent());
	                        }
                        }
                    }  
                }  
			}
//			for(int i=0;i<list2.getLength();i++)
//			{
//				org.w3c.dom.Node constant=list2.item(i);
//				NamedNodeMap attrs=constant.getAttributes();
//				System.out.println("the "+(i+1)+" has "+attrs.getLength()+"个属性");
//				for(int j=0;j<attrs.getLength();j++)
//				{
//					org.w3c.dom.Node attr=attrs.item(j);
//					System.out.print("the 属性 "+(j+1)+" is :"+attr.getNodeName());
//					System.out.println("，the values is: "+attr.getNodeValue());
//				}
				
				//遍历package子节点：
//				for(int k=0;k<list2.getLength();k++)
//				{
//					NodeList ChildNodes = list2.item(0).getChildNodes();
//					System.out.println("第"+(k+1)+"个节点"+list2.item(k).getNodeName()+"有"+ChildNodes.getLength()+"子节点");
//					NamedNodeMap attr1=ChildNodes.item(k).getAttributes();
//					int x=attr1.getLength();
//					for(int j=0;j<attr1.getLength();j++)
//					{
//						//通过item方法获得某一属性
//						org.w3c.dom.Node att=attr1.item(j);
//						//获取属性名
//						System.out.print("the 属性 "+(j+1)+" is :"+att.getNodeName());
//						//获取属value
//						System.out.println("，the values is: "+att.getNodeValue());
//					}
//				}
				
		}catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		catch (NullPointerException e) {
//			// TODO: handle exception
//		}
//	
	}
}



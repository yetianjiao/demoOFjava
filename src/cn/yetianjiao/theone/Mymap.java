package cn.yetianjiao.theone;

//import java.util.HashMap;
import java.util.*;

public class Mymap {
	public static void main(String[] args){
		Map<String,String>map=new HashMap<>();
		map.put("1","mr.lee");
		map.put("2","mr.wei");
		Set<String>set=map.keySet();
		Iterator<String> it=set.iterator();
		System.out.println("about keys;");
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		System.out.println("about values:");
		Collection<String>itt =map.values();
		it=itt.iterator();
		while(it.hasNext())
		{ 
			System.out.println(it.next());
		}
	}
}

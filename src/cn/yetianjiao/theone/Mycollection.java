package cn.yetianjiao.theone;

import java.util.*;

public class Mycollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection<Integer> hah=new ArrayList<>();
		hah.add(1);
		hah.add(2);
		hah.add(3);
		Iterator<Integer>it=hah.iterator();
		while(it.hasNext()){
			int str=(Integer)it.next();
			System.out.println(str);
		}
		
	}

}

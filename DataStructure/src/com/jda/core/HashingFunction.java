package com.jda.core;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import com.jda.Utility.CustomLinkedList;
import com.jda.Utility.OrderedLinkedList;
import com.jda.utility.AlgorithmUtility;

public class HashingFunction 
{
	public static void main(String[] args) {
		try
		{
		CustomLinkedList  hasFun[]= new CustomLinkedList[11];
		String fileName = AlgorithmUtility.getString();
		File file = new File(fileName);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		String[] tmpstr;
		while ((st = br.readLine()) != null) 
		{
			tmpstr = st.split(",");
			for (int i = 0; i < tmpstr.length; i++) 
			{
				int idx=(Integer.valueOf(tmpstr[i]))%11;
				hasFun[idx].add(tmpstr[i]);
			}
		}
		System.out.println("Enter the integer value to search in the file content");
		int key = AlgorithmUtility.getInteger();
		int idx = hasFun[key%11].search(String.valueOf(key));
		if (idx == -1) 
		{
			hasFun[key%11].add(String.valueOf(key));
		} 
		else
		{
			hasFun[key%11].pop(idx);
		}
		System.out.println("File " + fileName + "  updated successfully");
	}
	catch(Exception e)
		{
		System.out.println(e+ " Exception");
		}
	}
}

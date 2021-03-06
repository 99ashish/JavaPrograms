package com.jda.core;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import com.jda.Utility.OrderedLinkedList;
import com.jda.utility.AlgorithmUtility;
/**
 * Read .a List of Numbers from a file and arrange it ascending Order in a
 * Linked List. Take user input for a number, if found then pop the number out
 * of the list else insert the number in appropriate position. Read from file
 * the list of Numbers and take user input for a new number.
 *
 */
public class OrededLinkedList 
{
	public static void main(String[] args)
	{
		try
		{
		OrderedLinkedList list = new OrderedLinkedList();
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
				list.add(Integer.valueOf(tmpstr[i]));
			}
		}
		System.out.println("Enter the integer value to search in the file content");
		int key = AlgorithmUtility.getInteger();
		int idx = list.search(key);
		if (idx == -1) 
		{
			list.add(key);
		} 
		else
		{
			list.pop(idx);
		}
		list.writeToFile(fileName);
		System.out.println("File " + fileName + "  updated successfully");
	}
	catch(Exception e)
		{
		System.out.println(e+ " Exception");
		}
}
}

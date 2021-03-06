package com.jda.core;

import com.jda.Utility.Deque;
import com.jda.utility.AlgorithmUtility;

public class DequeProgram
{
	public static void main(String[] args) 
	{
		System.out.println("Enter the string");
		String str=AlgorithmUtility.getString();
		Deque dq= new Deque();
		int len=str.length();
		for(int i=0;i<len;i++)
			dq.addAtBack(str.charAt(i));
		while(!dq.isEmpty())
		{
			char char1=dq.removeFromBack();
			char char2=dq.removeFromFront();
			if(char1!=char2)
			{
				System.out.println("Given string is not palindrom");
				return;
			}
			if(char1=='0' && char2=='0')
			{
				System.out.println("Given string is palindrom");
				return;
			}
		}
		System.out.println("Given string is palindrom");
	}
}

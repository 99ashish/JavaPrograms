package com.jda.Utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CustomLinkedList {
	static int size = 0;
	String data;
	CustomLinkedList link;
	public static CustomLinkedList head;
	public static CustomLinkedList end;

	public void add(String str) {
		size++;
		if (head == null) {
			CustomLinkedList node = new CustomLinkedList();
			node.data = str;
			head = node;
			end = node;
		} else {
			CustomLinkedList node = new CustomLinkedList();
			node.data = str;
			end.link = node;
			end = node;
		}
	}

	public void remove(String str) {
		CustomLinkedList list = head;
		CustomLinkedList prev = list;
		if (head.data == str)
		{
			head = head.link;
			size--;
		}
		else 
		{
			while (list != null) {
				if (list.data == str) {
					prev.link = list.link;
					if(list==end)
						end=prev;
					size--;
				}
				prev=list;
				list=list.link;
			}
		}
	}
	public void writeToFile(String fileName) throws IOException
	{
		 FileWriter fw=new FileWriter(fileName);    
		 CustomLinkedList list = head;
			while (list != null) {	
         fw.write(list.data +","); 
         list = list.link;
			}
			fw.close();
	}
	public int search(String str)
	{
		if(head==null)
			return -1;
		if(head.data==str)
			return 0;
		CustomLinkedList list=head;
		int cnt=0;
		while(list!=null)
		{
			cnt++;
			if(str.equals(list.data ))
				return cnt;
			list=list.link;
		}
		return -1;
	}
public boolean isEmpty()
{
	if(size==0)
		return true;
	return false;
}
public int sizeOfLinkedList()
{
	return size;
}
public void append(String str)
{
	add(str);
}
public int index(String str)
{
	if(head.data==str)
		return 0;
	int cnt=0;
	CustomLinkedList list=head;
	while(list!=null)
	{
		cnt++;
		if(list.data==str)
			return cnt;
		list=list.link;	
	}	
	return -1;
}
public void insert(int pos, String str)
{
	if(pos==0)
	{
		CustomLinkedList tmp= new CustomLinkedList();
		tmp.data=str;
		tmp.link=head;
		head=tmp;
		return;
	}
	int cnt=0;
	CustomLinkedList list=head;
	CustomLinkedList prev=list;
	while(list!=null)
	{
		cnt++;
		if(cnt==pos)
		{
			CustomLinkedList tmp= new CustomLinkedList();
			tmp.data=str;
			tmp.link=head;
			head=tmp;
			return;
		}
		prev=list;
		list=list.link;
	}
	add(str);
}
public String pop()
{
	if(head==null)
	{size--;
		return null;
	}
	CustomLinkedList list=head;
	CustomLinkedList prev=list;
	while(list.link!=null)
	{
		prev=list;
		list=list.link;
	}
	String elmnt=prev.data;
	size--;
	if(list==head)
	{
		head=null;
		return elmnt;
	}
	end=prev;
	prev.link=null;
	return elmnt;
}
public String pop(int pos)
{
	if(head==null)
		return null;
	if(pos==0)
	{
		size--;
	  String str=head.data;
	  head=head.link;
	  return str;
	}
	CustomLinkedList list=head;
	CustomLinkedList prev=head;
	int cnt=0;
	while(list!=null)
	{
		cnt++;
		if(cnt==pos)
		{
			size--;
			 String str=list.data;
			  prev.link=list.link;
			  return str;
		}
		prev=list;
		list=list.link;
	}
	String elmnt=prev.data;
	if(list==end)
	{
	end=prev;
	prev.link=null;
	}
	return elmnt;
}
public void printList() {
		CustomLinkedList list = head;
		while (list != null) {
			System.out.println(list.data);
			list = list.link;
		}
	}
}
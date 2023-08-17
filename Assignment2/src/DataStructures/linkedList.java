package DataStructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class linkedList<E extends Comparable<E>> implements Iterable<E>{
	Node head;
	Node tail;
	int size=0;
	public class Node implements Comparator<Node>
	{
		E data;
		Node next;
		@Override
		public int compare(linkedList<E>.Node o1, linkedList<E>.Node o2) {
			// TODO Auto-generated method stub
			return (o1.data).compareTo(o2.data);
		}
	}
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		Iterator<E> it = new Iterator<E>() 
        {
            private Node currentNode = head;
            private int currentIndex=0;
            @Override
            public boolean hasNext() 
            {        
                // OverRiding Default hasNext  Method//
                return currentIndex < size;
            }
            @Override
            public E next() 
            {             
                // OverRiding Default next  Method//
            	E val=currentNode.data;
            	currentNode=currentNode.next;
            	currentIndex++;
                return val;
            }
        };
        
        return it;
	}
	
	public void insert(E data)
	{
		Node temp=new Node();
		temp.data=data;
		temp.next=null;
		if(size==0)
			head=tail=temp;
		else
		{
			tail.next=temp;
			tail=temp;
		}
		size++;
	}
	public void insertFirst(E data)
	{
		Node temp=new Node();
		temp.data=data;
		temp.next=head;
		head=temp;
		if(size==0)
			tail=temp;
		
		size++;
	}
	public void insertAt(int idx,E data)
	{
		if(idx<0 || idx>
		size)
		System.out.println("Invalid arguments");
		else if(idx==0)
			insertFirst(data);
		else if(idx==size)
			insert(data);
		else
		{
			Node node=new Node();
			node.data=data;
			
			Node temp=head;
			for(int i=0;i<idx-1;i++)
			{
				temp=temp.next;
			}
			node.next=temp.next;
			temp.next=node;
			size++;
		}
	}
	public void delete()
	{
		if(size==0)
			System.out.println("Empty List");
		else if(size==1)
		{
			head=tail=null;
			size=0;
		}
		else
		{
			Node temp=head;
			for(int i=0;i<size-2;i++)
				temp=temp.next;
			
			tail=temp.next;
			temp.next=null;
			size--;
		}
	}
	public void deleteFirst()
	{
		if(size==0)
		{
			System.out.println("Empty list");
		}
		else if(size==1)
		{
			head=tail=null;
		}
		else
		{
			head=head.next;
			size--;
		}
	}
	public void deleteAt(int idx)
	{
		if(idx<0 || idx>=size)
			System.out.println("Invalid Index");
		else if(idx==0)
			deleteFirst();
		else if(idx==size-1)
			delete();
		else
		{
			Node temp=head;
			for(int i=0;i<idx-1;i++)
				temp=temp.next;
			
			temp.next=temp.next.next;
			size--;
		}
	}
	public E Center()
	{
		Node f=head;
		Node s=head;
		while(f.next!=null && f.next.next!=null)
		{
			s=s.next;
			f=f.next.next;
		}
		
		return s.data;
	}
	public void reverseHelper(Node node)
	{
		if(node==null)
		{
			return;
		}
		reverseHelper(node.next);
		if(node==tail)return;
		
		else
		{
			node.next.next=node;
		}
	}
	public void reverse()
	{
		reverseHelper(this.head);
		this.head.next=null;
		Node temp=head;
		head=tail;
		tail=temp;
	}
	public int size()
	{
		return size;
	}
	public void print()
	{
		Node temp=head;
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
	public void sort()
	{
		ArrayList<E>list =new ArrayList<>();
		Iterator<E> it=iterator();
		while(it.hasNext())
			list.add(it.next());
		Collections.sort(list);
		Node temp=head;
		for(E val:list)
		{
			temp.data=val;
			temp=temp.next;
		}
		
	}
	
}

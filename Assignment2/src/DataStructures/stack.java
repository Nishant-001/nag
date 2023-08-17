package DataStructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class stack<T extends Comparable<T>> implements Iterable<T>{
	ArrayList<T> data;
	int front;
	int size;
	public stack()
	{
		data=new ArrayList<>();
		size=0;
	}
	
	void push(T val)
	{
		data.add(val);
		size++;
	}
	void pop()
	{
		if(size==0)
		{
			System.out.println("Empty Stack");
		}
		else
		{
			data.remove(size-1);
			size--;
		}
	}
	T peek()
	{
		if(size==0)
		{
			System.out.println("Empty Queue");
			return null;
		}
		else
		{
			return data.get(size-1);
		}
	}
	boolean contains(T val)
	{
		for(int i=0;i<size;i++)
		{
			if(data.get(i).equals(val))
				return true;
		}
		return false;
	}
	int size()
	{
		return size;
	}
	T center()
	{
		int mid=(size-1)/2;
		return data.get(mid);
	}
	void sort()
	{
		Collections.sort(data);
	}
	void reverse()
	{
		Collections.reverse(data);
	}
	void print()
	{
		System.out.println(data);
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		Iterator<T> it = new Iterator<T>() 
        {
            private int currentIndex = 0;
            @Override
            public boolean hasNext() 
            {        
                // OverRiding Default hasNext  Method//
                return currentIndex < size && data.get(currentIndex) != null;
            }
            @Override
            public T next() 
            {             
                // OverRiding Default next  Method//
                return data.get(currentIndex++);
            }
        };
        
        return it;
	}
	
	
	
}

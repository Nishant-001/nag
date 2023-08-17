package DataStructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class priorityQueue<T extends Comparable<T>> implements Iterable<T>{
	ArrayList<T> data;
	int size;
	public priorityQueue()
	{
		data=new ArrayList<>();
		size=0;
	}
	
	void enqueue(T val)
	{
		data.add(val);
		size++;
		int i=size-2;
		while(i>=0 && data.get(i).compareTo(data.get(i+1))>0)
		{
			swap(i,i+1);
		}
	}
    private void swap(int i,int j)
    {
        T ith=data.get(i);
        T jth=data.get(j);
        data.set(i,jth);
        data.set(j,ith);
        
    }
	T dequeue()
	{
		if(size==0)
		{
			System.out.println("Empty Queue");
			return null;
		}
		else
		{
			
			size--;
			return data.remove(0);
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
			return data.get(0);
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

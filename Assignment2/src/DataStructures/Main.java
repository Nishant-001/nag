package DataStructures;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) throws Exception {
		
		//------------------Linked List-------------------------------------- //
//		linkedList<Integer> list=new linkedList<>();
//		list.insert(5);
//		list.insert(0);
//		list.insert(1);
//		list.insertFirst(12);
//		list.print();
//		System.out.println(list.Center());
//		list.sort();
//		Iterator<Integer> it=list.iterator();
//		while(it.hasNext())
//			System.out.println(it.next());
		
		
		//------------------ Stack----------------------------------------//
		
//		stack<Integer> st=new stack<>();
//		st.push(1);
//		st.push(20);
//		st.push(2);
//		st.push(21);
//		st.push(5);
//		st.push(3);
//		st.push(3);
//		st.push(3);
//		st.push(3);st.push(3);
//		st.push(3);
//		st.push(3);
//		st.push(3);st.push(3);st.push(3);
//		
//		st.pop();
//		
//		st.print();
//		
//		st.reverse();
//		st.sort();
//		
//		st.print();
		
		
	//----------------queue---------------------------------------------------//
//		queue<Integer> q=new queue<>();
//		q.enqueue(1);
//		q.enqueue(7);
//		q.enqueue(2);
//		q.enqueue(89);
//		q.enqueue(14);
//		
//		q.dequeue();
//		q.dequeue();
//		
//		q.reverse();
//		q.print();
//		System.out.println(q.center());
//		Iterator<Integer> it=q.iterator();
//		while(it.hasNext())
//			System.out.println(it.next());
		
	//-----------------priorityQueue--------------------------------------------//
	
//		priorityQueue<Integer> q=new priorityQueue<>();
//		q.enqueue(1);
//		q.enqueue(7);
//		q.enqueue(2);
//		q.enqueue(89);
//		q.enqueue(14);
//		
//		System.out.println(q.dequeue());
//		
//		q.print();
//		
//		System.out.println(q.peek());
		
	//------------------hashTable-----------------------------------------------//
	hashTable<Integer,Integer> ht=new hashTable<>();
	ht.insert(2, 9);
	ht.insert(3, 1);
	ht.insert(7, 12);
	
	ht.delete(3);
//	ht.print();
	
//	System.out.println(ht.get(3));
	Iterator<Integer> it=new iterator();
	while(it.hasNext())
	{
		System.out.println(it.next());
	}
	
		
		
		
}
}

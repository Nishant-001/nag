package DataStructures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class hashTable<K, V>
{
    private class HMNode {
      K key;
      V value;

      HMNode(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }

    private int size; // n
    private LinkedList<HMNode>[] buckets; // N = buckets.length

    public hashTable() throws Exception {
      initbuckets(4);
      size = 0;
    }

    @SuppressWarnings("unchecked")
	private void initbuckets(int N) throws Exception{
      buckets = new LinkedList[N];
      for (int bi = 0; bi < buckets.length; bi++) {
        buckets[bi] = new LinkedList<>();
      }
    }

    public void insert(K key, V value) throws Exception {
      int bi=hashfn(key);
      int di=getIndexWithinBucket(key,bi);
      if(di!=-1)
      {
          HMNode node=buckets[bi].get(di);
          node.value=value;
      }
      else
      {
          HMNode node=new HMNode(key,value);
          buckets[bi].add(node);
          size++;
      }
    
    double lambda=size*1.0/buckets.length;
    if(lambda>2.0)
    rehash();
    }
    
    private void rehash() throws Exception
    {
        LinkedList<HMNode>[]oba=buckets;
        initbuckets(oba.length*2);
        size=0;
        
        for(int i=0;i<oba.length;i++)
        {
            for(HMNode node: oba[i])
            insert(node.key,node.value);
        }
    }
    private int hashfn(K key)
    {
        int hc=key.hashCode();
        return Math.abs(hc)%buckets.length;
    }
    
    private int getIndexWithinBucket(K key, int bi)
    {
        int di=0;
        for(HMNode node: buckets[bi])
        {
            if(node.key.equals(key))
            return di;
            
            di++;
        }
        return -1;
    }
    public V get(K key) {
      int bi=hashfn(key);
      int di=getIndexWithinBucket(key,bi);
      if(di!=-1)
      {
          HMNode node=buckets[bi].get(di);
          return node.value;
      }
      else
      {
          return null;
      }
    }

    public boolean containsKey(K key) {
      int bi=hashfn(key);
      int di=getIndexWithinBucket(key,bi);
      if(di!=-1)
      {
          return true;
      }
      else
      {
          return false;
      }
    }

    public V delete(K key) throws Exception {
      int bi=hashfn(key);
      int di=getIndexWithinBucket(key,bi);
      if(di!=-1)
      {
          HMNode node=buckets[bi].remove(di);
          size--;
          return node.value;
      }
      else
      {
          return null;
      }
    }

    public ArrayList<K> keyset() {
      ArrayList<K> keys=new ArrayList<>();
      for(int i=0;i<buckets.length;i++)
      {
          for(HMNode node: buckets[i])
          keys.add(node.key);
      }
      
      return keys;
    }

    public int size() {
      return size;
    }

   public void print() {
      for (int bi = 0; bi < buckets.length; bi++) {
        for (HMNode node : buckets[bi]) {
          System.out.println( node.key + "->" + node.value + " ");
        }
      }
  }

//@Override
//public Iterator<V> iterator() {
//	Iterator<V> it = new Iterator<V>()
//    {
//        @Override
//        public boolean hasNext() 
//        {        
//            // OverRiding Default hasNext  Method//
//            return idx<size;
//        }
//        @Override
//        public V next() 
//        {             
//            // OverRiding Default next  Method//
//        	V val=get(list.get(idx));
//        	idx++;
//            return val;
//        }
//    };
//    
//    return it;
	public class iterator
	{
		ArrayList<K> list=keyset();
		int idx;
		int size=list.size();
		public iterator()
		{
			idx=0;
		}
		public boolean hasNext() {
			return idx<size;
		}
		public V next() {
			V val=get(list.get(idx));
			idx++;
			return val;
		}
	}
}
}


class KeyValuePair<K,V>{
	K key;
	V value;
	public KeyValuePair(K key, V value) {
		this.key= key;
		this.value = value;
	}
	@Override
	public String toString() {
		return "KeyValuePair [key=" + key + ", value=" + value + "]";
	}
	@Override
	public boolean equals(Object object) {
		if(object instanceof KeyValuePair) {
			KeyValuePair k = (KeyValuePair) object; // downcasting
			return this.key.equals(k.key);
		}
		return false;
	}
	
}
class Node<T>{
	T data;
	Node<T> next;
	Node(T data){
		this.data = data;
	}
	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
	
}
class LinkedList<T>{
	Node<T> start;
	Node<T> tail;
	int size;
	int getSize() {
		return size;
	}
	T removeAt(int index) {
		Node<T> temp = null;
		if(start == null) {
			System.out.println("LL is Empty Can't Remove");
			return null;
		}
		if(index ==0) {
			temp = start;
			T data = temp.data;
			start = start.next;
			temp = null;
			size--;
			return data;
		}
		Node<T> previous;
		previous = temp = start;
		int counter = 0;
		while(counter<index) {
			previous = temp;
			temp = temp.next;
			counter++;
		}
		T data = temp.data;
		previous.next = temp.next;
		temp= null;
		size--;
		return data;
	}
	int find(T data) {
		int index = 0;
		Node<T> temp = start;
		while(temp!=null) {
			if(temp.data.equals(data)) {
				return index;
			}
			temp = temp.next;
			index++;
		}
		return -1;
	}
	void print() {
		Node<T> temp = start;
		while(temp!=null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	T dataAtIndex(int index){
		Node<T> temp = start;
		int counter = 0;
		if(size==0) {
			throw new RuntimeException("LL is Empty");
		}
		if(index>size || index<0) {
			throw  new RuntimeException("Index Out of Range");
		}
		while(counter<index) {
			temp = temp.next;
			counter++;
		}
		return temp.data;
	}
	void addInLast(T data) {
		if(start == null) {
			tail = start = new Node<>(data);
			size++;
			return;
		}
		else {
			Node<T> node = new Node<>(data);
			tail.next = node;
			tail = node;
			size++;
		}
		
	}
}
class HashTable<K,V>{
	final int DEFAULT_CAPACITY = 10;
	LinkedList<KeyValuePair<K,V>> [] buckets;
	int size;
	HashTable(){
		buckets = new LinkedList[DEFAULT_CAPACITY];
	}
	HashTable(int capacity){
		buckets = new LinkedList[capacity];
	}
	private void reHashing() {
		double loadFactor = 1.0;
		double lambda  = (size) * loadFactor / buckets.length;
		if(lambda>2) {
			reHash();
		}
	}
	private void reHash() {
		LinkedList<KeyValuePair<K,V>> oldBucketRef []= buckets ;
		buckets = new LinkedList[2* oldBucketRef.length];
		size  = 0;
		for(LinkedList<KeyValuePair<K,V>> bucket : oldBucketRef) {
			if(bucket!=null) {
				KeyValuePair<K,V> keyValuePair = bucket.removeAt(0);
				put(keyValuePair.key, keyValuePair.value);
			}
		}
	}
	private int hashFunction(K key) {
		int hashCode = key.hashCode();
		int bucketIndex = hashCode % buckets.length;
		return bucketIndex;
	}
	public void print() {
		System.out.println("Print Called. "+buckets);
		for(LinkedList<KeyValuePair<K,V>> bucket : buckets) {
			if(bucket!=null) {
				bucket.print();
			}
		}
	}
	public V get (K key) {
		int bucketIndex = hashFunction(key);
		LinkedList<KeyValuePair<K,V>> bucket = buckets[bucketIndex];
		if(bucket == null) {
			return null;
		}
		else {
			KeyValuePair<K,V> data = new KeyValuePair<>(key, null);
			int index = bucket.find(data);
			if(index==-1) {
				return null;
			}
			else {
				KeyValuePair<K,V> result = bucket.dataAtIndex(index);
				return result.value;
			}
			
		}
	}
	public V remove(K key) {
		int bucketIndex = hashFunction(key);
		LinkedList<KeyValuePair<K,V>> bucket = buckets[bucketIndex];
		if(bucket == null) {
			return null;
		}
		else {
			KeyValuePair<K,V> data = new KeyValuePair<>(key, null);
			int index = bucket.find(data);
			if(index==-1) {
				return null;
			}
			else {
				
				KeyValuePair<K,V> result = bucket.removeAt(index);
				size--;
				return result.value;
				
			}
		}
	}
	public void put(K key, V value) {
		int bucketIndex = hashFunction(key);
		LinkedList<KeyValuePair<K,V>> bucket = buckets[bucketIndex];
		// if bucket is null (Empty)
		KeyValuePair<K,V> keyValuePair = new KeyValuePair(key, value);
		if(bucket == null) {
			bucket = new LinkedList<KeyValuePair<K,V>>();
			
			bucket.addInLast(keyValuePair);
			buckets[bucketIndex] = bucket;
			size++;
		}
		else {
			// bucket found on index
			int index = bucket.find(keyValuePair);
			if(index==-1) {
				bucket.addInLast(keyValuePair);
				size++;
			}
			else {
				KeyValuePair temp = bucket.dataAtIndex(index);
				temp.value = value;
			}
			
		}
		reHashing();
		
	}
}
public class MyHashMapDemo {

	public static void main(String[] args) {
		HashTable<String,Integer> phones = new HashTable<>();
		phones.put("amit", 3333);
		phones.put("ram", 2222);
		phones.put("ram", 4333);
		phones.print();
		System.out.println("Get "+phones.get("amit"));
		int r = phones.remove("ram");
		System.out.println("After Remove "+r);
		phones.print();
		

	}

}

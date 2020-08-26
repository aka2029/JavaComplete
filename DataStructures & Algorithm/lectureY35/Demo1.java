import java.util.ArrayList;

class Heap{
	ArrayList<Integer> list = new ArrayList<>();
	boolean isMax;
	Heap(){
		isMax = false;
	}
	Heap(boolean isMax){
		this.isMax = isMax;
	}
	public void add(int element) {
		list.add(element); // it will end of the list
		if(isMax) {
			upHeapify2(list.size()-1);
		}
		else {
			upHeapify(list.size()-1);
		}
		
		//upHeapify(list.size()-1);
	}
	
	public int getSize() {
		return list.size();
	}
	
	public int get() {
		return list.get(0);
	}
	
	public int remove() {
		swap(0, list.size()-1);
		int lastElement = list.remove(list.size()-1);
		if(isMax) {
			downHeapify2(0);
		}
		else {
		downHeapify(0);
		}
		//System.out.println("Remove Element is "+lastElement);
		return lastElement;
	}
	
	public void delete() {
		swap(0, list.size()-1);
		int lastElement = list.remove(list.size()-1);
		if(isMax) {
			downHeapify2(0);
		}
		else {
		downHeapify(0);
		}
		System.out.println("Remove Element is "+lastElement);
		
	}
	private void downHeapify(int parentIndex) {
		int lci = parentIndex * 2 + 1;
		int rci = parentIndex * 2 + 2;
		int minIndex = parentIndex;
		if(lci < list.size() && list.get(lci)<list.get(parentIndex)) {
			minIndex = lci;
		}
		if(rci < list.size() && list.get(rci)<list.get(parentIndex)) {
			minIndex = rci;
		}
		if(rci<list.size() && lci<list.size()) {
		if(list.get(rci)<list.get(lci)) {
			minIndex = rci;
		}
		else {
			minIndex = lci;
		}
		}
		
		if(minIndex!=parentIndex) {
			swap(parentIndex, minIndex);
			downHeapify(minIndex);
		}
		
	}
	
	private void downHeapify2(int parentIndex) {
		int lci = parentIndex * 2 + 1;
		int rci = parentIndex * 2 + 2;
		int maxIndex = parentIndex;
		if(lci < list.size() && list.get(lci)>list.get(parentIndex)) {
			maxIndex = lci;
		}
		if(rci < list.size() && list.get(rci)>list.get(parentIndex)) {
			maxIndex = rci;
		}
		if(rci<list.size() && lci<list.size()) {
		if(list.get(rci)>list.get(lci)) {
			maxIndex = rci;
		}
		else {
			maxIndex = lci;
		}
		}
		
		if(maxIndex!=parentIndex) {
			swap(parentIndex, maxIndex);
			downHeapify2(maxIndex);
		}
		
	}
	private void upHeapify(int childIndex) {
		int parentIndex = (childIndex - 1)/2;
		if(list.get(childIndex)<list.get(parentIndex)) {
			swap(parentIndex, childIndex);
			upHeapify(parentIndex);
		}
	}
	
	private void upHeapify2(int childIndex) {
		int parentIndex = (childIndex - 1)/2;
		if(list.get(childIndex)>list.get(parentIndex)) {
			swap(parentIndex, childIndex);
			upHeapify2(parentIndex);
		}
	}
	
	private void swap(int parentIndex, int childIndex) {
		int parentValue = list.get(parentIndex);
		int childValue = list.get(childIndex);
		list.set(childIndex, parentValue);
		list.set(parentIndex, childValue);
	}
	public void print() {
		for(Integer data : list) {
			System.out.println(data);
		}
	}
}
public class HeapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heap heap = new Heap();
		heap.add(10);
		heap.add(20);
		heap.add(15);
		heap.add(30);
		heap.add(5);
		heap.add(25);
		//heap.add(35);
		//heap.add(2);
		heap.print();
		System.out.println("After Remove");
		heap.delete();
		heap.print();
		

	}

}

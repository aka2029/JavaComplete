
public class MinHeapToMaxHeap {

	public static void main(String[] args) {
		int arr[] = {1,3,2,6,8,4,5};
		boolean isMAX = true;
		Heap heap = new Heap(isMAX);
		for(int element : arr) {
			heap.add(element);
		}
		System.out.println("Now Max Heap is ");
		heap.print();

	}

}

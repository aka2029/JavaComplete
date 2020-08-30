
public class KthSmallest {

	public static void main(String[] args) {
		int arr [] = {13,11,12,14,15,18,17,20,19,16};
		Heap heap = new Heap();
		for(int element : arr) {
			heap.add(element);
		}
		int  i = 1;
		int kth = 4;
		while(i<kth) {
			heap.delete();
			i++;
		}
		System.out.println(heap.get());
		
		

	}

}

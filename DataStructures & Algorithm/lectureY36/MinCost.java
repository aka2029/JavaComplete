
public class MinCost {

	public static void main(String[] args) {
		int arr [] = {5,2,3,9};
		Heap heap = new Heap();
		int sum = 0;
		for(int element : arr) {
			heap.add(element);
		}
		while(heap.getSize()!=1) {
			int first = heap.remove();
			int second = heap.remove();
			int cost = (first + second); 
			heap.add(cost);
			sum += cost;
		}
		
		System.out.println("Total Cost is "+heap.remove());
		System.out.println("SUM is "+sum);

	}

}

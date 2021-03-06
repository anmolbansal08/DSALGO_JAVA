package july2;

public class quicksort {

	public static void main(String[] args) {
		int[] arr = { 2, 8, 1, 0, 7, 3, 9, 5 };
		 quicksort(arr, 0, arr.length - 1);
		 for (int val : arr) {
		 System.out.print(val + " ");
		 }
//		System.out.println(partitioning(arr, arr[0]));
//		System.out.println(".");
	}

	//
	private static void quicksort(int[] arr, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		//
		int pivot = arr[hi];
		int pivotidx = partitioning(arr, pivot);
		quicksort(arr, lo, pivotidx - 1); // left half
		quicksort(arr, pivotidx + 1, hi); // right half
	}

	private static int partitioning(int[] arr, int pivot) {
		int itr = 0;
		int pidx = 0;

		// 0 to pidx - 1 => <= pivot
		// pidx to itr - 1 => > pivot
		while (itr < arr.length) {
			if (arr[itr] <= pivot) {
				int temp = arr[itr];
				arr[itr] = arr[pidx];
				arr[pidx] = temp;

				itr++;
				pidx++;
			} else {
				itr++;
			}
		}

		return pidx - 1;
	}

}

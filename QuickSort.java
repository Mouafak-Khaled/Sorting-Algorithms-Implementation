package code;

import given.AbstractArraySort;

/*
 * Implement the quick-sort algorithm here. You can look at the slides for the pseudo-codes.
 * Make sure to use the swap and compare functions given in the AbstractArraySort!
 * 
 */

public class QuickSort<K extends Comparable<K>> extends AbstractArraySort<K> {
	// Add any fields here

	public QuickSort() {
		name = "Quicksort";

		// Initialize anything else here
	}

	// useful if we want to return a pair of indices from the partition function.
	// You do not need to use this if you are just returning and integer from the
	// partition
	public class indexPair {
		public int p1, p2;

		indexPair(int pos1, int pos2) {
			p1 = pos1;
			p2 = pos2;
		}

		public String toString() {
			return "(" + Integer.toString(p1) + ", " + Integer.toString(p2) + ")";
		}

	}

	@Override
	public void sort(K[] inputArray) {
		// TODO:: Implement the quicksort algorithm here
		sort(inputArray, 0, inputArray.length - 1);

	}

	// Public since we are going to check its output!
	/*
	 * public indexPair partition(K[] inputArray, int lo, int hi, int p) { // TODO::
	 * Implement a partitioning function here
	 * 
	 * 
	 * return null;
	 * 
	 * }
	 */

	public void sort(K[] inputArray, int lo, int hi) {
		// TODO:: Implement the quicksort algorithm here

		if (lo < hi) {

			int pivotIndex = partition(inputArray, lo, hi, 0);
			sort(inputArray, lo, pivotIndex - 1);
			sort(inputArray, pivotIndex + 1, hi);
		}

	}

	// Alternative, if you are just returning an integer
	public int partition(K[] inputArray, int lo, int hi, int p) {
		// TODO:: Implement a partitioning

		int head = lo;
		int tail = hi;
		K pivot = inputArray[lo];

		while (head <= tail) {

			while (head <= tail && compare(inputArray[head], pivot) <= 0)
				head++;

			while (head <= tail && compare(inputArray[tail], pivot) > 0)
				tail--;

			if (head < tail)
				swap(inputArray, head, tail);

		}

		swap(inputArray, lo, tail);

		return tail;
	}

	// The below methods are given given as suggestion. You do not need to use them.
	// Feel free to add more methods
	protected int pickPivot(K[] inpuArray, int lo, int hi) {
		// TODO: Pick a pivot selection method and implement it
		return -1;
	}

}

package code;



import given.AbstractArraySort;

/*
 * Implement the heap-sort algorithm here. You can look at the slides for the pseudo-code.
 * Make sure to use the swap and compare functions given in the AbstractArraySort!
 * 
 */

public class HeapSort<K extends Comparable<K>> extends AbstractArraySort<K> {

	// Add any fields here

	public HeapSort() {
		name = "Heapsort";

		// Initialize anything else here
	}

	@Override
	public void sort(K[] inputArray) {
		// TODO: Implement the heap-sort algorithm

		heapify(inputArray);
		int index = inputArray.length - 1;
		while (0 < index) {
			swap(inputArray, 0, index);
			index = index - 1;
			downheap(inputArray, 0, index);
		}

	}

	// Public since we are going to check its output!
	public void heapify(K[] inputArray) {

		for (int i = inputArray.length / 2; i >= 0; i--)
			downheap(inputArray, i);

	}

	// The below methods are given given as suggestion. You do not need to use them.
	// Feel free to add more methods

	protected void downheap(K[] inputArray, int i) {

		downheap(inputArray, i, inputArray.length - 1);

	}

	protected void downheap(K[] inputArray, int i, int k) {

		int index = i;
		int lc = LeftChild(i, inputArray);
		int rc = RightChild(i, inputArray);

		if (lc != -1 && lc <= k && compare(inputArray[index], inputArray[lc]) < 0)
			index = lc;

		if (rc != -1 && rc <= k && compare(inputArray[index], inputArray[rc]) < 0)
			index = rc;

		if (index != i) {

			swap(inputArray, i, index);
			downheap(inputArray, index, k);
		}

	}

	public int LeftChild(int index, K[] inputArray) {

		int i = (2 * index + 1);
		boolean hasLeft = i <= inputArray.length - 1 && i > 0;

		if (hasLeft)
			return i;

		return -1;

	}

	public int RightChild(int index, K[] inputArray) {

		int i = (2 * index + 2);
		boolean hasRight = i <= inputArray.length - 1 && i > 0;

		if (hasRight)
			return i;

		return -1;
	}

}

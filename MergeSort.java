package code;

import given.AbstractArraySort;

/*
 * Implement the merge-sort algorithm here. You can look at the slides for the pseudo-codes.
 * Make sure to use the swap and compare functions given in the AbstractArraySort!
 * 
 * You may need to create an Array of K (Hint: the auxiliary array). 
 * Look at the previous assignments on how we did this!
 * 
 */

public class MergeSort<K extends Comparable<K>> extends AbstractArraySort<K> {

	// Add any fields here

	public MergeSort() {
		name = "Mergesort";

		// Initialize anything else here
	}

	@Override
	public void sort(K[] inputArray) {
		// TODO: Implement the merge-sort algorithm

		sort(inputArray, 0, inputArray.length - 1);

	}

	public void sort(K[] inputArray, int lo, int hi) {
		if (lo < hi) {
			// Find the middle point
			int mid = (lo + hi) / 2;

			// Sort first and second halves
			sort(inputArray, lo, mid);
			sort(inputArray, mid + 1, hi);

			// Merge the sorted halves
			merge(inputArray, lo, mid, hi);
		}
	}

	// Public since we are going to check its output!
	public void merge(K[] inputArray, int lo, int mid, int hi) {

		int leftPart = mid - lo + 1;
		int rightPart = hi - mid;

		K[] leftSubArray = (K[]) new Comparable[leftPart];
		K[] rightSubArray = (K[]) new Comparable[rightPart];

		// Copy data to sub arrays
		for (int i = 0; i < leftPart; i++)
			leftSubArray[i] = inputArray[lo + i];

		for (int j = 0; j < rightPart; j++)
			rightSubArray[j] = inputArray[mid + 1 + j];

		
		// merging the sub arrays into the inputs array
		int i = 0;
		int j = 0;
		int k = lo;

		while (i < leftPart && j < rightPart) {
			
			if (compare(leftSubArray[i], rightSubArray[j]) < 0) {
				inputArray[k] = leftSubArray[i];
				i++;
				
			} else {

				inputArray[k] = rightSubArray[j];
				j++;
			}

			k++;
		}

		// if any element remains in one of the sub arrays
		while (i < leftPart) {
			inputArray[k] = leftSubArray[i];
			i++;
			k++;
		}

		while (j < rightPart) {
			inputArray[k] = rightSubArray[j];
			j++;
			k++;
		}
		

	}
	


}

package code;
import given.AbstractArraySort;

/*
 * Implement the c algorithm here. You can look at the slides for the pseudo-codes.
 * You do not have to use swap or compare from the AbstractArraySort here
 * 
 * You may need to cast any K to Integer
 * 
 */

public class CountingSort<K extends Comparable<K>> extends AbstractArraySort<K> {

	// Add any fields here

	public CountingSort() {
		name = "Countingsort";
	}

	@Override
	public void sort(K[] inputArray) {

		if (inputArray == null) {
			System.out.println("Null array");
			return;
		}
		if (inputArray.length < 1) {
			System.out.println("Empty array");
			return;
		}

		if (!(inputArray[0] instanceof Integer)) {
			System.out.println("Can only sort integers!");
			return;
		}

		Integer min = min(inputArray);
		Integer max = max(inputArray);
		Integer k = max - min + 1;

		Integer[] intInputs = (Integer[]) inputArray;
		int[] counts = new int[k];

		for (int i = 0; i < intInputs.length; i++)
			counts[(Integer) inputArray[i] - (Integer) min(inputArray)]++;

		Integer c = 0;

		for (Integer i = 0; i < k; i++) {
			for (Integer j = 0; j < counts[i]; j++) {

				intInputs[c] = i + min;
				c = c + 1;

			}
			

		}

	}

	public Integer max(K[] inputArray) {

		K max = inputArray[0];

		for (int i = 0; i < inputArray.length; i++) {

			if (compare(inputArray[i], max) >= 0) {

				max = inputArray[i];

			}

		}

		return (Integer) max;
	}

	public Integer min(K[] inputArray) {

		K min = inputArray[0];

		for (int i = 0; i < inputArray.length; i++) {

			if (compare(inputArray[i], min) <= 0) {

				min = inputArray[i];

			}

		}

		return (Integer) min;
	}

}

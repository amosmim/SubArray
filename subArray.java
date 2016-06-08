/**
 * Created by Amos Maimon 08/06/2016.
 */
public class subArray {
	private int start;
	private int end;
	private int sum;
	public subArray() {	}
	public void func (int[] A, int size) throws Exception{
	    // check Valid input.
		if (size <= 0) {
			throw new Exception("the array is empty!");
		}
		// find the big sub sum and is end.
		this.sum = A[0];
		int tampsum = A[0];
		this.end = 0;

		for(int i = 1; i < size; i++) {
			tampsum += A[i];

			if (tampsum > this.sum) {
				this.sum = tampsum;
				this.end = i;
			}

			if (tampsum < 0) {
				tampsum = 0;
			}
		}

		// find the start of the sub array.
		int j = this.end;
		tampsum = this.sum;
		while ((tampsum > 0) || (j == 0)) {
			tampsum -= A[j];
			j--;
		}
		this.start = j + 1;
	}

	public int getEnd() {
		return end;
	}

	public int getSum() {
		return sum;
	}

	public int getStart() {

		return start;
	}

	public static void main(String[] args) {
		int[] array = {-10, 5 , 7, -10, 8, 5 , 7, 19, 4, 7, -7, -98, -20, 1 ,8};
		subArray subArray = new subArray();
		try {
			subArray.func(array, array.length);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if(i < array.length -1) {
				System.out.print(" ,");
			}
		}

		System.out.println("\nsum: " + subArray.getSum());
		System.out.println("start: " + subArray.getStart());
		System.out.println("end: " + subArray.getEnd());
		for (int i = subArray.getStart(); i <= subArray.getEnd(); i++) {
			System.out.print(array[i]);
			if(i < subArray.getEnd()) {
				System.out.print(", ");
			}
		}



	}
}

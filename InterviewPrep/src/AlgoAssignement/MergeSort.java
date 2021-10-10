package AlgoAssignement;

public class MergeSort {
	public static void main(String[] args) {
		
		int[] arr = {0,5,65,24,85,74,13,2,0};
		
		mergeSort(arr);
		
		for(int i : arr) {
			System.out.println(i);
		}
		
	}
	
	public static void mergeSort(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		
		
		int idx =  2;
		
		while(idx/2 < arr.length) {
			for (int i = 0; idx*i < arr.length; i++) {
				sort(arr, idx*i, idx*(i+1));
			}
			
			for(int i : arr) {
				System.out.println(i);
			}
			System.out.println("//////////" + (idx*2));
			idx = idx * 2;
		}

	}
	private static void sort(int[] arr, int start, int end) {
		
		
		
		int mid  = start + (end- start)/2;
		end = Math.min(end,  arr.length);
		int idx1 = start;
		int idx2 = mid;
		
		while(idx1 < mid && idx2 < end) {
			if (arr[idx1] > arr[idx2] ) {
				int temp = arr[idx1];
				arr[idx1] = arr[idx2];
				arr[idx2] = temp;
				
				//idx2++;
			}
			else {
				idx1++;
			}
		}
		
	}

}

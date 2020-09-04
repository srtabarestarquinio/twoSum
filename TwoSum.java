import java.util.*;

public class TwoSum{
	//Helper functions:
    public int findSmallest (int [] arr, int start){
        int smallest = start; //assume first item is smallest
        for (int i = start+1; i<arr.length; i++){
            if (arr[i] < arr[smallest]){//change smallest, as necessary
                smallest = i;
            } 
        }
        return smallest;
    }
    //helper swap funtion
    public void swap (int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }  	
	public void sort(int []arr){
		//sort unsorted array
		int [] sortedArr
        for (int i=0;i<arr.length-1; i++) {
            swap(arr, i, findSmallest(arr, i));
        }
		return 
	}
	public int twoSum(int[] num, int target){
		int low=0, high=num.length()-1;

		while(low<high){
			int sum=num[low]+num[high];
			if(sum==target){
				return new int[]={low+1, high+1};
			}
			else if(sum>target){
				--high;
			}
			else{
				++low;
			}
		}
	}

	//Main function: Welcome user, take user input
	public static void main(String[] args){
		TwoSum twoSum = new twoSum();
		//initialize array of given nums
		int [] arr={}
		Scanner input=new Scanner(System.in);
		System.out.print("Given nums = ");
		System.out.println(" target = ");

		//replace user input array by the sorted version
		twoSum.sort(arr);




		System.out.println("The output should be ");
		System.out.println("Because nums[] + nums[] = ");
	}
}


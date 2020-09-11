import java.util.*;

public class Main{
	//Helper functions:

	//helper findSmallest function
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
    //sort funtion 	
	public int[] sort(int [] arr){
		//sort unsorted array
		//go over all array
        for (int i=0;i<arr.length-1; i++) {
            //call findSmallest funtion and with result, call swap funtion
            swap(arr, i, findSmallest(arr, i));
        }
        return arr;
	}
	public int [] findTwoSum(int[] sortedArr, int target){
		//Create variables for upper and lower boundaries of array
		int low=0, high=sortedArr.length-1;
		//go over while loop until the lower boundary is no longer smaller then the upper boundary, because this means that the pointers have gone over all posibilities
		while(low<high){
			//create variable 'sum' that will try the possibilities of the sum of two different values in the array to find the target value
			int sum=sortedArr[low]+sortedArr[high];
			
			//if the sum equals the target value, then proceed to finding the indices
			if(sum==target){
				//create variables 'arrlow' and 'arrhigh' to get the indeces of the values that sum to the target value, start at zero and increase in the for loop until gets to wanted indeces
				int arrlow=0, arrhigh=0;
				for(int i=0; i<sortedArr.length;i++){
					if (sortedArr[i]==sortedArr[low]){
						arrlow=i;
					}
					if(sortedArr[i]==sortedArr[high]){
						arrhigh=i;
					}
				}
				if(arrlow==arrhigh){
		  		arrlow--;
				}	
        	return new int[] {arrlow, arrhigh};	
        	
			}
			//if sum is larger then the target value, then increase the lower boundary
			else if(sum<target){
				low++;
			}
			//if sum is smaller then the target value, then decrease the upper boundary
			else{
				high--;
			}
		}
		//if end of while loop means that 2 nums to sum to target value were not found in array, therefore output [-1, 0] to signal user the issue
		return new int[] {-1, -1};
	}

	//Main function: Welcome user, take user input
	public static void main(String[] args){
		Main twoSum = new Main();

		Scanner input=new Scanner(System.in);
		
		//Create array of user input size
		System.out.println("Input size of desired array:");
		int n=input.nextInt();
		int [] arr=new int[n];

		//add user input values into array
		System.out.println("Input array values:");
		for(int i=0; i<n; i++){
			arr[i]=input.nextInt();
		}

		//create target variable and store user input
		System.out.println("Target value:");
		int target = input.nextInt();

		input.close();


		//sort array, called sort funtion and store return value in integer array 'sortedArray'
		int [] sortedArr=twoSum.sort(arr);
		//Print sorted array and target value
		System.out.println("Given nums sorted = "+Arrays.toString(sortedArr)+", target= "+target);

		//Call findTwoSum funtion that will give a size 2 int array of the indices where the values that sum up to the target value are located
		int [] indices = twoSum.findTwoSum(sortedArr, target);

		//if both values are the same output [-1, -1] because numbers are not allowed to be used twice
		// if((indices[0]==-1 && indices[1]==-1)){
		// 	System.out.println("The output should be "+Arrays.toString(indices));
		// 	System.out.println("Because num is not allowed to be used twice.");
		// }

		//if array does not include the numbers necessary to make up sum, output [-1, -1]
		if((indices[0]==-1 && indices[1]==-1)){
			System.out.println("There are not enough numbers in array to reach target sum");
		}
		else{
			System.out.println("The output should be "+Arrays.toString(indices));
			int idx1=indices[0], idx2=indices[1];
			System.out.println("Because arr["+idx1+"] + arr["+idx2+"] = "+sortedArr[idx1]+" + "+sortedArr[idx2]+" = "+(sortedArr[idx1]+sortedArr[idx2]));
		}		
	}
}

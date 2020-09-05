import java.util.*;

public class Main{
	//Helper functions:
    public int findSmallest (int [] sortedArr, int start){
        int smallest = start; //assume first item is smallest
        for (int i = start+1; i<sortedArr.length; i++){
            if (sortedArr[i] < sortedArr[smallest]){//change smallest, as necessary
                smallest = i;
            } 
        }
        return smallest;
    }
    //helper swap funtion
    public void swap (int [] sortedArr, int i, int j){
        int temp = sortedArr[i];
        sortedArr[i] = sortedArr[j];
        sortedArr[j] = temp;
    }  	
	public int[] sort(int []sortedArr){
		//sort unsorted array
        //int [] sortedArr=arr;
        for (int i=0;i<sortedArr.length-1; i++) {
            swap(sortedArr, i, findSmallest(sortedArr, i));
        }
        return sortedArr;
	}
	public int [] findTwoSum(int[] arr, int target){
		System.out.println(Arrays.toString(arr));
		int [] sortedArr=arr;
		sortedArr=sort(sortedArr);

		int low=0, high=sortedArr.length-1;

		System.out.println(Arrays.toString(arr));
		while(low<high){
			int sum=sortedArr[low]+sortedArr[high];
			if(sum==target){
				int arrlow=0, arrhigh=0;
				for(int i=0; i<arr.length;i++){
					if (arr[i]==sortedArr[low]){
						System.out.println(arr[i]+"index: "+i);
						arrlow=i;
					}
					if(arr[i]==sortedArr[high]){
						System.out.println(arr[i]+"index:"+i);
						arrhigh=i;
					}
				}
				return new int[] {arrlow, arrhigh};
			}
			else if(sum<target){
				low++;
			}
			else{
				high--;
			}
		}
		return new int[] {};
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

		//Print given array and target value
		System.out.println("Given nums = "+Arrays.toString(arr)+", target= "+target);
		
		//Sort array
		

		int [] indices = twoSum.findTwoSum(arr, target);
    	
    	System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(indices));
		//int [] indicesUnsorted = {Arrays.asList(arr).indexOf(indicesSorted[0]), Arrays.asList(arr).indexOf(indicesSorted[1])};


		if(indices.length==2){
			System.out.println("The output should be "+Arrays.toString(indices));
			int idx1=indices[0], idx2=indices[1];
					System.out.println("Because arr["+idx1+"] + arr["+idx2+"] = "+arr[idx1]+" + "+arr[idx2]+" ="+(arr[idx1]+arr[idx2]));

		}
		
	}
}


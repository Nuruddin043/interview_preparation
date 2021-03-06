package array;

public class LargestContainer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input ={3,5,5,2,5,5,6,6,4,4,1,1,2,5,5,6,6,4,1,3};
		System.out.println(getSizeBruteForce(input));
	}
	
	public static int getSizeBruteForce(int A[]){
		int max= 0;
		for(int i=0; i<A.length; i++){
			for(int j=i+1; j<A.length; j++){
				int size = Math.min(A[i], A[j]) * (j-i);
				max = max>size?max:size;
			}
		}
		return max;
	}
	
	public static int getSize(int A[]){
		if(A.length < 2)
			return 0;
		int minLeft = Integer.MAX_VALUE;
		int minRight = Integer.MAX_VALUE;
		int res = 0;
		int si = 0;
		int ei = A.length-1;
		while(si<ei){
			minLeft = A[si];
			minRight = A[ei];
			int tmp = Math.min(minLeft, minRight) * (ei-si);
			res = Math.max(tmp, res);
			if(minLeft<minRight)
				si++;
			else if(minLeft>minRight)
				ei--;
			else{
				si++;
				ei--;
			}
		}
		return res;
	}

}

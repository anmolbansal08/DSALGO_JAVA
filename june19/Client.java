package june19;

public class Client {

	public static void main(String[] args) {
//		int[] arr = {-5, 2, -1, 3, 6, -11, 8, 9, -10, 5, 6, -4, -5};
		int testarr[]={-3,5,1,2,-8,6};
//		int ta2[]={0,0,-1,0};
		
		kadanes(testarr);
	}
	
	public static void kadanes(int[] arr){
//		int csp = 0;
//		int cep = 0;
		int csum = 0;
		
//		int osp = 0;
//		int oep = 0;
		int osum = 0;
		
		for(int i = 0; i < arr.length; i++){
			if(csum >0){
				csum += arr[i];
//				cep = i;
			} else {
				csum = arr[i];
//				csp = cep = i;
			}
			
			if(csum > osum){
				osum = csum;
//				osp = csp;
//				oep = cep;
			}
		}
		
		
		
		System.out.println(osum);
//		if(oep==osp){
//			System.out.println("");
//			return;
//		}
//		for(int i = osp; i <= oep; i++){
//			System.out.print(arr[i] + " ");
//		}
//		System.out.println(".");
	}

	

    static int maxSubArraySum(int a[]) 
    { 
        int csum = Integer.MIN_VALUE, osum = 0; 
  
        for (int i = 0; i < a.length; i++) 
        { 
            osum = osum + a[i]; 
            if (csum < osum) 
                csum = osum; 
            if (osum < 0) 
                osum = 0; 
        } 
        return csum; 
    } 
}

import java.util.*;
class ReturnAsArray{
	public static void main(String[] args) {
		int i=0,Length=0,n=0,j=0;
		int[] TempArr1;
		int[] TempArr2;
		int[] TempArr3;
		System.out.println("enter the number:");
		Scanner s=new Scanner(System.in);
		double UserInputNumber=s.nextDouble();

		String UserInputNumberStr = String.valueOf( UserInputNumber);
		int LengthOfInputData=UserInputNumberStr.length();

		long TempNum1=(long)UserInputNumber;
		String TempNum1Str=String.valueOf(TempNum1);
		int LengthOfInputDataWholePart=TempNum1Str.length();

		if (TempNum1==UserInputNumber) {
			Length=LengthOfInputDataWholePart;
			TempArr1=new int[LengthOfInputDataWholePart];
			for(i=0;i<(LengthOfInputDataWholePart);i++){
				TempArr1[i]=Character.getNumericValue(TempNum1Str.charAt(i));
				System.out.println(TempArr1[i]);
			}	

		}
		else{
			double TempNum2=Math.pow(10,LengthOfInputData-LengthOfInputDataWholePart-1)*UserInputNumber;
			long TempNum3=(long)TempNum2;
			String TempNum3Str=String.valueOf(TempNum3);
			int LengthOfInputCompleteData=TempNum3Str.length();
			Length=LengthOfInputCompleteData;
			TempArr1=new int[LengthOfInputCompleteData];
			for(i=0;i<(LengthOfInputCompleteData);i++){
				TempArr1[i]=Character.getNumericValue(TempNum3Str.charAt(i));
				System.out.println(TempArr1[i]);
			}	
		}
		TempArr2=new int[Length];
		TempArr2=TempArr1;
		n=(int)Math.ceil((float)Length/2);
		TempArr3=new int[n];
		j=n-1;
		for(i=Length-1;i>=0;i=i-2){
			if(i-1>=0){
				TempArr3[j]=TempArr2[i] + ((TempArr2[i-1])*10);
				j=j-1;
			}
			else{
				TempArr3[j]=TempArr2[i];
			}
		}
	}
}
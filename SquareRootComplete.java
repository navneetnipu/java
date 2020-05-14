import java.util.*;
//String.valueOf(number_user_input)
//Double.parseDouble(str)
//Character.getNumericValue(c)
//number_user_input_str.length()


class SquareRootComplete{

	public static void main(String[] args) {

		System.out.print("enter the number:");
		Scanner s=new Scanner(System.in);
		double UserInputNumber=s.nextDouble();
		Object[] ReqData1=RequiredNumberAndInfo(UserInputNumber);
		Object[] ReqData2=RequiredNumberAndInfo((double)ReqData1[1]);
		double Root=(RootFunction((int[])ReqData1[0]))/(RootFunction((int[])ReqData2[0]));
		System.out.println("the square root of the number is:"+Root);
	}

	public static Object[] RequiredNumberAndInfo(double UserInputNumber){

		Object[] ResultArray=new Object[2];
		String UserInputNumberStr = String.valueOf( UserInputNumber);
		int LengthOfInputData=UserInputNumberStr.length();

		long temp1=(long)UserInputNumber;
		String temp1Str=String.valueOf(temp1);
		int LengthOfInputDataWholePart=temp1Str.length();
		
		double number1=(UserInputNumber)*Math.pow(10,(LengthOfInputData-LengthOfInputDataWholePart-1));
		long number2=(long)number1;
		String number2Str=String.valueOf(number2);

		long Number=(long)Math.pow(10,(LengthOfInputData-LengthOfInputDataWholePart-1));

		int Temp1Arr[]=new int[LengthOfInputData-1];

		for(int i=0;i<(LengthOfInputData-1);i++){
			Temp1Arr[i]=Character.getNumericValue(number2Str.charAt(i));
		}
		int n=Math.round((LengthOfInputData-1)/2);
		int j=n-1;
		int Temp2Arr[]=new int[n];
		for(int i=LengthOfInputData-2;i>=0;i=i-2){
			if(i-1>=0){
				Temp2Arr[j]=Temp1Arr[i]+(Temp1Arr[i-1]*10);
				j--;
			}
			else{
				Temp2Arr[j]=Temp1Arr[i];
			}
		}
		ResultArray[0]=Temp2Arr;
		ResultArray[1]=Number;
		return ResultArray;
	}

	public static double RootFunction(int[] Num){

		int x=0,Remainder=0,R=0,Sum=0,l=0,Divident=0;
		double Root=0;
		for (int i=0;i<=Num.length+3;i++) {
			if (i<Num.length) {
				Divident=(Remainder*100)+Num[i];
				if (((Sum*10)+1)<=Divident) {
					Root=Root*10;
					for (int k=1;k<=9 ;k++ ) {
						Remainder=Divident;
						R=Divident-(((Sum*10+k))*k);
						if (R<Divident && R>=0 ) {
							Remainder=R;
							x=k;
						}
						else{
							x=x;
						}
					}
					Sum=(Sum*10+x)+x;
					Root=Root+x;
				}
				else{
					}
			}
			else{
				Divident=Remainder*100;
				if (((Sum*10)+1)<=Divident) {
					Divident=Divident*100;
					Root=Root*10;
					l=l*10;
				}	
				else{
					Root=Root*10;
					for (int k=1;k<=9 ;k++ ) {
						Remainder=Divident;
						R=Divident-(((Sum*10+k))*k);
						if (R<Divident && R>=0 ) {
							Remainder=R;
							x=k;
						}
						else{
								x=x;
						}
					}
					Sum=(Sum*10+x)+x;
					Root=Root+x;
					l=l*10;
				}
			}
		}
		Root=Root/l;
		return Root;
	}
}
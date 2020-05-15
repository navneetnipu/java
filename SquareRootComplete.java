import java.util.*;

/*
basic used typical functions
String.valueOf(number_user_input)
Double.parseDouble(str)
Character.getNumericValue(c)
number_user_input_str.length()
*/

class SquareRootComplete{

	public static void main(String[] args) {
		double Root1=0,Root2=0,Root=0,DecimalNum=0;// temporary variables to store the intermediate data
		System.out.println("enter the number:");
		Scanner s=new Scanner(System.in);
		double UserInputNumber=s.nextDouble();// taking user input as double formatted number

		/*
			generating required output using diffeent methods
		*/

		DecimalNum=ReturnDenumDecimal(UserInputNumber);
		int[] NumeratorArray=ReturnAsArray(UserInputNumber);
		Root1=RootFunction(NumeratorArray);
		int[] DenumeratorArray=ReturnAsArray(DecimalNum);
		Root2=RootFunction(DenumeratorArray);
		Root=(double)Root1/Root2;
		System.out.println("the square root of the number is : "+Root);// printing the actual square root of the number
	}

	/*
		method to generate the decimal part of the input number
	*/

	public static double ReturnDenumDecimal(double UserInputNumber){

		int Length=0,Decimal=0;//temporary variables
		double Denum=0;

		String UserInputNumberStr = String.valueOf( UserInputNumber);
		int LengthOfInputData=UserInputNumberStr.length();

		long TempNum1=(long)UserInputNumber;
		String TempNum1Str=String.valueOf(TempNum1);
		int LengthOfInputDataWholePart=TempNum1Str.length();

		/*
			converting decimal part of the entered double number
		*/

		if (TempNum1==UserInputNumber) {
			Length=LengthOfInputDataWholePart;
			Decimal=0;
		}
		else{
			double TempNum2=Math.pow(10,LengthOfInputData-LengthOfInputDataWholePart-1)*UserInputNumber;
			long TempNum3=(long)TempNum2;
			String TempNum3Str=String.valueOf(TempNum3);
			int LengthOfInputCompleteData=TempNum3Str.length();
			Length=LengthOfInputCompleteData;
			Decimal=LengthOfInputCompleteData-LengthOfInputDataWholePart;
		}
		Denum=Math.pow(10,Decimal);
		return Denum;// returning the actual decimal part of the entered number
	}

	/*
		method to generate the array of the input number in usable form for generating square root of the number
	*/
	public static int[] ReturnAsArray(double UserInputNumber){

		int i=0,Length=0,n=0,j=0;//temporary variables
		int[] TempArr1;
		int[] TempArr2;
		int[] TempArr3;
		int[] Array;// actual usable array variable

		String UserInputNumberStr = String.valueOf( UserInputNumber);
		int LengthOfInputData=UserInputNumberStr.length();

		long TempNum1=(long)UserInputNumber;
		String TempNum1Str=String.valueOf(TempNum1);
		int LengthOfInputDataWholePart=TempNum1Str.length();

		/*
			converting number into usable array
		*/

		if (TempNum1==UserInputNumber) {
			Length=LengthOfInputDataWholePart;
			TempArr1=new int[LengthOfInputDataWholePart];
			for(i=0;i<(LengthOfInputDataWholePart);i++){
				TempArr1[i]=Character.getNumericValue(TempNum1Str.charAt(i));
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
		Array=new int[n];
		Array=TempArr3;
		return Array;//returning actual usable array
	}

	/*
		method to generate the square root of any given valid double number by continuous division method
	*/

	public static double RootFunction(int[] Num){

		int x=0,Remainder=0,R=0,Sum=0,Divident=0,k=1,i=0;// temporary variables
		double Root=0,count=0,FinalRoot=0;
		long DecRoot=0;//dcimal part root

		/*
			square root my long division method
		*/

		for (i=0;i<(Num.length);i++) {
			Divident=(Remainder*100)+Num[i];
				if (((Sum*10)+1)<=Divident) {
					Root=Root*10;
					for (k=1;k<=9 ;k++ ) {
						R=Divident-(((Sum*10+k))*k);
						if (R<=Divident && R>=0 ) {
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
						Remainder=Divident;
						Root=Root*10;
						Sum=Sum*10;
					}
		}

		/*
			generating square root after decimal point
		*/

		if(Remainder==0) {
			FinalRoot=Root;
		}
		else{
				x=0;
	    		count=0;
	    		Divident=Remainder;
	    		for(int m=1;Divident<(Sum*10+1);m++)
	    		{
	    			Divident=Divident*100;
	    			count=count+1;
	    		}
	    		for(i=1;i<=5;i++)
	    		{
	    			if(Divident>=(Sum*10+1))
	    			{
	    				DecRoot=DecRoot*10;
	    				for(k=1;k<=9;k++)
	    				{
	    					R=Divident-((Sum*10+k)*k);
	    					if((Divident>=((Sum*10+k)*k)) && (R<=Divident) && (R>=0))
	    						{
	  				 				Remainder=R;
	  				 				x=k;
	  				 			}
	  				 		else
	  				 			{
	  				 				x=x;
	  				 			}
	  					}
	  					Sum= (Sum*10+x)+x;
	  					Divident=Remainder*100;
	    				DecRoot=DecRoot+x;
	    			}
	    			else
	    			{	
	    				Divident=Divident*100;
	    				Sum=Sum*10;
	    				DecRoot=DecRoot*10;
	    			}
	    		}
	    		String t= String.valueOf(DecRoot);
	    		int p=t.length();
	    		FinalRoot=(double)(((double)DecRoot)/(Math.pow(10,p)))+Root;//final square root
		}
		return FinalRoot;//returning final root value 
	}
}

// END OF PROGRAM

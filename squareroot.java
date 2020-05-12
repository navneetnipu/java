// METHOD TO FIND SQUARE ROOT OF A float NUMBER

//


import java.util.*;
class squareroot
{
	

	// variable declaration
	
	    // i=loop variable
		// j=loop variable
		// k=best divisor
		// num_w=int(number)
		// num_d=decimal(number)
		// num_m=float of decimal part
		// n_w=number of digits in num_w
		// n_d=number of digits in num_d
		// p=to store number temporerly

	    // procedure

		// 1-get the float number
		// 2-convert to num_w and num_d and find number of digits
		// 3-use arithmetic procedure to find square root 

	public static void main(String args[])
	{
		float number;

		Scanner s=new Scanner(System.in);
		number=s.nextFloat();

		int[] digits=ReturnWholeNumber(number);		
		long root=RootOfNumber(digits[0],digits[2]);
		System.out.println(digits[0]+"*"+digits[2]+"*"+digits[3]);
		System.out.println("root is:"+root);


	}

	// function that generates whole digits,decimal digits as a whole number,number of digits in whole number and decimal number

	public static int[] ReturnWholeNumber(float Number)
	{
		// variable needed for this function

		float num_m;
	    int p,num_w,num_d,n_d,n_w;
	    String t;


		int[] Return = new int[4];

		t=String.valueOf(Number);

		p=(int)Number;
		for(n_w=0;p!=0;n_w++)
		{
			p=p/10;
		}

		num_w=(int)Number;
		n_d=(t.length())-n_w-1;
		num_m=(Number-(float)num_w)*(int)Math.pow(10,n_d);
		num_d=Math.round(num_m);

		Return[0]=num_w;
		Return[1]=num_d;
		Return[2]=n_w;
		Return[3]=n_d;
		return Return;
	}

	// function that generates root of the whole number given to it

	public static long RootOfNumber(int int_num,int int_num_w)
	{
		// variable needed for this function
		int count=0;
		double n=0;
		long root=0;
	    long x=0,j,k=0,r=0,remainder=0,divisor=0,divident=0,sum=0,num=0;

	    // procedure for root of number
	    // by division method

	    for(j=2;j<=int_num_w;j=j+2)
	    	{
	    		root=root*10;
	    		n=((int_num/Math.pow(10,(int_num_w-j))))-(((int)(int_num/Math.pow(10,int_num_w-j+2)))*100);
	    		num=Math.round(n);
	  			divident=remainder*100+num;
	  			sum=(sum*10+k)+k;

	  			for(k=1;k<=9;k++)
	  
	   				{
	   					divisor=sum*10+k;
	  				 	r=divident-(divisor*k);

	  				 	if((r<=divident) &&((divisor*k)<=divident))
	  				 	{
	  				 		remainder=r;
	  				 		x=k;
	  				 	}
	  				 	else
	  				 	{
	  				 		count=count+1;;
	  				 	}
	   				}
	   			root=(root+x);
	    	}
	    return root;
	}
}

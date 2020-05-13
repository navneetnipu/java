// method to find square root of a EVEN DIGITED long number APPROXIMATE to 3 DECIMAL PLACES


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
		double e;
		int h;
		long g=0;

		System.out.println("enter the even digited number in whole part of float:");
		Scanner s=new Scanner(System.in);
		number=s.nextFloat();

		int[] digits=ReturnWholeNumber(number);	
		long[] root_n_remainder=RootOfNumber(digits[0],digits[2],0);
		g=root_n_remainder[2];
		for(h=0;g!=0;h++)
		{
			g=g/10;
		}
		e=(((double)root_n_remainder[2])/(Math.pow(10,h+(root_n_remainder[3])-1)))+(double)root_n_remainder[0];
		System.out.println("the square root is:"+e);
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

	public static long[] RootOfNumber(long int_num,int int_num_w,int excess_remainder_in)
	{
		// variable needed for this function
		int count=0,i;
		double n=0;
		long root=0;
	    long x=0,j,k=0,r=0,remainder=0,divisor=0,divident=0,sum=0,num=0,excess_remainder=0,new_root=0;
	    long[] Root_and_Remainder=new long[4];

	    // procedure for root of number
	    // by division method

	    for(j=2;j<=int_num_w;j=j+2)
	    {
	    		root=root*10;
	    		n=((int_num/Math.pow(10,(int_num_w-j))))-(((int)(int_num/Math.pow(10,int_num_w-j+2)))*100);
	    		num=(int)n;
	  			divident=remainder*100+num;
	    		
	  			sum=(sum*10+x)+x;

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
	  				 		x=x;
	  				 	}
	   				}
	   			root=(root+x);
	   			excess_remainder=remainder;
	    }
	    sum=(sum*10+x)+x;
	    if(excess_remainder==0)
	    	{
	    		Root_and_Remainder[0]=root;
	  			Root_and_Remainder[1]=excess_remainder;
	  			Root_and_Remainder[2]=new_root;
	  			return Root_and_Remainder;
	    	}
	    else
	    	{
	    		x=0;
	    		count=0;
	    		divident=remainder;
	    		for(int m=1;divident<(sum*10+1);m++)
	    		{
	    			divident=divident*100;
	    			count=count+1;
	    		}
	    		for(i=1;i<=5;i++)
	    		{
	    			new_root=new_root*10;
	    			if(divident>=(sum*10+1))
	    			{
	    				for(k=1;k<=9;k++)
	    				{
	    					divisor=(sum*10+k);
	    					r=divident-(divisor*k);
	    					if((divident>=(divisor*k)) && (r<=divident) && (r>=0))
	    						{
	  				 				remainder=r;
	  				 				x=k;
	  				 			}
	  				 		else
	  				 			{
	  				 				x=x;
	  				 			}
	  					}
	  					sum= (sum*10+x)+x;
	  					divident=remainder*100;
	    				new_root=new_root+x;
	  					excess_remainder=remainder;
	    			}
	    			else
	    			{	
	    				divident=divident*100;
	    				new_root=new_root*10;
	    			}
	    			
	  				
	    		}

	    		Root_and_Remainder[0]=root;
	  			Root_and_Remainder[1]=excess_remainder;
	  			Root_and_Remainder[2]=new_root;
	  			Root_and_Remainder[3]=count;
	  			return Root_and_Remainder;
	   		}
	}
}

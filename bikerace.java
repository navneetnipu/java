// bikerace
import java.util.*;
class bikerace
{
	public static void main(String args[])
	{
		// declaring variables and taking input

		float s1,s2,s3,s4,s5,avg;
		Scanner s=new Scanner(System.in);
		System.out.println("enter the speed of the first racer in kmph:");
		s1=s.nextFloat();
		System.out.println("enter the speed of the second racer in kmph:");
		s2=s.nextFloat();
		System.out.println("enter the speed of the third racer in kmph:");
		s3=s.nextFloat();
		System.out.println("enter the speed of the forth racer in kmph:");
		s4=s.nextFloat();
		System.out.println("enter the speed of the fifth racer in kmph:");
		s5=s.nextFloat();

		//taking average speed

		avg=(s1+s2+s3+s4+s5)/5;

		//conditions for qualifying for the race

		if(s1>avg)
		{
		}

		else if(s2>avg)
		{
			System.out.println("second racer is qualified.");
		}

		else if(s3>avg)
		{
			System.out.println("third racer is qualified.");
		}

		else if(s4>avg)
		{
			System.out.println("forth racer is qualified.");
		}

		else if(s5>avg)
		{
			System.out.println("fifth racer is qualified.");
		}

		else
		{
			System.out.println("no one is qualified.");
		}

	}
}
import java.util.*;
class quadraticdemo
{
	public static void main(String [] args)
	{
		double a,b,c,i,r;
		double root1,root2,D;

		Scanner s=new Scanner(System.in);
		System.out.println("given a quadratic equation:ax^2+bx+c=0\n");
		System.out.println("enter the value for a:\n");
		a=s.nextFloat();
		System.out.println("enter the value for b:\n");
		b=s.nextFloat();
		System.out.println("enter the value for c:\n");
		c=s.nextFloat();

		D=b*b-4*a*c;

		if(D>0)
		{
			root1=(-b+Math.sqrt(D))/(2*a);
			root2=(-b-Math.sqrt(D))/(2*a);

			System.out.println(root1+"and"+root2);

		}

		else if(D==0)
		{
			root2=(-b)/(2*a);
			root1=root2;

			System.out.println(root1+"and"+root2);
		}

		else
		{
			r=(-b)/(2*a);
			i=(Math.sqrt(-D))/(2*a);
			System.out.println(r+"+i"+i);
			System.out.println(r+"-i"+i);
		}

	}
}
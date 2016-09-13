import java.util.Scanner;

public class PracticeAlgorithms 
{

	public static void main(String[] args) 
	{
		//add();
		max();
	}
	
	public static void add()
	{
		int num1, num2;
		Scanner s = new Scanner(System.in);
		System.out.println ("Please input two numbers: ");
		num1 = s.nextInt();
		num2 = s.nextInt();
		
		System.out.print(num1 + num2);
		
	}
	
	public static void max()
	{
		int a, b, c;
		Scanner s = new Scanner(System.in);
		System.out.println("Please input three numbers: ");
		a = s.nextInt();
		b = s.nextInt();
		c = s.nextInt();
		
		if(a > b)
		{
			if(a > c)
				System.out.println(a + " is the largest number");
			else
				System.out.println(c + " is the largest number");
		}
		else
		{
			if(b > c)
				System.out.println(b + " is the largest number");
			else
				System.out.println(c + " is the largest number");
		}
	}
	
	public static void roots(int a, int b, int c)
	{
		int d;
		double r1, r2, rp, ip;
		d = b*b - 4 * a * c;
		if (d >= 0)
		{
			r1 = (-1 * b + Math.sqrt(d)) / (2 * a);
			r2 = (-1 * b - Math.sqrt(d)) / (2 * a);
			System.out.println("Root 1: " + r1);
			System.out.println("Root 2: " + r2);
		}
		else
		{
			rp = b / (2 * a);
			ip = Math.sqrt((-1 * d) / (2 * a));
			System.out.println("Root 1: " + rp + " + " + ip);
			System.out.println("Root 2: " + rp + " - " + ip);
		}
	}
	
	public static void factorial()
	{
		int n, factorial, i;
		Scanner s = new Scanner(System.in);
		factorial = 1;
		i = 1;
		System.out.println("Please input a number: ");
		n = s.nextInt();
		while (i < n)
		{
			factorial *= i;
			i++;
		}
		System.out.println("The factorial of your number is: " + factorial);
	}
}
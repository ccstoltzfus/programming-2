import java.util.Scanner;
import java.io.*;


public class XORCryptor 
{
	public static void main(String[] args) 
	{
		help();
		readtest("test.txt");
	}

	public static void help()
	{
		System.out.println("Uses:    help -- get help \n"
				+ "readtest <filepath> -- cat a file to prove that you can read files \n"
				+ "xor <filepath> <cipher> -- XOR text in file with cipher \n"
				+ "analyze <filepath> <num buckets> -- give character frequencies for text in file for each bucket");
	}
	
	public static void readtest (String path)
	{
		Scanner scan = null;
		try
		{
			scan = new Scanner(new File(path));
		}
		catch (Exception e)
		{
			System.out.println("Sorry! I was unable to load that file.");
		}
		
		System.out.println(scan.nextLine());
	}
	
	public static void xor (String path, String key)
	{
		//Code goes here
	}
	
	public static void analyze (String path, int x)
	{
		//More code!
	}
}

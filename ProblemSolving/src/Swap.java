
public class Swap
{
	public static void main(String[] args)
	{
		
		int a = 12;
		int b = 34;
		
		System.out.println("a : " + a + " b : " + b);
		
		a = a + b;
		b = a - b;
		a = a - b;
		
		System.out.println("a : " + a + " b : " + b);
	}
}

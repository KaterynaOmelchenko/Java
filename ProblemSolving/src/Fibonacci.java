import java.util.ArrayList;

public class Fibonacci
{
	public static void main(String[] args)
	{
		var fibNumbers = new ArrayList<Integer>();
		fibNumbers.add(0, 0);
		fibNumbers.add(1, 1);
		
		for (var i = 2; i < 10; i++)
		{
			fibNumbers.add(fibNumbers.get(i - 2) + fibNumbers.get(i - 1));
		}
		
		System.out.println(fibNumbers);
		
	}
}

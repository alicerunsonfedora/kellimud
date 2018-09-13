import java.util.Scanner;  
public class TheGame {

	public TheGame() {
	
	}

	public static void main(String[] args)
	{
		boolean ExitFlag = false;
        Scanner in = new Scanner(System.in);
		while(true)
		{
			String input = in.nextLine();
			
			if(input.equals("pick up"))
			{
				System.out.println("What item do you want to pick up?");
			}
			
			else if (input.equals("drop"))
			{
				System.out.println("What item do you want to drop?");
			}
			
			else if(input.equals("attack"))
			{
				System.out.println("");
			}
			
			else if(input.equals("move"))
			{
				System.out.println("What direction do you want to move to?");
			}
			
			else if(input.equals("exit"))
			{
				System.out.println("Are you sure you want to close the game?");
				
				while(true)
				{
					input = in.nextLine();
					if(input.equals("yes"))
					{
						System.out.println("Game is closing");
						ExitFlag = true;
						break;
					}
					else if(input.equals("no"))
					{
						System.out.println("DECIDE DUDEEE,wanna play or not?");
						System.out.println("I mean... Game resuming");
						break;
					}
					else
					{
						System.out.println("yes or no?");
					}
				}
			}
			else
			{
				System.out.println("The Fuck you talking about dude?");
				System.out.println("I mean... Use proper command");
			}
			if (ExitFlag == true)
			{
				break;
			}
		}

	}

}

import java.util.Scanner;  
public class TheGame {

	public TheGame() {
	
	}

	public static void main(String[] args)
	{
		int i;
		Player player = new Player("FilthyCStudent","noob");
		Room room0 = new Room(0,1);
		Room room1 = new Room(1,1);
		Room room2 = new Room(2,1);
		Room room3 = new Room(3,1);
		Room room4 = new Room(4,1);
		Room room5 = new Room(5,1);
		Room room6 = new Room(6,1);
		Room room7 = new Room(7,1);
		Room room8 = new Room(8,1);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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

import java.util.Scanner;  
public class TheGame {
	public TheGame() {
	
	}

	public static void main(String[] args)
	{
		Player player = new Player("FilthyCStudent","noob");
		
		Room[] thisDick = new Room[9];
		thisDick[0] = new Room(player,0,1);
		thisDick[1] = new Room(player,1,1);
		thisDick[2] = new Room(player,2,1);
		thisDick[3] = new Room(player,3,1);
		thisDick[4] = new Room(player,4,1);
		thisDick[5] = new Room(player,5,1);
		thisDick[6] = new Room(player,6,1);
		thisDick[7] = new Room(player,7,1);
		thisDick[8] = new Room(player,8,1);
		Dungeon TheDungeon = new Dungeon(thisDick);
		
		System.out.println("Tom : Hello Stranger");
		System.out.println("Tom : My name is Tom Kelliher");
		System.out.println("Tom : WAIT WHAT???");
		System.out.println("Tom : IS THAT 42 CHOCOLATE BARS???");
		System.out.println("Tom : I'm out of here noob, good luck");
		System.out.println("...");
		System.out.println("Announcer : Little did Tom know, those bars had stupid CS students in them...");
		System.out.println("Announcer : Tom's only weakness");
		System.out.println("Announcer : After eating all 42 of them, he transoformed into the MAD TOM");
		System.out.println("Announcer : You are in a dungeon, your job is to find MAD TOM and end his suffering");
		System.out.println("Announcer : Good Luck, Adventurer");
		
		
		
		
		
		
		
		
		
		
		
		

        Scanner in = new Scanner(System.in);
		while(true)
		{
			boolean ExitFlag = false;
			String input = in.nextLine();
			
			if(input.equalsIgnoreCase("pick up"))
			{
				System.out.println("What item do you want to pick up?");
			}
			
			else if (input.equalsIgnoreCase("drop"))
			{
				System.out.println("What item do you want to drop?");
			}
			
			else if (input.equalsIgnoreCase("equip"))
			{
				System.out.println("What item do you want to equip?");
			}
			
			else if(input.equalsIgnoreCase("attack"))
			{
				System.out.println("");
			}
			
			else if(input.equalsIgnoreCase("move"))
			{
				System.out.println("What direction do you want to move to?");
			}
			
			else if(input.equalsIgnoreCase("exit"))
			{
				ExitFlag = player.exit();
				if(ExitFlag==true)
				{
					break;
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

import java.util.Scanner;
import java.io.Console;
import static java.lang.System.out;
public class TheGame {
	public TheGame() {
	
	}

	public static void main(String[] args)
	{
		Player player = new Player("Filthy CS Student (you)","noob");
		
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
		
		Scene sceneHandler = new Scene();

		Characters.mc.changeName("Filthy CS Student (you)");
		sceneHandler.playScene(sceneHandler.introSceneA);
		Characters.tom.changeName("The Mad Tom");
		sceneHandler.playScene(sceneHandler.introSceneB);
		Characters.narrator.changeName("Andy");

        Scanner in = new Scanner(System.in);
		while(true)
		{
			if (player.isDead)
			{
				break;
			}
			
			boolean ExitFlag = false;
			out.println(Characters.narrator.say("What should we do?\n$> "));
			String input = in.nextLine();
			
			if(input.equalsIgnoreCase("pick up"))
			{
				out.println(Characters.narrator.say("What item do you want to pick up?"));
				input = in.nextLine();
				if (input.equals(""))
				{
					out.println(Characters.narrator.say("Ah, got it. Stop picking up air, you weirdo."));
				}
				else
				{
					System.out.println(player.manage_inventory("pick up", input,TheDungeon));
				}
				
			}
			
			else if (input.equalsIgnoreCase("drop"))
			{
				out.println(Characters.narrator.say("What item do you want to drop?"));
				input = in.nextLine();
				System.out.println(player.manage_inventory("drop", input,TheDungeon));
			}
			
			else if (input.equalsIgnoreCase("equip"))
			{
				out.println(Characters.narrator.say("What item do you want to equip?"));
				input = in.nextLine();
				System.out.println(player.equip(input));
			}
			
			else if(input.equalsIgnoreCase("info"))
			{
				out.println(Characters.narrator.say("Uh, let's see here..."));
				out.println(player.info(TheDungeon));
			}
			
			else if(input.equalsIgnoreCase("attack"))
			{
				int damage[] = new int[2];
				damage = player.attack(TheDungeon);
				System.out.println("You did " + damage[0] + " damage to the mob");
				System.out.println("The Mob did " + damage[1] + " damage to you");
			}
			
			else if(input.equalsIgnoreCase("move"))
			{
				out.println(Characters.narrator.say("Okay, so where are we going? We can go North, South, East, or West."));
				out.println(Characters.narrator.say("No pressure or anything, but I'm letting you do the navigation."));
				input = in.nextLine();
				System.out.println(player.move(input,TheDungeon));
			}
			
			else if(input.equalsIgnoreCase("exit"))
			{
				ExitFlag = player.exit();
				if(ExitFlag==true)
				{
					break;
				}
			}

			else if (input.equalsIgnoreCase("clear"))
			{
				out.println("\f");
				out.println(Characters.narrator.say("Alright, I cleared it up."));
			}

			else if (input.equalsIgnoreCase("me"))
			{
				out.println(Characters.narrator.say("Here's all I know about you:"));
				out.println("Name: " + player.name());
				out.println("Level: " + player.level());
				out.println("Health: " + player.health());
			}

			else if (input.equalsIgnoreCase("fuck"))
			{
				out.println(Characters.narrator.say("E-Eh? That's not nice..."));
				out.println(Characters.narrator.say("W-ho?"));

				String who = in.nextLine();

				if (who.equalsIgnoreCase("mob"))
				{
					sceneHandler.playScene(sceneHandler.fuckMobDieScene);
				}
				else if (who.equalsIgnoreCase("you"))
				{
					out.println(Characters.narrator.say("Uwaa~!"));
				}
				else 
				{
					out.println(Characters.narrator.say("That's weird. How about no?"));
				}

			}

			else
			{
				out.println(Characters.narrator.say("Eh? I-I don't understand what you mean."));
				out.println(Characters.narrator.say("Could you try a valid command next time?"));
			}
			if (ExitFlag == true)
			{
				break;
			}
		}

	}
	

}

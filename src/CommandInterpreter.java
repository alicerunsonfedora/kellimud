import static java.lang.System.out;

import java.util.Scanner;

public class CommandInterpreter {
		
	public void interpret(String input, Player player, Dungeon TheDungeon) {
		Scanner in = new Scanner(System.in);
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
		
		else if(input.equalsIgnoreCase("hand"))
		{
			out.println(player.hand().name() + Integer.toString(player.hand().getLevel()));
		}
		
		else if(input.equalsIgnoreCase("info"))
		{
			out.println(Characters.narrator.say("Uh, let's see here..."));
			out.println(player.info(TheDungeon));
		}
		else if(input.equalsIgnoreCase("hand"))
		{
			out.println(player.hand());
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
			System.out.println(player.move(TheDungeon));
		}
		
		else if(input.equalsIgnoreCase("exit"))
		{
			out.println(Characters.narrator.say("Are you sure you want to close the game?"));
			
			while(true)
			{
				String input1 = in.nextLine();
				if(input1.equalsIgnoreCase("yes"))
				{
					out.println(Characters.narrator.say("I guess it's goodbye, then."));
					out.println(Characters.narrator.say("Until we meet again..."));
					System.exit(0);
				}
				else if(input1.equalsIgnoreCase("no"))
				{
					Scene.playScene(Scene.confirmGameResume);
				}
				else
				{
					System.out.println("yes or no?");
				}
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
			out.println("Attack: " + player.attackValue());
			out.println("Defense: " + player.defense());
		}

		else if (input.equalsIgnoreCase("mob"))
		{
			if (TheDungeon.room().MobAlive())
			{
				out.println(Characters.narrator.say("Here's what I know about the mob:"));
				out.println("Level: " + Integer.toString(TheDungeon.room().mob().level()));
				out.println("Health: " + Integer.toString(TheDungeon.room().mob().health()));
			}

			else
			{
				out.println(Characters.narrator.say("Welp, looks like there's no mob here..."));
			}
		}

		else if (input.equalsIgnoreCase("fuck"))
		{
			out.println(Characters.narrator.say("E-Eh? That's not nice..."));
			out.println(Characters.narrator.say("W-ho?"));

			String who = in.nextLine();

			if (who.equalsIgnoreCase("mob"))
			{
				//sceneHandler.playScene(sceneHandler.fuckMobDieScene);
				//break;
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
		
		else if (input.equalsIgnoreCase("help"))
		{
			out.println("===Inventory===");
			out.println("drop: drops an object");
			out.println("equip: equips an object");
			out.println("pick up: picks up an object\n");
			
			out.println("===Interactions===");
			out.println("attack: attack a mob in the room, if present");
			out.println("move: move to a different room in a direction\n");
			
			out.println("===Getting Information===");
			out.println("hand: displays information on what you are holding");
			out.println("info: displays information on where you are.");
			out.println("me: displays information about yourself");
			out.println("mob: displays information about a mob\n");
			
			out.println("===Miscellaneous===");
			out.println("clear: clears the console");
			out.println("exit: quits the game");
			out.println("help: displays this screen\n");
		}

		else
		{
			out.println(Characters.narrator.say("Eh? I-I don't understand what you mean."));
			out.println(Characters.narrator.say("Could you try a valid command next time?"));
		}
	}
	
	public CommandInterpreter() {}

}

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
		
		Speaker tom = new Speaker("Tom");
		Speaker narrator = new Speaker("Announcer");
		Speaker mc = new Speaker(player.name());

		out.println(tom.say("Hello, stranger."));
		out.println(tom.say("I'm Tom Kelliher."));
		out.println(tom.say("Wait, what?"));
		out.println(tom.say("Is that... 42 chocolate bars?"));
		out.println(tom.say("Ahaha~"));
		out.println(tom.say("AHAHA~"));
		out.println(tom.say("AHAHAHAHAHAHAHAHAHAHAHAHAHAHA~!"));
		out.println(tom.say("Good luck, noob! I'm outta here!"));
		
		out.println(mc.say("..."));
		out.println(mc.say("What just happened?"));

		out.println(narrator.say("Little did Tom know that the bars had stupid computer science students inside of them."));
		out.println(narrator.say("That is, Tom's only weakness..."));
		out.println(narrator.say("After eating all 42 of them, he transformed into... the MAD TOM!"));

		tom.changeName("The Mad Tom");

		out.println(narrator.say("Let's face it; you're in a dungeon now."));
		out.println(narrator.say("I'll make this simple. Find the Mad Tom. End his suffering."));
		out.println("Got it?");

		out.println(mc.say("..."));
		out.println(mc.say("I guess."));

		out.println(narrator.say("Good. I knew I could count on you, " + player.name() + "."));
		out.println(narrator.say("Good luck to you. If you need me to help, just ask."));
		out.println(narrator.say("Oh, and you can call me Andy."));

		narrator.changeName("Andy");

/*
		####################################################

		Main Game Input

		####################################################
		
*/		
		

        Scanner in = new Scanner(System.in);
		while(true)
		{
			if (player.isDead)
			{
				break;
			}
			
			boolean ExitFlag = false;
			out.println(narrator.say("What should we do?\n$> "));
			String input = in.nextLine();
			
			if(input.equalsIgnoreCase("pick up"))
			{
				out.println(narrator.say("What item do you want to pick up?"));
				input = in.nextLine();
				if (input.equals(""))
				{
					out.println(narrator.say("Ah, got it. Stop picking up air, you weirdo."));
				}
				else
				{
					System.out.println(player.manage_inventory("pick up", input,TheDungeon));
				}
				
			}
			
			else if (input.equalsIgnoreCase("drop"))
			{
				out.println(narrator.say("What item do you want to drop?"));
				input = in.nextLine();
				System.out.println(player.manage_inventory("drop", input,TheDungeon));
			}
			
			else if (input.equalsIgnoreCase("equip"))
			{
				out.println(narrator.say("What item do you want to equip?"));
				input = in.nextLine();
				System.out.println(player.equip(input));
			}
			
			else if(input.equalsIgnoreCase("info"))
			{
				out.println(narrator.say("Uh, let's see here..."));
				out.println(player.info(TheDungeon));
			}
			
			else if(input.equalsIgnoreCase("attack"))
			{
				System.out.println("");
			}
			
			else if(input.equalsIgnoreCase("move"))
			{
				out.println(narrator.say("Okay, so where are we going? We can go North, South, East, or West."));
				out.println(narrator.say("No pressure or anything, but I'm letting you do the navigation."));
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
				out.println(narrator.say("Alright, I cleared it up."));
			}

			else if (input.equalsIgnoreCase("me"))
			{
				out.println(narrator.say("Here's all I know about you:"));
				out.println("Name: " + player.name());
				out.println("Level: " + player.level());
				out.println("Health: " + player.level());
			}

			else if (input.equalsIgnoreCase("fuck"))
			{
				out.println(narrator.say("E-Eh? That's not nice..."));
				out.println(narrator.say("W-ho?"));

				String who = in.nextLine();

				if (who.equalsIgnoreCase("mob"))
				{
					out.println(tom.say("Well, the mob ate its child and is now stronger than you."));
					out.println(tom.say(player.die()));
				}
				else if (who.equalsIgnoreCase("you"))
				{
					out.println(narrator.say("Uwaa~!"));
				}
				else 
				{
					out.println(narrator.say("That's weird. How about no?"));
				}

			}

			else
			{
				out.println(narrator.say("Eh? I-I don't understand what you mean."));
				out.println(narrator.say("Could you try a valid command next time?"));
			}
			if (ExitFlag == true)
			{
				break;
			}
		}

	}
	

}

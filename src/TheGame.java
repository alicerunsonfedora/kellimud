import java.util.Scanner;
import java.io.Console;
import static java.lang.System.out;
public class TheGame {
	public TheGame() {
	
	}

	public static void main(String[] args)
	{
		Boolean isCommandLine = true; //Use this to define type of app
		
		Player player = new Player("Filthy CS Student (you)","noob");

		Room room = new Room(player,1);
		
		Dungeon TheDungeon = new Dungeon(room);
		Scene sceneHandler = new Scene();
		
		if (isCommandLine) {
			CommandInterpreter cmd = new CommandInterpreter();
			out.println("#####################################");
			out.println("#        REALM OF THE MAD TOM       #");
			out.println("#       (C) 2018 Version 1.0.0      #");
			out.println("#####################################");
	
			Characters.mc.changeName("Filthy CS Student (you)");
			sceneHandler.playScene(sceneHandler.introSceneA);
			Characters.tom.changeName("The Mad Tom");
			sceneHandler.playScene(sceneHandler.introSceneB);
			Characters.narrator.changeName("Andy");
			cmd.interpret("help", player, TheDungeon);
	
	        Scanner in = new Scanner(System.in);
			while(true)
			{
				if (player.isDead)
				{
					sceneHandler.playScene(sceneHandler.yaDieScene);
					break;
				}
				
				out.println(Characters.narrator.say("What should we do?\n$> "));
				String command = in.nextLine();
				cmd.interpret(command, player, TheDungeon);
				
			}
		} else {
			//Add GUI parts here
			GUIInterpreter gui = new GUIInterpreter();
		}
	}

}

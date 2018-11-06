import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.io.Console;
import static java.lang.System.out;
public class TheGame {
	public TheGame() {
	
	}
	public static Player player()
	{
		return player;
	}
	
	public static Dungeon dungeon()
	{
		return TheDungeon;
	}
	private static Player player = new Player("Filthy CS Student (you)","noob");
	private static Room room = new Room(player,1);
	private static Dungeon TheDungeon = new Dungeon(room);
	private static MudDataModel observable = new MudDataModel(player,TheDungeon);
	public static void main(String[] args)
	{
		Boolean isCommandLine = false; //Use this to define type of app
		



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
			//GUIInterpreter gui = new GUIInterpreter();
			MainWindows app = new MainWindows();
			app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			app.setSize(1280, 720);
			app.setTitle("REALM OF THE MAD TOM");
			app.setResizable(false);
			app.setVisible(true);
			
		}

	}
	
	public static MudDataModel observable()
	{
		return observable;
	}
	
	public static void PlayerObserver(PlayerPanel g)
	{
		observable.addObserver(g);
	}
	
	public static void MobObserver(MobPanel g)
	{
		observable.addObserver(g);
	}
	


}

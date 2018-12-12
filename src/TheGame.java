import java.util.Scanner;
import javax.swing.*;
import java.io.Console;
import static java.lang.System.out;
import java.awt.BorderLayout;
import mdlaf.*;                        // Using Material Design components
import mdlaf.utils.MaterialColors;     // Using Material Design colors
import mdlaf.animation.MaterialUIMovement;

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
	private static Player player = new Player("John, a Filthy CS Student","noob");
	private static Player player2 = new Player("Chegg, another Filthy CS Student","noob");
	private static Room room = new Room(player,1);
	private static Dungeon TheDungeon = new Dungeon(room);
	private static MudDataModel observable = new MudDataModel(player,TheDungeon,player2);
	private static MudDataModel observable2 = new MudDataModel(player2,TheDungeon,player);
	private static PlayerDataManager pm = new PlayerDataManager(player, "settings.json");
	private static PlayerDataManager pm2 = new PlayerDataManager(player2, "settings2.json");
	private static MainWindows app,app2;
	public static void main(String[] args)
	{
		Boolean isCommandLine = false; //Use this to define type of app

		pm.readFromFile();
		pm2.readFromFile();

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
			int windowWidth = 1280;
			int windowHeight = 720;
			app = new MainWindows(observable,player);
			app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			app2 = new MainWindows(observable2,player2);
			app2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

			try {
				UIManager.setLookAndFeel (new MaterialLookAndFeel ());
			}
			catch (UnsupportedLookAndFeelException e) {
				e.printStackTrace ();
			}

		}

		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			public void run() {

				if (player.isDead) { pm.resetToDefaults(); }
				else { pm.saveToFile(); }

				if (player2.isDead) { pm2.resetToDefaults(); }
				else { pm2.saveToFile(); }

			}
		}, "Shutdown-thread"));

	}


	public static PlayerDataManager pm() { return pm; }
	public static PlayerDataManager pm2() { return pm2; }
	
	public static MudDataModel observable(Player player)
	{
		if(player.equals(player2))
		{
			return observable2;
		}
		else
		{
			return observable;
		}
	}
	
	public static void PlayerObserver(Player player,PlayerPanel g)
	{
		if(player.equals(player2))
		{
			observable2.addObserver(g);
		}
		else
		{
			observable.addObserver(g);
		}
	}
	
	public static void MobObserver(Player player,MobPanel g)
	{
		if(player.equals(player2))
		{
			observable2.addObserver(g);
		}
		else
		{
			observable.addObserver(g);
		}
	}
	public static void MainObserver(Player player,MainContent g) 
	{
		if(player.equals(player2))
		{
			observable2.addObserver(g);
		}
		else
		{
			observable.addObserver(g);
		}
	}
	
	public static MainWindows GetWindows(Player player)
	{
		if(player.equals(player2))
		{
			return app2;
		}
		else
		{
			return app;
		}
	}

}

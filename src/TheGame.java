import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.io.Console;
import static java.lang.System.out;

import java.awt.BorderLayout;
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
	private static Player player2 = new Player("Filthy CS Student Number 2","noob");
	private static Room room = new Room(player,1);
	private static Dungeon TheDungeon = new Dungeon(room);
	private static MudDataModel observable = new MudDataModel(player,TheDungeon,player2);
	private static MudDataModel observable2 = new MudDataModel(player2,TheDungeon,player);
	private static MainWindows app,app2;
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
			app = new MainWindows(observable,player);
			app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			app.setSize(1280, 720);
			app.setTitle("REALM OF THE MAD TOM");
			app.setResizable(false);
			app.setVisible(true);
			app2 = new MainWindows(observable2,player2);
			app2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			app2.setSize(1280, 720);
			app2.setTitle("REALM OF THE MAD TOM2");
			app2.setResizable(false);
			app2.setVisible(true);
//			observable.addObserver(app);
//			MainContent main = new MainContent();
//			main.setLayout(new BorderLayout());
//			PlayerPanel g = new PlayerPanel(observable);
//			MobPanel g1 = new MobPanel(observable);
//			JLabel exit = new JLabel("");
//			main.setOpaque(false);
//			g.setOpaque(false);
//			g1.setOpaque(false);
//			observable.addObserver(g);
//			observable.addObserver(g1);
//			main.add(g,BorderLayout.LINE_START);
//			main.add(exit,BorderLayout.CENTER);
//			main.add(g1,BorderLayout.LINE_END);
//			app.add(main);
			
		}

	}
	
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

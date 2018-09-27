import static java.lang.System.out;
public class Scene
{
    public Scene()
    {

    }

    static String[] introSceneA = 
    {
        Characters.tom.say("Hello, stranger."),
		Characters.tom.say("I'm Tom Kelliher."),
		Characters.tom.say("Wait, what?"),
		Characters.tom.say("Is that... 42 chocolate bars?"),
		Characters.tom.say("Ahaha~"),
		Characters.tom.say("AHAHA~"),
		Characters.tom.say("AHAHAHAHAHAHAHAHAHAHAHAHAHAHA~!"),
        Characters.tom.say("Good luck, noob! I'm outta here!"),
        Characters.mc.say("..."),
		Characters.mc.say("What just happened?"),
		Characters.narrator.say("Little did Tom know that the bars had stupid computer science students inside of them."),
		Characters.narrator.say("That is, Tom's only weakness..."),
		Characters.narrator.say("After eating all 42 of them, he transformed into... the MAD TOM!")
    };

    static String[] introSceneB = 
    {
        Characters.narrator.say("Let's face it; you're in a dungeon now."),
		Characters.narrator.say("I'll make this simple. Find the Mad Tom. End his suffering."),
		Characters.narrator.say("Got it?"),
		Characters.mc.say("..."),
		Characters.mc.say("I guess."),
		Characters.narrator.say("Good. I knew I could count on you, " + Characters.mc.myName() + "."),
		Characters.narrator.say("Good luck to you. If you need me to help, just ask."),
		Characters.narrator.say("Oh, and you can call me Andy.")
    };

    static String[] confirmGameResume = {
        Characters.narrator.say("*gasp* Really?"),
		Characters.narrator.say("Yay~!"),
		Characters.narrator.say("Onward, fellow soldier~!")
    };

    static String[] fuckMobDieScene = 
    {
        Characters.tom.say("So you ended up fucking the mob."),
        Characters.tom.say("Lucky for you, you get a child."),
        Characters.tom.say("At the same time, you're also at a loss as the mob eats the child."),
        Characters.tom.say("Now the mob's stronger than you and, well, it doesn't end well for you."),
        Characters.tom.say("Ya die, ya die, ya die, ya die!")
    };

    static String[] yaDieScene = 
    {
        Characters.tom.say("Unfortunately, the mob has managed to introduce you to death."),
        Characters.tom.say("Ya die, ya die, ya die, ya die!")
    };

    static String[] mobDieScene = 
    {
        Characters.narrator.say("Congrats, you killed the mob!"),
        Characters.narrator.say("Yaay~!")
    };

    static void playScene(String[] scene)
    {
        for (String s : scene)
        {
            out.println(s);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                
            }
        }
    }
}
public class Speaker
{
    private String name;

    public Speaker(String speakerName)
    {
        name = speakerName;
    }

    public String say(String message)
    {
        return name + ": " + message;
    }

    public String changeName(String newName)
    {
        name = newName;
        return name;
    }

    public String myName()
    {
        return name;
    }
}
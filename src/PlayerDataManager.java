import java.io.FileReader;
import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class PlayerDataManager {

    private Player player;

    public void readFromFile() {
        JSONParser parser = new JSONParser();
        try {
            Object fileObject = parser.parse(new FileReader("settings.json"));
            JSONObject jsonObject = (JSONObject) fileObject;

            player.setName( (String) jsonObject.get("name") );

            Long playerLongLevel = (Long) jsonObject.get("level");
            Long playerLongExp = (Long) jsonObject.get("progress");
            double playerLongHealth = (double) jsonObject.get("health");

            player.setLevel(playerLongLevel.intValue());
            player.setExperience(playerLongExp.intValue());
            player.setHealth((int) playerLongHealth);

            System.out.println(player);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void saveToFile() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", player.name());
        jsonObject.put("level", player.level());
        jsonObject.put("progress", player.exp());
        jsonObject.put("health", (double) player.health());

        try (FileWriter file = new FileWriter("settings.json")) {
            file.write(jsonObject.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PlayerDataManager(Player who) {
        player = who;
    }

}

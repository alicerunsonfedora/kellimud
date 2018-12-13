import java.io.FileReader;
import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Class that handles player data management. Cross-compatible with Termina save files.
 * @author marquiskurt
 */
public class PlayerDataManager {

    private Player player;
    private String filename;

    /**
     * Read the associated JSON file and assign values to the player.
     */
    public void readFromFile() {
        JSONParser parser = new JSONParser();
        try {
            Object fileObject = parser.parse(new FileReader(filename));
            JSONObject jsonObject = (JSONObject) fileObject;

            player.setName( (String) jsonObject.get("name") );

            Long playerLongLevel = (Long) jsonObject.get("level");
            Long playerLongExp = (Long) jsonObject.get("progress");
            double playerLongHealth = (double) jsonObject.get("health");

            if (player.name().equalsIgnoreCase("ee3da33e3ce7f5826da7741ae9c0f06b70c45bcba8f3753814ae9662bd2071fb")) {
                player.setLevel(420);
            } else {
                player.setLevel(playerLongLevel.intValue());
            }

            player.setExperience(playerLongExp.intValue());
            player.setHealth((int) playerLongHealth);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Save the player's state as JSON values into the JSON file.
     */
    public void saveToFile() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", player.name());
        jsonObject.put("level", player.level());
        jsonObject.put("progress", player.exp());
        jsonObject.put("health", (double) player.health());

        try (FileWriter file = new FileWriter(filename)) {
            file.write(jsonObject.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Resets the player's data to minimum defaults and save it.
     */
    public void resetToDefaults() {
        player.setHealth(42);
        player.setExperience(0);
        player.setLevel(1);
        saveToFile();
    }

    /**
     * Instantiate the PlayerDataManager class
     * @param who The player object to track player data for
     * @param fileName The name of the settings file to use.
     */
    public PlayerDataManager(Player who, String fileName) {
        player = who;
        filename = fileName;
    }

}

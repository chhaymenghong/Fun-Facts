package menghong.funfacts;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

// This class is used to parse JSON text to
public class JsonParserOperation {
    private static final String filePath = "C:\\Users\\menghong\\Desktop\\AllProjects\\Fun-Facts\\app\\src\\main\\res";
    private ArrayList<String> factsBook;
    private int factsBookSize;
    public JsonParserOperation() {
        factsBook = generateFactBook();
        factsBookSize = factsBook.size();
    }
    public ArrayList<String> generateFactBook() {
        ArrayList<String> listOfFacts = new ArrayList<String>();
        try {
            // Read Json file and turn it into Json object
            FileReader reader = new FileReader(filePath);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

            // get information from the Json object
            JSONArray listFactObject = (JSONArray) jsonObject.get("results");
            for (int i = 0; i < listFactObject.length(); i++) {
                JSONObject eachFactObject = listFactObject.getJSONObject(i);
                String eachFact = (String) eachFactObject.get("facts");
                listOfFacts.add(eachFact);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return listOfFacts;
    }

    // Return one cool fact
    public String getFact() {
        Random randomGenerator = new Random();
        int randNum = randomGenerator.nextInt(factsBookSize);
        return factsBook.get(randNum);
    }
}

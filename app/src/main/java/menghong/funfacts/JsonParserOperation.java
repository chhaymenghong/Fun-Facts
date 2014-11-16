package menghong.funfacts;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

// This class is used to parse JSON text to
public class JsonParserOperation {
    private ArrayList<String> factsBook;
    private int factsBookSize;
    private InputStream iS;
    public JsonParserOperation(InputStream iS) {
        this.iS = iS;
        factsBook = generateFactBook();
        factsBookSize = factsBook.size();

    }
    // Create FactBook
    public ArrayList<String> generateFactBook() {
        ArrayList<String> listOfFacts = new ArrayList<String>();
        try {
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(iS));
            StringBuilder file = new StringBuilder();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null) {
                file.append(inputStr);
            }
            // Read Json file and turn it into Json object
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = new JSONObject(file.toString());
            // get information from the Json object
            JSONArray listFactObject = (JSONArray) jsonObject.get("data");
            for (int i = 0; i < listFactObject.length(); i++) {
                JSONObject dataObject = (JSONObject) listFactObject.get(i);
                JSONArray factArray = (JSONArray)dataObject.get("facts");
                String eachFact = (String) factArray.get(0);
                if (eachFact.length() < 70)
                    listOfFacts.add(eachFact);
            }
        } catch (FileNotFoundException e) {
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

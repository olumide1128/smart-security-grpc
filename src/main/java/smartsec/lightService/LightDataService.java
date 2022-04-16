package smartsec.lightService;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LightDataService {
	
	JSONArray lightArr;
	
	public LightDataService() {
		lightArr = readJSON();
	}
	
	
	public String changeLightState(int id, String action) {
		// TODO Auto-generated method stub
		
		JSONObject lightPoint;
		
        try {
    		lightPoint = (JSONObject) lightArr.get(id-1); //I am subtracting 1 to make the index in sync with the real ids
    		lightPoint.put("state", action);
    		
        	FileWriter file = new FileWriter("data/lightJSON.json");
        	
            //We can write any JSONArray or JSONObject instance to the file
            file.write(lightArr.toJSONString()); 
            file.flush();
            
            System.out.println("Updated json successfully!");
            lightArr = readJSON(); //Reload JSON
            
        } catch (IOException e) {
            e.printStackTrace();
            return "Error updating Light State!";
        } catch (IndexOutOfBoundsException e) {
        	return "Id not found!";
        }
		
		return "Light with Id: "+id+" Turned "+action+" Successfully!";

	}
	
	
	//read from JSON file and store in arrayList
	public static JSONArray readJSON() {
        JSONParser jsonParser = new JSONParser();
        JSONArray lightArr = new JSONArray();
        
        try
        {
        	FileReader reader = new FileReader("data/lightJSON.json");
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            lightArr = (JSONArray) obj;
           
             
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        return lightArr;
	}

}

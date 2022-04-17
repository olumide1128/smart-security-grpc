package smartsec.cameraService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.grpc.Metadata;
import io.grpc.Status;
import smartsec.cameraService.CameraService.camera;

public class CameraDataService {
	
	static JSONArray camArr;
	
	public CameraDataService() {
		camArr = readJSON(); //Load the JSON into camArr
	}
	
	
	public static ArrayList<String> takeSnapshots(){
		
		ArrayList<String> bStrings = new ArrayList<>();
		
		try {
			File dir = new File("snapshots");
			
			for(File file: dir.listFiles()) {
				String fullPath = "snapshots/"+file.getName();
				File imgfile = new File(fullPath);
				String base64Str = imgToBase64(imgfile);
				
				bStrings.add(base64Str);
			}
		}catch(IOException e) {
			return null;
		}
		
		return bStrings;
		
	}
	
	
	//Method to convert an img to base64 String
    public static String imgToBase64(File img) throws IOException{
        
        byte [] b = FileUtils.readFileToByteArray(img);
        
        String x = Base64.getEncoder().encodeToString(b);
        
        return x;
    }

    
	public static String updateCameraPosition(int id, String pan, String tilt, String rotation) {
		
		JSONObject cam;
		/*In order to update the JSON File*/
		
        try {
    		cam = (JSONObject) camArr.get(id-1); //I am subtracting 1 to make the index in sync with the real ids
    		
    		Integer.parseInt(pan);
    		Integer.parseInt(tilt);
    		Integer.parseInt(rotation); //Validate position properties to check if they are Numbers
    		
    		cam.put("pan",pan);
    		cam.put("tilt",tilt);
    		cam.put("rotation",rotation);
    		
        	FileWriter file = new FileWriter("data/cameraJSON.json");
        	
            //We can write any JSONArray or JSONObject instance to the file
            file.write(camArr.toJSONString()); 
            file.flush();
            
            System.out.println("Updated json successfully!");
            camArr = readJSON(); //Reload JSON
            
        } catch (IOException e) {
            e.printStackTrace();
            return "Error updating position!";
        } catch (IndexOutOfBoundsException e) {
        	return "Id not found!";
        } catch(NumberFormatException e) {
        	return "Position Properties must be Number!";
        }
		
		return "Cam Position with id "+cam.get("cameraId")+" has been updated Successfully!";
	}
	
	
	public static camera getCameraStatus(int id) {
		JSONObject cam;
		
		try {
			cam = (JSONObject) camArr.get(id-1);
		}catch(IndexOutOfBoundsException e) {
           return null;
		}
		
		camera camProto = camera.newBuilder().setCameraId(id).setBattery(cam.get("battery").toString()).
				setActive(Boolean.parseBoolean(cam.get("active").toString())).setPan(cam.get("pan").toString()).setTilt(cam.get("tilt").toString()).
				setRotation(cam.get("rotation").toString()).build();
		
		return camProto;
			
	}
	
	
	//read from JSON file and store in arrayList
	public static JSONArray readJSON() {
        JSONParser jsonParser = new JSONParser();
        JSONArray camArr = new JSONArray();
        
        try
        {
        	FileReader reader = new FileReader("data/cameraJSON.json");
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            camArr = (JSONArray) obj;
           
             
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        return camArr;
	}
}

package Simple.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJsonFile {

	public static void main(String[] args) {
		JSONParser jsonparcer=new JSONParser();
		try {
			FileReader fileReader=new FileReader("src/resource/employees.json");
			Object object = jsonparcer.parse(fileReader);
			JSONArray emplist=	(JSONArray)	object;
			
			System.out.println(emplist);
			for (Object emp : emplist) {
				parse((JSONObject)emp);
				
			}	
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private static void parse(JSONObject emp) {
		JSONObject employee = (JSONObject)emp.get("employee");
		System.out.println(employee.get("empId"));
		System.out.println(employee.get("name"));
		System.out.println(employee.get("username"));
		System.out.println(employee.get("password"));
		System.out.println(employee.get("salary"));
		System.out.println();
		
	}

}

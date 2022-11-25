package Simple.JsonReader;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonWriter {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		FileWriter writer = null;
		JSONObject employee = new JSONObject();
		employee.put("empId", 10);
		employee.put("name", "Sarang");
		employee.put("username", "sarang@123");
		employee.put("password", "saragn@123#1999");
		employee.put("salary", 10000);

		JSONObject employee1 = new JSONObject();
		employee1.put("empId", 20);
		employee1.put("name", "Tarang");
		employee1.put("username", "Tarang@123");
		employee1.put("password", "Taragn@123#1999");
		employee1.put("salary", 12000);
		// adding employee data into jsonarray
		JSONArray jsonlistOfEmployee = new JSONArray();
		jsonlistOfEmployee.add(employee1);
		jsonlistOfEmployee.add(employee);

		// creating a file
		try {
			writer = new FileWriter("src/resource/employeewriter.json");

			writer.write(jsonlistOfEmployee.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}

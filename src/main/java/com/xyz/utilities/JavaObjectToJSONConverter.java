package com.xyz.utilities;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JavaObjectToJSONConverter {

	public static String objectToJSON(Object object) throws IOException{
		ObjectMapper objMapper = new ObjectMapper();
		return objMapper.writeValueAsString(object);
	}
	public static JsonNode createJsonNode(Object object) throws IOException{
		ObjectMapper objMapper = new ObjectMapper();
		return objMapper.valueToTree(object);
	}
	public static JsonNode addField(JsonNode jsonNode, String fieldName, Object value) {
		return jsonNode;
	}
	public static void main(String[] args){
		Personn person = new Personn();
		person.setName("Ram");
		person.setAge(30);
		try {
			String jsonString = objectToJSON(person);
			System.out.println(jsonString);
			JsonNode jsonNode = createJsonNode(person);
			System.out.println(jsonNode.toPrettyString());
			if(jsonNode instanceof ObjectNode) {
				jsonNode = ((ObjectNode)jsonNode).putPOJO("city", "DDN");
			}
			System.out.println(jsonNode.toPrettyString());
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}

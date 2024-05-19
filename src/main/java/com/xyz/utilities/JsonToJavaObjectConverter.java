package com.xyz.utilities;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToJavaObjectConverter {

	public static <T> T jsonToObject(String json, Class<T> clazz) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objMapper = new ObjectMapper();
		return objMapper.readValue(json, clazz);
	}
	public static JsonNode jsonToJsonNode(String json) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objMapper = new ObjectMapper();
		return objMapper.readTree(json);
	}
	public static void main(String[] args) {
		String jsonString = "{\"name\":\"Ram\",\"age\":30}";
		try {
			Personn person = jsonToObject(jsonString,Personn.class);
			System.out.println("java object created from json : "+person);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}

package com.example.assesment;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.schibsted.spt.data.jslt.Expression;
import com.schibsted.spt.data.jslt.Parser;

public class Test {
 public static void main(String[] args) throws IOException {
	 
//		List<TransformObject> tranObjList = config.getListOfTranformObj();
		ObjectMapper mapper = new ObjectMapper();
		String json = "{\"eventId\": \"878237843\",\"device\": {\"osType\": \"Linux\",\"model\": \"Laptop\"},\"ip\": \"10.45.2.30\",\"sessionId\": \"ads79uoijd098098\"}";
		String transform = "{\"eventId\": .eventId, \"device_os\": .device.osType,\"device_description\": .device.osType +\" \"+ .device.model}";	
		JsonNode inp = null;
		try {
			inp = mapper.readTree(json);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Expression jslt = Parser.compileString(transform);
		JsonNode output = jslt.apply(inp);
		System.out.println("output is " + output);
}
}

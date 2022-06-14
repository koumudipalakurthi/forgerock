package com.example.assesment.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.assesment.entity.FeatureConfiguration;
import com.example.assesment.entity.Input;
import com.example.assesment.entity.TransformObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.schibsted.spt.data.jslt.Expression;
import com.schibsted.spt.data.jslt.Parser;

@Service
public class ForgeRockService {

	public JsonNode getJsltTranformedconfig(Input input) throws Exception {
		JsonNode output = null;
		try {
			// check whether the given input is not null and empty
			if (!ObjectUtils.isEmpty(input)) {
				FeatureConfiguration config = input.getFeatureConfiguration();
				Object inputObj = input.getInputJson();
				List<TransformObject> tranObjList = config.getTransforms();
				ObjectMapper mapper = new ObjectMapper();
				JsonNode inputJsonNode = null;
				if (!ObjectUtils.isEmpty(inputObj)) {
					inputJsonNode = mapper.convertValue(inputObj, JsonNode.class);
				}
				// construct transform object with eventId, name and jsltExpression
				String tranformObj = "{\"eventId\": .eventId";
				for (TransformObject eachObj : tranObjList) {
					if(eachObj.isEnabled()) {
						tranformObj = tranformObj + ", \"" + eachObj.getName() + "\":" + eachObj.getJsltExpression();
					}
				}
				tranformObj = tranformObj + "}";
				// parse the transform object using jslt library and get the output as JsonNode
				Expression jslt = Parser.compileString(tranformObj);
				output = jslt.apply(inputJsonNode);
			}
		} catch (Throwable e) {
			System.out.println(e.getStackTrace());
			e.printStackTrace();
		}

		return output;
	}
}

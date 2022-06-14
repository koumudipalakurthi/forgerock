package com.example.assesment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.assesment.entity.Input;
import com.example.assesment.service.ForgeRockService;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("/forgerock/assesment")
public class ForgeRockController {

	@Autowired
	ForgeRockService service;

	// takes feature configuration and input json as Input object, transforms to
	// required format
	// using jslt library and gives back the output json based on the feature
	// configuration
	@PostMapping("/retrieve/mlfeatures")
	public JsonNode retrieveMLFeatures(@RequestBody Input input) throws Exception {
		return service.getJsltTranformedconfig(input);
	}

}

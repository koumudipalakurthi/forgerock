# Forgerock assessment Test
Autonomous Identity products need to extract features from free-form JSON objects for analytics and machine learning purposes. Due to the lack of a fixed schema, extracting features from JSON data needs to be declarative and configurable at run time. To help with simplifying the feature extraction, we use the JSON processing library which allows performing JSON transformations using a specific syntax - https://github.com/schibsted/jslt. Analysts can define the JSLT transformations based on a specific JSON feed to be processed.

The goal of this exercise is to develop a microservice with REST API to retrieve ML features from a given JSON object using a supplied feature configuration. The transformation would be defined using https://github.com/schibsted/jslt library. 
- Feature configuration has 
-- id 
-- name 
-- list of transform objects 
- Each transform object has 
-- name 
-- enabled 
-- useInML 
-- jsltExpression 
The microservice REST API should be able to accept feature configuration and JSON payload, process both and return transformed JSON output. Transforms which have "enabled" property set to false should not be included in the output. The feature configuration object and input JSON object may be different for each request. 

# Input


```sh
{
	"featureConfiguration": {
		"id": 1,
		"name": "DeviceFeatures",
		"transforms": [{
			"name": "device_os",
			"useInML": true,
			"enabled": true,
			"jsltExpression": ".device.osType"
		}, {
			"name": "device_description",
			"useInML": true,
			"enabled": true,
			"jsltExpression": ".device.osType + \" \" + .device.model"
		}]
	},
	"inputJson": {
		"eventId": "878237843",
		"device": {
			"osType": "Linux",
			"model": "Laptop"
		},
		"ip": "10.45.2.30",
		"sessionId": "ads79uoijd098098"
	}
}

```

# Output

```sh
{
  "eventId": "878237843",
  "device_os": "Linux",
  "device_description": "Linux Laptop"
}
```

# Swagger URL
http://localhost:9673/swagger-ui.html

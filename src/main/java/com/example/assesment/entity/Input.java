package com.example.assesment.entity;

public class Input {
	
	private FeatureConfiguration featureConfiguration;
	private Object inputJson;
	public FeatureConfiguration getFeatureConfiguration() {
		return featureConfiguration;
	}
	public void setFeatureConfiguration(FeatureConfiguration featureConfiguration) {
		this.featureConfiguration = featureConfiguration;
	}
	public Object getInputJson() {
		return inputJson;
	}
	public void setInput(Object inputJson) {
		this.inputJson = inputJson;
	}
}

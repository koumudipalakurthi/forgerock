package com.example.assesment.entity;

import java.util.*;

public class FeatureConfiguration {

	private String id;
	private String name;
	private List<TransformObject> transforms;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<TransformObject> getTransforms() {
		return transforms;
	}

	public void setTransforms(List<TransformObject> transforms) {
		this.transforms = transforms;
	}

}

package com.example.assesment.entity;

public class TransformObject {

	private String name;
	private boolean enabled;
	private String useInML;
	private String jsltExpression;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getUseInML() {
		return useInML;
	}

	public void setUseInML(String useInML) {
		this.useInML = useInML;
	}

	public String getJsltExpression() {
		return jsltExpression;
	}

	public void setJsltExpression(String jsltExpression) {
		this.jsltExpression = jsltExpression;
	}

}

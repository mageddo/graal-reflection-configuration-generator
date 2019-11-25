package com.acme.vo;

import nativeimage.RuntimeReflection;

@RuntimeReflection(allDeclaredFields = true, allDeclaredMethods = true, allDeclaredConstructors = true)
public class Fruit {

	private String name;

	public Fruit() {
	}

	public Fruit(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Fruit setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public String toString() {
		return "Fruit{" +
			"name='" + name + '\'' +
			'}';
	}
}

package com.jgr.reflection;

public abstract class Animal implements Eating {

    public static String CATEGORY = "domestic";
    private String name;

    public Animal(String name) {
    	this.name = name;
	}

	protected abstract String getSound();

    // constructor, standard getters and setters omitted 
}
package com.jgr.reflection;

public class Bird extends Animal {
    private boolean walks;
    private String name;
    public Bird() {
        super("bird");
        this.name = "bird";
    }

    public Bird(String name, boolean walks) {
        super(name);
        this.name = name;
        setWalks(walks);
    }

    private void setWalks(boolean walks) {
		this.walks = walks;
	}

	public Bird(String name) {
        super(name);
    }

    public boolean walks() {
        return walks;
    }

	@Override
	public String eats() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getSound() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getName() {
		return this.name;
	}

    // standard setters and overridden methods
}
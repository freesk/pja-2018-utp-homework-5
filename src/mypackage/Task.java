package mypackage;

import java.util.UUID;

public class Task {
	private int currentPriorityLevel;
	private final int priorityLevel;
	public String uniqueID = "";
	public static final int LOW = 0;
	public static final int NORMAL = 1;
	public static final int HIGH = 2;
	private final int a;
	private final int b;
	private Integer res;
	
	public Task(int a, int b, int priorityLevel) {
		this.uniqueID = UUID.randomUUID().toString();
		this.currentPriorityLevel = priorityLevel;
		this.priorityLevel = priorityLevel;
		this.a = a;
		this.b = b;
	}
	
	public int getPriorityLevel() {
		return priorityLevel;
	}
	
	public int getCurrentPriorityLevel() {
		return currentPriorityLevel;
	}
	
	public void up() {
		if (currentPriorityLevel < HIGH) currentPriorityLevel++;
	}
	
	public void calculate() {
		res = a + b;
	}
	
	public int get() throws Exception {
		if (res == null) 
			throw new Exception("The resource is not available");
		
		return res;
	}
	
	@Override 
	public String toString() {
		return "(" + a + " + " + b + ") of priority " + priorityLevel + "; res: " + res;
	}
}

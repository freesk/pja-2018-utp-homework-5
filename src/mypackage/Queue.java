package mypackage;
import java.util.ArrayList;
import java.util.Vector;

public class Queue {
	private final Vector<Task> in = new Vector<Task>();
	private final int MAX = 1000;
	
	public final Vector<Task> out = new Vector<Task>();
	
	public synchronized void add(Task t) {
		try {
			while (in.size() > MAX - 1) wait();
		} catch (InterruptedException e) { 
			System.out.println(e.getMessage());
		}
		in.add(t);
		System.out.println("Queue: " + t + " added");
		System.out.println("Queue: === Current State ===");
		for (Task task : in)
			System.out.println("Queue: " + task);
		System.out.println("Queue: === End of Current State ===");
		notifyAll();
	}
	
	public synchronized void put(Task t) {
		out.add(t);
	}
	
	public synchronized Task get() {
		try {
			while (in.size() < 1) wait();
		} catch (InterruptedException e) { 
			System.out.println(e.getMessage());
		}
		
		// while the first item is not of high priority 
		// level up its priority level and move it to the end
		// of the list 
		while (in.get(0).getCurrentPriorityLevel() != Task.HIGH) {
			in.get(0).up();
			in.add(in.remove(0));
		}
		
		// get for processing 
		Task t = in.remove(0);
		notifyAll();
		
		return t;
	}
	
}

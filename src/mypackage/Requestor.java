package mypackage;

public class Requestor extends Thread implements Runnable {
	   
	private Thread t;
	private Queue q;
	
	public Requestor(Queue q) {
		this.q = q;
	}
	
	public void run() {
		Thread cThread = Thread.currentThread();
		while(cThread == t) {
			try {
				// sleep a random number of seconds
				sleep(Mixin.getRandomInt(1, 3) * 1000);
			} catch(InterruptedException e) {
				System.out.println(e.getMessage());
				return;
			}
			if (cThread == t) {
	
				final int priorityLevel = Mixin.getRandomInt(0, 2);
				final int a = Mixin.getRandomInt(-999999, 999999);
				final int b = Mixin.getRandomInt(-999999, 999999);
				
				Task task = new Task(a, b, priorityLevel);
				
				try {
					q.add(task);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
			}
		}
	}
	
	public void startThread() {
		super.start();
		if (t == null) {
			t = new Thread(this);
			t.start(); 
		}
	}
	
	@SuppressWarnings("deprecation")
	public void stopThread() {
		t = null;
		super.stop();
	}
	
}

package mypackage;

public class Service extends Thread implements Runnable {
	
	private Thread t;
	private Queue q;
	
	public Service(Queue q) {
		this.q = q;
	}
	
	public void run() {
		Thread cThread = Thread.currentThread();
		while(cThread == t) {
			try {
				// sleep a random number of seconds 
				sleep(Mixin.getRandomInt(2, 3) * 1000);
			} catch(InterruptedException e) {
				System.out.println(e.getMessage());
				return;
			}
			if (cThread == t) {
				Task t = q.get();
				t.calculate();
				// put the calculated task into the out array
				System.out.println("Service: " + t + " resolved");
				q.put(t);
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

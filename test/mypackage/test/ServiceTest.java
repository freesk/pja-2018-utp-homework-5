package mypackage.test;

import java.util.Timer;
import java.util.TimerTask;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import mypackage.Queue;
import mypackage.Service;
import mypackage.Task;

class ServiceTest {
	
	boolean foo;

	@Test
	void calculate() throws Exception {
		Queue q = new Queue();
		Task t1 = new Task(1, 1, 0);
		q.add(t1);
		
		Service s = new Service(q);
		s.startThread();

		foo = false;
		
		Timer timer = new Timer();
		
		// in seconds
		final int delay = 8;
		
		// wait n seconds, then release the while loop
		timer.schedule(new TimerTask() {
			public void run() {
				// stop the thread
				s.stopThread();
				// good to go
				foo = true;
			}
		}, delay * 1000);
		
		// wait here
		while(!foo) {
			System.out.println("wait");
		}
		
		Assert.assertEquals(1, q.out.size());
		Assert.assertEquals(2, q.out.get(0).get());
	}

}

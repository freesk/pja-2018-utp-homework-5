package mypackage.test;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import mypackage.Queue;
import mypackage.Task;

class QueueTest {

	@Test
	void get() {
		Queue q = new Queue();
		
		Task t1 = new Task(1, 1, 0);
		Task t2 = new Task(1, 1, 1);
		Task t3 = new Task(1, 1, 2);
		Task t4 = new Task(1, 1, 1);
		Task t5 = new Task(1, 1, 0);
		
		q.add(t1);
		q.add(t2);
		q.add(t3);
		q.add(t4);
		q.add(t5);
		
		Assert.assertEquals(q.get(), t3);
		Assert.assertEquals(q.get(), t2);
		Assert.assertEquals(q.get(), t4);
		Assert.assertEquals(q.get(), t1);
		Assert.assertEquals(q.get(), t5);
		
	}

}

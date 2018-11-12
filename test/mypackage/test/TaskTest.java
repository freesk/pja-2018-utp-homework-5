package mypackage.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import mypackage.Task;

class TaskTest {

	@Test
	void up() {
		Task t = new Task(0, 0, 0);
		
		t.up();
		
		Assert.assertEquals(1, t.getCurrentPriorityLevel());
		
		t.up();
		
		Assert.assertEquals(2, t.getCurrentPriorityLevel());
		
		t.up();
		
		Assert.assertEquals(2, t.getCurrentPriorityLevel());
	}

}

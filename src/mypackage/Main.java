package mypackage;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue q = new Queue();
		
		for (int i = 0; i < 6; i++) {
			Requestor r = new Requestor(q);
			r.startThread();
		}
		
		
		for (int j = 0; j < 3; j++) {
			Service s = new Service(q);
			s.startThread();
		}
	
		
	}

}

/**
What will be the output?
 **/
public class WhatIsOutput {
	public class Sync1 extends Thread{
		private int m_value;
		public Sync1(int value){
			m_value = value;
		}
		public synchronized void printValue(int iValue){

			while(true){
				System.out.println(iValue);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		public void run(){
			printValue(m_value);
		}
	}

	public class Sync2 extends Thread{
		private Sync1 m_sync1;
		public Sync2(Sync1 sync1){
			m_sync1 = sync1;
		}
		public void run(){
			m_sync1.printValue(2);
		}
	}


	public static void main(String[] args) {
		WhatIsOutput whatIsOutput = new WhatIsOutput();
		
		Sync1 sync11 = whatIsOutput.new Sync1(1);
		sync11.start();
		
		Sync2 sync2 = whatIsOutput.new Sync2(sync11);
		sync2.start();
		
		Sync1 sync12 = whatIsOutput.new Sync1(3);
		sync12.start();
	}
}

/**
ANSWER:

synchronized(X.class) is used to make sure that there is exactly one Thread in the block. 
synchronized(this) ensures that there is exactly one thread per instance. 

Possbile output:
1
3
3
1
1
3
1
3
3
1

Only syncl1 and syncl2 threads will be able to acquire the lock on Sync1 object.
synchronizing the method equals to synchronized block on "this". So, this ensures that there is exactly one thread per instance
in the printValue method. Since thread sync2 is using the instance on Sync1 syncl1, it won't be able to acquire the lock at all (syncl1 already acquired the lock from starting syncl1). 
So, syncl1 and syncl2 threads will be able to enter the synchronized block. 

If we change the synchronized block to be on Sync1.class, then only one thread (of the 3 above) will be called.
It makes sure that only on thread will enter the block. Thus, a possible output will be then:
2
2
2
2
2
2
2

OR:
1
1
1
1
1
1
1

 **/

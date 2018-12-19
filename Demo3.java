/**
 * 这个类是讲述监控线程死锁等待演示
 * @ClassName:     Demo3.java
 * @Description:   TODO  
 * @author         Jim老师 
 * @version        jdk8.0  
 * @Date           2018年12月15日   上午1:26:26 
                     无敌是多么的寂寞
                     男人不能说不行，不行也得行
 */
public class Demo3 {
	static class SynAddRunalbe implements Runnable {
	    int a, b;
	    public SynAddRunalbe(int a, int b) {
	        this.a = a;
	        this.b = b;
	    }

	    @Override
	    public void run() {
	        synchronized (Integer.valueOf(a)) {
	            synchronized (Integer.valueOf(b)) {
	                System.out.println(a + b);
	            }
	        }
	    }
	}

	public static void main(String[] args) throws InterruptedException {
		
		for (int i = 0; i < 1000; i++) {
			   Thread.sleep(10);
			   System.out.println(i);
		}
		
		
	    for (int i = 0; i < 100; i++) {
	        new Thread(new SynAddRunalbe(1, 2)).start();
	        new Thread(new SynAddRunalbe(2, 1)).start();
	    }
	}
}

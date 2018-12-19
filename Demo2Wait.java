/**
 * 这个类是讲述wait
 * @ClassName:     Demo2Wait.java
 * @Description:   TODO  
 * @author         Jim老师 
 * @version        jdk8.0  
 * @Date           2018年12月17日   下午10:05:13 
                     无敌是多么的寂寞
                     男人不能说不行，不行也得行
 */
/*
 * 有wait必须有锁,而且必须是同对象。
 */
class    ZiRunnable    implements   Runnable{
	    public void run(){
	    	    while(true){
	    	    	       //ZiRunnable.class返回Class对象
	    	    	      //Class  cs=ZiRunnable.class;
		    	    	  synchronized (this) {
			    	    		    System.out.println("下一步等待");
				    	    	    try {
				    	    	    	    //停了,暂停
				    	    	    	    this.wait();  //this指的是new  ZiRunnable对象
											System.out.println("等待结束");
									} catch (Exception e) {
										    System.out.println("wait出现异常????????????");
									}
						  }
	    	    }
	    }
}
public class Demo2Wait {
       public static void main(String[] args) {
		       Thread  thread=new  Thread(new  ZiRunnable());
		       thread.start();
	   }
}

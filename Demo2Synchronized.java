import org.omg.CORBA.WCharSeqHolder;

/**
 * 这个类是讲述锁Synchronized
 * @ClassName:     Demo2Synchronized.java
 * @Description:   TODO  
 * @author         Jim老师 
 * @version        jdk8.0  
 * @Date           2018年12月17日   下午9:43:55 
                     无敌是多么的寂寞
                     男人不能说不行，不行也得行
 */
/*
 * 同步就是锁：
 *   
 * 第一种格式：
 *       synchronized(对象){
 *              需要锁的程序;
 *       }
 * 第二种格式：
 *       public  synchronized [static]   void     show(){
 *             需要锁的程序;
 *       }
 * 
 */
class   Ticket  implements    Runnable{
	    public static  int   num=100;  //代表100张票
	    Object  object=new  Object();
		@Override
		public void run() {
			    while(true){
			    	   //num=1
			    	  //保证if里面只能执行一个线程
			    	  //t1
			    		        show();
			    	  //t0
			    }
		}
		public  synchronized static  void     show(){
			 //num=0;
	  		  if(num>0){
	  	    	    /*
	  	    	     * Thread.currentThread()：获取当前线程对象
	  	    	     * .getName()：获取线程名
	  	    	     */
	  	    	    //线路老化或者网速慢
	  	    	    try {Thread.sleep(10);} catch (InterruptedException e) {e.printStackTrace();}
	  	    	    System.out.println(Thread.currentThread().getName()+"卖出:"+num+"号票!");//1号票
	  	    	    num--; //num=0;
	  	       }
		}
}
public class Demo2Synchronized {
       public static void main(String[] args) {
    	        Ticket   ticket=new  Ticket();
		        Thread  t0=new  Thread(ticket);  //创建了一个线程
		        t0.setName("北京站");
		        t0.start();  //启动线程
		        
		        Thread  t1=new  Thread(ticket);  //创建了一个线程
		        t1.setName("北京西站?????????????");
		        t1.start();  //启动线程
	}
}











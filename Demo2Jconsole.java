import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 这个类是讲述监控线程
 * @ClassName:     Demo2Jconsole.java
 * @Description:   TODO  
 * @author         Jim老师 
 * @version        jdk8.0  
 * @Date           2018年12月17日   下午9:25:52 
                     无敌是多么的寂寞
                     男人不能说不行，不行也得行
 */
/*
 * 无限循环线程
 * 等待线程
 */
public class Demo2Jconsole {
         /*
          * 无限循环线程
          */
	     public   static   void   createBusyThread(){
	    	       Thread  thread=new   Thread(new  Runnable() {
							@Override
							public void run() {
							       while(true); //一直循环
								
							}
					});
	    	       thread.start();  //启动线程
	     }
	     /*
	      * 线程锁等待演示
	      */
	     public  static  void     createLockThread(final  Object  lock){//Object  lock=ob;
	    	       Thread  thread=new   Thread(new  Runnable() {
					@Override
					public void run() {
						   /*同步里面放锁对象，
						    * synchronized锁的对象必须跟wait所属对象一致，要不然就锁不住而且报异常
						    */
						   synchronized (lock) {
							     try {
							    	 lock.wait();
								} catch (Exception e) {
									e.printStackTrace();
								}
						   }
					}
				});
	    	       thread.start();
	     }
	     public static void main(String[] args) throws IOException {
	    	      /*
	    	       * BufferedReader：管道/缓冲流，提高读的效率
	    	       * InputStreamReader是从字节流到字符流的桥：它读取字节，并使用指定的charset将其解码为字符 。
	    	       * System.in:标准输入流，获取控制台的输入  返回InputStream对象
	    	       */
			      BufferedReader   bReader=new   BufferedReader(new  InputStreamReader(System.in));
			      bReader.readLine();  //读取一行，目的是为了暂停
			      createBusyThread();  //无限循环线程启动
			      bReader.readLine();  //读取一行，目的是为了暂停
			      Object  ob=new   Object();
			      createLockThread(ob);
		}
}
























































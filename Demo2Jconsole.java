import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ������ǽ�������߳�
 * @ClassName:     Demo2Jconsole.java
 * @Description:   TODO  
 * @author         Jim��ʦ 
 * @version        jdk8.0  
 * @Date           2018��12��17��   ����9:25:52 
                     �޵��Ƕ�ô�ļ�į
                     ���˲���˵���У�����Ҳ����
 */
/*
 * ����ѭ���߳�
 * �ȴ��߳�
 */
public class Demo2Jconsole {
         /*
          * ����ѭ���߳�
          */
	     public   static   void   createBusyThread(){
	    	       Thread  thread=new   Thread(new  Runnable() {
							@Override
							public void run() {
							       while(true); //һֱѭ��
								
							}
					});
	    	       thread.start();  //�����߳�
	     }
	     /*
	      * �߳����ȴ���ʾ
	      */
	     public  static  void     createLockThread(final  Object  lock){//Object  lock=ob;
	    	       Thread  thread=new   Thread(new  Runnable() {
					@Override
					public void run() {
						   /*ͬ�������������
						    * synchronized���Ķ�������wait��������һ�£�Ҫ��Ȼ������ס���ұ��쳣
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
	    	       * BufferedReader���ܵ�/����������߶���Ч��
	    	       * InputStreamReader�Ǵ��ֽ������ַ������ţ�����ȡ�ֽڣ���ʹ��ָ����charset�������Ϊ�ַ� ��
	    	       * System.in:��׼����������ȡ����̨������  ����InputStream����
	    	       */
			      BufferedReader   bReader=new   BufferedReader(new  InputStreamReader(System.in));
			      bReader.readLine();  //��ȡһ�У�Ŀ����Ϊ����ͣ
			      createBusyThread();  //����ѭ���߳�����
			      bReader.readLine();  //��ȡһ�У�Ŀ����Ϊ����ͣ
			      Object  ob=new   Object();
			      createLockThread(ob);
		}
}
























































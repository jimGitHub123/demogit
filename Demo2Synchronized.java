import org.omg.CORBA.WCharSeqHolder;

/**
 * ������ǽ�����Synchronized
 * @ClassName:     Demo2Synchronized.java
 * @Description:   TODO  
 * @author         Jim��ʦ 
 * @version        jdk8.0  
 * @Date           2018��12��17��   ����9:43:55 
                     �޵��Ƕ�ô�ļ�į
                     ���˲���˵���У�����Ҳ����
 */
/*
 * ͬ����������
 *   
 * ��һ�ָ�ʽ��
 *       synchronized(����){
 *              ��Ҫ���ĳ���;
 *       }
 * �ڶ��ָ�ʽ��
 *       public  synchronized [static]   void     show(){
 *             ��Ҫ���ĳ���;
 *       }
 * 
 */
class   Ticket  implements    Runnable{
	    public static  int   num=100;  //����100��Ʊ
	    Object  object=new  Object();
		@Override
		public void run() {
			    while(true){
			    	   //num=1
			    	  //��֤if����ֻ��ִ��һ���߳�
			    	  //t1
			    		        show();
			    	  //t0
			    }
		}
		public  synchronized static  void     show(){
			 //num=0;
	  		  if(num>0){
	  	    	    /*
	  	    	     * Thread.currentThread()����ȡ��ǰ�̶߳���
	  	    	     * .getName()����ȡ�߳���
	  	    	     */
	  	    	    //��·�ϻ�����������
	  	    	    try {Thread.sleep(10);} catch (InterruptedException e) {e.printStackTrace();}
	  	    	    System.out.println(Thread.currentThread().getName()+"����:"+num+"��Ʊ!");//1��Ʊ
	  	    	    num--; //num=0;
	  	       }
		}
}
public class Demo2Synchronized {
       public static void main(String[] args) {
    	        Ticket   ticket=new  Ticket();
		        Thread  t0=new  Thread(ticket);  //������һ���߳�
		        t0.setName("����վ");
		        t0.start();  //�����߳�
		        
		        Thread  t1=new  Thread(ticket);  //������һ���߳�
		        t1.setName("������վ?????????????");
		        t1.start();  //�����߳�
	}
}











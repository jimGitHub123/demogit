/**
 * ������ǽ���wait
 * @ClassName:     Demo2Wait.java
 * @Description:   TODO  
 * @author         Jim��ʦ 
 * @version        jdk8.0  
 * @Date           2018��12��17��   ����10:05:13 
                     �޵��Ƕ�ô�ļ�į
                     ���˲���˵���У�����Ҳ����
 */
/*
 * ��wait��������,���ұ�����ͬ����
 */
class    ZiRunnable    implements   Runnable{
	    public void run(){
	    	    while(true){
	    	    	       //ZiRunnable.class����Class����
	    	    	      //Class  cs=ZiRunnable.class;
		    	    	  synchronized (this) {
			    	    		    System.out.println("��һ���ȴ�");
				    	    	    try {
				    	    	    	    //ͣ��,��ͣ
				    	    	    	    this.wait();  //thisָ����new  ZiRunnable����
											System.out.println("�ȴ�����");
									} catch (Exception e) {
										    System.out.println("wait�����쳣????????????");
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

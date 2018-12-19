import java.util.ArrayList;
import java.util.List;

/**
 * ������ǽ����ڴ���
 * 
 * @ClassName: Demo1.java
 * @Description: TODO
 * @author Jim��ʦ
 * @version jdk8.0
 * @Date 2018��12��17�� ����8:33:51 �޵��Ƕ�ô�ļ�į ���˲���˵���У�����Ҳ����
 */
/*
 * ���ò����� -Xms100m -Xmx100m -XX:+UseSerialGC
 * 
 * eden/from=8
 * 
 * eden:27328KB from:3392kb
 * 
 * �������� 27328KB+3392kb+3392kb=33m ������� 67m
 * 
 * �����/������=2
 * 
 */
public class Demo1JConsole {
	/*
	 * ����һ���ڲ���
	 */
	static class OOMObject {
		public byte[] bt = new byte[32 * 1024];// 64K
	}

	public static void fillHeap(int num) throws InterruptedException {
		List<OOMObject> list = new ArrayList<OOMObject>();
		for (int i = 0; i < num; i++) {
			// �����ӳ�,�ü������߸�������
			Thread.sleep(50);
			list.add(new OOMObject());
		}
		System.out.println("��һ��ִ��gc");
		System.gc();
		System.out.println("ִ��gc���");
		System.out.println("������ڴ��������");
		for (int i = 0; i < 10000000; i++) {
			Thread.sleep(70);
			System.out.println(i);
		}
	}
	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(5000);
		fillHeap(1000);

	}
}

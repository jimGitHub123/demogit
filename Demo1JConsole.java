import java.util.ArrayList;
import java.util.List;

/**
 * 这个类是讲述内存监控
 * 
 * @ClassName: Demo1.java
 * @Description: TODO
 * @author Jim老师
 * @version jdk8.0
 * @Date 2018年12月17日 下午8:33:51 无敌是多么的寂寞 男人不能说不行，不行也得行
 */
/*
 * 配置参数： -Xms100m -Xmx100m -XX:+UseSerialGC
 * 
 * eden/from=8
 * 
 * eden:27328KB from:3392kb
 * 
 * 新生代： 27328KB+3392kb+3392kb=33m 老年代： 67m
 * 
 * 老年代/新生代=2
 * 
 */
public class Demo1JConsole {
	/*
	 * 创建一个内部类
	 */
	static class OOMObject {
		public byte[] bt = new byte[32 * 1024];// 64K
	}

	public static void fillHeap(int num) throws InterruptedException {
		List<OOMObject> list = new ArrayList<OOMObject>();
		for (int i = 0; i < num; i++) {
			// 稍作延迟,让监视曲线更加明显
			Thread.sleep(50);
			list.add(new OOMObject());
		}
		System.out.println("下一步执行gc");
		System.gc();
		System.out.println("执行gc完毕");
		System.out.println("大多数内存分配完了");
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

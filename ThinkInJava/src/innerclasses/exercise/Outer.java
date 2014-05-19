package innerclasses.exercise;

import innerclasses.Parcel2;

/*
 * Author: Jack Huang
 * Date:   2014-03-26
 * Functio: 编写一个名为Outer的类，它包含一个名为Inner的类，
 * 在Outer中添加一个方法，它返回一个Inner类型的对象。在main()中，创建并初始化一个指向某个Inner对象的引用。
 */

public class Outer {

	/**
	 * @param args
	 * 
	 */
	// Outer类的构造函数
	public Outer(String s) {
		System.out.println("Outer name=" + s);
	}

	// Inner类，内部类
	public class Inner {
		// Inner类的构造函数
		public Inner(String name) {
			// name="Hai";
			System.out.println("Inner name=" + name);
		}
	}

	// 内部类Inner的方法
	public Inner getinnerName(String myname) {
		return new Inner(myname);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 初始化Outer类的对象
		Outer o = new Outer("Hai");
		// 外部类的对象调用内部类类型的方法
		Outer.Inner g = o.getinnerName("Huang");

	}

}

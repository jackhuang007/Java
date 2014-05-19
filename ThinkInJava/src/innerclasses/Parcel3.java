package innerclasses;

//: innerclasses/Parcel3.java
// Using .new to create instances of inner classes.

public class Parcel3 {
	class Contents {
		private int i = 11;

		public int value() {
			return i;
		}
	}
    //如果是静态内部类，不需要用外部类的对象来创建内部类的对象
	static class Destination {
		private String label;

		Destination(String whereTo) {
			label = whereTo;
		}

		String readLabel() {
			return label;
		}
	}

	public static void main(String[] args) {
		Parcel3 p = new Parcel3();
		// Must use instance of outer class
		// to create an instance of the inner class:
		Parcel3.Contents c = p.new Contents();
		//如果是静态内部类，不需要用外部类的对象来创建内部类的对象
		Parcel3.Destination d = new Destination("Tasmania");
		System.out.println(c.value());
		System.out.println(d.readLabel());
	}
} // /:~

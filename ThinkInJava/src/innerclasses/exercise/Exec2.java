package innerclasses.exercise;
/*
 * Author:   Jack Huang
 * Date:     214-03-26
 * Function: 创建一个类，它持有一个String，并且有一个显示这个String的toString()方法。
 * 将你的新类的若干个对象添加到一个Sequence对象中，然后显示它们。
 */

//innerclasses/Sequence2.java
//TIJ4 Chapter Innerclasses, Exercise 2, page 350
/* Create a class that holds a String, and has a toString() method that
* displays this String. Add several instances of your new class to a 
* Sequence ojbect, then display them.
*/

class Word {
	private String word;
	public Word(String s) { word = s; }
	public String toString() { return word; }
} 

interface Selector {
	boolean end();
	Object current();
	void next();
}

public class Exec2 {
	private Object[] items;
	private int next = 0;
	public Exec2(int size) { items = new Object[size]; }
	public void add(Object x) {
		if(next < items.length)
			items[next++] = x;
	}
	private class SequenceSelector implements Selector {
		private int i = 0;
		public boolean end() { return i == items.length; }
		public Object current() { return items[i]; }
		public void next() { if(i < items.length) i++; } 
	}
	public Selector selector() {
		return new SequenceSelector();
	}
	public static void main(String[] args) {
		Exec2 sequence = new Exec2(10);
		for(int i = 0; i < 10; i++)
			sequence.add(new Word(Integer.toString(i)));
		Selector selector = sequence.selector();
		while(!selector.end()) {
			System.out.print(selector.current() + " ");
			selector.next();
		}
		Word w1 = new Word("Peace");
		Word w2 = new Word("Love");
		Word w3 = new Word("Easter");
		Exec2 message = new Exec2(3);
		message.add(w1);
		message.add(w2);
		message.add(w3);
		Selector sel = message.selector();
		while(!sel.end()) {
			System.out.print(sel.current() + " ");
			sel.next();
		}
			
	}
}
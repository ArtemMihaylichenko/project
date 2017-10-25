package ua.nure.mihaylichenko.Practice2;

import java.util.Iterator;

public class Demo {

	public static void main(String[] args) {
		MyList list = new MyListImpl();
		list.add("A");
		list.add("B");
		list.add(new Object());
		list.add(null);
		list.add(3);
		list.add(7);
		list.add(new Double(7.5));
		list.add(1);
		System.out.println("list.contains(3) ==> " + list.contains(3));
		System.out.println("list.contains(null) ==> " + list.contains(null));
		MyList list2 = new MyListImpl();
		list2.add(3);
		list2.add(7);
		list2.add(new Object());
		list2.add(null);
		System.out.println("list.containsAll(list2) ==> " + list.containsAll(list2));
		System.out.println("list.size() ==> " +list.size());
		list.remove("B");
		System.out.println("list.size() after remove(\"B\") ==> " +list.size() + System.lineSeparator());
		list2.clear();
		for (Object o: list) {
			System.out.println(o);
		}
		System.out.println();
		Iterator<Object> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println();
		MyListImpl myList = (MyListImpl) list;
		ListIterator listIter = myList.listIterator();
		while (listIter.hasNext()) {
			listIter.next();
		}
		while (listIter.hasPrevious()) {
			System.out.println(listIter.previous());
		}
		System.out.println();
		while (listIter.hasNext()){
			System.out.println(listIter.next());
		}
	}

}


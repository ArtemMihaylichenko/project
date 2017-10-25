package ua.nure.mihaylichenko.Practice2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyListImpl implements MyList, ListIterable {
	
	private Object[] array = new Object[0];
	
	@Override
	public void add(Object e) {
		Object[] result = Arrays.copyOf(array, array.length + 1);
		result[result.length - 1] = e;
		array = result;
	}

	@Override
	public void clear() {
		array = new Object[0];
		
	}

	@Override
	public boolean remove(Object o) {
			if (contains(o)){
				Object[] result = new Object[array.length - 1];
				int indexRemove = 0;
				int countArray = 0;
				if (o != null) {
				for (int i = 0; i < array.length; i++) {
					if (array[i] != null && o.equals(array[i])) {
							indexRemove = i;
							break;
					}
				}
				for (int i = 0; i < array.length; i++) {
					if (i != indexRemove) {
					result[countArray] = array[i];
					countArray++;
					}
				}
				array = result;
				return true;
				}
				else {
					for (int i = 0; i < array.length; i++) {
						if (array[i] == null) {
							indexRemove = i;
							break;
						}
					}
					for (int i = 0; i < array.length; i++) {
						if (i != indexRemove) {
						result[countArray] = array[i];
						countArray++;
						}
					}
					array = result;
					return true;
				}
			}
			return false;
	}

	@Override
	public Object[] toArray() {
		return array.clone();
	}

	@Override
	public int size() {
		return array.length;
	}

	@Override
	public boolean contains(Object o) {
		if (o == null) {
			for (int k = 0; k < array.length; k++) {
				if (array[k] == null) {
					return true;
				}
			}
		}
		else {
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null && o.equals(array[i])) {
				return true;
			}
		}
		}
		return false;
	}

	@Override
	public boolean containsAll(MyList c) {
		if (c == null) {
			return false;
		}
		if (c.size() == size()) {
			Object[] result = c.toArray();
			for (int i = 0; i < result.length; i++) {
				if (result[i].equals(array[i])) {
					continue;
				}
				else {
					return false;
				}
			}
			return true;
		}
		else {
			return false;
		}
	}
	public Iterator<Object> iterator() {
	    return new IteratorImpl();
	}
	public String toString(){
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				if (i == array.length - 1) {
					sb.append("[" + null +"].");
				}
				else {
					sb.append("[" + null +"],");
				}
			}
			else {
				if (i == array.length - 1) {
					sb.append("[" + array[i].toString() + "].");
				}
				else {
					sb.append("[" + array[i].toString() + "],");
				}
			}
		}
		return sb.toString();
		
	}
	private class IteratorImpl implements Iterator<Object> {
		protected int index = 0;
		protected int lastIndex = -1;
		protected boolean flag = false;
	    public boolean hasNext() { 
	        return index < size();
	    }
	 
	    public Object next() {
	    	if (index >= size()) {
	    		throw new NoSuchElementException();
	    	}
	    		lastIndex = index;
	    		index++;
	    		flag = true;
	    	return array[lastIndex];
	    }
	    
	    public void remove(){ 
	    	if (flag) {
	        	MyListImpl.this.remove(array[lastIndex]);
	        	flag = false;
	        }
	        else {
	        	throw new IllegalStateException();
	        }
	    }
	}
	@Override
	public ListIterator listIterator() {
		return new ListIteratorImpl();
	}	
	private class ListIteratorImpl extends IteratorImpl implements ListIterator {
		
		@Override
		public boolean hasPrevious() {
			return index > 0;
		}
		public Object previous() {
			index--;
			if (index < 0) {
				throw new NoSuchElementException();
			}
	    		lastIndex = index;
	    		flag = true;
			return array[lastIndex];
		}

		@Override
		public void set(Object e) {
			if (flag) {
				array[lastIndex] = e;
				flag = false;
			}
			else {
				throw new IllegalStateException();
			}
			
		}
	}
	
	}


package de.svennetz.test.listComparision;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Object3ListDecorator implements List<Object3> {	
	private List<Object3> list;	
	
	public Object3ListDecorator(List<Object3> list) {
		super();
		this.list = list;
	}

	public int size() {
		return this.list.size();
	}

	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	public boolean contains(Object o) {
		//return this.list.contains(o);
		
		Object3 lo = (Object3)o;
		for(Object3 object : this.list) {
			if(object.getId() == lo.getId() && object.getSubId() == lo.getSubId() && object.getText().equals(lo.getText())) {
				return true;
			}
		}		
		return false;
	}

	public Iterator<Object3> iterator() {
		return this.list.iterator();
	}

	public Object[] toArray() {
		return this.list.toArray();
	}

	public <T> T[] toArray(T[] a) {
		return this.list.toArray(a);
	}

	public boolean add(Object3 e) {
		return this.list.add(e);
	}

	public boolean remove(Object o) {
		return this.list.remove(o);
	}

	public boolean containsAll(Collection<?> c) {
		return this.list.containsAll(c);
	}

	public boolean addAll(Collection<? extends Object3> c) {
		return this.list.addAll(c);
	}

	public boolean addAll(int index, Collection<? extends Object3> c) {
		return this.list.addAll(index, c);
	}

	public boolean removeAll(Collection<?> c) {
		return this.list.removeAll(c);
	}

	public boolean retainAll(Collection<?> c) {
		return this.list.retainAll(c);
	}

	public void clear() {
		this.list.clear();		
	}

	public Object3 get(int index) {
		return this.list.get(index);
	}

	public Object3 set(int index, Object3 element) {
		return this.list.set(index, element);
	}

	public void add(int index, Object3 element) {
		this.list.add(index, element);
	}

	public Object3 remove(int index) {
		return this.list.remove(index);
	}

	public int indexOf(Object o) {
		return this.list.indexOf(o);
	}

	public int lastIndexOf(Object o) {
		return this.list.lastIndexOf(o);
	}

	public ListIterator<Object3> listIterator() {
		return this.list.listIterator();
	}

	public ListIterator<Object3> listIterator(int index) {
		return this.list.listIterator(index);
	}

	public List<Object3> subList(int fromIndex, int toIndex) {
		return this.list.subList(fromIndex, toIndex);
	}
	
	public boolean containsId(Object3 o) {
		for(Object3 object : this.list) {
			if(object.getId() == o.getId() && object.getSubId() == o.getSubId()) {
				return true;
			}
		}	
		return false;
	}
	
}
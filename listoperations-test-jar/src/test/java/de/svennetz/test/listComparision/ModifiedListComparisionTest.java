package de.svennetz.test.listComparision;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ModifiedListComparisionTest {
	private List<Object3> originalList;
	private List<Object3> modifiedList;

	@Before
	public void Init() {
		this.originalList = new ArrayList<Object3>();
		for (int i = 0; i < 50000; i++) {
			this.originalList.add(new Object3(1, i));
		}

		// 5 items deleted (i % 10000 == 0)
		// 25 items modified (i % 2000 == 0)
		// res unmodified		
		this.modifiedList = new ArrayList<Object3>();
		for (int i = 0; i < 50000; i++) {
			if (i % 10000 != 0) {
				if(i % 2000 == 0) {
					Object3 o = new Object3(1, i);
					o.setText("Modified");
					this.modifiedList.add(o);
				} else {
					this.modifiedList.add(new Object3(1, i));					
				}
			}
		}
	}

	@Test
	public void testListComparison1() {
		long startTime = System.currentTimeMillis();

		boolean isEqual = this.originalList.equals(this.modifiedList);

		long stopTime = System.currentTimeMillis();
		long elapsed = (stopTime - startTime);
		System.out.println(elapsed + " ms");
		assertFalse(isEqual);
	}

	@Test
	public void testListComparison2() {
		long startTime = System.currentTimeMillis();

		Object3ListDecorator originalDecoratorList = new Object3ListDecorator(this.originalList);
		Object3ListDecorator modifiedDecoratorList = new Object3ListDecorator(this.modifiedList);
		List<Object3> unmodifiedResultList = new ArrayList<Object3>();
		List<Object3> modifiedResultList = new ArrayList<Object3>();
		List<Object3> deletedResultList = new ArrayList<Object3>();
		
		for (Object3 originalObject : originalDecoratorList) {			
			if (modifiedDecoratorList.contains(originalObject)) {
				unmodifiedResultList.add(originalObject);
			}
			else {
				if (modifiedDecoratorList.containsId(originalObject)) {
					modifiedResultList.add(originalObject);	
				}
				else {
					deletedResultList.add(originalObject);					
				}
			}
		}
		
		long stopTime = System.currentTimeMillis();
		long elapsed = (stopTime - startTime);
		System.out.println(elapsed + " ms");
		
		assertTrue(unmodifiedResultList.size() == (originalDecoratorList.size() - 25));
		assertTrue(modifiedResultList.size() == 20);
		assertTrue(deletedResultList.size() == 5);
	}
}

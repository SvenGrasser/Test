package de.svennetz.test.listComparision;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ListComparisionTest {
	private List<Object1> list1;
	private List<Object2> list2; 

	@Before
	public void Init() {
		this.list1 = new ArrayList<Object1>();
		for (int i = 0; i < 10000; i++) {
			this.list1.add(new Object1(1, i, 1));
			this.list1.add(new Object1(1, i, 2));
		}

		this.list2 = new ArrayList<Object2>();
		for (int i = 0; i < 8000; i++) {
			this.list2.add(new Object2(1, i));
		}
		for (int i = 0; i < 12000; i++) {
			this.list2.add(new Object2(2, i));
		}
	}

	@Test
	public void testComparison1() {
		long startTime = System.currentTimeMillis();
		int id = 1;
		
		List<Object1> targetList = new ArrayList<Object1>();
		for (Object1 object1 : this.list1) {			
			for (Object2 object2 : this.list2) {
				if(id == object2.getNr() && object1.getSubId() == object2.getSubNr()) {
					targetList.add(object1);
				}
			}
		}
		
		long stopTime = System.currentTimeMillis();
		long elapsed = (stopTime - startTime);
		System.out.println(elapsed + " ms");
		assertTrue(targetList.size() == 16000);
	}
	
	@Test
	public void testComparison2() {
		long startTime = System.currentTimeMillis();
		
		int id = 1;		
		List<Object1> targetList = new ArrayList<Object1>();
		int currentSubId = 0;
		for (Object1 listObject1 : this.list1) {
			if(currentSubId == listObject1.getSubId()) {
				targetList.add(listObject1);
				continue;
			}			
						
			for (Object2 listObject2 : this.list2) {
				if(id == listObject2.getNr() && listObject1.getSubId() == listObject2.getSubNr()) {
					currentSubId = listObject1.getSubId();
					targetList.add(listObject1);
					break;
				}
			}
		}
		
		long stopTime = System.currentTimeMillis();
		long elapsed = (stopTime - startTime);
		System.out.println(elapsed + " ms");
		assertTrue(targetList.size() == 16000);
	}
	
	@Test
	public void testComparison3() {
		long startTime = System.currentTimeMillis();
		
		int id = 1;		

		List<Object2> comparisonList = new ArrayList<Object2>();
		for (Object2 listObject2 : this.list2) {
			if(id == listObject2.getNr()) {
				comparisonList.add(listObject2);
			}
		}		
		
		List<Object1> targetList = new ArrayList<Object1>();
		int currentSubId = 0;
		for (Object1 listObject1 : this.list1) {
			if(currentSubId == listObject1.getSubId()) {
				targetList.add(listObject1);
				continue;
			}			
						
			for (Object2 listObject2 : comparisonList) {
				if(listObject1.getSubId() == listObject2.getSubNr()) {
					currentSubId = listObject1.getSubId();
					targetList.add(listObject1);
					break;
				}
			}
		}
		
		long stopTime = System.currentTimeMillis();
		long elapsed = (stopTime - startTime);
		System.out.println(elapsed + " ms");
		assertTrue(targetList.size() == 16000);
	}
}

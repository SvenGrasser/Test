package de.svennetz.test.listComparision;

public class Object1 {
	private int id;
	private int subId;
	private int subsubId;
			
	public Object1(int id, int subId, int subsubId) {
		super();
		this.id = id;
		this.subId = subId;
		this.subsubId = subsubId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSubId() {
		return subId;
	}
	public void setSubId(int subId) {
		this.subId = subId;
	}
	public int getSubSubId() {
		return subsubId;
	}
	public void setSubSubId(int subsubId) {
		this.subsubId = subsubId;
	}
}

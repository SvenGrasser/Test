package de.svennetz.test.listComparision;

public class Object3 {
	private int id;
	private int subId;
	private String text;
			
	public Object3(int id, int subId) {
		super();
		this.id = id;
		this.subId = subId;
		this.text = "Standard";
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}

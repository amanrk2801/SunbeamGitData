package com.sunbeam;

enum Elements{
	H(1,"Hydrogen"),HE(2,"Helium"),LI(3,"Lithium");
	private final int elementNum; 
	private final String elementName;
	private Elements(int elementNum, String elementName) {
		this.elementNum = elementNum;
		this.elementName = elementName;
	}
	public int getElementNum() {
		return elementNum;
	}
	public String getElementName() {
		return elementName;
	} 
}
public class Program {

	public static void main(String[] args) {
		Elements[] eleVal = Elements.values(); 
		for (Elements ele : eleVal) {
			System.out.println(ele.getElementNum() + "." + ele.getElementName());
		}
	}

}

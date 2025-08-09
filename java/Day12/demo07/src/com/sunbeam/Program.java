package com.sunbeam;
enum WeekDays{
	MONDAY{
		@Override
		public String toString() {
			return "Monday"; 
		}
	},
	TUESDAY{
		@Override
		public String toString() {
			return "Tuesday"; 
		}
	},
	WEDNESDAY{
		@Override
		public String toString() {
			return "Wednesday";
		} 
	},
	THURSDAY{
		@Override
		public String toString() {
			return "Thursday"; 
		}
	}
}
public class Program {

	public static void main(String[] args) {
//		for (WeekDays wk : WeekDays.values()) {
//			System.out.println(wk.ordinal() + "." + wk.name() + "--> " +wk.toString());
//		}
		WeekDays[] wkDay = WeekDays.values(); 
		for (WeekDays wk : wkDay) {
			System.out.println(wk.ordinal() + "." + wk.name() + "--> "+wk.toString());
		}
	}

}

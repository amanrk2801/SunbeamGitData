package tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sunbeam.dependent.School;

public class TestRichSchool {

	public static void main(String[] args) {
		/*
		 * Start SC in standalone app
		 */
		try (ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("bean-config.xml")) {
			System.out.println("SC up n running....");
			// invoke B.L method - manageAcademics
			// 1. get ready to use Public school from SC
			School school = ctx.getBean
					("rich_public_school", School.class);
			// 2. B.L
			school.manageAcademics();
			//3. B.L
			school.organizeSportsEvent();
			

		} //JVM - ctx.close() -> tries to call destroy() on singleton bean 
		//-> marked for GC
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}

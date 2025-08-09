package tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sunbeam.dependent.PublicSchool;

public class TestSpringContainer {

	public static void main(String[] args) {
		/*
		 * Start SC in standalone app
		 */
		try (ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("bean-config.xml")) {
			System.out.println("SC up n running....");
			// invoke B.L method - manageAcademics
			// 1. get ready to use Public school from SC
			PublicSchool school = ctx.getBean
					("public_school", PublicSchool.class);
			// 2. B.L
			school.manageAcademics();
			//3. B.L
			school.organizeSportsEvent();
			PublicSchool school2 = ctx.getBean("public_school", 
					PublicSchool.class);
			System.out.println(school == school2);

		} //JVM - ctx.close() -> tries to call destroy() on singleton bean 
		//-> marked for GC
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}

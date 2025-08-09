package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.TagDao;
import com.sunbeam.dao.TagDaoImpl;

public class AssignResaturantToTag {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);
				SessionFactory sf = getFactory()) {
			// create dao
			TagDao dao = new TagDaoImpl();
			System.out.println("Enter tag id n restaurant id");
			System.out.println(dao.linkRestaurant(sc.nextLong(), sc.nextLong()));
		}
	}

}

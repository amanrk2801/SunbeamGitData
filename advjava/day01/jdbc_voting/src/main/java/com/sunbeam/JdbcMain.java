package com.sunbeam;

import java.sql.Date;
import java.util.List;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class JdbcMain {
	public static void main1(String[] args) {
		try(UserDao userDao = new UserDaoImpl()) {
			String email = "nilesh@gmail.com1"; // sc.next();
			User user = userDao.findByEmail(email );
			if(user == null)
				System.out.println("User not found");
			else
				System.out.println("Found: " + user);
		} // userDao.close();
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main2(String[] args) {
		try(UserDao userDao = new UserDaoImpl()) {
			int id = 5; // sc.nextInt();
			User user = userDao.findById(id);
			if(user == null)
				System.out.println("User not found");
			else
				System.out.println("Found: " + user);
		} // userDao.close();
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main3(String[] args) {
		try(UserDao userDao = new UserDaoImpl()) {
			List<User> list = userDao.findAll();
			for (User user : list) {
				System.out.println(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main4(String[] args) {
		try(UserDao userDao = new UserDaoImpl()) {
			Date birth = Date.valueOf("1970-01-01");
			User u = new User(0, "James", "Bond", "james@bond.com", "007", birth, false, "voter");
			int cnt = userDao.save(u);
			System.out.println("User saved: " + cnt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main5(String[] args) {
		try(UserDao userDao = new UserDaoImpl()) {
			int id = 5; // sc.nextInt();
			User user = userDao.findById(id);
			if(user == null)
				System.out.println("User not found");
			else {
				user.setPasswd("seven");
				user.setRole("admin");
				user.setStatus(true);
				int count = userDao.update(user);
				System.out.println("Updated: " + count);
			}
		} // userDao.close();
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		try(UserDao userDao = new UserDaoImpl()) {
			int id = 5; // sc.nextInt();
			int count = userDao.deleteById(id);
			System.out.println("Deleted: " + count);
		} // userDao.close();
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

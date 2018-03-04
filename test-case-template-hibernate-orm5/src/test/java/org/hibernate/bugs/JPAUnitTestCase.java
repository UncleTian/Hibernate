package org.hibernate.bugs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.domain.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */
public class JPAUnitTestCase {

	private EntityManagerFactory entityManagerFactory;

	@Before
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "templatePU" );
	}

	@After
	public void destroy() {
		entityManagerFactory.close();
	}

	// Entities are auto-discovered, so just add them anywhere on class-path
	// Add your tests, using standard JUnit.
	@Test
	public void hhh123Test() throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Student stu = new Student();
		stu.setName("Jack");
		stu.setAge(88);
		stu.setAddress("haha");
		stu.setEmail("1234@145.com");
		stu.setTelephone("123456789");
		entityManager.persist(stu);
//		
		Student find = entityManager.find(Student.class, 1L);
		System.out.println("db student : " + find);
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
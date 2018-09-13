package org.hibernate.bugs;

import org.hibernate.Session;
import org.hibernate.domain.HeadMaster;
import org.hibernate.domain.Student;
import org.hibernate.domain.Teacher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Set;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */
public class JPAUnitTestCase {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @Before
    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("templatePU");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    @After
    public void destroy() {
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    // Entities are auto-discovered, so just add them anywhere on class-path
    // Add your tests, using standard JUnit.
    @Test
    public void generateData() throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Student stu = new Student();
        stu.setName("RoseSL");
        stu.setAge(41);
        stu.setAddress("hahaKSL");
        stu.setEmail("1234@145.com");
        stu.setTelephone("4848449SD");

        Student stu2 = new Student();
        stu2.setName("JackGG");
        stu2.setAge(34);
        stu2.setAddress("ojbk");
        stu2.setEmail("kops@145.com");
        stu2.setTelephone("9029102");

        Teacher tec = new Teacher();
        tec.setName("JJKI");
        tec.getStudents().add(stu);
        tec.getStudents().add(stu2);

        HeadMaster hm = new HeadMaster();
        hm.setName("X Professor");
        hm.getStudents().add(stu);
        hm.getStudents().add(stu2);

        stu.setTeacher(tec);
        stu.setHeadMaster(hm);
        stu2.setTeacher(tec);
        stu2.setHeadMaster(hm);

        entityManager.persist(tec);
        entityManager.persist(hm);
//		
        Student find = entityManager.find(Student.class, 1L);
        System.out.println("db student : " + find);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    //	@Test
    public void deleteTest() {
        Teacher teacher = entityManager.find(Teacher.class, 14);
        Set<Student> tech_students = teacher.getStudents();
        tech_students.stream().forEach(s -> entityManager.remove(s));
        HeadMaster headMaster = entityManager.find(HeadMaster.class, 4);
        headMaster.setName("Wolverine12");

        entityManager.persist(teacher);
        entityManager.persist(headMaster);
    }

    @Test
    public void updateData() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Session session = entityManager.unwrap(org.hibernate.Session.class);
        Student student = session.get(Student.class, 1L);
        student.setAddress("beijing");
        System.out.println(student);
        session.evict(student);
        transaction.commit();
    }
}

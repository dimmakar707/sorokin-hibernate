package sorokin.dev;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("sorokin.dev");

        SessionFactory sessionFactory = context.getBean(SessionFactory.class);

        Session session = sessionFactory.openSession();

        Student student1 = new Student("Vasya", 22);
        Student student2 = new Student("Pasha", 20);

        //INSERT
        session.beginTransaction();
        session.persist(student1);
        session.persist(student2);
        session.getTransaction().commit();

        session.close();

        session = sessionFactory.openSession();
        student1 = session.merge(student1);
        session.beginTransaction();
        student1.setName("Dima");

        session.detach(student1);
        student1.setAge(35);

        session.getTransaction().commit();
        session.close();

        //SELECT
//        Student studentById1 = session.get(Student.class, 1L);
//        System.out.println("Student 1: " + studentById1);

        //SELECT BY PARAMETER
//        Student studentById2 = session.createQuery("SELECT s FROM Student s WHERE s.id = :id", Student.class)
//                .setParameter("id", 2)
//                .getSingleResult();
//        System.out.println(studentById2);


        //UPDATE
//        session.beginTransaction();
//        Student studentForUpdate = session.get(Student.class, 1L);
//        studentForUpdate.setAge(30);
//        studentForUpdate.setName("Dima");
//        session.getTransaction().commit();

        //DELETE
//        session.beginTransaction();
//        Student studentForDelete = session.get(Student.class, 2L);
//        session.remove(studentForDelete);

        //DELETE WITH JPQL
//        session.createQuery("DELETE FROM Student s WHERE s.id = :id")
//                .setParameter("id", 1)
//                .executeUpdate();

        //DELETE WITH NATIVE SQL Query
//        session.createNativeQuery("DELETE FROM Students WHERE id = 1").executeUpdate();
//
//        session.getTransaction().commit();

//        System.out.println("-----------------");

        //SELECT All Students
//        List<Student> allStudents = session.createQuery("SELECT s FROM Student s ORDER BY id", Student.class).list();
//        System.out.println(allStudents);

        //SELECT Student by name
//        Student studentByName = session.createQuery("SELECT s FROM Student s WHERE name = :name", Student.class)
//                .setParameter("name", "Pasha")
//                .getSingleResult();
//        System.out.println(studentByName);
//
//        session.beginTransaction();
//        Student student3 = new Student("Pasha", 25);
//        session.persist(student3);
//        session.getTransaction().commit();
//
//        session.close();
    }
}
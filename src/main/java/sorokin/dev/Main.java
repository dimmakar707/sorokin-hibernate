package sorokin.dev;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("sorokin.dev");

        SessionFactory sessionFactory = context.getBean(SessionFactory.class);

        Session session = sessionFactory.openSession();

        Student student1 = new Student("Vasya", 22);
        Student student2 = new Student("Pasha", 20);

        session.beginTransaction();
        session.persist(student1);
        session.persist(student2);
        session.getTransaction().commit();

        Student studentById1 = session.get(Student.class, 1);
        System.out.println("Student 1: " + studentById1);

        Student studentById2 = session.createQuery("SELECT s FROM Student s WHERE s.id = :id", Student.class)
                .setParameter("id", 2)
                .getSingleResult();
        System.out.println(studentById2);

        session.close();
    }
}
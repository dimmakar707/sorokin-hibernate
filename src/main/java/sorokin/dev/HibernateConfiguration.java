package sorokin.dev;

import org.hibernate.SessionFactory;

public class HibernateConfiguration {

    public SessionFactory sessionFactory() {
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();

        configuration
                .addPackage("sorokin.dev")
                .setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")
                .setProperty("hibernate.connecction.url", "jdbc:postgres://localhost:6543/postgres")
                .setProperty("hibernate.connection.username", "postgres")
                .setProperty("hibernate.connection.password", "root")
                .setProperty("hibernate.show_sql", "true")
                .setProperty("hibernate.hbm2ddl.auto", "create-drop");

        return configuration.buildSessionFactory();
    }

}

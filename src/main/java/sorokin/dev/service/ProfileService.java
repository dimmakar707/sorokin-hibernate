package sorokin.dev.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import sorokin.dev.Profile;
import sorokin.dev.TransactionHelper;

@Service
public class ProfileService {

    private final SessionFactory sessionFactory;
    private final TransactionHelper transactionHelper;


    public ProfileService(SessionFactory sessionFactory, TransactionHelper transactionHelper) {
        this.sessionFactory = sessionFactory;
        this.transactionHelper = transactionHelper;
    }

    public Profile saveProfile(Profile profile) {
        return transactionHelper.executeInTransaction(session -> {
            session.persist(profile);
            return profile;
        });
    }
}

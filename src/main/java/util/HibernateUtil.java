package util;

import model.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory= createSessionFactory();

    private static SessionFactory createSessionFactory(){
        Configuration config=new Configuration();
        config.addAnnotatedClass(AdminEntity.class);
        config.addAnnotatedClass(CustomerEntity.class);
        config.addAnnotatedClass(OrderEntity.class);
        config.addAnnotatedClass(ProductEntity.class);
        config.addAnnotatedClass(ReturnDetailsEntity.class);
        config.addAnnotatedClass(ReturnEntity.class);
        config.addAnnotatedClass(StaffEntity.class);
        config.addAnnotatedClass(SupplierEntity.class);
        config.addAnnotatedClass(UserEntity.class);
        config.configure("/hibernate.cfg.xml");
        return config.buildSessionFactory();
    }

    public static Session getSession(){
        return sessionFactory.openSession();
    }
}

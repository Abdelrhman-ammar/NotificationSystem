package Not_Sys;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MYSQLInventory implements DBInventory {


    @Override
    public Blueprint get(int id, String table) {
        Blueprint retr = null;
        SessionFactory factory = null;
        if (table.equals("template")) {
            factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Template.class)
                    .buildSessionFactory();
            Session session = factory.getCurrentSession();
            try {
                session.beginTransaction();
                retr = session.get(Template.class, id);
                session.getTransaction().commit();

            } finally {
                factory.close();
            }
        } else {
            factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(NotificationHandler.class)
                    .buildSessionFactory();
            Session session = factory.getCurrentSession();
            try {
                session.beginTransaction();
                retr = session.get(NotificationHandler.class, id);
                session.getTransaction().commit();
            } finally {
                factory.close();
            }
        }
        return retr;
    }

    @Override
    public boolean update(int id, Blueprint b) {
        boolean cond = false;
        if (b.getClass() == Template.class) {
            SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Template.class)
                    .buildSessionFactory();
            Session session = factory.getCurrentSession();
            try {
                session.beginTransaction();
                Template temp = session.get(Template.class, id);
                temp.setHeader(b.getHeader());
                temp.setContent(b.getContent());
                temp.setLanguage(b.getLanguage());
                session.getTransaction().commit();
                cond = true;
            } finally {
                factory.close();
            }
        } else {
            SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(NotificationHandler.class)
                    .buildSessionFactory();
            Session session = factory.getCurrentSession();
            try {
                session.beginTransaction();
                NotificationHandler noti = session.get(NotificationHandler.class, id);
                noti.setHeader(b.getHeader());
                noti.setContent(b.getContent());
                noti.setLanguage(b.getLanguage());
                session.getTransaction().commit();
                cond = true;
            } finally {
                factory.close();
            }
        }
        return cond;
    }


    @Override
    public boolean delete(int id, String table) {
        Blueprint retr = null;
        boolean cond = false;
        SessionFactory factory = null;
        if (table.equals("template")) {
            factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Template.class)
                    .buildSessionFactory();
            Session session = factory.getCurrentSession();
            try {
                session.beginTransaction();
                retr = session.get(Template.class, id);
                if (retr != null) {
                    cond = true;
                    session.delete(retr);
                }
                session.getTransaction().commit();
            } finally {
                factory.close();
            }
        } else {
            factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(NotificationHandler.class)
                    .buildSessionFactory();
            Session session = factory.getCurrentSession();
            try {
                session.beginTransaction();
                retr = session.get(NotificationHandler.class, id);
                if (retr != null) {
                    cond = true;
                    session.delete(retr);
                }
                session.getTransaction().commit();
            } finally {
                factory.close();
            }
        }
        return cond;
    }

    @Override
    public boolean store(Blueprint obj) {
        boolean cond = false;
        SessionFactory factory = null;
        if (obj.getClass() == Template.class) {
            factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Template.class)
                    .buildSessionFactory();
        } else {
            factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(NotificationHandler.class)
                    .buildSessionFactory();
        }
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            session.save(obj);
            session.getTransaction().commit();
            cond = true;
        } finally {
            factory.close();
        }
        return cond;
    }
}

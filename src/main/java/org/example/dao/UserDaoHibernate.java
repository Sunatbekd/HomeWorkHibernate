package org.example.dao;

import org.example.config.Config;
import org.example.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserDaoHibernate implements UserDao{
    @Override
    public void dropUsersTable() {
        try (Session session = Config.getSession().openSession()){
            session.beginTransaction();
            session.createSQLQuery("DROP TABLE users").executeUpdate();
            session.getTransaction().commit();

        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void saveUser(User user) {
        try (Session session = Config.getSession().openSession()){
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();

        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    public User getById(Long id){
        try (Session session = Config.getSession().openSession()){
            session.beginTransaction();
            User user = session.get(User.class,id);
            session.getTransaction().commit();
            return user;

        }catch (HibernateException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void removeUserById(Long id) {
        try (Session session = Config.getSession().openSession()){
            session.beginTransaction();
            User user = session.load(User.class,id);
            session.delete(user);
            session.getTransaction().commit();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = Config.getSession().openSession()){
            session.beginTransaction();
            List<User> userList = session.createQuery("from User ").getResultList();
            session.getTransaction().commit();
            return userList;
        }catch (HibernateException e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public void cleanUsersTable() {
        try (Session session = Config.getSession().openSession()){
            session.beginTransaction();
            String clean = "Delete from User";
            Query query = session.createQuery(clean);
            query.executeUpdate();
            session.getTransaction().commit();

        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
    }
}

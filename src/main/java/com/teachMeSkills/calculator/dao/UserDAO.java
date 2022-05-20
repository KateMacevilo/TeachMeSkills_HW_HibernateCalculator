package com.teachMeSkills.calculator.dao;

import com.teachMeSkills.calculator.config.HibernateSessionFactoryUtil;
import com.teachMeSkills.calculator.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAO {

    public void save(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public User findByLogin (String login){

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        String hql = "from User where login = :paramName";
        Query query = session.createQuery(hql);
        query.setParameter("paramName", login);
        User user = (User) query.getSingleResult();

        return user;
    }

    public List<User> findAll() {
        List<User> users = (List<User>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User").list();
        return users;
    }



}

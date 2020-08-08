package me.herrlestrate.writeups.dao;

import me.herrlestrate.writeups.model.Writeup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WriteupDAOImpl implements WriteupDAO{

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<Writeup> allWriteups() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Writeup").list();
    }

    public void create(Writeup writeup) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(writeup);
    }

    public Writeup getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Writeup.class, id);
    }

    public void update(Writeup writeup) {
        Session session = sessionFactory.getCurrentSession();
        session.update(writeup);
    }

    public void delete(Writeup writeup) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(writeup);
    }
}

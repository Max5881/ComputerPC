package ru.sapteh.DaoImp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.DAO.DAO;
import ru.sapteh.Model.Computer;

import java.util.List;

public class ComputerDaoImp implements DAO<Computer,Integer> {
    private final SessionFactory factory;

    public ComputerDaoImp(SessionFactory factory) {
        this.factory = factory;
    }

    public void create(Computer computer) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(computer);
            session.getTransaction().commit();
        }
    }

    public Computer read(Integer integer) {
        try(Session session = factory.openSession()){
            Computer result = session.get(Computer.class,integer);
            return result;
        }

    }

    public List<Computer> readAllBy() {
        try(Session session = factory.openSession()) {
            Query<Computer> result = session.createQuery("FROM Computer");
            return result.list();
        }

    }

    public void delete(Computer computer) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(computer);
            session.getTransaction().commit();
        }

    }

    public void update(Computer computer) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(computer);
            session.getTransaction().commit();
        }

    }
}

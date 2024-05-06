package org.example.app.repository.impl;

import org.example.app.domain.contact.Contact;
import org.example.app.repository.ContactRepository;
import org.example.app.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class ContactRepositoryImpl implements ContactRepository {

    @Override
    public void create(Contact contact) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(contact);
            transaction.commit();
        }
    }

    @Override
    public Optional<List<Contact>> fetchAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Contact> contacts = session.createQuery("FROM Contact", Contact.class).list();
            return Optional.of(contacts);
        }
    }

    @Override
    public Optional<Contact> fetchById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Contact contact = session.get(Contact.class, id);
            return Optional.ofNullable(contact);
        }
    }

    @Override
    public void update(Long id, Contact contact) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            contact.setId(id);
            session.update(contact);
            transaction.commit();
        }
    }

    @Override
    public void delete(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Contact contact = session.get(Contact.class, id);
            session.delete(contact);
            transaction.commit();
        }
    }
}


package org.example.app.service;

import org.example.app.domain.contact.Contact;

import java.util.List;

public interface ContactService {
    Contact create(Contact contact);
    List<Contact> fetchAll();
    Contact fetchById(Long id);
    Contact update(Long id, Contact contact);
    boolean delete(Long id);
}

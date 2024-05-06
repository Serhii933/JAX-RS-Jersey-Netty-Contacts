package org.example.app.repository;

import org.example.app.domain.contact.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactRepository {
    void create(Contact contact);
    Optional<List<Contact>> fetchAll();
    Optional<Contact> fetchById(Long id);
    void update(Long id, Contact contact);
    void delete(Long id);
}

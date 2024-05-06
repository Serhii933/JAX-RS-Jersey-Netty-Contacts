package org.example.app.service.impl;

import org.example.app.domain.contact.Contact;
import org.example.app.repository.ContactRepository;
import org.example.app.service.ContactService;

import java.util.List;

public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact create(Contact contact) {
        contactRepository.create(contact);
        return contact;
    }

    @Override
    public List<Contact> fetchAll() {
        return contactRepository.fetchAll().orElse(null);
    }

    @Override
    public Contact fetchById(Long id) {
        return contactRepository.fetchById(id).orElse(null);
    }

    @Override
    public Contact update(Long id, Contact contact) {
        contactRepository.update(id, contact);
        return contact;
    }

    @Override
    public boolean delete(Long id) {
        contactRepository.delete(id);
        return true;
    }
}

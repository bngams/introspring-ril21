package fr.cesi.ril21.demospring.services;

import fr.cesi.ril21.demospring.entities.Contact;
import fr.cesi.ril21.demospring.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private ContactRepository contactRepo;

    @Autowired
    public ContactService(ContactRepository contactRepo) {
        this.contactRepo = contactRepo;
    }

    public List<Contact> getContacts() {
       return (List<Contact>) this.contactRepo.findAll();
    }

    public Contact findContactById(Long id) {
        return this.contactRepo.findById(id).get();
    }

    public Contact saveContact(Contact c) {
        return this.contactRepo.save(c);
    }
}

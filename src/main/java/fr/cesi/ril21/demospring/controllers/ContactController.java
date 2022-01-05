package fr.cesi.ril21.demospring.controllers;

import fr.cesi.ril21.demospring.entities.Contact;
import fr.cesi.ril21.demospring.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private ContactService contactServ;

    @Autowired
    public ContactController(ContactService contactServ) {
        this.contactServ = contactServ;
    }

    // HTTP GET /contacts
    @GetMapping("")
    public List<Contact> getContacts() {
        return this.contactServ.getContacts();
    }

    // GET /contacts/1 - /contacts/id
    // we use a path variable not an url param
    // /contacts?id=1 <= param
    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable Long id) {
        return this.contactServ.findContactById(id);
    }

    // POST /contacts
    // @RequestMapping(value="/contacts", method = "POST")
    @PostMapping("")
    public ResponseEntity<Contact> postContact(@RequestBody Contact c) {
        return new ResponseEntity<Contact>(this.contactServ.saveContact(c), HttpStatus.CREATED);
    }

    // PUT /contacts
    @PutMapping("")
    public Contact putContact(@RequestBody Contact c) {
        return null;
    }

    // DELETE /contacts
    @DeleteMapping("/{id}")
    public Long deleteContactById(@PathVariable Long id) {
        return null;
    }

}

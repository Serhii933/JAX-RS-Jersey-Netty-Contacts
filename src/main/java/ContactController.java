package org.example.app.controller;

import org.example.app.domain.contact.Contact;
import org.example.app.service.ContactService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/contacts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @POST
    public Response createContact(Contact contact) {
        contactService.create(contact);
        return Response.ok(contact).build();
    }

    @GET
    public Response getAllContacts() {
        List<Contact> contacts = contactService.fetchAll();
        return Response.ok(contacts).build();
    }

    @GET
    @Path("/{id}")
    public Response getContactById(@PathParam("id") Long id) {
        Contact contact = contactService.fetchById(id);
        if (contact != null) {
            return Response.ok(contact).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response updateContact(@PathParam("id") Long id, Contact contact) {
        contactService.update(id, contact);
        return Response.ok(contact).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteContact(@PathParam("id") Long id) {
        boolean deleted = contactService.delete(id);
        if (deleted) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}

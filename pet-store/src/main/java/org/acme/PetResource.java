package org.acme;

import org.acme.models.Pet;
import org.acme.repository.PetRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pets")
public class PetResource {
    private final PetRepository petRepository;

    public PetResource(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(){
        return Response.ok(petRepository.getAllPets()).build();
    }

    @GET
    @Path("/query")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByColumn(@QueryParam("column") String column, @QueryParam("value") String value){
        return Response.ok(petRepository.getPetByColumnAndValue(column,value)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(Pet pet){
        try{
            petRepository.addPet(pet);
            return Response.status(201).build();

        }
        catch(Exception e){
            return Response.status(500).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(Pet pet){
        try{
            petRepository.updatePet(pet);
            return Response.status(204).build();

        }
        catch(Exception e){
            return Response.status(500).build();
        }
    }

    @DELETE
    public Response delete(@QueryParam("id") Long id){
        try{
            petRepository.deletePet(id);
            return Response.status(204).build();

        }
        catch(Exception e){
            return Response.status(500).build();
        }
    }


}

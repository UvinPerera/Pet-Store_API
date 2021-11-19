package org.acme;

import org.acme.models.PetType;
import org.acme.repository.PetTypeRepository;
import javax.ws.rs.*;
import javax.ws.rs.core.*;


@Path("/pet-type")
public class PetTypeResource {
  private final PetTypeRepository pettypeRepository;

  public PetTypeResource(PetTypeRepository pettypeRepository) {
    this.pettypeRepository = pettypeRepository;
  }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        return Response.ok(pettypeRepository.getAllPetTypes()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(PetType petType){
      try {
        pettypeRepository.addPetType(petType);
        return Response.status(201).build();
      }
      catch (Exception e){
        return Response.status(500).build();

      }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(PetType petType){
      try{
        pettypeRepository.updatePetType(petType);
        return Response.status(200).build();
      }
      catch (Exception e){
        return Response.status(500).build();

      }
    }

    /**
     * @param id The Id of the Pet type
     * */
    @DELETE
    public Response delete(@QueryParam("id") Long id){
      try{
        pettypeRepository.deletePetType(id);
        return Response.status(200).build();
      }
      catch (Exception e){
        return Response.status(500).build();

      }
    }

}

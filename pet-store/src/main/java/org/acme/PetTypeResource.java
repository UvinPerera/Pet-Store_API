package org.acme;

import org.acme.models.PetType;
import org.acme.repository.PetTypeRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/pet-type")
public class PetTypeResource {

  private List<PetType> petTypes = new ArrayList();
  private final PetTypeRepository pettypeRepository;

  public PetTypeResource(PetTypeRepository pettypeRepository) {
    this.pettypeRepository = pettypeRepository;
  }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {

        return Response.ok(pettypeRepository.getAllPetTypes()).build();
    }

}

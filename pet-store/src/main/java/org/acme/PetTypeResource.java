package org.acme;

import org.acme.models.PetType;
import org.acme.repository.PetTypeRepository;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.*;
import javax.ws.rs.core.*;


@Path("/pet-type")
@Tag(name = "Pet type API", description = "CRUD operations for the pet-type related APIs are here")
public class PetTypeResource {
  private final PetTypeRepository pettypeRepository;

  public PetTypeResource(PetTypeRepository pettypeRepository) {
    this.pettypeRepository = pettypeRepository;
  }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
	summary = "Get all pet-types",
	description = "This endpoint returns all pet-types in the database"
    )
    @APIResponse(
	responseCode = "200",
	description = "API returns all pet types",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    @APIResponse(
            responseCode = "500",
            description = "Internal Server Error"
    )
    public Response get() {
        return Response.ok(pettypeRepository.getAllPetTypes()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
            summary = "Add a pet type",
            description = "This endpoint adds a pet-type in the database, Don't add an ID explicitly"
    )
    @APIResponse(
            responseCode = "201",
            description = "Pet type created successfully"
    )
    @APIResponse(
            responseCode = "500",
            description = "Internal Server Error"
    )
    public Response post(
            @RequestBody(
                    required = true
            )
                    PetType petType){
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
    @Operation(
            summary = "Update a pet type",
            description = "This endpoint updates a pet-type in the database, with an ID provided"
    )
    @APIResponse(
            responseCode = "200",
            description = "Pet type updated successfully"
    )
    @APIResponse(
            responseCode = "500",
            description = "Internal Server Error"
    )
    public Response update(
            @RequestBody(
                    required = true
            )
                    PetType petType){
      try{
        pettypeRepository.updatePetType(petType);
        return Response.status(200).build();
      }
      catch (Exception e){
        return Response.status(500).build();

      }
    }


    @DELETE
    @Operation(
            summary = "Delete a pet type",
            description = "This endpoint delete a pet-type in the database, with an ID provided"
    )
    @APIResponse(
            responseCode = "200",
            description = "Pet type deleted successfully"
    )
    @APIResponse(
            responseCode = "500",
            description = "Internal Server Error"
    )
    public Response delete(
            @Parameter(
                    required = true
            )
            @QueryParam("id") Long id
    ){
      try{
        pettypeRepository.deletePetType(id);
        return Response.status(200).build();
      }
      catch (Exception e){
        return Response.status(500).build();

      }
    }

}

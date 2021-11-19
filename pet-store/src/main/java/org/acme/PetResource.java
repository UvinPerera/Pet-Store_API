package org.acme;

import org.acme.models.Pet;
import org.acme.repository.PetRepository;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pets")
@Tag(name = "Pet API", description = "All the pet related CRUD operation APIs are here")
public class PetResource {
    private final PetRepository petRepository;

    public PetResource(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
            summary = "Get all pets",
            description = "This endpoint returns all pets in the database"
    )
    @APIResponse(
            responseCode = "200",
            description = "API returns all pets",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    @APIResponse(
            responseCode = "500",
            description = "Internal Server Error"
    )
    public Response get(){
        return Response.ok(petRepository.getAllPets()).build();
    }

    @GET
    @Path("/query")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
            summary = "Get pets by query",
            description = "This endpoint returns all pets in the database with a the column and the corresponding value provided"
    )

    @APIResponse(
            responseCode = "200",
            description = "API returns the filtered pets",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    @APIResponse(
            responseCode = "500",
            description = "Internal Server Error"
    )
    public Response getByColumn(
            @Parameter(
            description = "Column in the database",
            required = true
            )
            @QueryParam("column") String column,
            @Parameter(
                    description = "The value need to be filter w.r.t column",
                    required = true
            )
            @QueryParam("value") String value){
        return Response.ok(petRepository.getPetByColumnAndValue(column,value)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
            summary = "Add a pet",
            description = "This endpoint adds a pet in the database, Don't add an ID explicitly"
    )
    @APIResponse(
            responseCode = "201",
            description = "Pet created successfully"
    )
    @APIResponse(
            responseCode = "500",
            description = "Internal Server Error"
    )
    public Response post(
            @RequestBody(
                    required = true
            )
            Pet pet
    ){
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
    @Operation(
            summary = "Update a pet",
            description = "This endpoint updates a pet in the database, with an ID provided"
    )
    @APIResponse(
            responseCode = "200",
            description = "Pet updated successfully"
    )
    @APIResponse(
            responseCode = "500",
            description = "Internal Server Error"
    )
    public Response put(
            @RequestBody(
                    required = true
            )
                    Pet pet){
        try{
            petRepository.updatePet(pet);
            return Response.status(200).build();

        }
        catch(Exception e){
            return Response.status(500).build();
        }
    }

    @DELETE
    @Operation(
            summary = "Delete a pet",
            description = "This endpoint delete a pet in the database, with an ID provided"
    )
    @APIResponse(
            responseCode = "200",
            description = "Pet deleted successfully"
    )
    @APIResponse(
            responseCode = "500",
            description = "Internal Server Error"
    )
    public Response delete(
            @Parameter(
                    required = true
            )
            @QueryParam("id") Long id){
        try{
            petRepository.deletePet(id);
            return Response.status(200).build();

        }
        catch(Exception e){
            return Response.status(500).build();
        }
    }


}

package org.acme.repository;

import org.acme.models.Pet;
import java.util.List;

public interface PetRepository {
    public List<Pet> getAllPets();

    public List<Pet> getPetByColumnAndValue(String type);

    public void addPetType(Pet pet);

    public void updatePetType(Pet pet);

    public void deletePetType(Long id);
}

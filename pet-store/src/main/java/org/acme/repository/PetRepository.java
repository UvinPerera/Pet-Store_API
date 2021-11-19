package org.acme.repository;

import org.acme.models.Pet;
import java.util.List;

public interface PetRepository {
    public List<Pet> getAllPets();

    public List<Pet> getPetByColumnAndValue(String column, String value);

    public void addPet(Pet pet);

    public void updatePet(Pet pet);

    public void deletePet(Long id);
}

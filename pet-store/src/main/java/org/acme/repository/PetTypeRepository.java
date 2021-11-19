package org.acme.repository;

import org.acme.models.PetType;
import java.util.List;

public interface PetTypeRepository{


    public List<PetType> getAllPetTypes();

    public List<PetType> getPetType(String type);

    public void addPetType(PetType petType);

    public void updatePetType(PetType petType);

    public void deletePetType(Long id);
}

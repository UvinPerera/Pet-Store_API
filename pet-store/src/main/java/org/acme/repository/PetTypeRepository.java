package org.acme.repository;

import org.acme.models.PetType;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public interface PetTypeRepository{

    @Transactional
    public List<PetType> getAllPetTypes();
    @Transactional
    public List<PetType> getPetType(String type);
}

package org.acme.repository.impl;

import org.acme.models.Pet;
import org.acme.models.PetType;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PetRepository implements org.acme.repository.PetRepository {
    @Inject
    EntityManager em;

    @Override
    @Transactional
    public List<Pet> getAllPets() {
        List<Pet> result = em.createQuery("Select pt from PetType pt",Pet.class).getResultList();
        return result;
    }

    @Override
    @Transactional
    public List<Pet> getPetByColumnAndValue(String type) {
        return null;
    }

    @Override
    @Transactional
    public void addPetType(Pet pet) {

    }

    @Override
    @Transactional
    public void updatePetType(Pet pet) {

    }

    @Override
    @Transactional
    public void deletePetType(Long id) {

    }
}

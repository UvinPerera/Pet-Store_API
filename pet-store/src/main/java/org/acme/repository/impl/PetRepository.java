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
        List<Pet> result = em.createQuery("Select pt from Pet pt",Pet.class).getResultList();
        return result;
    }

    @Override
    @Transactional
    public List<Pet> getPetByColumnAndValue(String column, String value) {
        List<Pet> result = em.createQuery("Select pt from Pet pt where pt."+column+"="+value,Pet.class).getResultList();
        return result;
    }

    @Override
    @Transactional
    public void addPet(Pet pet) {
        em.persist(pet);

    }

    @Override
    @Transactional
    public void updatePet(Pet pet) {
        em.merge(pet);
    }

    @Override
    @Transactional
    public void deletePet(Long id) {
        Pet pet = em.find(Pet.class,id);
        em.remove(pet);
    }
}

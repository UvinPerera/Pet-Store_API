package org.acme.repository.impl;

import org.acme.models.PetType;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PetTypeRepository implements org.acme.repository.PetTypeRepository {
    @Inject
    EntityManager em;

    @Override
    @Transactional
    public List<PetType> getAllPetTypes() {
        List<PetType> result = em.createQuery("Select pt from PetType pt",PetType.class).getResultList();
        return result;
    }

    @Override
    @Transactional
    public List<PetType> getPetType(String type) {
        List<PetType> result = em.createQuery("Select pt from PetType pt where pt.type="+type,PetType.class).getResultList();
        return result;
    }

    @Override
    @Transactional
    public void addPetType(PetType petType) {
        em.persist(petType);
    }

    @Override
    @Transactional
    public void updatePetType(PetType petType) {
        em.merge(petType);
    }

    @Override
    @Transactional
    public void deletePetType(Long id) {
        PetType petType = em.find(PetType.class,id);
        em.remove(petType);
    }
}

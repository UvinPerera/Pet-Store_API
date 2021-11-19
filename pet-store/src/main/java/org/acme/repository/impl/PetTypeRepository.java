package org.acme.repository.impl;

import org.acme.models.PetType;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class PetTypeRepository implements org.acme.repository.PetTypeRepository {
    @Inject
    EntityManager em;

    @Override
    public List<PetType> getAllPetTypes() {
        List<PetType> result = em.createQuery("Select pt from PetType pt",PetType.class).getResultList();
        return result;
    }

    @Override
    public List<PetType> getPetType(String type) {
        List<PetType> result = em.createQuery("Select pt from PetType pt where pt.type="+type,PetType.class).getResultList();
        return result;
    }
}

package de.ronios.superheroes.antiHero.repository;

import de.ronios.superheroes.antiHero.entity.AntiHeroEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AntiHeroRepository extends CrudRepository<AntiHeroEntity, UUID> {
}
package de.ronios.superheroes.antiHero.service;

import de.ronios.superheroes.antiHero.entity.AntiHeroEntity;
import de.ronios.superheroes.antiHero.exception.NotFoundException;
import de.ronios.superheroes.antiHero.repository.AntiHeroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AntiHeroService {
    private final AntiHeroRepository antiHeroRepository;
    public Iterable<AntiHeroEntity> findAllAntiHeroes() {
        return antiHeroRepository.findAll();
    }
    public AntiHeroEntity findAntiHeroById(UUID id) {
        return findOrThrow(id);
    }
    public void removeAntiHeroById(UUID id) {
        findOrThrow(id);
        antiHeroRepository.deleteById(id);
    }
    public AntiHeroEntity addAntiHero(AntiHeroEntity antiHero) {
        return antiHeroRepository.save(antiHero);
    }
    public void updateAntiHero(UUID id, AntiHeroEntity antiHero) {
        findOrThrow(id);
        antiHeroRepository.save(antiHero);
    }

    private AntiHeroEntity findOrThrow(final UUID id) {
        return antiHeroRepository
                .findById(id)
                .orElseThrow(
                        () -> new NotFoundException("Anti-hero by id " + id + " was not found")
                );
    }
}

package de.ronios.superheroes.antiHero.controller;

import de.ronios.superheroes.antiHero.dto.AntiHeroDto;
import de.ronios.superheroes.antiHero.entity.AntiHeroEntity;
import de.ronios.superheroes.antiHero.service.AntiHeroService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/anti-heroes")
public class AntiHeroController {
    private final AntiHeroService service;
    private final ModelMapper mapper;

    private AntiHeroDto convertToDto(AntiHeroEntity entity) {
        return mapper.map(entity, AntiHeroDto.class);
    }

    private AntiHeroEntity convertToEntity(AntiHeroDto dto) {
        return mapper.map(dto, AntiHeroEntity.class);
    }
}

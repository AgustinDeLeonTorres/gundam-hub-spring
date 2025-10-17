package com.agustindlg.gundam_hub_spring.application.service;

import com.agustindlg.gundam_hub_spring.domain.model.Universe;
import com.agustindlg.gundam_hub_spring.domain.repository.IUniverseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniverseServiceImpl implements IUniverseService {

    private final IUniverseRepository IUniverseRepository;

    @Autowired
    public UniverseServiceImpl(IUniverseRepository IUniverseRepository) {
        this.IUniverseRepository = IUniverseRepository;
    }

    @Override
    public List<Universe> getAllUniverses() {
        return IUniverseRepository.findAll();
    }

    @Override
    public Optional<Universe> getUniverseById(Long id) {
        return IUniverseRepository.findById(id);
    }

    @Override
    public Universe saveUniverse(Universe universe) {
        return IUniverseRepository.save(universe);
    }

    @Override
    public void deleteUniverse(Long id) {
        IUniverseRepository.deleteById(id);
    }
}
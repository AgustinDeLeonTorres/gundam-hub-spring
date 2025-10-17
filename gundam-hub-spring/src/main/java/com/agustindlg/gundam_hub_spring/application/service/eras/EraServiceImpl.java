package com.agustindlg.gundam_hub_spring.application.service;

import com.agustindlg.gundam_hub_spring.domain.model.Era;
import com.agustindlg.gundam_hub_spring.domain.repository.IEraRepository;
import com.agustindlg.gundam_hub_spring.application.service.IEraService; //com.agustindlg.gundam_hub_spring.service.IEraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EraServiceImpl implements IEraService {

    private final IEraRepository eraRepository;

    @Autowired
    public EraServiceImpl(IEraRepository eraRepository) {
        this.eraRepository = eraRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Era> findAll() {
        return eraRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Era> findById(Long id) {
        return eraRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Era> findByUniverseId(Long universeId) {
        return eraRepository.findByUniverseIdOrderByChronologicalOrder(universeId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Era> findCanonicalByUniverseId(Long universeId) {
        return eraRepository.findByUniverseIdAndIsCanonicalOrderByChronologicalOrder(universeId, true);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Era> findByNameContaining(String name) {
        return eraRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Era save(Era era) {
        return eraRepository.save(era);
    }

    @Override
    public void deleteById(Long id) {
        eraRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(Long id) {
        return eraRepository.existsById(id);
    }
}
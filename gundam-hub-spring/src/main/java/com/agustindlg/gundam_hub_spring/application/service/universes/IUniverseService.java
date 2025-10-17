package com.agustindlg.gundam_hub_spring.application.service;

import com.agustindlg.gundam_hub_spring.domain.model.Universe;
import java.util.List;
import java.util.Optional;

public interface IUniverseService {
    List<Universe> getAllUniverses();
    Optional<Universe> getUniverseById(Long id);
    Universe saveUniverse(Universe universe);
    void deleteUniverse(Long id);
}
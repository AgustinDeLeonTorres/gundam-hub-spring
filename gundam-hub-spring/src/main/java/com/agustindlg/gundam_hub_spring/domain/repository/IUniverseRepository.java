package com.agustindlg.gundam_hub_spring.domain.repository;

import com.agustindlg.gundam_hub_spring.domain.model.Universe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUniverseRepository extends JpaRepository<Universe, Long> {
    Optional<Universe> findByName(String name);
}

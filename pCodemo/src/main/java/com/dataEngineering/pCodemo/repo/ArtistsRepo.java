package com.dataEngineering.pCodemo.repo;

import com.dataEngineering.pCodemo.entity.Artists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArtistsRepo extends JpaRepository<Artists,Long> {
}

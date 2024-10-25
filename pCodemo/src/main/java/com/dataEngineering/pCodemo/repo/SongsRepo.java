package com.dataEngineering.pCodemo.repo;

import com.dataEngineering.pCodemo.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SongsRepo extends JpaRepository<Song,Long> {
}

package com.dataEngineering.pCodemo.service;

import com.dataEngineering.pCodemo.dto.ArtistDto;

import java.util.List;

public interface ArtistService {
    ArtistDto createArtist(ArtistDto artistDto);

    ArtistDto getArtistsById(Long artistsID);

    List<ArtistDto> getAllArtists();

    ArtistDto updateArtist(long artistId, ArtistDto updatedArtists);

    void deleteArtist(Long artistId);
}

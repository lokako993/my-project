package com.dataEngineering.pCodemo.service.imp;

import com.dataEngineering.pCodemo.dto.ArtistDto;
import com.dataEngineering.pCodemo.entity.Artists;
import com.dataEngineering.pCodemo.exception.ResourceNotFoundException;
import com.dataEngineering.pCodemo.mapper.ArtistMapper;
import com.dataEngineering.pCodemo.repo.ArtistsRepo;
import com.dataEngineering.pCodemo.service.ArtistService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ArtistServiceImp implements ArtistService {

    private ArtistsRepo artistsRepo;

    @Override
    public ArtistDto createArtist(ArtistDto artistDto) {

        Artists artists = ArtistMapper.mapToArtists(artistDto);
        Artists saveArtist = artistsRepo.save(artists);
            return ArtistMapper.mapToArtitstDto(saveArtist);

    }

    @Override
    public ArtistDto getArtistsById(Long artistsID) {
        Artists artists= artistsRepo.findById(artistsID)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Artist is not exisst with given id: " + artistsID));
        return ArtistMapper.mapToArtitstDto(artists);
    }

    @Override
    public List<ArtistDto> getAllArtists() {
        List<Artists> artists= artistsRepo.findAll();
        return artists.stream().map((artist) -> ArtistMapper.mapToArtitstDto(artist)).collect(Collectors.toList());
    }

    @Override
    public ArtistDto updateArtist(long artistId, ArtistDto updatedArtists) {
        Artists artists = artistsRepo.findById(artistId).orElseThrow(
                () -> new ResourceNotFoundException("Artist is not exist with given id:" + artistId)
        );
        artists.setName(updatedArtists.getName());
        artists.setBeginYear(updatedArtists.getBeginYear());
        artists.setEndYear(updatedArtists.getEndYear());
        artists.setLocation(updatedArtists.getLocation());
        artists.setTyp(updatedArtists.getTyp());
        artists.setGender(updatedArtists.getGender());

        Artists updatedArtistObj = artistsRepo.save(artists);

        return ArtistMapper.mapToArtitstDto(updatedArtistObj);
    }

    @Override
    public void deleteArtist(Long artistId) {
        Artists artists = artistsRepo.findById(artistId).orElseThrow(
                () -> new ResourceNotFoundException("Artist is not exist with given id:" + artistId)
        );

        artistsRepo.deleteById(artistId);
    }
}

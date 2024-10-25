package com.dataEngineering.pCodemo.mapper;

import com.dataEngineering.pCodemo.dto.ArtistDto;
import com.dataEngineering.pCodemo.entity.Artists;

public class ArtistMapper {

    public static ArtistDto mapToArtitstDto(Artists artists){
        return new ArtistDto(
                artists.getId(),
                artists.getName(),
                artists.getBeginYear(),
                artists.getEndYear(),
                artists.getLocation(),
                artists.getTyp(),
                artists.getGender()
        );
    }
    public static Artists mapToArtists(ArtistDto artistsDto){
        return new Artists(
                artistsDto.getId(),
                artistsDto.getName(),
                artistsDto.getBeginYear(),
                artistsDto.getEndYear(),
                artistsDto.getLocation(),
                artistsDto.getTyp(),
                artistsDto.getGender()
        );
    }
}

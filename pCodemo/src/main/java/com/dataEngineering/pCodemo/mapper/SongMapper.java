package com.dataEngineering.pCodemo.mapper;

import com.dataEngineering.pCodemo.dto.SongDto;
import com.dataEngineering.pCodemo.entity.Song;

public class SongMapper {

    public static Song mapToSong(SongDto songDto){
        return new Song(
                songDto.getId(),
                songDto.getTitle(),
                songDto.getJaehr(),
                songDto.getKuenstId()
                );
    }

    public static SongDto mapToSongDto(Song song){
        return new SongDto(
                song.getId(),
                song.getTitle(),
                song.getJaehr(),
                song.getKuenstId()
        );
    }
}

package com.dataEngineering.pCodemo.service;

import com.dataEngineering.pCodemo.dto.SongDto;

import java.util.List;

public interface SongService {

    SongDto createSong(SongDto songDto);
    SongDto getSongById(Long songId);
    List<SongDto> getAllSongs();
    SongDto updateSong(long songId, SongDto updateSongs);
    void deleteSong(Long songId);
}

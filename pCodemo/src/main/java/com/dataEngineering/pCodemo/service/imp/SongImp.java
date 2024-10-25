package com.dataEngineering.pCodemo.service.imp;

import com.dataEngineering.pCodemo.dto.SongDto;
import com.dataEngineering.pCodemo.entity.Song;
import com.dataEngineering.pCodemo.exception.ResourceNotFoundException;
import com.dataEngineering.pCodemo.mapper.SongMapper;
import com.dataEngineering.pCodemo.repo.SongsRepo;
import com.dataEngineering.pCodemo.service.SongService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class SongImp implements SongService {

    private SongsRepo songsRepo;

    @Override
    public SongDto createSong(SongDto songDto) {
        Song song = SongMapper.mapToSong(songDto);
        Song saveSong = songsRepo.save(song);
        return SongMapper.mapToSongDto(saveSong);
    }

    @Override
    public SongDto getSongById(Long songId) {
        Song song = songsRepo.findById(songId)
                .orElseThrow(() -> new ResourceNotFoundException("Song is not exist eith given Id: "+ songId));
        return SongMapper.mapToSongDto(song);
    }

    @Override
    public List<SongDto> getAllSongs() {
        List<Song> songs = songsRepo.findAll();

        return songs.stream().map((song) -> SongMapper.mapToSongDto(song)).collect(Collectors.toList());
    }

    @Override
    public SongDto updateSong(long songId, SongDto updatedSongs) {
        Song song = songsRepo.findById(songId).orElseThrow(
                () -> new RuntimeException("Song is not exist with given id: "+ songId));
        song.setJaehr(updatedSongs.getJaehr());
        song.setTitle(updatedSongs.getTitle());
        song.setKuenstId(updatedSongs.getKuenstId());

        Song updatedSongObj =songsRepo.save(song);

        return SongMapper.mapToSongDto(updatedSongObj);
    }

    @Override
    public void deleteSong(Long songId) {
        Song song = songsRepo.findById(songId).orElseThrow(
                () -> new ResourceNotFoundException("Song is not exist withgiven id : "+songId)
        );
        songsRepo.deleteById(songId);

    }
}

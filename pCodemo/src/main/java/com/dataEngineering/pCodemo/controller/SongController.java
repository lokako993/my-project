package com.dataEngineering.pCodemo.controller;

import com.dataEngineering.pCodemo.dto.SongDto;
import com.dataEngineering.pCodemo.service.SongService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/song")
public class SongController {
    private SongService songService;

    @PostMapping
    public ResponseEntity<SongDto> createSong(@RequestBody SongDto songDto){
        SongDto savedSong = songService.createSong(songDto);
        return new ResponseEntity<>(savedSong, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<SongDto> getSongById(@PathVariable("id") Long songId){
        SongDto songDto = songService.getSongById(songId);
        return ResponseEntity.ok(songDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<SongDto> updateSong(@PathVariable("id") Long songId
                                            , @RequestBody SongDto updatedSong){
        SongDto songDto = songService.updateSong(songId, updatedSong);
        return ResponseEntity.ok(songDto);
    }

    public ResponseEntity<String> deletSong(@PathVariable("id") Long songId){
        songService.deleteSong((songId));
        return ResponseEntity.ok("Song deleted successfully!");
    }
}

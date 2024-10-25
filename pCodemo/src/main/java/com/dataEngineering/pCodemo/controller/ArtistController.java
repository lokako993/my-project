package com.dataEngineering.pCodemo.controller;

import com.dataEngineering.pCodemo.dto.ArtistDto;
import com.dataEngineering.pCodemo.service.ArtistService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/artists")
public class ArtistController {

    private ArtistService artistService;

    //Build artist REST API
    @PostMapping
    public ResponseEntity<ArtistDto> createArtist(@RequestBody ArtistDto artistDto){
        ArtistDto savedArtist = artistService.createArtist(artistDto);
        return new ResponseEntity<>(savedArtist, HttpStatus.CREATED);
    }

    // Build Get Artist REST API
    @GetMapping("{id}")
    public ResponseEntity<ArtistDto> getArtistById(@PathVariable("id") Long artistId){
       ArtistDto artistDto = artistService.getArtistsById(artistId);
       return ResponseEntity.ok(artistDto);
    }

    //Build GET ALL Artists REST API
    @GetMapping
    public ResponseEntity<List<ArtistDto>> getAllArtists(){
        List<ArtistDto> artists = artistService.getAllArtists();
        return ResponseEntity.ok(artists);
    }

    @PutMapping("{id}")
    public ResponseEntity<ArtistDto> updateArtists(@PathVariable("id") Long artistsId,
                                                   @RequestBody ArtistDto updatedArtists){
        ArtistDto artistDto = artistService.updateArtist(artistsId, updatedArtists);
        return ResponseEntity.ok(artistDto);
    }

    //Build Delete Artist API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteArtist(@PathVariable("id") Long artistId){
        artistService.deleteArtist(artistId);
        return ResponseEntity.ok("Artist deleted successfully!.");
    }
}

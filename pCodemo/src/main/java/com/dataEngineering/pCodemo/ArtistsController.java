package com.dataEngineering.pCodemo;

import com.dataEngineering.pCodemo.entity.Artists;
import com.dataEngineering.pCodemo.repo.ArtistsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArtistsController {

    @Autowired
    ArtistsRepo repo;

    @PostMapping("/addArtists")
    public void addArtists(@RequestBody Artists artists){
        repo.save(artists);
    }
}

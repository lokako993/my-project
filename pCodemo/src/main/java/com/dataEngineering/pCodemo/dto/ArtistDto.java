package com.dataEngineering.pCodemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArtistDto {

    private Long id;
    private String name;
    private int beginYear;
    private int endYear;
    private String location;
    private String typ;
    private String gender;

}

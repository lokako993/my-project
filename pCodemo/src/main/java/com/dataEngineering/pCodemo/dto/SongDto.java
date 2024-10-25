package com.dataEngineering.pCodemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SongDto {

    private Long id;
    private String title;
    private int jaehr;
    private int kuenstId;
}

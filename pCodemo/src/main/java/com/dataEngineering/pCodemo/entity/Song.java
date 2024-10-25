package com.dataEngineering.pCodemo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Table(name = "Songs")
@Entity
@NoArgsConstructor
public class Song {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(name ="Titel")
    private String title;
    @Column(name = "Jaehr")
    private int jaehr;
    @Column(name = "KuenstId")
    private int kuenstId;
}

package com.dataEngineering.pCodemo.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "artists")
public class Artists {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //this column name will be pased in table name
    @Column(name = "Name")
    private String name;
    @Column(name = "BeginYear")
    private int beginYear;

    @Column(name = "EndYear")
    private int endYear;

    @Column(name = "Location")
    private String location;

    @Column(name = "Typ")
    private String typ;

    @Column(name = "Gender")
    private String gender;





}

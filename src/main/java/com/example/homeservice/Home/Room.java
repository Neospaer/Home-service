package com.example.homeservice.Home;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name_room")
    private String name;

    @Column(name = "home_id",insertable = false,updatable = false)
    private long homeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_id",referencedColumnName = "id")
    @JsonBackReference
    private Home home;
}

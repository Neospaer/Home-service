package com.example.homeservice.Home;

import com.example.homeservice.Request.HomeRequest;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NamedEntityGraph(
        name = "home-entity-graph-with-rooms",
        attributeNodes = {@NamedAttributeNode("rooms")}
)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "homes")
public class Home {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Integer id;
   @Column(name = "name")
   private String name;
   @Column(name = "address")
   private String address;
   @OneToMany(mappedBy = "home",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
   @JsonBackReference
   private List<Room> rooms = new ArrayList<>();

}

package com.example.homeservice.Repositories;

import com.example.homeservice.Home.Home;
import lombok.NonNull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HomeRepositoies extends JpaRepository<Home,Integer> {

    @EntityGraph(value = "home-entity-graph-with-rooms", type = EntityGraph.EntityGraphType.LOAD)
    Optional<Home> findById(@NonNull Long aLong);
    @EntityGraph(value = "home-entity-graph-with-rooms", type = EntityGraph.EntityGraphType.LOAD)
    <S extends Home> S save(@NonNull S entity);
}

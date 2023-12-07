package com.example.homeservice.Repositories;

import com.example.homeservice.Home.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepositories extends JpaRepository<Room,Integer> {
}

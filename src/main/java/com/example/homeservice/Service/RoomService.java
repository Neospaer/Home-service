package com.example.homeservice.Service;

import com.example.homeservice.Home.Room;
import com.example.homeservice.Request.RoomRequest;

public interface RoomService {
    Room createRoom(Integer homeId, RoomRequest roomRequest);
    Room putRoom(Integer roomId,RoomRequest roomRequest);
    void deleteRoom(Integer id);
}

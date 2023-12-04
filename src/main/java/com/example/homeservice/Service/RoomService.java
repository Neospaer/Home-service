package com.example.homeservice.Service;

import com.example.homeservice.Home.Room;
import com.example.homeservice.Request.RoomRequest;

public interface RoomService {
    Room createRoom(Long homeId, RoomRequest roomRequest);
    Room putRoom(Long roomId,RoomRequest roomRequest);
    void deleteRoom(Long id);
}

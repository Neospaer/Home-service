package com.example.homeservice.Controller;


import com.example.homeservice.Home.Room;
import com.example.homeservice.Request.RoomRequest;
import com.example.homeservice.Service.RoomService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService){
        this.roomService = roomService;
    }

    @PostMapping("/rooms")
    public ResponseEntity<Room> createHome(@RequestParam Integer homeId, @Valid @RequestBody RoomRequest roomRequest){
        Room room = roomService.createRoom(homeId, roomRequest);
        return ResponseEntity.ok(room);
    }

    @PutMapping("/rooms/{id}")
    public ResponseEntity<Room> putHome(@PathVariable Integer id, @Valid @RequestBody RoomRequest roomRequest){
        Room room = roomService.putRoom(id, roomRequest);
        return ResponseEntity.ok(room);
    }

    @DeleteMapping("/rooms/{id}")
    public void deleteRooms(@PathVariable Integer id){
        roomService.deleteRoom(id);
    }
}

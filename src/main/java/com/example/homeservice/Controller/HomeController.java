package com.example.homeservice.Controller;

import com.example.homeservice.Home.Home;
import com.example.homeservice.Request.HomeRequest;
import com.example.homeservice.Service.HomeService;
import com.example.homeservice.Service.HomeServiceimpl;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@Getter
@Setter
@RestController
@RequestMapping("/homeService")
public class HomeController {
    private final HomeService homeService;
    public HomeController(HomeService homeService){
        this.homeService = homeService;
    }

    @PostMapping("/post")
    public ResponseEntity<Home> createHome(@RequestBody @Valid HomeRequest request){
        Home home = homeService.createHome(request);
        return ResponseEntity.ok(home);
    }

    @Autowired
    public HomeController(HomeServiceimpl homeServiceimpl) {
        this.homeService = homeServiceimpl;
    }

    @GetMapping("/get")
    public Home getHome(@RequestParam("id") int targetId){
        List<Home> homeList = homeService.getHome();
        for(Home home: homeList){
            if(home.getId() == targetId) {
                return home;
            }
        }
        return null;
    }

    @GetMapping("/getAll")
    public List<Home> getAllElements() {
        return homeService.getHome();
    }

    @DeleteMapping("/delete")
    public boolean deleteElementById(int id) {
        List<Home> homeList = homeService.getHome();
        Iterator<Home> iterator = homeList.iterator();
        while (iterator.hasNext()) {
            Home element = iterator.next();
            if (element.getId() == id) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
    @PutMapping("/put")
    public boolean updateElementById(int id, Home updatedElement) {
        List<Home> homeList = homeService.getHome();
        for (Home element : homeList) {
            if (element.getId() == id) {
                element.setName(updatedElement.getName());
                element.setAddress(updatedElement.getAddress());
                return true;
            }
        }
        return false; // Элемент с указанным id не найден
    }
}

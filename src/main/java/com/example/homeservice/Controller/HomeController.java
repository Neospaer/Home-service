package com.example.homeservice.Controller;

import com.example.homeservice.Home.Home;
import com.example.homeservice.Request.HomeRequest;
import com.example.homeservice.Service.HomeService;
import jakarta.persistence.Id;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@RestController
@RequestMapping(value = "/api",produces = MediaType.APPLICATION_JSON_VALUE)
public class HomeController {
    private final HomeService homeService;
    public HomeController(HomeService homeService){
        this.homeService = homeService;
    }

    @PostMapping("/homes")
    public ResponseEntity<Home> createHome(@RequestBody @Valid HomeRequest request){
        Home home = homeService.createHome(request);
        return ResponseEntity.ok(home);
    }
    @PutMapping("/homes/{id}")
    public ResponseEntity<Home> putHome(@RequestBody @Valid Home put){
        Home home = homeService.putHome(put);
        return ResponseEntity.ok(home);
    }
    @GetMapping("/homes")
    public ResponseEntity<List<Home>> getHome(){
        return new ResponseEntity<>(homeService.getHome(), HttpStatus.OK);
    }
    @GetMapping("/home/{id}")
    public Optional<Home> getHomeId(@PathVariable Integer id){
        return homeService.getHomeId(id);
    }
    @DeleteMapping("/homes/{id}")
    public void deleteHome(@PathVariable Integer id){
        homeService.deleteHome(id);
    }
}
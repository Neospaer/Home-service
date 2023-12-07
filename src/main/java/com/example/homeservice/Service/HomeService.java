package com.example.homeservice.Service;

import com.example.homeservice.Home.Home;
import com.example.homeservice.Request.HomeRequest;

import java.util.List;
import java.util.Optional;

public interface HomeService {
    Home createHome(HomeRequest request);
    List<Home> getHome();
    Optional<Home> getHomeId(Integer id);
    Home putHome(Home home);
    void deleteHome(Integer id);

}

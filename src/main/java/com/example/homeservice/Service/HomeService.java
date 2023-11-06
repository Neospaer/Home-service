package com.example.homeservice.Service;

import com.example.homeservice.Home.Home;
import com.example.homeservice.Request.HomeRequest;

import java.util.List;

public interface HomeService {
    Home createHome(HomeRequest homeRequest);

    List<Home> getHome();


}

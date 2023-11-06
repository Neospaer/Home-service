package com.example.homeservice.Service;

import com.example.homeservice.Home.Home;
import com.example.homeservice.Request.HomeRequest;
import com.example.homeservice.Service.HomeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class HomeServiceimpl implements HomeService {
    public final List<Home> homeList = new ArrayList<>();
    public Integer count = 1;
    public Home createHome(HomeRequest homeRequest){
        Home home = new Home();
        home.create(homeRequest,count);
        homeList.add(home);
        count++;
        return home;
    }
    public List<Home> getHome() {
        return homeList;
    }
}

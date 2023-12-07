package com.example.homeservice.Service;

import com.example.homeservice.Home.Home;
import com.example.homeservice.Repositories.HomeRepositories;
import com.example.homeservice.Request.HomeRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class HomeServiceImpl implements HomeService{

    private final HomeRepositories homeRepositories;

    @Override
    public Home createHome(HomeRequest homeRequest){
        return homeRepositories.save(Home.builder()
                .name(homeRequest.getName())
                .address(homeRequest.getAddress())
                .build());
    }
    @Override
    public List<Home> getHome() {
        return homeRepositories.findAll();
    }
    @Override
    public Optional<Home> getHomeId(Integer id){
        return homeRepositories.findById(id);
    }
    @Override
    public Home putHome(Home home){
        return homeRepositories.save(home);
    }
    @Override
    public void deleteHome(Integer id){
        homeRepositories.deleteById(id);
    }

}

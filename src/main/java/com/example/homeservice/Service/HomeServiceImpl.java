package com.example.homeservice.Service;

import com.example.homeservice.Home.Home;
import com.example.homeservice.Repositories.HomeRepositoies;
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

    private final HomeRepositoies homeRepositoies;

    @Override
    public List<Home> getHome() {
        return homeRepositoies.findAll();
    }

    @Override
    public Home createHome(HomeRequest homeRequest){
        return homeRepositoies.save(Home.builder()
                .name(homeRequest.getName())
                .address(homeRequest.getAddress())
                .build());
    }
    @Override
    public Home putHome(Home home){
        return homeRepositoies.save(home);
    }

    @Override
    public Optional<Home> getHomeId(Integer id){
        return homeRepositoies.findById(id);
    }

    @Override
    public void deleteHome(Integer id){
        homeRepositoies.deleteById(id);
    }

}

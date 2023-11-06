package com.example.homeservice.Home;

import com.example.homeservice.Request.HomeRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Home {
   private Integer id;

   private String name;

   private String address;

   public void create(HomeRequest homeRequest, Integer id){
      this.id = id;
      this.name = homeRequest.getName();
      this.address = homeRequest.getAddress();
   }

}

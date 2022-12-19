package com.learning.s2s.client;

import com.learning.s2s.shared.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "car-client", url= "${s2s.url}")
public interface CarClient {

    @GetMapping("/cars")
    List<Car> getAllCars();
}

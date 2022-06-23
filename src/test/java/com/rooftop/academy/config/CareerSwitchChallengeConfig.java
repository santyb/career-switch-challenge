package com.rooftop.academy.config;

import com.rooftop.academy.service.CareerSwitchChallengeService;
import com.rooftop.academy.service.impl.CareerSwitchChallengeServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CareerSwitchChallengeConfig {

    @Bean
    public CareerSwitchChallengeService careerSwitchChallengeService() {
        return new CareerSwitchChallengeServiceImpl();
    }

}

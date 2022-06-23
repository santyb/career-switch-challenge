package com.rooftop.academy;

import com.rooftop.academy.config.CareerSwitchChallengeConfig;
import com.rooftop.academy.dto.BlocksDTO;
import com.rooftop.academy.dto.CheckApiResponse;
import com.rooftop.academy.service.impl.CareerSwitchChallengeServiceImpl;
import com.rooftop.academy.util.CareerSwitchChallengeATestsUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {CareerSwitchChallengeConfig.class})
@ExtendWith(MockitoExtension.class)
class CareerSwitchChallengeApplicationTests {

    @MockBean
    private RestTemplate restTemplate;

    @Autowired
    @InjectMocks
    private CareerSwitchChallengeServiceImpl challengeService;

    private BlocksDTO blocksRequest;

    @BeforeEach
    void setUp() {
        blocksRequest = CareerSwitchChallengeATestsUtils.blocksRequestMock();
    }

    @Test
    void contextLoads() {
    }

    @Test
    void checkBlocksService() {
        when(restTemplate.postForObject(anyString(), any(Object.class), eq(CheckApiResponse.class))).thenReturn(CareerSwitchChallengeATestsUtils.checkResponse());
        BlocksDTO response = challengeService.check(blocksRequest, "token");

        Assertions.assertNotNull(response);
    }
}

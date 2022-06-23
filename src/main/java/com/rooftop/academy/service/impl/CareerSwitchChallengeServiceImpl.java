package com.rooftop.academy.service.impl;

import com.rooftop.academy.dto.BlocksDTO;
import com.rooftop.academy.dto.CheckApiResponse;
import com.rooftop.academy.service.CareerSwitchChallengeService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.rooftop.academy.constants.CareerSwitchChallengeConstants.POST_CHECK_API;

/**
 * This is a Career Switch Challenge Service Implementation
 *
 * @author Santiago Botero Madrid
 * @since 21.06.2022
 */
@Service
public class CareerSwitchChallengeServiceImpl implements CareerSwitchChallengeService {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    private RestTemplate restTemplate = new RestTemplate();

    private String uriBuilder;

    /**
     * Check blocks
     *
     * @param blocks object request
     * @param token user token
     * @return BlocksDTO ordered block response
     */
    @Override
    public BlocksDTO check(BlocksDTO blocks, String token) {
        logger.log(Level.INFO, "Entering into CareerSwitchChallengeServiceImpl.check()");

        BlocksDTO blocksResponse = new BlocksDTO();
        uriBuilder = UriComponentsBuilder.fromUriString(POST_CHECK_API)
                .queryParam("token", token)
                .build()
                .toUriString();

        List<String> blockList = blocks.getBlocks();

        List<String> orderedBlocksList = new ArrayList<>();

        orderedBlocksList.add(blockList.get(0));
        blockList.remove(0);

        orderBlockList(blockList, orderedBlocksList);

        blocksResponse.setBlocks(orderedBlocksList);

        logger.log(Level.INFO, "Exiting CareerSwitchChallengeServiceImpl.check()");

        return blocksResponse;
    }

    /**
     * Method to order BlockList
     *
     * @param blockList block list request
     * @param orderedBlocksList ordered block list
     *
     */
    private void orderBlockList(List<String> blockList, List<String> orderedBlocksList) {
        logger.log(Level.INFO, "Exiting CareerSwitchChallengeServiceImpl.orderBlockList()");
        Boolean isNext;

        for (int i = 0; i < blockList.size(); i++) {

            if (blockList.size() == 1) {
                orderedBlocksList.add(blockList.get(0));
                blockList.remove(blockList.get(0));
                break;
            }

            BlocksDTO blocksDTO = new BlocksDTO();

            int lastIndex = orderedBlocksList.size() - 1;

            blocksDTO.setBlocks(Arrays.asList(orderedBlocksList.get(lastIndex), blockList.get(i)));

            isNext = callApiVerifyNextElement(blocksDTO);

            if (Boolean.TRUE.equals(isNext)) {
                orderedBlocksList.add(blockList.get(i));
                blockList.remove(blockList.get(i));
            }
        }
        if (!blockList.isEmpty()) {
            orderBlockList(blockList, orderedBlocksList);
        }
    }

    /**
     * Call Api Verify Next Element
     *
     * @param blocksDTO block list request
     * @response Boolean
     *
     */
    private Boolean callApiVerifyNextElement(BlocksDTO blocksDTO) {
        logger.log(Level.INFO, "Exiting CareerSwitchChallengeServiceImpl.callApiVerifyNextElement()");

        CheckApiResponse checkApiResponse;
        checkApiResponse = restTemplate.postForObject(uriBuilder, blocksDTO, CheckApiResponse.class);
        logger.log(Level.INFO, "Exiting CareerSwitchChallengeServiceImpl.callApiVerifyNextElement()");

        return checkApiResponse.isMessage();
    }
}

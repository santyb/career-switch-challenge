package com.rooftop.academy.controller;

import com.rooftop.academy.dto.BlocksDTO;
import com.rooftop.academy.exceptions.BusinessException;
import com.rooftop.academy.service.impl.CareerSwitchChallengeServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.rooftop.academy.constants.CareerSwitchChallengeConstants.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * This is the Career Switch Controller class.
 *
 * @author Santiago Botero Madrid
 * @since 20.06.2022
 */

@RestController
@RequestMapping(value = CAREER_SWITCH_SERVICE)
@Tag(name = "Career Switch Challenge")
public class CareerSwitchChallengeController {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    CareerSwitchChallengeServiceImpl careerSwitchChallengeService;

    /**
     * check
     *
     * @param blocks blocks request object
     * @param token  unique environment token
     * @return ResponseEntity<BlocksDTO> wrapper response
     */
    @PostMapping(value = CHECK, produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "This API Allows to order a block list")
    public ResponseEntity<BlocksDTO> check(@Parameter(description = "blocks", required = true) @RequestBody BlocksDTO blocks,
                                               @Parameter(description = "Token", required = true)
                                               @RequestParam(value = "token") String token) {

        logger.log(Level.INFO, "Entering into CareerSwitchChallengeController.checkBlocks()");
        BlocksDTO response;
        try {
            response = careerSwitchChallengeService.check(blocks, token);
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        logger.log(Level.INFO, "Exiting CareerSwitchChallengeController.checkBlocks()");

        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }
}

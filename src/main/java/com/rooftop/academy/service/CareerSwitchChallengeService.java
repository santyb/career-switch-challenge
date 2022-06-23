package com.rooftop.academy.service;

import com.rooftop.academy.dto.BlocksDTO;
import com.rooftop.academy.dto.CheckApiResponse;

/**
 * This is an interface for Career Switch Controller
 *
 * @author Santiago Botero Madrid
 * @since 20.06.2022
 */
public interface CareerSwitchChallengeService {
    BlocksDTO check (BlocksDTO blocks, String token);
}

package org.sysone.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sysone.domain.Candidate;

@RestController
public class DeveloperInfoController {

    public static final Logger LOGGER = LoggerFactory.getLogger(DeveloperInfoController.class);

    public static final String CANDIDATE_NAME = "Cesar Vega";

    @GetMapping(value = "/candidate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Candidate> candidate(){
        LOGGER.info("Candidate: {} ", CANDIDATE_NAME);
        return ResponseEntity.ok(new Candidate(CANDIDATE_NAME));
    }
}

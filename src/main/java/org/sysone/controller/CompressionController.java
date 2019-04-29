package org.sysone.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.sysone.domain.RequestData;
import org.sysone.domain.ResponseData;
import org.sysone.service.SysOneCompressorService;

import javax.validation.Valid;

@RestController
public class CompressionController {

    public static final Logger LOGGER = LoggerFactory.getLogger(CompressionController.class);

    @Autowired
    private SysOneCompressorService compressor;

    @PostMapping(value = "/compress", consumes = MediaType.APPLICATION_JSON_VALUE,
                                      produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData> compress(@Valid @RequestBody RequestData req){
        ResponseData resp = new ResponseData();
        resp.setCompressed(compressor.compress(req.getValue()));
        LOGGER.info("Raw Value: {}, Compressed Value: {} ", req.getValue(), resp.getCompressed());
        return ResponseEntity.ok(resp);
    }
}

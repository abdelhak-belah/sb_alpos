package com.amenass.sb_alpos.dao.discover;

import com.amenass.sb_alpos.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.Map;

import static com.amenass.sb_alpos.keys.EndpointKey.ENDPOINT_DISCOVER;
import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

@Controller
@RequiredArgsConstructor
@RequestMapping(ENDPOINT_DISCOVER)
public class DiscoverController {

    private final DiscoverService discoverService;

    @PostMapping("/start")
    public ResponseEntity<ResponseUtil> discoverStart(@RequestBody String CIDR) {
        return ResponseEntity.ok(
                ResponseUtil.builder()
                        .timeStamp(now())
                        .data(Map.of("started", discoverService.discoverStart(CIDR)))
                        .message("Discover started Successfully")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/result")
    public ResponseEntity<ResponseUtil> discoverResult() {
        return discoverService.discoverResult();
    }
}

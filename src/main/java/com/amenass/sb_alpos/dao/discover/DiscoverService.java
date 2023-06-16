package com.amenass.sb_alpos.dao.discover;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class DiscoverService {

    private final DiscoverRepository discoverRepository;


    public Boolean discoverStart(String CIDR) {
        buildDockerImage();
        return true;
    }



    private  void buildDockerImage() {
        // Dockerfile content
        String dockerfileContent =
                "FROM alpine:latest\n" +
                "RUN apk --no-cache add nmap curl\n" +
                "ENTRYPOINT [\"sh\", \"-c\", \"nmap -sn 192.168.1.0/24 | grep 'Nmap scan report' | awk '{print $5}' | xargs -I {} curl -X POST -d 'ip={}' http://host.docker.internal:1997/api/discover/result\"]";

        // Write Dockerfile content to a file
        try {
            File dockerfile = new File("Dockerfile");
            FileWriter writer = new FileWriter(dockerfile);
            writer.write(dockerfileContent);
            writer.close();
        } catch (IOException e) {
            System.err.println("Failed to create Dockerfile: " + e.getMessage());
            return;
        }

        // Create a RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Set the Docker API endpoint URL
        String dockerApiUrl = "http://localhost:2375/build?t=my-image-tag";

        // Create HttpHeaders and set Content-Type header
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        // Create MultiValueMap to hold the Dockerfile data
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("tarfile", new FileSystemResource("Dockerfile"));

        // Create HttpEntity with headers and body
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        // Send the POST request to build the Docker image
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                dockerApiUrl,
                HttpMethod.POST,
                requestEntity,
                String.class
        );

        // Check the response status and handle accordingly
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("Docker image build successful!");
            System.out.println("Image ID: " + responseEntity.getBody());
        } else {
            System.err.println("Docker image build failed. Response code: " + responseEntity.getStatusCode());
        }
    }

}

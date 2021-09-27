package com.yorosoft.serverapi.controller;

import com.yorosoft.serverapi.model.Response;
import com.yorosoft.serverapi.model.Server;
import com.yorosoft.serverapi.service.implementation.ServerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

/**
 * @author Get Arrays (https://www.getarrays.io/)
 * @version 1.0
 * @since 9/4/2021
 */

@RestController
@RequestMapping("/server")
@RequiredArgsConstructor
public class ServerController {
    private final ServerServiceImpl serverService;

    @GetMapping("/list")
    public ResponseEntity<Response> getServers() {
        Map<String, Collection<Server>> collectionMap = new HashMap<>();
        collectionMap.put("servers", serverService.list(30));
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(collectionMap)
                        .message("Servers retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveServer(@RequestBody @Valid Server server) {
        Map<String, Server> map = new HashMap<>();
        map.put("server", serverService.create(server));
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(map)
                        .message("Server created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getServer(@PathVariable("id") Long id) {
        Map<String, Server> map = new HashMap<>();
        map.put("server", serverService.get(id));
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(map)
                        .message("Server retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteServer(@PathVariable("id") Long id) {
        Map<String, Boolean> map = new HashMap<>();
        map.put("deleted", serverService.delete(id));
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(map)
                        .message("Server deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}

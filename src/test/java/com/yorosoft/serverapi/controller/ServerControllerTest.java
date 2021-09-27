package com.yorosoft.serverapi.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.yorosoft.serverapi.enumeration.Status;
import com.yorosoft.serverapi.model.Response;
import com.yorosoft.serverapi.model.Server;
import com.yorosoft.serverapi.repository.ServerRepo;
import com.yorosoft.serverapi.service.implementation.ServerServiceImpl;

import java.util.ArrayList;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class ServerControllerTest {
    @Test
    void testGetServers() throws InterruptedException {
        ServerRepo serverRepo = mock(ServerRepo.class);
        when(serverRepo.findAll((org.springframework.data.domain.Pageable) any()))
                .thenReturn(new PageImpl<Server>(new ArrayList<Server>()));
        ResponseEntity<Response> actualServers = (new ServerController(new ServerServiceImpl(serverRepo))).getServers();
        assertTrue(actualServers.getHeaders().isEmpty());
        assertTrue(actualServers.hasBody());
        assertEquals(HttpStatus.OK, actualServers.getStatusCode());
        Response body = actualServers.getBody();
        assertNull(body.getReason());
        assertEquals("Servers retrieved", body.getMessage());
        assertNull(body.getDeveloperMessage());
        assertEquals(1, body.getData().size());
        assertEquals(HttpStatus.OK, body.getStatus());
        assertEquals(200, body.getStatusCode());
        verify(serverRepo).findAll((org.springframework.data.domain.Pageable) any());
    }

    @Test
    void testGetServers2() {
        ServerRepo serverRepo = mock(ServerRepo.class);
        when(serverRepo.findAll((org.springframework.data.domain.Pageable) any()))
                .thenReturn(new PageImpl<Server>(new ArrayList<Server>()));
        ResponseEntity<Response> actualServers = (new ServerController(new ServerServiceImpl(serverRepo))).getServers();
        assertTrue(actualServers.getHeaders().isEmpty());
        assertTrue(actualServers.hasBody());
        assertEquals(HttpStatus.OK, actualServers.getStatusCode());
        Response body = actualServers.getBody();
        assertNull(body.getReason());
        assertEquals("Servers retrieved", body.getMessage());
        assertNull(body.getDeveloperMessage());
        assertEquals(1, body.getData().size());
        assertEquals(HttpStatus.OK, body.getStatus());
        assertEquals(200, body.getStatusCode());
        verify(serverRepo).findAll((org.springframework.data.domain.Pageable) any());
    }

    @Test
    void testSaveServer() {
        Server server = new Server();
        server.setStatus(Status.SERVER_UP);
        server.setId(123L);
        server.setName("Name");
        server.setMemory("Memory");
        server.setIpAddress("42 Main St");
        server.setType("Type");
        ServerRepo serverRepo = mock(ServerRepo.class);
        when(serverRepo.save((Server) any())).thenReturn(server);
        ServerController serverController = new ServerController(new ServerServiceImpl(serverRepo));

        Server server1 = new Server();
        server1.setStatus(Status.SERVER_UP);
        server1.setId(123L);
        server1.setName("Name");
        server1.setMemory("Memory");
        server1.setIpAddress("42 Main St");
        server1.setType("Type");
        ResponseEntity<Response> actualSaveServerResult = serverController.saveServer(server1);
        assertTrue(actualSaveServerResult.getHeaders().isEmpty());
        assertTrue(actualSaveServerResult.hasBody());
        assertEquals(HttpStatus.OK, actualSaveServerResult.getStatusCode());
        Response body = actualSaveServerResult.getBody();
        assertNull(body.getReason());
        assertEquals("Server created", body.getMessage());
        assertNull(body.getDeveloperMessage());
        assertEquals(1, body.getData().size());
        assertEquals(HttpStatus.CREATED, body.getStatus());
        assertEquals(201, body.getStatusCode());
        verify(serverRepo).save((Server) any());
    }

    @Test
    void testSaveServer2() {
        Server server = new Server();
        server.setStatus(Status.SERVER_UP);
        server.setId(123L);
        server.setName("Name");
        server.setMemory("Memory");
        server.setIpAddress("42 Main St");
        server.setType("Type");
        ServerRepo serverRepo = mock(ServerRepo.class);
        when(serverRepo.save((Server) any())).thenReturn(server);
        ServerController serverController = new ServerController(new ServerServiceImpl(serverRepo));

        Server server1 = new Server();
        server1.setStatus(Status.SERVER_UP);
        server1.setId(123L);
        server1.setName("Name");
        server1.setMemory("Memory");
        server1.setIpAddress("42 Main St");
        server1.setType("Type");
        ResponseEntity<Response> actualSaveServerResult = serverController.saveServer(server1);
        assertTrue(actualSaveServerResult.getHeaders().isEmpty());
        assertTrue(actualSaveServerResult.hasBody());
        assertEquals(HttpStatus.OK, actualSaveServerResult.getStatusCode());
        Response body = actualSaveServerResult.getBody();
        assertNull(body.getReason());
        assertEquals("Server created", body.getMessage());
        assertNull(body.getDeveloperMessage());
        assertEquals(1, body.getData().size());
        assertEquals(HttpStatus.CREATED, body.getStatus());
        assertEquals(201, body.getStatusCode());
        verify(serverRepo).save((Server) any());
    }

    @Test
    void testGetServer() {
        Server server = new Server();
        server.setStatus(Status.SERVER_UP);
        server.setId(123L);
        server.setName("Name");
        server.setMemory("Memory");
        server.setIpAddress("42 Main St");
        server.setType("Type");
        ServerRepo serverRepo = mock(ServerRepo.class);
        when(serverRepo.findById((Long) any())).thenReturn(Optional.<Server>of(server));
        ResponseEntity<Response> actualServer = (new ServerController(new ServerServiceImpl(serverRepo))).getServer(123L);
        assertTrue(actualServer.getHeaders().isEmpty());
        assertTrue(actualServer.hasBody());
        assertEquals(HttpStatus.OK, actualServer.getStatusCode());
        Response body = actualServer.getBody();
        assertNull(body.getReason());
        assertEquals("Server retrieved", body.getMessage());
        assertNull(body.getDeveloperMessage());
        assertEquals(1, body.getData().size());
        assertEquals(HttpStatus.OK, body.getStatus());
        assertEquals(200, body.getStatusCode());
        verify(serverRepo).findById((Long) any());
    }

    @Test
    void testGetServer2() {
        Server server = new Server();
        server.setStatus(Status.SERVER_UP);
        server.setId(123L);
        server.setName("Name");
        server.setMemory("Memory");
        server.setIpAddress("42 Main St");
        server.setType("Type");
        ServerRepo serverRepo = mock(ServerRepo.class);
        when(serverRepo.findById((Long) any())).thenReturn(Optional.<Server>of(server));
        ResponseEntity<Response> actualServer = (new ServerController(new ServerServiceImpl(serverRepo))).getServer(123L);
        assertTrue(actualServer.getHeaders().isEmpty());
        assertTrue(actualServer.hasBody());
        assertEquals(HttpStatus.OK, actualServer.getStatusCode());
        Response body = actualServer.getBody();
        assertNull(body.getReason());
        assertEquals("Server retrieved", body.getMessage());
        assertNull(body.getDeveloperMessage());
        assertEquals(1, body.getData().size());
        assertEquals(HttpStatus.OK, body.getStatus());
        assertEquals(200, body.getStatusCode());
        verify(serverRepo).findById((Long) any());
    }

    @Test
    void testDeleteServer() {
        ServerRepo serverRepo = mock(ServerRepo.class);
        doNothing().when(serverRepo).deleteById((Long) any());
        ResponseEntity<Response> actualDeleteServerResult = (new ServerController(new ServerServiceImpl(serverRepo)))
                .deleteServer(123L);
        assertTrue(actualDeleteServerResult.getHeaders().isEmpty());
        assertTrue(actualDeleteServerResult.hasBody());
        assertEquals(HttpStatus.OK, actualDeleteServerResult.getStatusCode());
        Response body = actualDeleteServerResult.getBody();
        assertNull(body.getReason());
        assertEquals("Server deleted", body.getMessage());
        assertNull(body.getDeveloperMessage());
        assertEquals(1, body.getData().size());
        assertEquals(HttpStatus.OK, body.getStatus());
        assertEquals(200, body.getStatusCode());
        verify(serverRepo).deleteById((Long) any());
    }

    @Test
    void testDeleteServer2() {
        ServerRepo serverRepo = mock(ServerRepo.class);
        doNothing().when(serverRepo).deleteById((Long) any());
        ResponseEntity<Response> actualDeleteServerResult = (new ServerController(new ServerServiceImpl(serverRepo)))
                .deleteServer(123L);
        assertTrue(actualDeleteServerResult.getHeaders().isEmpty());
        assertTrue(actualDeleteServerResult.hasBody());
        assertEquals(HttpStatus.OK, actualDeleteServerResult.getStatusCode());
        Response body = actualDeleteServerResult.getBody();
        assertNull(body.getReason());
        assertEquals("Server deleted", body.getMessage());
        assertNull(body.getDeveloperMessage());
        assertEquals(1, body.getData().size());
        assertEquals(HttpStatus.OK, body.getStatus());
        assertEquals(200, body.getStatusCode());
        verify(serverRepo).deleteById((Long) any());
    }
}


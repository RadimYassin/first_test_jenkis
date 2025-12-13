package com.example.Point.of.sale.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

/**
 * Tests unitaires pour le HelloController.
 * Utilise MockMvc pour tester les endpoints REST sans démarrer le serveur
 * complet.
 */
@WebMvcTest(HelloController.class)
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Test du endpoint GET /
     * Vérifie que la méthode hello() retourne le message attendu
     */
    @Test
    void testHelloEndpoint_ShouldReturnGreeting() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("Hello new test :)"));
    }

    /**
     * Test du endpoint GET /user
     * Vérifie que la méthode getUsers() retourne le message attendu
     */
    @Test
    void testGetUsersEndpoint_ShouldReturnUserMessage() throws Exception {
        mockMvc.perform(get("/user"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("User"));
    }

    /**
     * Test du endpoint GET /presentation
     * Vérifie que la méthode getPresentation() retourne le message attendu
     */
    @Test
    void testGetPresentationEndpoint_ShouldReturnPresentationMessage() throws Exception {
        mockMvc.perform(get("/presentation"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("presentation"));
    }

    /**
     * Test du endpoint GET / - vérifie que la réponse contient le mot "Hello"
     */
    @Test
    void testHelloEndpoint_ShouldContainHelloWord() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello")));
    }

    /**
     * Test du endpoint GET /user - vérifie que la réponse contient le mot "User"
     */
    @Test
    void testGetUsersEndpoint_ShouldContainUserWord() throws Exception {
        mockMvc.perform(get("/user"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("User")));
    }

    /**
     * Test du endpoint GET /presentation - vérifie que la réponse contient le mot
     * "presentation"
     */
    @Test
    void testGetPresentationEndpoint_ShouldContainPresentationWord() throws Exception {
        mockMvc.perform(get("/presentation"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("presentation")));
    }

    /**
     * Test que tous les endpoints retournent un status 200 OK
     */
    @Test
    void testAllEndpoints_ShouldReturn200Status() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().isOk());
        mockMvc.perform(get("/user")).andExpect(status().isOk());
        mockMvc.perform(get("/presentation")).andExpect(status().isOk());
    }

    /**
     * Test qu'un endpoint inexistant retourne 404
     */
    @Test
    void testNonExistentEndpoint_ShouldReturn404() throws Exception {
        mockMvc.perform(get("/nonexistent"))
                .andExpect(status().isNotFound());
    }
}

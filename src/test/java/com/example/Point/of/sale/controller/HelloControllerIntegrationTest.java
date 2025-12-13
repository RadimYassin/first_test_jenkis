package com.example.Point.of.sale.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests d'intégration pour le HelloController.
 * Lance l'application complète avec un port aléatoire pour tester les
 * endpoints.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    /**
     * Test d'intégration du endpoint GET /
     * Vérifie la réponse du serveur réel
     */
    @Test
    void testHelloEndpoint_Integration() {
        String url = "http://localhost:" + port + "/";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("Hello new test :)");
    }

    /**
     * Test d'intégration du endpoint GET /user
     * Vérifie la réponse du serveur réel
     */
    @Test
    void testGetUsersEndpoint_Integration() {
        String url = "http://localhost:" + port + "/user";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("User dsjhqwjdjqwdc sjsjs");
    }

    /**
     * Test d'intégration du endpoint GET /presentation
     * Vérifie la réponse du serveur réel
     */
    @Test
    void testGetPresentationEndpoint_Integration() {
        String url = "http://localhost:" + port + "/presentation";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("presentation  hsjsj test ");
    }

    /**
     * Test que tous les endpoints sont accessibles
     */
    @Test
    void testAllEndpointsAreAccessible_Integration() {
        // Test endpoint /
        ResponseEntity<String> response1 = restTemplate.getForEntity(
                "http://localhost:" + port + "/", String.class);
        assertThat(response1.getStatusCode()).isEqualTo(HttpStatus.OK);

        // Test endpoint /user
        ResponseEntity<String> response2 = restTemplate.getForEntity(
                "http://localhost:" + port + "/user", String.class);
        assertThat(response2.getStatusCode()).isEqualTo(HttpStatus.OK);

        // Test endpoint /presentation
        ResponseEntity<String> response3 = restTemplate.getForEntity(
                "http://localhost:" + port + "/presentation", String.class);
        assertThat(response3.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    /**
     * Test qu'un endpoint inexistant retourne 404
     */
    @Test
    void testNonExistentEndpoint_Returns404_Integration() {
        String url = "http://localhost:" + port + "/nonexistent";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    /**
     * Test que les réponses ne sont pas vides
     */
    @Test
    void testResponsesAreNotEmpty_Integration() {
        ResponseEntity<String> response1 = restTemplate.getForEntity(
                "http://localhost:" + port + "/", String.class);
        assertThat(response1.getBody()).isNotNull();
        assertThat(response1.getBody()).isNotEmpty();

        ResponseEntity<String> response2 = restTemplate.getForEntity(
                "http://localhost:" + port + "/user", String.class);
        assertThat(response2.getBody()).isNotNull();
        assertThat(response2.getBody()).isNotEmpty();

        ResponseEntity<String> response3 = restTemplate.getForEntity(
                "http://localhost:" + port + "/presentation", String.class);
        assertThat(response3.getBody()).isNotNull();
        assertThat(response3.getBody()).isNotEmpty();
    }
}

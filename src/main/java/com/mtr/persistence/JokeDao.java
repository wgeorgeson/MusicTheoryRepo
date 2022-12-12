package com.mtr.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jokeAPI.Joke;
import com.mtr.util.PropertiesLoader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JokeDao implements PropertiesLoader {

    private final Logger logger = LogManager.getLogger(this.getClass());
    Properties properties = null;

    public Joke getJoke() {
        Client client = ClientBuilder.newClient();

        try {
            properties = loadProperties("/api.properties");
        } catch (IOException ioe) {
            logger.error("IOException accessing api.properties " + ioe);
        } catch (Exception e) {
            logger.error("Exception accessing api.properties " + e);
        }

        WebTarget target =
                client.target(properties.getProperty("url"));
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        // from imported com.fasterxml.jackson.databind.ObjectMapper class
        ObjectMapper mapper = new ObjectMapper();
        Joke joke = null;

        try {
            // turn the response from the api call into a Joke class
            joke = mapper.readValue(response, Joke.class);
        } catch (JsonProcessingException jpe) {
            logger.error("JsonProcessingException converting Json response into a Joke class " + jpe);
        } catch (Exception e) {
            logger.error("Exception converting Json response into a Joke class " + e);
        }

        return joke;
    }
}
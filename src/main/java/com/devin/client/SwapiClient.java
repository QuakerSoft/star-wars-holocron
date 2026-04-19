package com.devin.client;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class SwapiClient {
    //HTTP Class for API
    private HttpClient client = HttpClient.newHttpClient();

    //Search function to pass
    public String search(String category, String query)throws Exception{
        //Encode Special Characters
        String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://swapi.dev/api/" + category + "/?search=" + encodedQuery))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
    //Query Functions
    public String searchSpecies(String name) throws Exception {
        return search("species", name);
    }
    public String searchStarships(String name) throws Exception {
        return search("starships", name);
    }
    public String searchCharacter(String name) throws Exception {
        return search("people", name);
    }
    public String searchPlanet(String name)throws Exception{
        return search("planets", name);
    }
//    public String searchCharacter(String name) throws Exception {
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://swapi.dev/api/people/?search=" + name))
//                .GET()
//                .build();
//
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        return response.body();
//    }
//    public String searchPlanet(String planet_name)throws Exception{
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://swapi.dev/api/planets/?search=" + planet_name))
//                .GET()
//                .build();
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        return response.body();
//    }
}

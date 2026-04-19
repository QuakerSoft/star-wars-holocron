package com.devin.Service;

import com.devin.Model.*;
import com.devin.Model.Character;
import com.devin.client.GeminiClient;
import com.devin.client.SwapiClient;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class SearchService {
    SwapiClient client = new SwapiClient(); // Create SWAPI objects

    //Create ai client object to retrieve parsed data
    GeminiClient ai = new GeminiClient();


    //Checks Results for null/empty
    private <T> T getFirstResult(SwapiResponse<T> response, String query) {
        if (response == null || response.results == null || response.results.length == 0) {
            System.out.println("\n❌ No results found for: " + query);
            return null;
        }
        return response.results[0];
    }

    public void searchCharacter(String name) throws Exception {
        String json = null;
        try {
            json = client.searchCharacter(name);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Gson gson = new Gson();
        SwapiResponse<com.devin.Model.Character> response = gson.fromJson(json, new TypeToken<SwapiResponse<com.devin.Model.Character>>(){}.getType());
        Character character = getFirstResult(response, name);
        if(character == null){
            return;
        }


        String promptData = "Name: " + character.getName();
        String summary = ai.summarize(promptData);


        System.out.println("Name: " + character.getName());
        System.out.println("Height: " + character.getHeight());
        System.out.println("Mass: " + character.getMass());
        System.out.println("Birth Year: "+ character.getBirth_year());
        System.out.print("Summary: ");
        System.out.println(summary);

    }
    public void searchPlanet(String name) throws Exception {
        String json = null;
        try {
            json = client.searchPlanet(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Gson gson = new Gson();
        SwapiResponse<Planet>response = gson.fromJson(json, new TypeToken<SwapiResponse<Planet>>(){}.getType());
        Planet planet = getFirstResult(response, name);
        if(planet == null){
            return;
        }

        String promptData = "Planet: " + planet.getName();
        String summary = ai.summarize(promptData);

        System.out.println("Name: " + planet.getName());
        System.out.println("Climate: " + planet.getClimate());
        System.out.println("Population: " + planet.getPopulation());
        System.out.println("Terrain: " + planet.getTerrain());
        System.out.print("Summary: " );
        System.out.println(summary);
    }
    public void searchSpecies(String name) throws Exception {
        String json = null;
        try {
            json = client.searchSpecies(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Gson gson = new Gson();
        SwapiResponse<Species>response = gson.fromJson(json, new TypeToken<SwapiResponse<Species>>(){}.getType());
        Species species = getFirstResult(response, name);
        if(species == null){
            return;
        }

        String promptData = "Species: " + species.getName();
        String summary = ai.summarize(promptData);

        System.out.println("Name: " + species.getName());
        System.out.println("Classification: " + species.getClassification());
        System.out.println("Average height: " + species.getAvg_height());
        System.out.println("Language: " + species.getLanguage());
        System.out.print("Summary: ");
        System.out.println(summary);
    }
    public void searchStarShips(String name) throws Exception {
        String json = null;
        try {
            json = client.searchStarships(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Gson gson = new Gson();
        SwapiResponse<Starships>response = gson.fromJson(json, new TypeToken<SwapiResponse<Starships>>(){}.getType());
        Starships starships = getFirstResult(response, name);
        if(starships == null){
            return;
        }

        String promptData = "Starships: " + starships.getName();
        String summary = ai.summarize(promptData);

        System.out.println("Name: " + starships.getName());
        System.out.println("Model: " + starships.getModel());
        System.out.println("Manufacturer: " + starships.getManufacturer());
        System.out.println("Credit Cost: " + starships.getCost_in_credits());
        System.out.print("Summary: ");
        System.out.println(summary);
    }
}

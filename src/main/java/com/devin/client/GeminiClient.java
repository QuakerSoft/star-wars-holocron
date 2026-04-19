package com.devin.client;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GeminiClient{
    private final String apiKey = System.getenv("GEMINI_API_KEY");
    public String summarize(String text) throws Exception {

        String prompt = "Summarize this star wars entry in 4 short sentences";
        String body = """
{
  "contents": [{
    "parts": [{
      "text": "%s %s"
    }]
  }]
}
""".formatted(prompt.replace("\"", "\\\""), text.replace("\"", "\\\""));

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(
                        "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key=" + apiKey
                ))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        HttpResponse<String> response =
                HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        //PARSE RESPONSE
        JsonObject obj = JsonParser.parseString(response.body()).getAsJsonObject();

        //Check if API returned an error
        if (obj.has("error")) {
            String errorMsg = obj.getAsJsonObject("error")
                    .get("message")
                    .getAsString();
            return "⚠️ Gemini API Error: " + errorMsg;
        }
        return obj
                .getAsJsonArray("candidates")
                .get(0).getAsJsonObject()
                .getAsJsonObject("content")
                .getAsJsonArray("parts")
                .get(0).getAsJsonObject()
                .get("text")
                .getAsString();
    }
}

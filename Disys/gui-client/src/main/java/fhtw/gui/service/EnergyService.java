package at.fhtw.gui.service;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.type.TypeReference;
import at.fhtw.gui.model.CurrentPercentage;
import at.fhtw.gui.model.HistoricalUsage;

import java.net.URI;
import java.net.http.*;
import java.time.LocalDate;
import java.util.List;

public class EnergyService {
    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();
    private static final String BASE_URL = "http://localhost:8080/energy";

    public CurrentPercentage fetchCurrentPercentage() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/current"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return mapper.readValue(response.body(), CurrentPercentage.class);
    }

    public List<HistoricalUsage> fetchHistoricalUsage(LocalDate start, LocalDate end) throws Exception {
        String url = BASE_URL + "/historical?start=" + start + "&end=" + end;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return mapper.readValue(response.body(), new TypeReference<List<HistoricalUsage>>() {});
    }
}

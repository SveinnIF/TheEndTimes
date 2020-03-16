package Model;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import io.javalin.Javalin;
import io.javalin.plugin.rendering.vue.VueComponent;


public class Application {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start();

        app.config.enableWebjars();

        app.get("/planet-systems/:planet-system-id", new VueComponent("planet-system-detail"));
        app.get("/planet-systems", new VueComponent("planet-system-overview"));
        app.get("/planet-systems/:planet-system-id/planets/:planet-id", new VueComponent("planet-detail"));

        UniverseRepository PlanetSystemRepository = new UniverseRepository();
        PlanetSystemController planetSystemController = new PlanetSystemController(PlanetSystemRepository);

        app.get("/api/planet-systems/:planet-system-id", planetSystemController::getSinglePlanetSystem);
        app.get("/api/planet-systems/", planetSystemController::getAllPlanetSystems);
        app.get("/api/planet-systems/:planet-system-id/planets/:planet-id",planetSystemController::getSinglePlanet);
        app.get("/api/planet-systems/:planet-system-id/planets",planetSystemController::getAllPlanets);

        app.get("/", ctx -> ctx.result("Hello, world"));



    }
}

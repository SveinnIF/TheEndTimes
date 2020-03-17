package Model;

import io.javalin.Javalin;
import io.javalin.plugin.rendering.vue.VueComponent;


public class Application {


    public static void main(String[] args) {
        Javalin app = Javalin.create().start();
        System.out.println("CUMMIES IN MY TUMMIES");
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

        UniverseJSONRepository universeJSONRepository = new UniverseJSONRepository();

    }
}

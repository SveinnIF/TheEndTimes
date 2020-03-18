package Model;

import io.javalin.http.Context;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PlanetSystemController {
    private IUniverseRepository UniverseJSONRepository;

    public PlanetSystemController(IUniverseRepository UniverseJSONRepository) {
        this.UniverseJSONRepository = UniverseJSONRepository;
    }

    public void getAllPlanets(Context context) {
        String systemId = context.pathParam(":planet-system-id");
        String sortBy = context.queryParam("sort_by");

        ArrayList<Planet> allPlanets = UniverseJSONRepository.getAllPlanets(systemId); //i think it is because this is not a copy, this is the actual array that i am sorting and when i press null it
                                                                                   //just prints the already sortet array
        if (sortBy != null) {
            switch (sortBy) {
                case "name":
                    allPlanets.sort(Comparator.comparing(CelestialBody::getName));
                    break;
                case "mass":
                    allPlanets.sort(Comparator.comparing(CelestialBody::getMass));
                    break;
                case "radius":
                    allPlanets.sort(Comparator.comparing(CelestialBody::getRadius));
                    break;
            }
        }

        context.json(allPlanets);
    }

    public void getAllPlanetSystems(Context context) {
        ArrayList<PlanetSystem> allPlanetSystems = UniverseJSONRepository.getAllPlanetSystems();
        context.json(allPlanetSystems);
    }

    public void getSinglePlanet(Context context){
        String systemId = context.pathParam(":planet-system-id");
        String planetId = context.pathParam(":planet-id");
        Planet planet = UniverseJSONRepository.getPlanet(systemId,planetId);
        context.json(planet);
    }

    public void getSinglePlanetSystem(Context context){
        String systemId = context.pathParam(":planet-system-id");
        PlanetSystem system = UniverseJSONRepository.getPlanetSystem(systemId);
        context.json(system);
    }

}

package Model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class UniverseJSONRepository{
    private File jsonFile;

    private ArrayList<PlanetSystem> planetSystems = new ArrayList<>();

    public UniverseJSONRepository(){
        Star sun = new Star("The Sun", 1.9885E30, 695342, 5777, "https://upload.wikimedia.org/wikipedia/commons/c/c3/Solar_sys8.jpg");
        ArrayList<Planet> planetList = new ArrayList<>();
        planetList.add(new Planet("Mercury", 3.283E23, 2439.7, 0.387, 0.206, 88, sun, "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Transit_Of_Mercury%2C_May_9th%2C_2016.png/480px-Transit_Of_Mercury%2C_May_9th%2C_2016.png"));
        planetList.add(new Planet("Venus", 4.867E24, 6051.8, 0.723, 0.007, 225, sun, "https://upload.wikimedia.org/wikipedia/commons/e/e5/Venus-real_color.jpg"));
        planetList.add(new Planet("Earth", 5.972E24, 6371, 1, 0.017, 365, sun, "https://upload.wikimedia.org/wikipedia/commons/thumb/a/aa/NASA_Earth_America_2002.jpg/480px-NASA_Earth_America_2002.jpg"));
        planetList.add(new Planet("Mars", 6.39E23, 3389.5, 1.524, 0.093, 687, sun, "https://upload.wikimedia.org/wikipedia/commons/thumb/5/58/Mars_23_aug_2003_hubble.jpg/480px-Mars_23_aug_2003_hubble.jpg"));
        planetList.add(new Planet("Jupiter", 1.898E27, 69911, 5.20440, 0.049, 4380, sun, "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2b/Jupiter_and_its_shrunken_Great_Red_Spot.jpg/480px-Jupiter_and_its_shrunken_Great_Red_Spot.jpg"));
        planetList.add(new Planet("Saturn", 5.683E26, 58232, 9.5826, 0.057, 10585, sun, "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/Saturn_from_Cassini_Orbiter_-_Square_%282004-10-06%29.jpg/480px-Saturn_from_Cassini_Orbiter_-_Square_%282004-10-06%29.jpg"));
        planetList.add(new Planet("Uranus", 8.681E25, 25362, 19.2184, 0.046, 30660, sun, "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3d/Uranus2.jpg/480px-Uranus2.jpg"));
        planetList.add(new Planet("Neptune", 1.024E26, 24622, 30.11, 0.010, 60225, sun, "https://upload.wikimedia.org/wikipedia/commons/thumb/4/41/Neptune_Full_%28cropped%29.jpg/480px-Neptune_Full_%28cropped%29.jpg"));

        PlanetSystem solarSystem = new PlanetSystem("Solar System", sun, planetList, "https://upload.wikimedia.org/wikipedia/commons/c/c3/Solar_sys8.jpg");
        planetSystems.add(solarSystem);
    }

    public UniverseJSONRepository(String fileName) {
        this(new File(fileName));
    }
    public UniverseJSONRepository(File fileName){
        this.jsonFile = jsonFile;

    }

    public void UpdateFromFile(){

    }

    public void readFromFile(){
        ObjectMapper objectMapper = new ObjectMapper();

        try{
            PlanetSystem[] cheesecake = objectMapper.readValue(jsonFile, PlanetSystem[].class);
            planetSystems = new ArrayList(Arrays.asList(cheesecake));
        } catch (IOException e){
            e.printStackTrace();
        }

    }

}


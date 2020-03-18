package Model;

import java.util.ArrayList;
import static java.lang.Float.POSITIVE_INFINITY;
//import java.util.Comparator;

public class PlanetSystem {
    private String name;
    private Star centerStar;
    String pictureUrl;
    private ArrayList<Planet> planets = new ArrayList<>();



    public PlanetSystem(String name, Star centerStar, ArrayList<Planet> planetList,String pictureUrl) {
        this.name = name;
        this.centerStar = centerStar;
        this.planets = planetList;
        this.pictureUrl = pictureUrl;
    }
    public PlanetSystem(){}

    public ArrayList<Planet> getPlanetList() {
        return planets;
    }

    public void setPlanetList(ArrayList<Planet> planetList) {
        this.planets = planetList;
    }

    public Star getCenterStar() {
        return centerStar;
    }

    public void setCenterStar(Star centerStar) {
        this.centerStar = centerStar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Planet getPlanet(String planet) {
        for (Planet value : planets) {
            if (planet.equals(value.getName())) {
                return value;
            }
        }
        return null;
    }



    public ArrayList<Planet> getPlanets() {
        return new ArrayList<Planet>(planets);
    }

//this is what i used before the project was re-written
//        Planet largestMass = planetList.stream().max(Comparator.comparingDouble(Planet::getMass)).get();
//        Planet largestRadius = planetList.stream().max(Comparator.comparingDouble(Planet::getRadius)).get();
//        Planet smallestMass = planetList.stream().min(Comparator.comparingDouble(Planet::getMass)).get();
//        Planet smallestRadius = planetList.stream().min(Comparator.comparingDouble(Planet::getRadius)).get();


    public Planet biggestPlanet() {
        double comparator = 0;
        Planet biggest = null;
        for (int i = 0; i < planets.size(); i++) {
            for (int j = 0; j < planets.size(); j++) {
                if ((i != j) && (Math.abs(planets.get(i).getRadius() - planets.get(j).getRadius()) < 0.00000001)) {
                    return massCheck();
                }
            }
            if (planets.get(i).getRadius() > comparator) {
                comparator = planets.get(i).getRadius();
                biggest = planets.get(i);
            }
        }
        return biggest;
    }

    public Planet massCheck() {  //originally had this as private as it's only used in this class but i thought i'd make it public in case someone wants to know what planet is the most massive
        double comparator = 0;
        Planet massivert = null;
        for (int i = 0; i < planets.size(); i++) {
            for (int j = 0; j < planets.size(); j++) {
                if ((i != j) && (Math.abs(planets.get(i).getMass() - planets.get(j).getMass()) < 0.00000001)) {
                    return planets.get(i); //stupid that i can't return a string with the two planets in it declearing that two planets are exactly alike
                }//even though the likelihood of that happening is basically 0. but so is the likelihood of two planets having the exact same radius so this code doesn't actaully have any reason to exsist but im making it anyway
            }
            if (planets.get(i).getMass() > comparator) {
                comparator = planets.get(i).getMass();
                massivert = planets.get(i);
            }
        }
        return massivert;
    }


    public Planet smallestPlanet() {

        double comparator = POSITIVE_INFINITY;
        Planet smallest = null;
        for (int i = 0; i < planets.size(); i++) {
            for (int j = 0; j < planets.size(); j++) {
                if ((i != j) && (Math.abs(planets.get(i).getRadius() - planets.get(j).getRadius()) < 0.00000001)) {
                    return smallMassCheck();
                }
            }
            if (planets.get(i).getRadius() < comparator) {
                comparator = planets.get(i).getRadius();
                smallest = planets.get(i);
            }
        }
        return smallest;
    }


    public Planet smallMassCheck() {
        double comparator = POSITIVE_INFINITY;
        Planet massivert = null;
        for (int i = 0; i < planets.size(); i++) {
            for (int j = 0; j < planets.size(); j++) {
                if ((i != j) && (Math.abs(planets.get(i).getMass() - planets.get(j).getMass()) < 0.00000001)) {
                    return planets.get(i); //stupid that i can't return a string with the two planets in it declearing that two planets are exactly alike
                }//even though the likelihood of that happening is basically 0. but so is the likelihood of two planets having the exact same radius so this code doesn't actaully have any reason to exsist but im making it anyway
            }
            if (planets.get(i).getMass() < comparator) {
                comparator = planets.get(i).getMass();
                massivert = planets.get(i);
            }
        }
        return massivert;
    }


    @Override
    public String toString() {
        return "The star of the " + name + " is " + centerStar.getName() + " and the planets are " + planets;
    }
}

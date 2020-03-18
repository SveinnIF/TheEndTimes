package Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.jetbrains.annotations.NotNull;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Star.class, name = "star")
})

public class CelestialBody implements Comparable<CelestialBody> {
    private String name,pictureUrl;
    private double radius,mass,effectiveTemp;
    public static final double Mjup = 1.898E27;
    public static final double Rjup = 71492;
    public static final double Rearth = 6371;
    public static final double Mearth = 5.972E24;
    public static final double Msun = 1.9885E30;
    public static final double Rsun = 695342;
    public static final double oneAU = 149597871;
    public static final double graviConst = 6.674E-11;



    public CelestialBody(String name, double mass, double radius, double effectiveTemp, String pictureUrl) {
        this.name = name;
        this.radius = radius;
        this.mass = mass;
        this.effectiveTemp = effectiveTemp;
        this.pictureUrl = pictureUrl;
    }
    public CelestialBody(String name, double mass, double radius,String pictureUrl) {
        this.name = name;
        this.mass = mass;
        this.radius = radius;
        this.pictureUrl = pictureUrl;
    }
    public CelestialBody(){}

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    @JsonProperty("radius")
    public double getRadius() {
        return radius;
    }

    @JsonProperty("mass")
    public double getMass() {
        return mass;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("effectiveTemp")
    public double getEffectiveTemp() {
        return effectiveTemp;
    }

    @JsonIgnore
    public double getGravity(){
        return  (graviConst * mass)/Math.pow((radius * 1000),2);
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setEffectiveTemp(double effectiveTemp) {
        this.effectiveTemp = effectiveTemp;
    }

    @Override
    public String toString() {
        return name+" has a mass of "+mass+" and a radius of "+radius+" and a temparature of "+effectiveTemp;
    }

    @Override
    public int compareTo(@NotNull CelestialBody o) {
        return 0;
    }
}


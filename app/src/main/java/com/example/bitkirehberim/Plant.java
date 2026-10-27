package com.example.bitkirehberim;


public class Plant {
    private String name;
    private String latinName;
    private String wateringFrequency;
    private String type;
    private String lightRequirement;
    private String growingEnvironment;
    private String careInfo;
    private String description;
    private String growingRegions;
    private String lifespan;
    private String fertilizing;
    private String pruning;
    private String repotting;
    private String generalCare;
    private String commonDiseases;
    private String prevention;
    private String propagation;


    public Plant(String name, String latinName, String wateringFrequency, String type, String lightRequirement, String growingEnvironment, String careInfo, String description, String growingRegions, String lifespan, String fertilizing, String pruning, String repotting, String generalCare, String commonDiseases, String prevention, String propagation) {
        this.name = name;
        this.latinName = latinName;
        this.wateringFrequency = wateringFrequency;
        this.type = type;
        this.lightRequirement = lightRequirement;
        this.growingEnvironment = growingEnvironment;
        this.careInfo = careInfo;
        this.description = description;
        this.growingRegions = growingRegions;
        this.lifespan = lifespan;
        this.fertilizing = fertilizing;
        this.pruning = pruning;
        this.repotting = repotting;
        this.generalCare = generalCare;
        this.commonDiseases = commonDiseases;
        this.prevention = prevention;
        this.propagation = propagation;
    }


    public String getName() {
        return name;
    }


    public String getLatinName() {
        return latinName;
    }


    public String getWateringFrequency() {
        return wateringFrequency;
    }


    public String getType() {
        return type;
    }


    public String getLightRequirement() {
        return lightRequirement;
    }


    public String getGrowingEnvironment() {
        return growingEnvironment;
    }


    public String getCareInfo() {
        return careInfo;
    }


    public String getDescription() {
        return description;
    }


    public String getGrowingRegions() {
        return growingRegions;
    }


    public String getLifespan() {
        return lifespan;
    }


    public String getFertilizing() {
        return fertilizing;
    }


    public String getPruning() {
        return pruning;
    }


    public String getRepotting() {
        return repotting;
    }


    public String getGeneralCare() {
        return generalCare;
    }


    public String getCommonDiseases() {
        return commonDiseases;
    }


    public String getPrevention() {
        return prevention;
    }


    public String getPropagation() {
        return propagation;
    }
}

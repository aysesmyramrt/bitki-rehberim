package com.example.bitkirehberim.models;

public class MedicinalPlant {
    private String name;
    private String scientificName;
    private String benefits;
    private String usage;
    private String precautions;
    private String preparation;
    private String dosage;
    private String sideEffects;
    private String interactions;
    private String storage;

    public MedicinalPlant(String name, String scientificName, String benefits,
                          String usage, String precautions, String preparation,
                          String dosage, String sideEffects, String interactions,
                          String storage) {
        this.name = name;
        this.scientificName = scientificName;
        this.benefits = benefits;
        this.usage = usage;
        this.precautions = precautions;
        this.preparation = preparation;
        this.dosage = dosage;
        this.sideEffects = sideEffects;
        this.interactions = interactions;
        this.storage = storage;
    }

    // Getter metodları
    public String getName() { return name; }
    public String getScientificName() { return scientificName; }
    public String getBenefits() { return benefits; }
    public String getUsage() { return usage; }
    public String getPrecautions() { return precautions; }
    public String getPreparation() { return preparation; }
    public String getDosage() { return dosage; }
    public String getSideEffects() { return sideEffects; }
    public String getInteractions() { return interactions; }
    public String getStorage() { return storage; }
}
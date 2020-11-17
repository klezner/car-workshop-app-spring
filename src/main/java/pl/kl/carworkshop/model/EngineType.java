package pl.kl.carworkshop.model;

public enum EngineType {
    PETROL("Petrol"),
    DIESEL("Diesel");

    private String commonName;

    EngineType(String commonName) {
        this.commonName = commonName;
    }

    public String getCommonName() {
        return commonName;
    }
}

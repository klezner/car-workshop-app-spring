package pl.kl.carworkshop.model;

public enum EmploymentLevel {
    JUNIOR("Apprentice mechanic"),
    MID("Mechanic"),
    SENIOR("Senior mechanic");

    private String commonName;

    EmploymentLevel(String commonName) {
        this.commonName = commonName;
    }

    public String getCommonName() {
        return commonName;
    }
}

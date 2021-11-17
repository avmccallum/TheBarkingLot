package com.ashleymccallum.thebarkinglot;

public enum PetRequirement {

    MAXIMUM, MODERATE, MINIMUM;

    public String toString() {
        switch (this) {
            case MAXIMUM: return "maximum";
            case MODERATE: return "moderate";
            case MINIMUM: return "minimum";
            default: return "unknown";
        }
    }
}

package com.example.parkingapp;

import com.google.gson.annotations.SerializedName;

public class parkingStatus {
    @SerializedName("availableCapacity")
    private int availableCapacity;
    @SerializedName("totalCapacity")
    private int totalCapacity;

    public int getAvailableCapacity() {
        return availableCapacity;
    }

    public void setAvailableCapacity(int availableCapacity) {
        this.availableCapacity = availableCapacity;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public parkingStatus(int availableCapacity, int totalCapacity) {
        this.availableCapacity = availableCapacity;
        this.totalCapacity = totalCapacity;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }
}

package com.example.parkingapp;
import com.google.gson.annotations.SerializedName;

public class Parking {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("address")
    private String address;
    @SerializedName("suggestedFreeThreshold")
    private String suggestedFreeThreshold;
    @SerializedName("suggestedFullThreshold")
    private String suggestedFullThreshold;
    @SerializedName("capacityRounding")
    private String capacityRounding;
    @SerializedName("totalCapacity")
    private String totalCapacity;
    @SerializedName("parkingStatus")
    parkingStatus parkingStatus;

    public Parking(String id, String name, String description, String adress, String suggestedFreeThreshold, String suggestedFullThreshold, String capacityRounding, String totalCapacity, com.example.parkingapp.parkingStatus parkingStatus) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = adress;
        this.suggestedFreeThreshold = suggestedFreeThreshold;
        this.suggestedFullThreshold = suggestedFullThreshold;
        this.capacityRounding = capacityRounding;
        this.totalCapacity = totalCapacity;
        this.parkingStatus = parkingStatus;
    }

    public String getAdress() {
        return address;
    }

    public void setAdress(String adress) {
        this.address = adress;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuggestedFreeThreshold() {
        return suggestedFreeThreshold;
    }

    public void setSuggestedFreeThreshold(String suggestedFreeThreshold) {
        this.suggestedFreeThreshold = suggestedFreeThreshold;
    }

    public String getSuggestedFullThreshold() {
        return suggestedFullThreshold;
    }

    public void setSuggestedFullThreshold(String suggestedFullThreshold) {
        this.suggestedFullThreshold = suggestedFullThreshold;
    }

    public String getCapacityRounding() {
        return capacityRounding;
    }

    public void setCapacityRounding(String capacityRounding) {
        this.capacityRounding = capacityRounding;
    }

    public String getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(String totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public com.example.parkingapp.parkingStatus getParkingStatus() {
        return parkingStatus;
    }

    public void setParkingStatus(com.example.parkingapp.parkingStatus parkingStatus) {
        this.parkingStatus = parkingStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

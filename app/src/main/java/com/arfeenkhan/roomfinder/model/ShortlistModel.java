package com.arfeenkhan.roomfinder.model;

public class ShortlistModel {
    private String buildingname,buidlingtype,available,bedrate;
    private int image;


    public ShortlistModel(int image, String buildingname, String buidlingtype, String available, String bedrate) {
        this.image = image;
        this.buildingname = buildingname;
        this.buidlingtype = buidlingtype;
        this.available = available;
        this.bedrate = bedrate;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getBuildingname() {
        return buildingname;
    }

    public void setBuildingname(String buildingname) {
        this.buildingname = buildingname;
    }

    public String getBuidlingtype() {
        return buidlingtype;
    }

    public void setBuidlingtype(String buidlingtype) {
        this.buidlingtype = buidlingtype;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getBedrate() {
        return bedrate;
    }

    public void setBedrate(String bedrate) {
        this.bedrate = bedrate;
    }
}

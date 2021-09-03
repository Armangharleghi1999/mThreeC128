package com.sg.dvdlibrary.dto;

public class DVD {

    private String Title;
    private int releaseDate;
    private String MPAArating;
    private String directorsName;
    private String Studio;
    private String userNote;

    public DVD(String Title) {
    }

    public String getTitle() {
        return Title;
    }

    public String getReleaseDate() {
        return (String.valueOf(releaseDate));
    }

    public void setReleaseDate(int releaseDate) {}

    public String getMPAArating() {
        return MPAArating;
    }

    public void setMPAArating(String MPAArating) {
        this.MPAArating = MPAArating;
    }

    public String getDirectorsName() {
        return directorsName;
    }

    public void setDirectorsName(String directorsName) {
        this.directorsName = directorsName;
    }

    public String getStudio() {
        return Studio;
    }

    public void setStudio(String studio) {
        Studio = studio;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }
}

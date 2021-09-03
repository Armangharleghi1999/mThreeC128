package com.sg.dvdlibrary.ui;
import com.sg.dvdlibrary.dto.DVD;
import java.util.List;

public class DVDLibraryView {
    private UserIO io;

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add DVD");
        io.print("2. Remove DVD");
        io.print("3. Edit info about a DVD");
        io.print("4. List the DVDs in collection");
        io.print("5. Display info about one DVD");
        io.print("6. Exit!");

        return io.readInt("Please select from the above choices.", 1, 6);
    }

    public DVD getNewDVDInfo() {
        String Title = io.readString("Please enter DVD title");
        int releaseDate = io.readInt("Please enter the year it was released");
        String MPAArating = io.readString("Please enter the MPAA rating");
        String directorsName = io.readString("Please enter the Director's name");
        String Studio = io.readString("Please enter the studio");
        String userNote = io.readString("Please enter any additional notes");
        DVD currentDVD = new DVD(Title);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setMPAArating(MPAArating);
        currentDVD.setDirectorsName(directorsName);
        currentDVD.setStudio(Studio);
        currentDVD.setUserNote(userNote);
        return currentDVD;
    }

    public void displayCreateDVDBanner() {
        io.print("=== Create DVD ===");
    }


    public void displayCreateSuccessBanner() {
        io.readString(
                "DVD successfully created.  Please hit enter to continue");
    }


    public void displayDVDList(List<DVD> DVDList) {
        for (DVD currentDVD : DVDList) {
            String DVDInfo = String.format("Title: #%s \nDate: %s \nMPAA Rating: %s \nDirector's Name: %s \nStudio: %s \nUserNotes: %s",
                    currentDVD.getTitle(),
                    currentDVD.getReleaseDate(),
                    currentDVD.getMPAArating(),
                    currentDVD.getDirectorsName(),
                    currentDVD.getStudio(),
                    currentDVD.getUserNote());
            io.print(DVDInfo);
        }
        io.readString("Please hit enter to continue.");
    }
    public void displayDisplayAllBanner() {
        io.print("=== Display All DVDs ===");
    }
    public void displayDisplayDVDBanner () {
        io.print("=== Display DVD ===");
    }

    public String getDVDTitlechoice() {
        return io.readString("Please enter the DVD Title.");
    }

    public void displayDVD(DVD DVD) {
        if (DVD != null) {
            io.print(DVD.getTitle());
            io.print(DVD.getReleaseDate());
            io.print(DVD.getMPAArating());
            io.print(DVD.getDirectorsName());
            io.print(DVD.getStudio());
            io.print(DVD.getUserNote());
            io.print("");
        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveDVDBanner () {
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveResult(DVD DVDRecord) {
        if(DVDRecord != null){
            io.print("DVD successfully removed.");
        }else{
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public DVD editDVDInfo(DVD dvdRecord) {
        int ReleaseDate = io.readInt("Please enter new release date (current = " + dvdRecord.getReleaseDate() + ")");
        String MPAARating = io.readString("Please enter MPAA Rating (current = " + dvdRecord.getMPAArating() + ")");
        String directorName = io.readString("Please enter director name (current = " + dvdRecord.getDirectorsName() + ")");
        String studio = io.readString("Please enter studio name (current = " + dvdRecord.getStudio() + ")");
        String UserNote = io.readString("Please enter any user notes (current = " + dvdRecord.getUserNote() + ")");
        dvdRecord.setReleaseDate(ReleaseDate);
        dvdRecord.setMPAArating(MPAARating);
        dvdRecord.setDirectorsName(directorName);
        dvdRecord.setStudio(studio);
        dvdRecord.setUserNote(UserNote);
        return dvdRecord;
    }

    public void displayEditDVDBanner() {
        io.print("=== Edit DVD ===");
    }

    public void displayEditSuccessBanner() {
        io.readString(
                "DVD successfully edited.  Please hit enter to continue");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public DVDLibraryView(UserIO io) {
        this.io = io;
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}

package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.DVDDaoException;
import com.sg.dvdlibrary.dto.DVD;

import java.io.*;
import java.util.*;


public class DVDLibraryDaoFileImpl implements DVDLibraryDao{
    public static final String DVD_FILE ="src/DVD.txt";
    public static final String DELIMITER = "::";

    private Map<String, DVD> dvds = new HashMap<>();

    @Override
    public DVD addDVD(String Title, DVD dvd)
            throws DVDDaoException {
        loadDVD();
        DVD newDVD = dvds.put(Title, dvd);
        writeDVD();
        return newDVD;
    }
    @Override
    public List<DVD> getAllDVD()
            throws DVDDaoException {
        loadDVD();
        return new ArrayList(dvds.values());
    }

    @Override
    public DVD getDVD(String Title)
            throws DVDDaoException {
        loadDVD();
        return dvds.get(Title);
    }

    @Override
    public DVD removeDVD(String Title)
            throws DVDDaoException {
        loadDVD();
        DVD removedDVD = dvds.remove(Title);
        writeDVD();
        return removedDVD;
    }
    private DVD unmarshallDVD(String DVDasText){

        String[] DVDTokens = DVDasText.split(DELIMITER);

        String Title = DVDTokens[0];

        DVD dvdFromFile = new DVD(Title);

        dvdFromFile.setReleaseDate(Integer.parseInt(DVDTokens[1]));

        dvdFromFile.setMPAArating(DVDTokens[2]);

        dvdFromFile.setDirectorsName(DVDTokens[3]);

        dvdFromFile.setStudio(DVDTokens[4]);

        dvdFromFile.setUserNote(DVDTokens[5]);

        return dvdFromFile;
    }

    private void loadDVD() throws DVDDaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(DVD_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDDaoException(
                    "-_- Could not load DVD data into memory.", e);
        }
        String currentLine;
        DVD currentDVD;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentDVD = unmarshallDVD(currentLine);
            dvds.put(currentDVD.getTitle(), currentDVD);
        }
        scanner.close();
    }

    private String marshallDVD(DVD aDVD){
        String DVDastext = aDVD.getTitle() + DELIMITER;
        DVDastext += aDVD.getReleaseDate() + DELIMITER;
        DVDastext += aDVD.getMPAArating() + DELIMITER;
        DVDastext += aDVD.getDirectorsName() + DELIMITER;
        DVDastext += aDVD.getStudio() + DELIMITER;
        DVDastext += aDVD.getUserNote() + DELIMITER;
        return DVDastext;
    }

    private void writeDVD() throws DVDDaoException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(DVD_FILE));
        } catch (IOException e) {
            throw new DVDDaoException(
                    "Could not save DVD data.", e);
        }
        String DVDastext;
        List<DVD> DVDlist = this.getAllDVD();
        for (DVD currentDVD : DVDlist) {
            DVDastext = marshallDVD(currentDVD);
            out.println(DVDastext);
            out.flush();
        }
        out.close();
    }

}

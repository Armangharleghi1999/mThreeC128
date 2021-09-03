package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.DVDDaoException;
import com.sg.dvdlibrary.dto.DVD;
import java.util.List;

public interface DVDLibraryDao {

    DVD addDVD(String Title, DVD dvd)
            throws DVDDaoException;

    List<DVD> getAllDVD()
            throws DVDDaoException;

    DVD getDVD(String Title)
            throws DVDDaoException;

    DVD removeDVD(String Title)
            throws DVDDaoException;

}

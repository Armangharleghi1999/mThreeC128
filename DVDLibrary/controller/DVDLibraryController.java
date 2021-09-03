package com.sg.dvdlibrary.controller;

import  com.sg.dvdlibrary.DVDDaoException;
import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.ui.DVDLibraryView;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOConsoleImpl;
import com.sg.dvdlibrary.App;
import com.sg.dvdlibrary.dto.DVD;

import java.util.List;

public class DVDLibraryController {


    private DVDLibraryView view;
    private DVDLibraryDao dao;
    private UserIO io = new UserIOConsoleImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        AddDVD();
                        break;
                    case 2:
                        RemoveDVD();
                        break;
                    case 3:
                        editDVD();
                        break;
                    case 4:
                        ListAllDVD();
                        break;
                    case 5:
                        DisplayDVD();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        } catch (DVDDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void AddDVD() throws DVDDaoException {
        view.displayCreateDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayCreateSuccessBanner();
    }

    private void ListAllDVD() throws DVDDaoException {
        view.displayDisplayAllBanner();
        List<DVD> DVDList = dao.getAllDVD();
        view.displayDVDList(DVDList);
    }

    private void DisplayDVD() throws DVDDaoException {
        view.displayDisplayDVDBanner();
        String Title = view.getDVDTitlechoice();
        DVD dvd = dao.getDVD(Title);
        view.displayDVD(dvd);
    }

    private void RemoveDVD() throws DVDDaoException {
        view.displayRemoveDVDBanner();
        String Title = view.getDVDTitlechoice();
        DVD removedDVD = dao.removeDVD(Title);
        view.displayRemoveResult(removedDVD);
    }

    private void editDVD() throws DVDDaoException {
        view.displayEditDVDBanner();
        String title = view.getDVDTitlechoice();
        DVD dvd = dao.getDVD(title);
        if (dvd != null){
            DVD editedDVD = view.editDVDInfo(dvd);
            dao.addDVD(title, editedDVD);
            view.displayEditSuccessBanner();
        } else {
            view.displayErrorMessage("Error, DVD does not exist");
        }
    }



    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
    public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view) {
        this.dao = dao;
        this.view = view;
    }
}

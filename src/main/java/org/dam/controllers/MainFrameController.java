package org.dam.controllers;

import org.dam.views.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrameController implements ActionListener {

    public static final String NAVIGATE_TO_INIT = "NAVIGATE_TO_INIT";
    public static final String NAVIGATE_TO_PAGE1 = "NAVIGATE_TO_PAGE1";
    public static final String NAVIGATE_TO_PAGE2 = "NAVIGATE_TO_PAGE2";

    private final MainFrame mainFrame;

    public MainFrameController(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    private void handleNavigateTo(String panelName){
        mainFrame.navigate(panelName);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case NAVIGATE_TO_INIT:
                handleNavigateTo("initPanel");
                break;
            case NAVIGATE_TO_PAGE1:
                handleNavigateTo("page1Panel");
                break;
            case NAVIGATE_TO_PAGE2:
                handleNavigateTo("page2Panel");
                break;
            default:
                break;
        }
    }
}

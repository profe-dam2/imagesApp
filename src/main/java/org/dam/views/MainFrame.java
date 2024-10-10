package org.dam.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static org.dam.controllers.MainFrameController.*;

public class MainFrame extends JFrame implements InterfaceView {
    private JPanel mainPanel;
    private JButton bt_init;
    private JButton bt_page1;
    private JButton bt_page2;
    private JPanel contenedorPaneles;
    private CardLayout navegador;
    private InitPanel initPanel;
    private Page1Panel page1Panel;
    private Page2Panel page2Panel;

    public MainFrame() {
        initWindow();
        addPanels();

    }

    public Page1Panel getPage1Panel() {
        return page1Panel;
    }

    public Page2Panel getPage2Panel() {
        return page2Panel;
    }

    private void addPanels(){
        // Obtener layout para navegar
        navegador = (CardLayout) contenedorPaneles.getLayout();

        // Instanciar paneles
        initPanel = new InitPanel();
        initPanel.setBackgroundImage("/gatos.png");

        page1Panel = new Page1Panel();
        page1Panel.setBackgroundImage("/perrito.jpg");

        page2Panel = new Page2Panel();
        page2Panel.setBackgroundImage("/toledo.jpeg");

        // Añadir los paneles al contenedor de paneles
        contenedorPaneles.add(initPanel, "initPanel");
        contenedorPaneles.add(page1Panel, "page1Panel");
        contenedorPaneles.add(page2Panel, "page2Panel");
    }

    public void navigate(String panelName){
        navegador.show(contenedorPaneles, panelName);
    }

    @Override
    public void initWindow() {
        setContentPane(mainPanel);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setCommands();
    }

    @Override
    public void showWindow() {
        setVisible(true);
    }

    @Override
    public void closeWindow() {
        dispose();
    }

    @Override
    public void setCommands() {
        bt_init.setActionCommand(NAVIGATE_TO_INIT);
        bt_page1.setActionCommand(NAVIGATE_TO_PAGE1);
        bt_page2.setActionCommand(NAVIGATE_TO_PAGE2);
    }

    @Override
    public void addListener(ActionListener listener) {
        bt_init.addActionListener(listener);
        bt_page1.addActionListener(listener);
        bt_page2.addActionListener(listener);
    }

    @Override
    public void initComponents() {

    }
}

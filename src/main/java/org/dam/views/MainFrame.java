package org.dam.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements InterfaceView {
    private JPanel mainPanel;
    private JButton INICIOButton;
    private JButton PAGINA1Button;
    private JButton PAGINA2Button;
    private JPanel contenedorPaneles;
    private CardLayout navegador;
    private InitPanel initPanel;

    public MainFrame() {
        initWindow();
        addPanels();
    }

    private void addPanels(){
        // Obtener layout para navegar
        navegador = (CardLayout) contenedorPaneles.getLayout();

        // Instanciar paneles
        initPanel = new InitPanel();


        // Añadir los paneles al contenedor de paneles
        contenedorPaneles.add(initPanel, "initPanel");
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

    }

    @Override
    public void addListener(ActionListener listener) {

    }

    @Override
    public void initComponents() {

    }
}

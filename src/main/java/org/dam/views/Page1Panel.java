package org.dam.views;

import org.dam.models.ProductModel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

import static org.dam.controllers.Page1PanelController.CREATE_PRODUCT;

public class Page1Panel extends JPanel {
    private JPanel mainPanel;
    private JPanel imagePreviewPanel;
    private JButton bt_save;
    private JTextField tx_code;
    private JTextField tx_decripcion;
    private JSlider sl_price;
    private JTextField tx_price;
    private JLabel lb_price;
    private Image backgroundImage;

    private ImagePanel imagePanel;

    public Page1Panel() {
        add(mainPanel);
        mainPanel.setOpaque(false);
        setImagePanel();
        setCommands();
        sl_price.setMinimum(0);
        sl_price.setMaximum(1000);
        sl_price.setValue(500);
        tx_price.setText("500");
        sl_price.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                tx_price.setText(String.valueOf(sl_price.getValue()));
            }
        });
        tx_price.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if(!tx_price.getText().equals("") && Character.isDigit(e.getKeyChar()) ){
                    sl_price.setValue(Integer.parseInt(tx_price.getText()));
                }
            }
        });
        tx_price.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                tx_price.setText(String.valueOf(sl_price.getValue()));
            }
        });
        tx_code.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
//                if(Character.isLetter(e.getKeyChar()) || Character.isSpaceChar(e.getKeyChar())){
////                    System.out.println("HAS PULSADO UNA LETRA");
////                    tx_code.setText(tx_code.getText().substring(0, tx_code.getText().length()-1));
////                }
                if(Character.isDigit(e.getKeyChar())){
                    //tx_code.setText(tx_code.getText() + e.getKeyChar());
                }else{
                    if(!tx_code.getText().equals("")){
                        tx_code.setText(tx_code.getText().substring(0, tx_code.getText().length()-1));
                    }
                }


            }
        });
    }

    private void setImagePanel() {
        imagePanel = new ImagePanel();
        imagePreviewPanel.add(imagePanel);
    }

    public ImagePanel getImagePanel() {
        return imagePanel;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0,getWidth(), getHeight(), this);
        }
    }
    public void setBackgroundImage(String path) {
        backgroundImage = new ImageIcon(getClass().getResource(path)).getImage();
        repaint();
    }

    public ProductModel getProduct() {
        //tx_code.setText(tx_code.getText().trim());
        String cleanCode = "";

        for(int i = 0; i < tx_code.getText().length(); i++){
//            if(!Character.isLetter(tx_code.getText().charAt(i)) && !Character.isSpaceChar(tx_code.getText().charAt(i))){
//                cleanCode = cleanCode + tx_code.getText().charAt(i);
//            }
            if(Character.isDigit(tx_code.getText().charAt(i))){
                cleanCode = cleanCode + tx_code.getText().charAt(i);
            }
        }
        tx_code.setText(cleanCode);

        if(tx_code.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Ingrese el codigo del producto");
        }else if(tx_decripcion.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Ingrese la descripcion del producto");
        }else if(tx_price.getText().equals("0")){
            JOptionPane.showMessageDialog(null, "El precio no puede ser 0€!!!");
        }
        else{
            return new ProductModel(tx_code.getText(), tx_decripcion.getText(), sl_price.getValue());
        }
        return null;
    }

    // LLAMAR DESDE EL CONSTRUCTOR!!!
    private void setCommands(){
        bt_save.setActionCommand(CREATE_PRODUCT);
    }

    // LLAMAR DESDE EL MAIN DE LA CLASE APP
    public void addListener(ActionListener listener){
        bt_save.addActionListener(listener);
    }

    public void showMessageCode(){
        tx_code.setBackground(Color.RED);
    }

    public void setDefaultValues(){
        tx_code.setText("");
        tx_decripcion.setText("");
        tx_price.setText("500");
        sl_price.setValue(500);

        tx_code.setBackground(Color.LIGHT_GRAY);

        // Establecer imagen por defecto
        imagePanel.setBackgroundImage("src/images/default.jpg");
    }

}

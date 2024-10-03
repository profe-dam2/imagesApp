package org.dam;

import com.formdev.flatlaf.FlatDarculaLaf;
import org.dam.views.MainFrame;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        FlatDarculaLaf.setup();

        MainFrame frame = new MainFrame();

        frame.showWindow();
    }
}

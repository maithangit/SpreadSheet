package ui;

import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Spreadsheets");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getRootPane().setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        // set icon.
        Image icon = Toolkit.getDefaultToolkit().getImage("ui/sheet.png");
        if(icon != null){
            frame.setIconImage(icon);
        }

        //Create and set up the content pane.
        Spreadsheet spreadsheet = new Spreadsheet();
        spreadsheet.setOpaque(true); //content panes must be opaque
        frame.setContentPane(spreadsheet);
        frame.setSize(760, 650);

        // centralized spreadsheet
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}

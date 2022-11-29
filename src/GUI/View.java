/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import codefiles.compress;
import codefiles.decompress;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author arund
 */
public class View extends JFrame implements ActionListener {
    //create buttons
    JButton compressButton;
    JButton decompressButton;
//    JLabel label = new JLabel();
    
    View() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        
    //add buttons to GUI
    //1.compress button
        compressButton = new JButton("Select file to be compressed");
        //what happens when we click this button -> function -> stored in action listener
        compressButton.addActionListener(this);
        compressButton.setBounds(100, 40, 250,30);
        
    //2.decompress button
        decompressButton = new JButton("Select file to be decompressed");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(100, 100, 250, 30);
            
    //add buttons to window        
        this.add(compressButton);
        this.add(decompressButton);
        
    //set color,size of the window
        //this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setSize(500, 200);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //if compressButton is pressed, what will be done
        if(e.getSource() == compressButton) {
            
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            
            if(response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try{
                    compress.method(file);
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null,excp.toString());
                }
            }
        }
        
        //if decompressButton is pressed, what will be done
        if(e.getSource() == decompressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            
            if(response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try{
                    decompress.method(file);
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null,excp.toString());
                }
            }
        }
    }
    
    public static void main(String[] args) {
        View view = new View();
        view.setVisible(true);
    }
    
}

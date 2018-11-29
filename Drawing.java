/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainapp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Gareth
 */
public class Drawing extends JPanel {
    JLabel graphLbl = new JLabel();
    
    public Drawing()
    {
        initPanel();
    }
    
    private void initPanel()
    {
        
        graphLbl.setText("GRAPH");
        
        
        this.add(graphLbl);        
        
    }
    
    private void setLayout()
    {
        graphLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        graphLbl.setText("Graph");

        javax.swing.GroupLayout DrawingLayout = new javax.swing.GroupLayout(this);
        setLayout(DrawingLayout);
        DrawingLayout.setHorizontalGroup(
            DrawingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DrawingLayout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(graphLbl)
                .addContainerGap(134, Short.MAX_VALUE))
        );
        DrawingLayout.setVerticalGroup(
            DrawingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DrawingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(graphLbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
    }
}

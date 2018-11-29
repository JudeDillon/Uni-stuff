/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitest;

import guitest.DrawingPanel;
import guitest.TimerTest;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;
/**
 *
 * @author Gareth
 */

public class Drawing extends JPanel 
{
    JLabel graphLbl = new JLabel();
    TimerTest timer1 = new TimerTest();
    
    protected void initPanel()
    {
        graphLbl.setText("GRAPH");
        drawGraph(timer1);
        this.revalidate();
    }
    
    public void drawGraph(TimerTest timerRef)
    {
        
        timer1.stopTimer(); //this calls the method to stop the Timer
        System.out.println("This is a list of transactions in chronological order: " + timer1.getAmountList());
        
        //adds the Graph Panel to the GUI
        DrawingPanel centreGraphing = new DrawingPanel(timerRef.getAmountList());
        this.add(centreGraphing);
        centreGraphing.setBackground(Color.blue);
        this.setSize(400,400);
        
        //this method allows the graph to appear on click
        centreGraphing.revalidate();
    }
    
    public void playButton(JButton graphButton)
    {
       //adds the Timer
        timer1.timer();
    }
    
    public TimerTest getTimerRef()
    {
        return timer1;
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

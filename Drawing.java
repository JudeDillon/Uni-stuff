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
    //add constructor and remove initPanel
    
    public Drawing(ArrayList Amounts, ArrayList currentBalance)
    {
        this.graphingAmounts = Amounts;
        this.arrayOfBalances = currentBalance;
    }
    
    //This is the array that will contain the values going in or out
    ArrayList graphingAmounts;
    
    //This will be the array tracking the balances at each month
    ArrayList<Integer> arrayOfBalances = new ArrayList<Integer>();
    
    private int oldX = 50;      
    private int oldY = 325;
    private int segmentSize = 25;
    private int segmentLength = 15;
    private int xBorder = 50;
    private int yBorder = 25;
    private int xLength = 600;
    private int yLength = 800;
    private int ballanceInAccount = 0;
    int j = 0;

    @Override
    public void paintComponent(Graphics g)
        { 
            Graphics2D g2 = (Graphics2D) g ;
            super.paintComponent(g2) ;
            BasicStroke pen = new BasicStroke(4F) ;
            BasicStroke penSoft = new BasicStroke(1F) ;
            BasicStroke penMed = new BasicStroke(2F) ;
            
            g2.setStroke(pen);            
            
            //Draws the Graph with no points
            
            g2.setColor(Color.BLACK);
            //yaxis
            g2.drawLine(xBorder,yBorder,xBorder,yLength);
            
            //xaxis
            g2.drawLine(xBorder,yLength/2+yBorder, xBorder+xLength, yLength/2+yBorder); 
            
            //y lines
            for(int i = xBorder; i<xBorder+xLength; i+=segmentSize)
            {
                g2.setStroke(penMed);
                g2.drawLine(i,yLength/2+segmentLength+yBorder,i,yLength/2-segmentLength+yBorder);
                //Changes pen so that grid is soft lines
                g2.setStroke(penSoft); 
                g2.drawLine(i,yLength, i, yBorder);
            }
            
            //x lines
            for(int i = yBorder; i<yLength; i+=segmentSize)
            {
                g2.setStroke(penMed);
                g2.drawLine(xBorder,i,xBorder+segmentLength,i);
                g2.setStroke(penSoft);
                g2.drawLine(xBorder+segmentLength,i,xBorder+xLength,i);
            }
            
            //Drawing the lines is dones with the following for loop
            g2.setStroke(penMed);
            g2.setColor(Color.red);
            for (int i=0; i<graphingAmounts.size(); i++)
            {
                Integer currentAmount = (Integer) graphingAmounts.get(i);
                ballanceInAccount = ballanceInAccount + currentAmount;
                arrayOfBalances.add(ballanceInAccount);
                
                //This if statement ensures that the first point is whatever the first amount is
                if (j == 0)
                {
                    oldY = convertToGraph(ballanceInAccount);
                    j++;
                }
                
                g2.drawLine(oldX,oldY,(segmentSize*i)+xBorder,convertToGraph(ballanceInAccount));
                oldX = (segmentSize*i)+xBorder;
                oldY = convertToGraph(ballanceInAccount);
            }
        }
    
    private int convertToGraph(int amount)
    {
        amount = amount*-1;
        amount = amount/8;
        amount = amount + 425;
        return amount;
    }
}

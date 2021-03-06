/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitest;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Gareth
 */


public class Control extends JPanel
{   
    private final JLabel settingsLbl = new JLabel();
    private final JLabel accTypeLbl = new JLabel();
    private final String[] accTypeStr = {"Current Account","Savings Account","Please Select an account"};
    private final JComboBox accTypeBox = new JComboBox(accTypeStr);
    private final JLabel intiBalLbl = new JLabel();


    private final JTextField intiBalTxt = new JTextField();
    private final JButton createAccBtn = new JButton();
    private final JLabel reportLbl = new JLabel();
    protected final JButton playButton = new JButton();
    protected final JButton stopButton = new JButton();
    

        
    public Control()
    {
        initPanel();
    }
    
    private void initPanel()
    {
        setCom();
        setLayout();
        
        addCom();
         
        accTypeBox.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    // Creatng a "Happy" event
                    //b.;

                }
            }) ;
    }
    
    private void setCom()
    {
        
        settingsLbl.setText("Settings");
        accTypeLbl.setText("Account Type");
        accTypeBox.setSelectedIndex(2);
        intiBalLbl.setText("Intial Balance");
        intiBalTxt.setText("PLease Enter account balance in digits");
        createAccBtn.setText("Create Account");
        playButton.setText("Play");
        stopButton.setText("Stop");//This button should graph the graph        
        reportLbl.setText("Reports");
    }
    
    private void addCom()
    {
        this.add(settingsLbl);
        this.add(accTypeLbl);
        this.add(accTypeBox);
        this.add(intiBalLbl);
        this.add(intiBalTxt);
        this.add(createAccBtn);
        this.add(playButton);
        this.add(stopButton);
        this.add(reportLbl);

    }
    
    private void setLayout()
    {
        GroupLayout ControlLayout = new GroupLayout(this);
        setLayout(ControlLayout);
        ControlLayout.setHorizontalGroup(
            ControlLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(ControlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ControlLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(settingsLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(GroupLayout.Alignment.TRAILING, ControlLayout.createSequentialGroup()
                        .addComponent(createAccBtn)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(ControlLayout.createSequentialGroup()
                        .addGroup(ControlLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(ControlLayout.createSequentialGroup()
                                .addComponent(playButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stopButton))
                            .addComponent(accTypeLbl)
                            .addComponent(accTypeBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(intiBalLbl)
                            .addComponent(intiBalTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(reportLbl))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        
        ControlLayout.setVerticalGroup(
            ControlLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(ControlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(settingsLbl)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(accTypeLbl)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(accTypeBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(intiBalLbl)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(intiBalTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ControlLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(createAccBtn))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reportLbl)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ControlLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(playButton)
                    .addComponent(stopButton))
                .addContainerGap(63, Short.MAX_VALUE))
        );
    }
}

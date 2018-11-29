package guitest;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UI extends JFrame {
    
    private final Control controlPanel = new Control();
    public Drawing drawingPanel = new Drawing();
    private final JOptionPane closePane = new JOptionPane();
    /**
     * Creates new form BankFrame
     */
    public UI() {
        initFrame();
        setVisible(true);
        close();
    }
    
    private void initFrame() {

        this.addPanels();
        this.setLayout();
        
        //This is for starting the timer 
        controlPanel.playButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                drawingPanel.playButton(controlPanel.stopButton);
            }
        });
        
        //This is the listener to stop the timer 
        controlPanel.stopButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                drawingPanel.initPanel();
            }
        });
    }
    
    private void addPanels()
    {
        this.getContentPane().add(controlPanel);
        this.getContentPane().add(drawingPanel);
    }
    
    private void setLayout()
    {
        setMinimumSize(new java.awt.Dimension(800, 300));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(controlPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(drawingPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(controlPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(drawingPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }
    
    protected void windowClosed()
            {
            // TODO: Check if it is safe to close the application
            // Exit application.
            System.exit(0);
            }
    
    private void close()
    {
//        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
//        addWindowListener(
//                new WindowAdapter()
//                {
//                        @Override
//                    public void windowClosing(WindowEvent e)
//                    {        
//                        closePane = JOptionPane.showConfirmDialog("Are you sure?", JOptionPane.YES_NO_OPTION);
//                        if (option == JOptionPane.YES_OPTION)
//                        {
//                            // yes option
//                            System.out.print("Yes");
//                            System.exit(0);
//                        }
//                        else
//                        {
//                            closePane.setVisible(false);
//                        }
//                    }
//                });
    }
}
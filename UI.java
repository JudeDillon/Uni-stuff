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
    public UI() 
    {
        initFrame();
        setVisible(true);
    }
    
    private void initFrame() 
    {
        this.addControlPanel();
        this.setLayout();
        this.addListeners();
    }
    
    private void addListeners()
    {
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
                addDrawingPanels();
            }
        });
        
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
 
        this.addWindowListener( new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                JFrame frame = (JFrame)e.getSource();

                int result = JOptionPane.showConfirmDialog(
                    frame,
                    "Are you sure you want to exit the application?",
                    "Exit Application",
                    JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION)
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
    
    private void addControlPanel()
    {
        this.getContentPane().add(controlPanel);
    }
    
    private void addDrawingPanels()
    {
        this.getContentPane().add(drawingPanel);
        drawingPanel.initPanel();
    }
    
    private void setLayout()
    {
        drawingPanel.setBackground(Color.WHITE);
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
}
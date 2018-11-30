package guitest;

import java.awt.*;
import java.awt.Dialog.ModalityType;
import java.awt.event.*;
import javax.swing.*;

public class UI extends JFrame {
    
    CurrentAccount timer1 = new CurrentAccount(20);
    private final Control controlPanel = new Control();
    
    private final int width = 1700;
    private final int height = 900;
    private Color malibu = new Color(107, 185, 240);
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
                playButton(controlPanel.stopButton);
            }
        });
        
        //This is the listener to stop the timer 
        controlPanel.stopButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                timer1.stopTimer();
                addDrawingPanels();
                //timer1.getResultText();
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
        //adds the graph to pane
        Drawing drawingPanel = new Drawing(timer1.getTransList(),timer1.getBalanceList());
        this.getContentPane().add(drawingPanel);
        
        //adds the graph results to pane
        ResultPanelTest results = new ResultPanelTest();
        this.getContentPane().add(results);  
        
        this.setLayoutWithGraph(drawingPanel, results);
        
        //these methods cause the pane to become visible
        this.pack();
        this.revalidate();
    }
    
    public void playButton(JButton graphButton)
    {
       //adds the Timer
        timer1.timer();
    }
    
    private void setLayout()
    {
        //controlPanel.setBackground(malibu);
        setMinimumSize(new java.awt.Dimension(width, height));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(controlPanel)
            )
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(controlPanel)
        );
    }
    
    private void setLayoutWithGraph(JPanel theNewGraphPanel, JPanel theNewResultsPanel)
    {
        theNewResultsPanel.setBackground(malibu);
        theNewGraphPanel.setBackground(malibu);
        setMinimumSize(new java.awt.Dimension(width,height));
        GroupLayout layoutWithGraph = new GroupLayout(getContentPane());
        getContentPane().setLayout(layoutWithGraph);
        
        layoutWithGraph.setHorizontalGroup(
            layoutWithGraph.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layoutWithGraph.createSequentialGroup()
                .addComponent(controlPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(theNewGraphPanel, 700,700,700)
                   // .addComponent(rootPane)
                .addComponent(theNewResultsPanel,300,300,300)
                    //.addComponent(rootPane)    
            )
        );
        layoutWithGraph.setVerticalGroup(
            layoutWithGraph.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(controlPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(theNewGraphPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(theNewResultsPanel,300,300,300)
        );
    }
}
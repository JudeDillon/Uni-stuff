/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitest;
import java.awt.Font;
import static java.awt.SystemColor.text;
import javax.swing.*;

/**
 *
 * @author Ryan
 */

public class ResultPanel extends JPanel
{
    ResultPanel()
    {
        initPanel();
    }
    
    private void initPanel()
    {
        JTextArea textArea = new JTextArea("this is text");
        textArea.setFont(new Font("Serif" , Font.ITALIC, 17));
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
    }
}
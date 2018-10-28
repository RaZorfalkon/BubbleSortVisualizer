import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;

/**
 * BubbleSortVisualizer
 */
public class BubbleSortVisualizer 
{

    private static List<Panel> panelList = new ArrayList<Panel>();
    private static JFrame frame;
    private static Panel mainPanel;

    public BubbleSortVisualizer() { }

    public static void main(String[] args) 
    {
        BuildGui();

        UpdateVisual();

        BubbleSort();
    }

    private static void BubbleSort()
    {
        for (int k = panelList.size() - 1; k > 0; k--)
        {
            for (int i = 0; i < panelList.size() - 1; i++)
            {
                if(panelList.get(i).getHeight() > panelList.get(i + 1).getHeight())
                {
                    Panel panel = panelList.get(i + 1);
                    panelList.set(i + 1, panelList.get(i));
                    panelList.set(i, panel);

                    UpdateVisual();
                    try {
                        Thread.sleep(30);
                    } catch (Exception ex) { }
                }
            }
        }
    }

    private static void BuildGui()
    {
        frame = new JFrame("BubbleSort Visualizer");
        //frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        

        mainPanel = new Panel();
        mainPanel.setSize(300, 300);
        mainPanel.setBackground(Color.gray);
        mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        GeneratePanelList();
        
        UpdateVisual();         
    }

    private static void UpdateVisual()
    {
        for (Panel panel : panelList)
        {
            mainPanel.add(panel);    
        }    

        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private static void GeneratePanelList()
    {
        for (int i = 0; i < mainPanel.getWidth() / 5; i++) 
        {
            Panel panel = new Panel();
            panel.setBackground(Color.DARK_GRAY);
            panel.setSize(5, new Random().nextInt(300));
            panel.setLayout(null);
            
            panelList.add(i, panel); 
        }
    }
}
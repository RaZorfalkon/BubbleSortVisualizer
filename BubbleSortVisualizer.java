import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;

public class BubbleSortVisualizer 
{
    // =======- Values to change -===========
    private static final int COLUMN_WITH = 5;
    private static final int DELAY = 25;
    //=======================================

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
   
    private static void BuildGui()
    {
        frame = new JFrame("BubbleSort Visualizer");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);     

        mainPanel = new Panel();
        mainPanel.setSize(300, 300);
        mainPanel.setBackground(Color.GRAY);
        mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        GeneratePanelList();
        
        for (int i = 0; i < panelList.size(); i++) 
        {
            mainPanel.add(panelList.get(i));       
        }    

        frame.add(mainPanel);
        frame.setVisible(true);

        UpdateVisual();         
    }

    private static void UpdateVisual()
    {
        frame.pack();
        
        try { Thread.sleep(DELAY); } catch (Exception ex) { }
    }

    private static void GeneratePanelList()
    {
        for (int i = 0; i < mainPanel.getWidth() / COLUMN_WITH; i++) 
        {
            Panel panel = new Panel();
            panel.setBackground(Color.LIGHT_GRAY);
            panel.setSize(COLUMN_WITH, new Random().nextInt(300));
            panel.setLayout(null);
            
            panelList.add(i, panel); 
        }
    }

    private static void BubbleSort()
    {
        for (int k = panelList.size() - 1; k > 0; k--)
        {
            for (int i = 0; i < panelList.size() - 1; i++)
            {
                if(panelList.get(i).getHeight() > panelList.get(i + 1).getHeight())
                {
                    Panel panel = new Panel();
                    panel.setSize(COLUMN_WITH, panelList.get(i + 1).getHeight());
                    
                    panelList.get(i + 1).setSize(COLUMN_WITH, panelList.get(i).getHeight());
                    panelList.get(i).setSize(COLUMN_WITH, panel.getHeight());

                    UpdateVisual();
                }
            }
        }
        UpdateVisual();
    }
}
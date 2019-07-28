import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;

public class BubbleSortVisualizer extends JFrame
{
    // =======- Values to change -===========
    private final int COLUMN_WITH = 5;
    private final int DELAY = 30;
    //=======================================

    private List<Panel> panelList = new ArrayList<Panel>();
    private Panel mainPanel;

    public BubbleSortVisualizer() { }

    public static void main(String[] args) 
    {
        BubbleSortVisualizer bsv = new BubbleSortVisualizer();

        bsv.BuildGui(); 

        bsv.UpdateVisual();

        bsv.BubbleSort();
    }
   
    public void BuildGui() 
    {
        this.setTitle("BubbleSort Visualizer");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);     

        mainPanel = new Panel();
        mainPanel.setSize(300, 300);
        mainPanel.setBackground(Color.GRAY);
        mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        GeneratePanelList();
        
        for (int i = 0; i < panelList.size(); i++) 
        {
            mainPanel.add(panelList.get(i));       
        }    

        this.add(mainPanel);
        this.setVisible(true);

        UpdateVisual();         
    }

    public void UpdateVisual()
    {
        this.pack();
        
        try { Thread.sleep(DELAY); } catch (Exception ex) { }
    }

    public void BubbleSort()
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

    private void GeneratePanelList()
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
}

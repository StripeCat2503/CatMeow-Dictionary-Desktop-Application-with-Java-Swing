package app;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;

public class HoverListener extends MouseAdapter{

    private JComponent component;
    private Color enterColor;
    private Color exitColor;
    
    public HoverListener(JComponent component, Color enterColor, Color exitColor){
        this.component = component;
        this.enterColor = enterColor;
        this.exitColor = exitColor;
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        component.setBackground(exitColor);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        component.setBackground(enterColor);
    }
    
}

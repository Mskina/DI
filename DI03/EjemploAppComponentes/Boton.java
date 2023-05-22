import javax.swing.JButton;
import javax.swing.border.*;
import java.awt.Color;
import java.awt.Font;

public class Boton extends JButton{

    Boton(){
        
        setBorder(javax.swing.BorderFactory.createBevelBorder(BevelBorder.RAISED));
        
        setBackground(new Color(142, 178, 200));
        setFont(new Font("SansSerif",Font.BOLD+Font.ITALIC,16)); 
        setAlignmentX(CENTER_ALIGNMENT);
        setForeground(Color.white);
    }
    Boton(String texto){
        super(texto);
        setBorder(javax.swing.BorderFactory.createBevelBorder(BevelBorder.RAISED));
        setBackground(new Color(142, 178, 200));
        setFont(new Font("SansSerif",Font.BOLD+Font.ITALIC,16)); 
        setAlignmentX(CENTER_ALIGNMENT);
        setForeground(Color.white);
    }
    
}

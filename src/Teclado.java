import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Teclado extends Frame{
    private int x;
    private int y;
    private Label lugar;
    private int x1;
    private int y1;
    private boolean bandera=false;
    
    public Teclado(){
        super("Viruz Blog: Eventos de Teclado");
        setSize(400,400);
        setBackground(Color.WHITE);
        x=100;
        y=100;
        x1=200;
        y1=200;
        addEventos();
        addComponentes();
        setVisible(true);
    }
    
 
    @Override
    public void paint(Graphics g){
        if(bandera){
            g.setColor(Color.RED);
            g.fillOval(x,y, 23, 23);

            g.setColor(Color.BLUE);
            g.fillOval(x1, y1, 23, 23);
            
            for(int i = 0; i < 100000000; i++);
            bandera = false;
            repaint();
        }else{
            //ocultar las pelotas grandes
            g.setColor(Color.WHITE);
            g.fillOval(x , y , 20, 20);
            g.fillOval(x1, y1, 20, 20);
            
            //pintar las pelotas normales
            g.setColor(Color.RED);
            g.fillOval(x, y, 20, 20);

            g.setColor(Color.BLUE);
            g.fillOval(x1, y1, 20, 20);
        }
    }

    private void addEventos(){
        //Eventos de Ventana
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        
        //Eventos de teclado
        addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                int codigoTecla = e.getKeyCode();
                switch(codigoTecla){
                  case KeyEvent.VK_UP: y-=5;
                                    if(y<25)
                                       y=25;
                                       break;
                  case KeyEvent.VK_DOWN: y+=5;
                                      if(y>255)
                                         y=255;                     
                                       break;
                  case KeyEvent.VK_LEFT: x-=5;
                                      if(x<0)
                                         x=0; 
                                       break;
                  case KeyEvent.VK_RIGHT: x+=5;
                                       if(x>280)
                                          x=280; 
                }
                int codigoTecla2 = e.getKeyCode();
                 switch(codigoTecla2){
               case KeyEvent.VK_W: y1-=5;
                                if(y1<25)
                                   y1=25;
                                   break;
               case KeyEvent.VK_X: y1+=5;
                                if(y1>255)
                                   y1=255;
                                   break;
               case KeyEvent.VK_A: x1-=5;
                                if(x1<0)
                                   x1=0;
                                   break;
               case KeyEvent.VK_D: x1+=5;
                                if(x1>280)
                                   x1=280; 
           }
              int codigoTecla3 = e.getKeyCode();
               switch(codigoTecla3){
               case KeyEvent.VK_ENTER: bandera=true;
                                   break;
               }
                lugar.setText("Ubicacion de la pelota "+x+","+y+" y pelota 2 "+x1+","+y1);
                repaint();
            }
        });
    }
   
    private void addComponentes(){
        lugar = new Label();
        lugar.setText("Ubicacion de la pelota "+x+","+y+" y pelota 2 "+x1+","+y1);
        add(lugar, BorderLayout.SOUTH);
    }
}
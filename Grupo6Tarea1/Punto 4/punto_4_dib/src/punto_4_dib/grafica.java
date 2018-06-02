package punto_4_dib;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import static punto_4_dib.Punto_4_dib.area;

public class grafica {
    static ArrayList<Point>todos_puntos= new ArrayList<Point>();
    public static void hacer_Linea(Graphics g, int x, int y, int x1, int y1){
        g.drawLine((200/80)*x, (200/80)*y, (200/80)*x1, (200/80)*y1);
    }
    public static void hacer_punto(Graphics g, int x, int y){
        g.drawOval((200/80)*x, (200/80)*y, 5/2, 5/2);
    }
    public static void hacer_Str(Graphics g, String s, int x, int y){
        g.drawString(s, (200/80)*x, (200/80)*y);
    }
    public static void upd(Graphics g){
        g.clearRect(175, 100, 3500, 3000);
        
    }
    public static ArrayList<Point> resolver(int tam){
        todos_puntos= new ArrayList<Point>();
        int N = tam;
 
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < N; i++)
        {
            int x = (int) (Math.random()*80);
            int y = (int) (Math.random()*80);
                    
            Point e = new Point(x, y);
            points.add(i, e);
            todos_puntos.add(i, e);
        }
        Punto_4_dib qh = new Punto_4_dib();
        ArrayList<Point> p = qh.envolvente_Convexa(points);
        return p;
    }
    public static int area_dib(ArrayList<Point> p){
        int res=area(p);
        return res;
    }
    public static ArrayList<Point> puntos_t(){
        return todos_puntos;
    }
}

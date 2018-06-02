package punto_4_dib;

import java.awt.Point;
import java.util.ArrayList;
import views.dibujo_View;

public class Punto_4_dib {
   
    public int distancia_puntos(Point A, Point B, Point C){
        int ABx = B.x - A.x;
        int ABy = B.y - A.y;
        int num = ABx*(A.y - C.y) - ABy*(A.x - C.x);
        if (num < 0)
            num = -num;
        return num;
    }
    
    public static int area(ArrayList<Point> p){
        int x_actual=p.get(0).x;
        int y_actual=p.get(0).y;
        int res=0;
        System.out.println("\n");
        for(int i=1;i<p.size()-1;i++){
            System.out.println("(" + x_actual + ", " + y_actual + ")");
            System.out.println("(" + p.get(i).x + ", " + p.get(i).y + ")");
            System.out.println("(" + p.get(i+1).x + ", " + p.get(i+1).y + ")");
            System.out.println(""+Math.abs(x_actual*(p.get(i).y - p.get(i+1).y)+p.get(i).x*(p.get(i+1).y - y_actual)+p.get(i+1).x*(y_actual - p.get(i).y))/2);
            
            res+=Math.abs(x_actual*(p.get(i).y - p.get(i+1).y)+p.get(i).x*(p.get(i+1).y - y_actual)+p.get(i+1).x*(y_actual - p.get(i).y))/2;
            System.out.println("res: "+res+"\n");
            //x_actual=p.get(i).x;
            //y_actual=p.get(i).y;
        }
        return res;
    }
    
    public ArrayList<Point> envolvente_Convexa(ArrayList<Point> points){
        ArrayList<Point> env_con = new ArrayList<>();
        ArrayList<Point> izq = new ArrayList<>();
        ArrayList<Point> der = new ArrayList<>();
        int p_min = -999; 
        int p_max = -999;
        int minimo = 9999;
        int maximo = -9999;
        
        if (points.size() < 3)
            return (ArrayList) points.clone();
 
        for (int i = 0; i < points.size(); i++)
        {
            if (points.get(i).x < minimo)
            {
                minimo = points.get(i).x;
                p_min = i;
            }
            if (points.get(i).x > maximo)
            {
                maximo = points.get(i).x;
                p_max = i;
            }
        }
        Point A = points.get(p_min);
        Point B = points.get(p_max);
        env_con.add(A);
        env_con.add(B);
        points.remove(A);
        points.remove(B);
 
        for (int i = 0; i < points.size(); i++)
        {
            Point p = points.get(i);
            if (lugar(A, B, p) == -1)
                izq.add(p);
            else if (lugar(A, B, p) == 1)
                der.add(p);
        }
        cam_envolvente(A, B, der, env_con);
        cam_envolvente(B, A, izq, env_con);
 
        return env_con;
    }
    
    public int lugar(Point A, Point B, Point P)
    {
        int res = (B.x - A.x)*(P.y - A.y) - (B.y - A.y)*(P.x - A.x);
        if (res > 0){
            return 1;
        }else{ 
            if (res == 0){
                return 0;
            }else{
                return -1;
            }
        }
        
    }
    
    public void cam_envolvente(Point A, Point B, ArrayList<Point> puntos_c, ArrayList<Point> envo){
        int insertPosition = envo.indexOf(B);
        if (puntos_c.isEmpty())
            return;
        if (puntos_c.size() == 1)
        {
            Point p = puntos_c.get(0);
            puntos_c.remove(p);
            envo.add(insertPosition, p);
            return;
        }
        int dist = Integer.MIN_VALUE;
        int furthestPoint = -1;
        for (int i = 0; i < puntos_c.size(); i++)
        {
            Point p = puntos_c.get(i);
            int distancia_puntos = distancia_puntos(A, B, p);
            if (distancia_puntos > dist)
            {
                dist = distancia_puntos;
                furthestPoint = i;
            }
        }
        Point P = puntos_c.get(furthestPoint);
        puntos_c.remove(furthestPoint);
        envo.add(insertPosition, P);
        
        
        ArrayList<Point> izqPB = new ArrayList<>();
        for (int i = 0; i < puntos_c.size(); i++)
        {
            Point M = puntos_c.get(i);
            if (lugar(P, B, M) == 1)
            {
                izqPB.add(M);
            }
        }
        ArrayList<Point> izqAP = new ArrayList<>();
        for (int i = 0; i < puntos_c.size(); i++)
        {
            Point M = puntos_c.get(i);
            if (lugar(A, P, M) == 1)
            {
                izqAP.add(M);
            }
        }
        cam_envolvente(A, P, izqAP, envo);
        cam_envolvente(P, B, izqPB, envo);
 
    }
    
    public static void main(String[] args) {
        dibujo_View as=new dibujo_View();
        as.setVisible(true);
       
    }
    
}

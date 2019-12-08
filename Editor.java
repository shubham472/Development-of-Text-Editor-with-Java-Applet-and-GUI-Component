import java.awt.*;
import java.io.*;
import java.lang.*;
import java.awt.event.*;
import java.applet.*;
public class key extends Applet implements KeyListener, MouseListener, MouseMotionListener
{  String msg="" ,b=" ",cpy="";
   int cps=0,sft=0,ctrl=0,num=0,cr=0,x,selected=0,vx1,vx2,vy1,vy2,p=0,q=0,tp=0,tq=0,lc=0;
   public void init()
   {  addKeyListener(this); requestFocus(); addMouseListener(this); addMouseMotionListener(this); }
   public int recLine(){
    int t,i,j;
    t=(q-70)/20;
    i=t*20;
    j=(t+1)*20;
    if(t!=0){
      if(Math.abs(i-q)<Math.abs(j-q)) t--;
    }
    return t;
  }
   public void keyPressed(KeyEvent ke)
   {  int key=ke.getKeyCode();
      if((key>30)&&(key<123)&& key!=32){
        if(cps==0){key=key+32;}
        msg=msg+(char)key;repaint();
      }
      x=msg.length();
      switch(key)
      {
         case KeyEvent.VK_F1:msg=msg.substring(1); break;
         case KeyEvent.VK_F2:msg=msg.substring(0,x-2); break;
         case KeyEvent.VK_F3:repaint(); break;
         case KeyEvent.VK_PAGE_DOWN:msg +="<pgDn>"; break;
         case KeyEvent.VK_PAGE_UP:msg +="<pgUn>"; break;
         case KeyEvent.VK_LEFT:msg +="<Left Arrow>"; break;
         case KeyEvent.VK_RIGHT:msg +="<right Arrow>"; break;
         case KeyEvent.VK_ENTER:msg =msg+"\n"; break;
         case KeyEvent.VK_BACK_SPACE:if(x==0)return; msg=msg.substring(0,x-1)+msg.substring(x);x--;repaint();break;
         case KeyEvent.VK_SPACE: msg=msg.substring(0,x)+" "+msg.substring(x); x++; repaint(); break;
         case KeyEvent.VK_SHIFT:sft=1; cr=Math.abs(cr-32); break;
         case KeyEvent.VK_NUM_LOCK:num=1; break;
       }
   }
   public void keyReleased(KeyEvent ke)
   { 
       int key=ke.getKeyCode();
       switch(key)
       {
          case KeyEvent.VK_CAPS_LOCK:if(cps==0){cps=1; cr=0;} else{cps=0; cr=32;}break;
          case KeyEvent.VK_SHIFT: cr=Math.abs(cr-32); sft=0; break;
        }
   }
   public void keyTyped(KeyEvent ke){ }
   public void mouseClicked(MouseEvent k){
     int p=k.getX(), q=k.getY(); 
      
   }
   public void mouseEntered(MouseEvent k){ }
   public void mouseExited(MouseEvent m){ }
   public void mousePressed(MouseEvent n){
      p=k.getX(), q=k.getY(); 
      if((p>50 && p<1250) && (q>50 && q<580)){
        int t=recLine();
        p=(p-60)/7;
        if(selected==0)selected=1;
        vx1=p;
        vy1=t;
      }

    }
   public void mouseReleased(MouseEvent k){
    p=k.getX(), q=k.getY(); 
    if(selected==1){
      vy2=recLine();
      vx2=(p-60)/7;
      selected=0;
    }
   }
   public void mouseDragged(MouseEvent k){
    tp=p;
    tq=q;
    p=k.getX(),q=k.getY();
    int t=recLine();
    p=(p-60)/7;
    if((p>50 && p<1250) && (q>50 && q<580)){
      if()
    }
    else {p=tp;q=tq}
   }
   public void mouseMoved(MouseEvent e){ }
   public void paint(Graphics g)
   { String a,b,c,d,e,f,h;
     int i,j,y,z;
     g.drawRect(0,0,30,20);            //Menu bar
     g.drawString("New",2,15);
     g.drawRect(30,0,40,20);
     g.drawString("Open",34,15);
     g.drawRect(70,0,40,20);
     g.drawString("Save",74,15);
     g.drawRect(110,0,70,20);
     g.drawString("Save as..",114,15);
     g.drawRect(180,0,30,20);
     g.drawString("Exit",184,15);     //Menu bar
     g.drawRect(210,0,1090,20);
     g.drawRect(50,50,1200,530);
     int v=0,k=70;
     for(j=0;j<msg.length();j++){
        if(msg.charAt(j)=='\n'){
          v=0;
          k=k+20;
          g.drawString("",v*7+60,k);
        }
        else{
          g.drawString(msg.substring(j,j+1),(v*7+60),k);
          v++;
        }
      }
  
     /*a=""+msg;
     i=a.indexOf(' ');
     if(i>0){
        b=a.substring(0,i);
        c=a.substring(i+1);
        if(b.charAt(i-6)=='C' && b.charAt(i-1)=='E') g.drawOval(30,40,20,20);
        else if(b.charAt(i-9)=='R' && b.charAt(i-1)=='E') g.drawRect(10,100,50,70);
      }*/
    }
}
/* if(i>0){
       b=a.substring(0,i);
       c=a.substring(i+1);
       j=c.indexOf(' ');
       if(j>0){ d=c.substring(0,j);
          e=c.substring(j+1);
          k=e.indexOf(' ');
          if(k>0){
             f=e.substring(0,k);
             h=e.substring(k+1);
             x=Integer.parseInt(d); 
             y=Integer.parseInt(f); 
             z=Integer.parseInt(h);
             if(b.charAt(i-6)=='C'&&b.charAt(i-1)=='E')  g.drawOval(x-z,y-z,2*z,2*z); 
           }
        }     
     }*/

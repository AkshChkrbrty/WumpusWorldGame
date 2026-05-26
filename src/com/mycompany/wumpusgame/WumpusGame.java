package com.mycompany.wumpusgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.net.URL;

public class WumpusGame extends JFrame {
       public String board[][] = new String[8][16];
       public int a[]=new int[128];
       public int pos;
       public int win=8;
       public int pp;
       public JFrame frame;
       public JPanel panel;
       public JPanel sq[][]=new JPanel[8][16];
       public JButton btnStart;
       public JButton btnNewGame;
       public JButton btnLeft;
       public JButton btnRight;
       public JButton btnUp;
       public JButton btnDown;
       public JButton hitLeft;
       public JButton hitRight;
       public JButton hitUp;
       public JButton hitDown;
       public JPanel controlPanel;
       private ImageIcon playerIcon;

       public WumpusGame() {
           // Load player image from inside the JAR
           URL imgUrl = WumpusGame.class.getResource("/player.png");
           if (imgUrl != null) {
               playerIcon = new ImageIcon(imgUrl);
           } else {
               // Fallback: draw a colored square if image not found
               playerIcon = null;
           }
       }

       private JLabel makePlayerLabel() {
           if (playerIcon != null) {
               return new JLabel(playerIcon);
           } else {
               JLabel lbl = new JLabel("P");
               lbl.setForeground(Color.RED);
               lbl.setFont(new Font("Arial", Font.BOLD, 14));
               return lbl;
           }
       }

       public void prepareBoard(){
            for (int i=0;i<8;i++){
                for(int j=0;j<16;j++)
                          board[i][j]="X";
                   }
            for(int i=0;i<128;i++)
                a[i]=0;
            int c=0;
            while(true){
                Random rand = new Random();
                int r=rand.nextInt(128);
                if (a[r]!=0)
                    continue;
                else if(r==0||r==1||r==16)
                    continue;
                else if(r==15){
                    a[15]=3;
                    a[14]=(a[14]!=3)?2:3;
                    a[31]=(a[31]!=3)?2:3;
                    c++;
                }
                else if(r==127){
                    a[127]=3;
                    a[126]=(a[126]!=3)?2:3;
                    a[111]=(a[111]!=3)?2:3;
                    c++;
                }
                else if(r==112){
                    a[112]=3;
                    a[113]=(a[113]!=3)?2:3;
                    a[96]=(a[96]!=3)?2:3;
                    c++;
                }
                else if(r!=112 && r!=0 && r%16==0){
                    a[r]=(r!=16)?3:0;
                   a[r+16]=(a[r]==16)?0:(a[r+16]!=3)?2:3;
                   a[r-16]=(a[r]==16)?0:(a[r+16]!=3)?2:3;
                   a[r+1]=(a[r+1]!=3)?2:3;
                   c++;
                }
                else if(r>=2 && r<=14){
                    a[r]=3;
                   a[r+1]=(a[r+1]!=3)?2:3;
                   a[r-1]=(a[r-1]!=3)?2:3;
                   a[r+16]=(a[r+16]!=3)?2:3;
                   c++;
                }
                else if(r>=113 && r<=126){
                    a[r]=3;
                   a[r+1]=(a[r+1]!=3)?2:3;
                   a[r-1]=(a[r-1]!=3)?2:3;
                   a[r-16]=(a[r-16]!=3)?2:3;
                   c++;
                }
                else if (r!=15 && r!=127 && (r-1)%16==0){
                   a[r]=3;
                   a[r+16]=(a[r+16]!=3)?2:3;
                   a[r-16]=(a[r-16]!=3)?2:3;
                   c++;
                }
                else{
                    a[r]=3;
                   a[r+16]=(a[r+16]!=3)?2:3;
                   a[r-16]=(a[r-16]!=3)?2:3;
                   a[r+1]=(a[r+1]!=3)?2:3;
                   a[r-1]=(a[r-1]!=3)?2:3;
                   c++;
                }
                if (c==8)
                    break;
            }
            c=0;
            while(true){
                Random rand = new Random();
                int r=rand.nextInt(128);
                if (a[r]!=0)
                    continue;
                else if(r==0||r==1||r==16)
                    continue;
                else if(r==15){
                    a[15]=5;
                    a[14]=(a[14]!=3)?4:5;
                    a[31]=(a[31]!=3)?4:5;
                    c++;
                }
                else if(r==127){
                    a[127]=5;
                    a[126]=(a[126]!=3)?4:5;
                    a[111]=(a[111]!=3)?4:5;
                    c++;
                }
                else if(r==112){
                    a[112]=5;
                    a[113]=(a[113]!=3)?4:5;
                    a[96]=(a[96]!=3)?4:5;
                    c++;
                }
                else if(r!=112 && r!=0 && r%16==0){
                    a[r]=(r!=16)?5:0;
                   a[r+16]=(a[r]==16)?0:(a[r+16]!=3)?4:5;
                   a[r-16]=(a[r]==16)?0:(a[r+16]!=3)?4:5;
                   a[r+1]=(a[r+1]!=3)?4:5;
                   c++;
                }
                else if(r>=2 && r<=14){
                    a[r]=5;
                   a[r+1]=(a[r+1]!=3)?4:5;
                   a[r-1]=(a[r-1]!=3)?4:5;
                   a[r+16]=(a[r+16]!=3)?4:5;
                   c++;
                }
                else if(r>=113 && r<=126){
                    a[r]=5;
                   a[r+1]=(a[r+1]!=3)?4:5;
                   a[r-1]=(a[r-1]!=3)?4:5;
                   a[r-16]=(a[r-16]!=3)?4:5;
                   c++;
                }
                else if (r!=15 && r!=127 && (r-1)%16==0){
                   a[r]=5;
                   a[r+16]=(a[r+16]!=3)?4:5;
                   a[r-16]=(a[r-16]!=3)?4:5;
                   c++;
                }
                else{
                    a[r]=5;
                   a[r+16]=(a[r+16]!=3)?4:5;
                   a[r-16]=(a[r-16]!=3)?4:5;
                   a[r+1]=(a[r+1]!=3)?4:5;
                   a[r-1]=(a[r-1]!=3)?4:5;
                   c++;
                }
                if (c==8)
                    break;
            }
            c=0;
            while(true){
                Random rand = new Random();
                int r=rand.nextInt(128);
                if (a[r]==0){
                    a[r]=6;
                     c++;
                }
                if (c==8)
                    break;
            }
       }
       
       public void gameGraphics(){
        JFrame frame = new JFrame("Defeat the Wumpus");
        frame.setSize(1000, 1000);
        frame.setLocation(10, 10);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        JLabel label = new JLabel(
            "<html>Press ← for Left Move&nbsp;&nbsp;|&nbsp;&nbsp;Press → for Right Move&nbsp;&nbsp;|&nbsp;&nbsp;Press ↑ for Up&nbsp;&nbsp;|&nbsp;&nbsp;Press ↓ for Down</html>"
        );
        frame.add(label, BorderLayout.NORTH);
        panel = new JPanel(new GridLayout(8, 16));
        sq = new JPanel[8][16];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 16; j++) {
                sq[i][j] = new JPanel();
                sq[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
                sq[i][j].add(new JLabel("X"));
                panel.add(sq[i][j]);
            }
        }
        frame.add(panel, BorderLayout.CENTER);
        controlPanel = new JPanel(new FlowLayout());
        btnStart = new JButton("Start");
        btnNewGame = new JButton("New Game");
        btnLeft = new JButton("Left");
        btnRight = new JButton("Right");
        btnUp = new JButton("Up");
        btnDown = new JButton("Down");
        hitLeft = new JButton("Hit Left");
        hitRight = new JButton("Hit Right");
        hitUp = new JButton("Hit Up");
        hitDown = new JButton("Hit Down");
        controlPanel.add(btnStart);
        controlPanel.add(btnNewGame);
        controlPanel.add(btnLeft);
        controlPanel.add(btnRight);
        controlPanel.add(btnUp);
        controlPanel.add(btnDown);
        controlPanel.add(hitLeft);
        controlPanel.add(hitRight);
        controlPanel.add(hitUp);
        controlPanel.add(hitDown);
        frame.add(controlPanel, BorderLayout.SOUTH);
        btnStart.addActionListener(e -> startBtn());
        btnNewGame.addActionListener(e -> newGameBtn());
        btnLeft.addActionListener(e -> {
            moveLeft();
            checkWin();
        });
        btnRight.addActionListener(e -> {
            moveRight();
            checkWin();
        });
        btnUp.addActionListener(e -> {
            moveUp();
            checkWin();
        });
        btnDown.addActionListener(e -> {
            moveDown();
            checkWin();
        });
        hitLeft.addActionListener(e -> hitLeft());
        hitRight.addActionListener(e -> hitRight());
        hitUp.addActionListener(e -> hitUp());
        hitDown.addActionListener(e -> hitDown());
        frame.setVisible(true);
       }

public void moveLeft() {
    int oldRow = pp / 16;
    int oldCol = pp % 16;

    sq[oldRow][oldCol] = new JPanel();
    sq[oldRow][oldCol].setBackground(Color.CYAN);
    sq[oldRow][oldCol].setBorder(BorderFactory.createLineBorder(Color.BLACK));
    if (a[pp] == 2) sq[oldRow][oldCol].add(new JLabel("Stench"));
    if (a[pp] == 4) sq[oldRow][oldCol].add(new JLabel("Breeze"));
    if (a[pp] == 6) { sq[oldRow][oldCol].add(new JLabel("Gold")); win--;a[pp]=7;}
    if (a[pp] == 7) { sq[oldRow][oldCol].add(new JLabel("Gold"));}
    if (a[pp] == 3) showGameOver();
    if (a[pp] == 5) showGameOver();
    panel.remove(oldRow * 16 + oldCol);
    panel.add(sq[oldRow][oldCol], oldRow * 16 + oldCol);

    pp = (pp % 16 == 0) ? pp : pp - 1;

    int newRow = pp / 16;
    int newCol = pp % 16;

    sq[newRow][newCol] = new JPanel();
    sq[newRow][newCol].setBackground(Color.CYAN);
    sq[newRow][newCol].setBorder(BorderFactory.createLineBorder(Color.BLACK));
    sq[newRow][newCol].add(makePlayerLabel());
    if (a[pp] == 2) sq[newRow][newCol].add(new JLabel("Stench"));
    if (a[pp] == 4) sq[newRow][newCol].add(new JLabel("Breeze"));
    if (a[pp] == 6) { sq[newRow][newCol].add(new JLabel("Gold")); win--; a[pp]=7; }
    if (a[pp] == 7) { sq[newRow][newCol].add(new JLabel("Gold"));}
    if (a[pp] == 3) showGameOver();
    if (a[pp] == 5) showGameOver();
    panel.remove(newRow * 16 + newCol);
    panel.add(sq[newRow][newCol], newRow * 16 + newCol);

    panel.revalidate();
    panel.repaint();
}

public void moveRight() {
    int oldRow = pp / 16;
    int oldCol = pp % 16;

    sq[oldRow][oldCol] = new JPanel();
    sq[oldRow][oldCol].setBackground(Color.CYAN);
    sq[oldRow][oldCol].setBorder(BorderFactory.createLineBorder(Color.BLACK));
    if (a[pp] == 2) sq[oldRow][oldCol].add(new JLabel("Stench"));
    if (a[pp] == 4) sq[oldRow][oldCol].add(new JLabel("Breeze"));
    if (a[pp] == 6) { sq[oldRow][oldCol].add(new JLabel("Gold")); win--;a[pp]=7; }
    if (a[pp] == 7) { sq[oldRow][oldCol].add(new JLabel("Gold"));}
    panel.remove(oldRow * 16 + oldCol);
    panel.add(sq[oldRow][oldCol], oldRow * 16 + oldCol);

    pp = ((pp + 1) % 16 == 0) ? pp : pp + 1;

    int newRow = pp / 16;
    int newCol = pp % 16;

    sq[newRow][newCol] = new JPanel();
    sq[newRow][newCol].setBackground(Color.CYAN);
    sq[newRow][newCol].setBorder(BorderFactory.createLineBorder(Color.BLACK));
    sq[newRow][newCol].add(makePlayerLabel());
    if (a[pp] == 2) sq[newRow][newCol].add(new JLabel("Stench"));
    if (a[pp] == 4) sq[newRow][newCol].add(new JLabel("Breeze"));
    if (a[pp] == 6) { sq[newRow][newCol].add(new JLabel("Gold")); win--;a[pp]=7; }
    if (a[pp] == 7) { sq[newRow][newCol].add(new JLabel("Gold"));}
    if (a[pp] == 3) showGameOver();
    if (a[pp] == 5) showGameOver();
    panel.remove(newRow * 16 + newCol);
    panel.add(sq[newRow][newCol], newRow * 16 + newCol);

    panel.revalidate();
    panel.repaint();
}

public void moveUp() {
    int oldRow = pp / 16;
    int oldCol = pp % 16;

    sq[oldRow][oldCol] = new JPanel();
    sq[oldRow][oldCol].setBackground(Color.CYAN);
    sq[oldRow][oldCol].setBorder(BorderFactory.createLineBorder(Color.BLACK));
    if (a[pp] == 2) sq[oldRow][oldCol].add(new JLabel("Stench"));
    if (a[pp] == 4) sq[oldRow][oldCol].add(new JLabel("Breeze"));
    if (a[pp] == 6) { sq[oldRow][oldCol].add(new JLabel("Gold")); win--;a[pp]=7;}
    if (a[pp] == 7) { sq[oldRow][oldCol].add(new JLabel("Gold"));}
    panel.remove(oldRow * 16 + oldCol);
    panel.add(sq[oldRow][oldCol], oldRow * 16 + oldCol);

    pp = (pp >= 0 && pp <= 15) ? pp : pp - 16;

    int newRow = pp / 16;
    int newCol = pp % 16;

    sq[newRow][newCol] = new JPanel();
    sq[newRow][newCol].setBackground(Color.CYAN);
    sq[newRow][newCol].setBorder(BorderFactory.createLineBorder(Color.BLACK));
    sq[newRow][newCol].add(makePlayerLabel());
    if (a[pp] == 2) sq[newRow][newCol].add(new JLabel("Stench"));
    if (a[pp] == 4) sq[newRow][newCol].add(new JLabel("Breeze"));
    if (a[pp] == 6) { sq[newRow][newCol].add(new JLabel("Gold")); win--;a[pp]=7; }
    if (a[pp] == 7) { sq[newRow][newCol].add(new JLabel("Gold"));}
    if (a[pp] == 3) showGameOver();
    if (a[pp] == 5) showGameOver();
    panel.remove(newRow * 16 + newCol);
    panel.add(sq[newRow][newCol], newRow * 16 + newCol);

    panel.revalidate();
    panel.repaint();
}

public void moveDown() {
    int oldRow = pp / 16;
    int oldCol = pp % 16;

    sq[oldRow][oldCol] = new JPanel();
    sq[oldRow][oldCol].setBackground(Color.CYAN);
    sq[oldRow][oldCol].setBorder(BorderFactory.createLineBorder(Color.BLACK));
    if (a[pp] == 2) sq[oldRow][oldCol].add(new JLabel("Stench"));
    if (a[pp] == 4) sq[oldRow][oldCol].add(new JLabel("Breeze"));
    if (a[pp] == 6) { sq[oldRow][oldCol].add(new JLabel("Gold")); win--;a[pp]=7; }
    if (a[pp] == 7) { sq[oldRow][oldCol].add(new JLabel("Gold"));}
    panel.remove(oldRow * 16 + oldCol);
    panel.add(sq[oldRow][oldCol], oldRow * 16 + oldCol);

    pp = (pp >= 112 && pp <= 127) ? pp : pp + 16;

    int newRow = pp / 16;
    int newCol = pp % 16;

    sq[newRow][newCol] = new JPanel();
    sq[newRow][newCol].setBackground(Color.CYAN);
    sq[newRow][newCol].setBorder(BorderFactory.createLineBorder(Color.BLACK));
    sq[newRow][newCol].add(makePlayerLabel());
    if (a[pp] == 2) sq[newRow][newCol].add(new JLabel("Stench"));
    if (a[pp] == 4) sq[newRow][newCol].add(new JLabel("Breeze"));
    if (a[pp] == 6) { sq[newRow][newCol].add(new JLabel("Gold")); win--;a[pp]=7; }
    if (a[pp] == 7) { sq[newRow][newCol].add(new JLabel("Gold"));}
    if (a[pp] == 3) showGameOver();
    if (a[pp] == 5) showGameOver();
    panel.remove(newRow * 16 + newCol);
    panel.add(sq[newRow][newCol], newRow * 16 + newCol);

    panel.revalidate();
    panel.repaint();
}

public void hitLeft(){
     if (a[pp] == 2){
         a[pp-1]=(a[pp-1]==3)?0:a[pp-1];
         a[pp-2]=0;
         a[pp-1+16]=0;
         a[pp-1-16]=0;
         a[pp]=0;
     }   
}
public void hitRight(){
     if (a[pp] == 2){
         a[pp+1]=(a[pp+1]==3)?0:a[pp+1];
         a[pp+2]=0;
         a[pp+1+16]=0;
         a[pp+1-16]=0;
         a[pp]=0;
     }   
}
public void hitUp(){
     if (a[pp] == 2){
         a[pp-16]=(a[pp-16]==3)?0:a[pp-16];
         a[pp-32]=0;
         a[pp-17]=0;
         a[pp-15]=0;
         a[pp]=0;
     }   
}
public void hitDown(){
     if (a[pp] == 2){
         a[pp+16]=(a[pp+16]==3)?0:a[pp+16];
         a[pp+32]=0;
         a[pp+17]=0;
         a[pp+15]=0;
         a[pp]=0;
     }   
}

public void showGameOver() {
    JFrame go = new JFrame("Game Over");
    go.setLayout(new BorderLayout());
    go.add(new JLabel("💀 Game Over! You were killed!", SwingConstants.CENTER), BorderLayout.CENTER);
    JButton restartBtn = new JButton("New Game");
    restartBtn.addActionListener(e -> { go.dispose(); newGameBtn(); });
    go.add(restartBtn, BorderLayout.SOUTH);
    go.setSize(280, 120);
    go.setLocationRelativeTo(null);
    go.setVisible(true);
}

public void startBtn(){
    sq[0][0] = new JPanel();
    sq[0][0].setBackground(Color.CYAN);
    sq[0][0].setBorder(BorderFactory.createLineBorder(Color.BLACK));
    sq[0][0].add(makePlayerLabel());
    if(a[0]==2){ sq[0][0].add(new JLabel("Stench")); }
    if(a[0]==4){ sq[0][0].add(new JLabel("Breeze")); }
    if(a[0]==6){ sq[0][0].add(new JLabel("Gold")); win--; }
    panel.remove(0);
    panel.add(sq[0][0], 0);
    panel.revalidate();
    panel.repaint();
    pp=0;
}

public void newGameBtn(){
    WumpusGame wg = new WumpusGame();
    wg.prepareBoard();
    wg.gameGraphics();
}

public void checkWin() {
    if (win == 0) {
        JFrame winFrame = new JFrame("Victory!");
        winFrame.setLayout(new BorderLayout());
        winFrame.add(new JLabel("🎉 Congratulations, You Won! 🎉", SwingConstants.CENTER), BorderLayout.CENTER);
        JButton restartBtn = new JButton("New Game");
        restartBtn.addActionListener(e -> { winFrame.dispose(); newGameBtn(); });
        winFrame.add(restartBtn, BorderLayout.SOUTH);
        winFrame.setSize(300, 120);
        winFrame.setLocationRelativeTo(null);
        winFrame.setVisible(true);
    }
}

public static void main(String args[]){
    WumpusGame g = new WumpusGame();
    g.prepareBoard();
    g.gameGraphics();
}

}

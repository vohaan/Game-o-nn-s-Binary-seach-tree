/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameDoanSo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class GIT extends JFrame implements ActionListener{   
    
    public static void main(String args[]){
        new GIT();
        }
    
    private JLabel SD,SC,sinhvien,Result ;
    private JTextField SD1,SC2;
    private JButton NewGame,Exit,Nhap;
    public GIT(){
        Container mainPane = getContentPane();
        mainPane.setLayout(new FlowLayout());
        JFrame game = new JFrame();
        mainPane.setBackground(Color.CYAN);
        
        
        JPanel p1 = new JPanel();
        sinhvien = new JLabel("Nguyễn Duy Tân , "+" Võ Hà An ");
        sinhvien.setBackground(Color.green);
        sinhvien.setOpaque(true);
        p1.add(sinhvien);
        //mainPane.add(p1, BorderLayout.NORTH);
        
        
        JPanel p2 = new JPanel();
        SD = new JLabel("Nhập Số đầu");
        p2.add(SD);
        SD1 = new JTextField(5);   
        p2.add(SD1);
        SC = new JLabel("Nhập Số cuối");
        p2.add(SC);
        SC2 = new JTextField(5);
        p2.add(SC2);
        mainPane.add(p2, BorderLayout.CENTER);
        
        JPanel p3 = new JPanel();
        NewGame = new JButton("New Game");
        p3.add(NewGame); 
        NewGame.addActionListener(this);
        Nhap = new JButton("Run");
        p3.add(Nhap);
        Nhap.addActionListener(this);
        Exit = new JButton("Exit");
        p3.add(Exit);
        Exit.addActionListener(this);       
        mainPane.add(p3, BorderLayout.CENTER);
        
        setSize(400,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);        
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object c = event.getSource();    
        if (c == NewGame){
            SD1.setText("");
            SC2.setText("");
            return;      
        }
        if(c == Nhap){
           int num1=Integer.parseInt(SD1.getText());
           int num2=Integer.parseInt(SC2.getText());
           int bodem = 1;
           int slpt = num2-num1;
           int count = 0;
            while (true){
                while (slpt !=0){
                    slpt/=2;
                    count++;
                    }
                int x = (num1+num2) / 2;
                if (num1 == x) {                 
                    JOptionPane.showMessageDialog(null,"Số của bạn đang nghĩ là :  " + x + ".");
                    break;
                }
                int result = JOptionPane.showConfirmDialog(null,
                        "Mình sẽ hỏi " + count + " lần!" +
                        "\nLần đoán thứ " + bodem + 
                        "\nSố của bạn nhỏ hơn : " + x + "?" ,
                        "Vui lòng chọn",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if(result == JOptionPane.YES_OPTION){
                    num2 = x;
                    bodem+=1;
                    }
                else if(result == JOptionPane.NO_OPTION){
                    num1 = x;
                    bodem+=1;
                    }
                else{
                    break;
                    }
                }         
            }
           if(c == Exit){
               System.exit(0);
           }        
        }  
    }

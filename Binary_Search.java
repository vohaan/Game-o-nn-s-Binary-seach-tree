/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TKNP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class Binary_Search extends JFrame implements ActionListener{
    
    public static void main(String[] args){       
    new Binary_Search();
    }
    
    private JTextField Nhap, Mang, MSapXep,search1;
    private JLabel PTNhap,XuatMNhap, XuatMSapXep,search;
    private JButton Tim,Min,Max,SapXep,XuatMang,Exit;
    private int arr[];
    
    public Binary_Search() {
        initComponent();
    }
    
    private void initComponent(){     
        Container mainPane = getContentPane();
        mainPane.setLayout(new FlowLayout());
        mainPane.setBackground(Color.CYAN);
        
        JPanel p1 = new JPanel();
        PTNhap = new JLabel("Nhập  : ");
        p1.add(PTNhap);
        PTNhap.setForeground(Color.RED);
        Nhap = new JTextField(5);
        p1.add(Nhap);
        mainPane.add(p1, BorderLayout.NORTH);               
        
        JPanel p2 = new JPanel();
        XuatMNhap = new JLabel("Mảng : ");
        p2.add(XuatMNhap);
        XuatMNhap.setForeground(Color.RED);
        Mang = new JTextField(30);
        p2.add(Mang);
        mainPane.add(p2, BorderLayout.CENTER);
        
        JPanel p3 = new JPanel();
        XuatMSapXep = new JLabel("Mảng được sắp xếp");
        p3.add(XuatMSapXep);
        XuatMSapXep.setForeground(Color.RED);
        MSapXep = new JTextField(30);
        p3.add(MSapXep);
        mainPane.add(p3, BorderLayout.CENTER);
        
        JPanel p4 = new JPanel();
        search = new JLabel("PT cần Tìm");
        p4.add(search);
        search.setForeground(Color.RED);
        search1 = new JTextField(5);
        p4.add(search1);
        mainPane.add(p4, BorderLayout.CENTER);
        
        JPanel p5 = new JPanel();
        Tim = new JButton("Tìm");
        p5.add(Tim); 
        Tim.addActionListener(this);
        Tim.setForeground(Color.BLUE);
        SapXep = new JButton("Sắp Xếp");
        p5.add(SapXep); 
        SapXep.addActionListener(this);
        SapXep.setForeground(Color.BLUE);
        XuatMang = new JButton("Xuất mảng");
        p5.add(XuatMang);
        XuatMang.addActionListener(this);
        XuatMang.setForeground(Color.BLUE);
        mainPane.add(p5, BorderLayout.SOUTH);
        
        JPanel p6 = new JPanel();
        Min = new JButton("Min");
        p6.add(Min); 
        Min.addActionListener(this);
        Min.setForeground(Color.BLUE);
        Max = new JButton("Max");
        p6.add(Max); 
        Max.addActionListener(this);
        Max.setForeground(Color.BLUE);
        mainPane.add(p6, BorderLayout.SOUTH);
        Exit = new JButton("Thoát");
        p6.add(Exit);
        Exit.addActionListener(this);
        Exit.setForeground(Color.BLUE);
        
        setSize(450,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        Object c = event.getSource();
        if( c == XuatMang){
        int n = Integer.parseInt(Nhap.getText());     
        Random rand = new Random();
        arr = new int[n];
        for( int i = 0 ; i < n ; i++){
            arr[i] = rand.nextInt(100)+1;
        }
        Mang.setText("" + Arrays.toString(arr));
        }
        if(c == Tim){
            int name = Integer.parseInt(search1.getText());
            int index = binarySearch(arr,name,0,arr.length-1);
            if (index >= 0){
                JOptionPane.showMessageDialog(null,"Tìm thấy tại vị trí " + index);
            }
            else{
                JOptionPane.showMessageDialog(null, "Không tìm thấy " + name + "!");
            }    
        }
        if(c == SapXep){
            //Arrays.sort(arr);
            quickSort(arr,0,arr.length-1);
            MSapXep.setText("" + Arrays.toString(arr));          
        }
        if(c == Min){  
            int min = arr[0];
            for(int i = 0; i< arr.length ; i++){
                if(arr[i]<min){
                    min = arr[i];
                }
            }
            JOptionPane.showMessageDialog(null,"Giá trị nhỏ nhất là " + min);//arr[0]);
        }
        if(c == Max){
            int max = arr[0];
            for(int i = 0; i < arr.length ; i++){
                if(arr[i]>max){
                    max = arr[i];
                }
            }
            JOptionPane.showMessageDialog(null,"Giá trị lớn nhất là " + max); //arr[arr.length-1]);
        }
        if( c == Exit){
            System.exit(0);
        }
    }
    public int binarySearch(int[] arr, int giatri, int lowIndex, int highIndex){
        if (lowIndex > highIndex) 
            return -1;
        int midIndex = lowIndex + (highIndex - lowIndex) / 2;
        if (arr[midIndex] == giatri) 
            return midIndex;
        if (arr[midIndex] > giatri)
            return binarySearch(arr, giatri, lowIndex, midIndex-1);
        else
            return binarySearch(arr, giatri, midIndex+1, highIndex);
    }
    void quickSort(int[] arr, int left, int right) {
    if (arr == null || arr.length == 0)
      return;

    if (left >= right)
      return;

    int middle = left + (right - left) / 2;
    int chot = arr[middle];
    int i = left, j = right;

    while (i <= j) {
      while (arr[i] < chot) {
        i++;
      }

      while (arr[j] > chot) {
        j--;
      }

      if (i <= j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
      }
    }

    if (left < j)
      quickSort(arr, left, j);

    if (right > i)
      quickSort(arr, i, right);
}
}
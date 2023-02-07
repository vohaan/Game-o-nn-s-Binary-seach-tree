package game;

import java.util.Scanner;

public class ds {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bạn hãy nghĩ về một số");
        System.out.print("Số từ khoảng : ");
        int lower = sc.nextInt();
        System.out.print("Đến khoảng : ");
        int upper = sc.nextInt();
        int slpt = upper - lower;
        int bodem=1;
        int count=0;
        System.out.println("Số của bạn nghĩ trong khoảng từ " + lower + " đến " + upper);
        while (true) {
            while (slpt !=0){
            slpt/=2;
            count++;  
            }        
            System.out.println("Mình sẽ hỏi " + count + " lần!");          
            int x = (lower + upper) / 2;
            if (lower == x) {
                System.out.println("Có phải số của bạn đang nghĩ là : " + x + "!");
                break;
            }
            System.out.println("Lần đoán thứ : " + bodem);
            System.out.println("Số của bạn nhỏ hơn " + (int)x + " ?");
            String truth = sc.next();
            if (truth.equals("y")) {
                upper = x;
                bodem+=1;
            }
            if (truth.equals("n")) {
                lower = x;
                bodem+=1;
            }
        } 
    }
}

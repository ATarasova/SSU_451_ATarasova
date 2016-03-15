import java.util.*;

/**
 * Created by tarasovaAA on 01.03.2016.
 */

public class Main {

    public static boolean checkString(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Basket basket = new BasketMain();

        while(true){
            System.out.println("Enter your solution:" +
                    "\n1 - Add" +
                    "\n2 - Del" +
                    "\n3 - Change" +
                    "\n4 - Clear" +
                    "\n5 - Number of returning goods" +
                    "\n6 - All goods" +
                    "\nclose - exit");
            Scanner coming = new Scanner(System.in);
            String str = coming.next();
            if (str.contains("close")) {
                System.exit(0);
            }
            if (!checkString(str)){
                continue;
            }

            Integer x = Integer.valueOf(str);
            switch (x) {
                case 1:
                    System.out.println("Enter goods:");
                    String a = coming.next();
                    System.out.println("Enter Number:");
                    int count = coming.nextInt();
                    basket.addProduct(a,count);
                    continue;
                case 2:
                    System.out.println("Enter goods:");
                    String a1 = coming.next();
                    try{
                        basket.removeProduct(a1);
                    }
                    catch (Exception e){
                        System.out.println("Wrong goods");
                    }
                    continue;

                case 3:
                    System.out.println("Enter goods:");
                    String a2 = coming.next();
                    System.out.println("Enter Number:");
                    int count1 = coming.nextInt();
                    try {
                        basket.updateProductQuantity(a2,count1);
                    }
                    catch (Exception e){
                    System.out.println("Wrong goods");
                    }
                    continue;
                case 4:
                    basket.clear();
                    continue;
                case 5:
                    System.out.println("Enter goods:");
                    String a3 = coming.next();
                    try{
                        System.out.println(basket.getProductQuantity(a3));
                    }
                    catch (Exception e){
                        System.out.println("Wrong goods");
                    }
                    continue;
                case 6:
                    System.out.println(basket.getProducts());
                    continue;
                default: continue;
            }
        }
    }
}
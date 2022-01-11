import java.util.Scanner;

public class PiecesInputCustomerSellingCost {
    public static void main(String[] args) {
        final double sellingCostAcoustic = 119.22;
        final double sellingCostDeko = 99.15;
        final double sellingCostSample = 39.47;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose the quantity of products to enter: ");
        int[] productsQuantity = new int[scanner.nextInt()];

        double[] materialCostArray = new double[productsQuantity.length];
        int[] panelQuantityArray = new int[productsQuantity.length];
        int[] sampleQuantityArray = new int[productsQuantity.length];

        double materialTotalCost = 0;
        int panelTotalQuantity = 0;
        int sampleTotalQuantity = 0;
        for (int i = 0; i < productsQuantity.length; i++) {
            System.out.println("Enter parameters for the product no " + (1+i) + ": ");
            System.out.println("1.Accoustic; \t 2.Deko; \t 3.Samples.");
            System.out.print("Choose the product type: ");
            int type = scanner.nextInt();

            System.out.println("1.White; \t 2.Black; \t 3.Red; \t 4.Yellow; \t 5.Blue; \t 6.Green; \t 7.Orange; \t 8.Purple; \t 9.Grey; \t 10.Brown.");
            System.out.print("Choose the product colour: ");
            int colour = scanner.nextInt();

            int panelPcsQuantity = 0;
            int samplePcsQuantity = 0;
            if(type == 1 || type == 2){
                System.out.print("Enter panel quantity in Pieces: ");
                panelPcsQuantity = scanner.nextInt();
            } else if(type == 3){
                System.out.print("Enter sample packs quantity in Pieces: ");
                samplePcsQuantity = scanner.nextInt();
            }


            if (type == 1){
                panelQuantityArray[i] = panelPcsQuantity;
                materialCostArray[i] = panelPcsQuantity * sellingCostAcoustic;
                System.out.println("Material cost for " +panelQuantityArray[i]+ " Acoustic panels in color no " +colour+ " is " +materialCostArray[i]+ "EUR");
            } else if (type == 2){
                panelQuantityArray[i] = panelPcsQuantity;
                materialCostArray[i] = panelPcsQuantity * sellingCostDeko;
                System.out.println("Material cost for " +panelQuantityArray[i]+ " Deko panels in color no " +colour+ " is " +materialCostArray[i]+ "EUR");
            } else if (type == 3){
                sampleQuantityArray[i] = samplePcsQuantity;
                materialCostArray[i] = samplePcsQuantity * sellingCostSample;
                System.out.println("Material cost for " +sampleQuantityArray[i]+ " Sample packs in color no " +colour+ " is " +materialCostArray[i]+ "EUR");
            }

            materialTotalCost += materialCostArray[i];
            panelTotalQuantity += panelQuantityArray[i];
            sampleTotalQuantity += sampleQuantityArray[i];
        }

        System.out.println("Total material Cost is " +materialTotalCost+ "EUR");
        System.out.println("Total panel Quantity is " +panelTotalQuantity+ "pcs");
        System.out.println("Total sample packs Quantity is " +sampleTotalQuantity+ "pcs");

        int boxesQuantity = 0;
        int palletsQuantity = 0;
        int bubbleWrapQuantity = 0;

        if(panelTotalQuantity <=8 ){
            boxesQuantity =(int) Math.ceil(panelTotalQuantity/2.00);
        } else {
            palletsQuantity =(int) Math.floor(panelTotalQuantity/50.00);
            if(panelTotalQuantity - (palletsQuantity*50.00) <= 8){
                double leftover = panelTotalQuantity - (palletsQuantity*50.00);
                boxesQuantity =(int) Math.ceil(leftover/2.00);
            }else {
                palletsQuantity =(int) Math.ceil(panelTotalQuantity/50.00);
            }
        }

        if(sampleTotalQuantity != 0){
            bubbleWrapQuantity = sampleTotalQuantity;
        }

        final double sellingCostBox = 7.02;
        final double sellingCostPallet = 33.06;
        final double sellingCostBubbleWrap = 0.32;

        double boxesTotalCost = boxesQuantity*sellingCostBox;
        if(boxesQuantity!=0){
            System.out.println("Packaging price for the " +boxesQuantity+ " boxes needed is " +boxesTotalCost+ "EUR");
        }
        double palletsTotalCost = palletsQuantity*sellingCostPallet;
        if(palletsQuantity!=0){
            System.out.println("Packaging price for the " +palletsQuantity+ " pallets needed is " +palletsTotalCost+ "EUR");
        }
        double bubbleWrapTotalCost = bubbleWrapQuantity*sellingCostBubbleWrap;
        System.out.println("Packaging price for the " +bubbleWrapQuantity+ " bubble wraps needed is " +bubbleWrapTotalCost+ "EUR");


        double packagingTotalCost = boxesTotalCost + palletsTotalCost +bubbleWrapTotalCost;
        System.out.println("Total packaging cost is " +packagingTotalCost+ "EUR");
    }
}

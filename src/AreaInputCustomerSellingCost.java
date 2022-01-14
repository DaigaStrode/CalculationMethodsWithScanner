import java.util.Scanner;

public class AreaInputCustomerSellingCost {
    public static void main(String[] args) {
        final double sellingCostAcoustic = 72.05;
        final double sellingCostDeko = 61.15;
        final double sellingCostSample = 20.99;

        final double onePanelM2 = 1.44;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose the quantity of products to enter: ");
        int[] productsQuantity = new int[scanner.nextInt()];

        double[] materialCostAcousticArray = new double[productsQuantity.length];
        int[] panelQuantityAcousticArray = new int[productsQuantity.length];
        double[] materialCostDekoArray = new double[productsQuantity.length];
        int[] panelQuantityDekoArray = new int[productsQuantity.length];
        double[] materialCostSampleArray = new double[productsQuantity.length];
        int[] sampleQuantityArray = new int[productsQuantity.length];

        double materialTotalCostAcoustic = 0;
        int panelTotalQuantityAcoustic = 0;
        double materialTotalCostDeko = 0;
        int panelTotalQuantityDeko = 0;
        double materialTotalCostSample = 0;
        int sampleTotalQuantity = 0;

        for (int i = 0; i < productsQuantity.length; i++) {
            System.out.println("Enter parameters for the product no " + (1+i) + ": ");
            System.out.println("1.Accoustic; \t 2.Deko; \t 3.Samples.");
            System.out.print("Choose the product type: ");
            int type = scanner.nextInt();

            if (type == 1){
                System.out.println("1.White; \t 2.Black; \t 3.Red; \t 4.Yellow; \t 5.Blue; \t 6.Green; \t 7.Orange; \t 8.Purple; \t 9.Grey; \t 10.Brown.");
                System.out.print("Choose the product colour: ");
                int colour = scanner.nextInt();

                System.out.print("Enter m2 quantity to cover with panels: ");
                double m2Quantity = scanner.nextDouble();
                int panelPcsQuantity = (int) Math.ceil(m2Quantity/onePanelM2);
                System.out.println("the panel pieces quantity required to cover " +m2Quantity+ "m2 is "+panelPcsQuantity+"pcs");

                panelQuantityAcousticArray[i] = panelPcsQuantity;
                materialCostAcousticArray[i] = panelPcsQuantity * sellingCostAcoustic;
                System.out.println("Material cost for " +panelQuantityAcousticArray[i]+ " Acoustic panels in color no " +colour+ " is " +materialCostAcousticArray[i]+ "EUR");
                materialTotalCostAcoustic += materialCostAcousticArray[i];
                panelTotalQuantityAcoustic += panelQuantityAcousticArray[i];
            }else if(type == 2){
                System.out.println("1.White; \t 2.Black; \t 3.Red; \t 4.Yellow; \t 5.Blue; \t 6.Green; \t 7.Orange; \t 8.Purple; \t 9.Grey; \t 10.Brown.");
                System.out.print("Choose the product colour: ");
                int colour = scanner.nextInt();

                System.out.print("Enter m2 quantity to cover with panels: ");
                double m2Quantity = scanner.nextDouble();
                int panelPcsQuantity = (int) Math.ceil(m2Quantity/onePanelM2);
                System.out.println("the panel pieces quantity required to cover " +m2Quantity+ "m2 is "+panelPcsQuantity+"pcs");

                panelQuantityDekoArray[i] = panelPcsQuantity;
                materialCostDekoArray[i] = panelPcsQuantity * sellingCostDeko;
                System.out.println("Material cost for " + panelQuantityDekoArray[i] + " Deko panels in color no " + colour + " is " + materialCostDekoArray[i] + "EUR");
                materialTotalCostDeko += materialCostDekoArray[i];
                panelTotalQuantityDeko += panelQuantityDekoArray[i];
            }
            else if(type == 3){
                System.out.print("Enter sample packs quantity in Pieces: ");
                int samplePcsQuantity = scanner.nextInt();
                sampleQuantityArray[i] = samplePcsQuantity;
                materialCostSampleArray[i] = samplePcsQuantity * sellingCostSample;
                System.out.println("Material cost for " +sampleQuantityArray[i]+ " Sample packs is " +materialCostSampleArray[i]+ "EUR");
                materialTotalCostSample += materialCostSampleArray[i];
                sampleTotalQuantity += sampleQuantityArray[i];
            }
        }

        System.out.println();

        if(panelTotalQuantityAcoustic != 0) {
            System.out.println("Acoustic panel Quantity is " +panelTotalQuantityAcoustic+ "pcs");
        }

        if(panelTotalQuantityDeko != 0) {
            System.out.println("Deko panel Quantity is " +panelTotalQuantityDeko+ "pcs");
        }

        int panelTotalQuantity = panelTotalQuantityAcoustic + panelTotalQuantityDeko;

        if(panelTotalQuantity != 0){
            System.out.println("Total panel Quantity is " +panelTotalQuantity+ "pcs");
        }
        if(sampleTotalQuantity != 0){
            System.out.println("Total sample packs Quantity is " +sampleTotalQuantity+ "pcs");
        }

        System.out.println();
        System.out.println("Total material Cost is " +(materialTotalCostAcoustic+materialTotalCostDeko+materialTotalCostSample)+ "EUR");
        System.out.println();

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

        final double baseCostBox = 7.02;
        final double baseCostPallet = 33.06;
        final double baseCostBubbleWrap = 0.32;

        double boxesTotalCost = boxesQuantity*baseCostBox;
        if(boxesQuantity!=0){
            System.out.println("Packaging price for the " +boxesQuantity+ " boxes needed is " +boxesTotalCost+ "EUR");
        }
        double palletsTotalCost = palletsQuantity*baseCostPallet;
        if(palletsQuantity!=0){
            System.out.println("Packaging price for the " +palletsQuantity+ " pallets needed is " +palletsTotalCost+ "EUR");
        }
        double bubbleWrapTotalCost = bubbleWrapQuantity*baseCostBubbleWrap;
        System.out.println("Packaging price for the " +bubbleWrapQuantity+ " bubble wraps needed is " +bubbleWrapTotalCost+ "EUR");


        System.out.println();
        double packagingTotalCost = boxesTotalCost + palletsTotalCost +bubbleWrapTotalCost;
        System.out.println("Total packaging cost is " +packagingTotalCost+ "EUR");
    }
}
import java.util.Scanner;

public class PiecesInput {
    public static void main(String[] args) {
        final double baseCostAcoustic = 72.05;
        final double baseCostDeko = 61.15;
        final double baseCostSample = 20.99;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose the quantity of products to enter: ");
        int[] productsQuantity = new int[scanner.nextInt()];

        double[] materialCostArray = new double[productsQuantity.length];
        int[] panelQuantityArray = new int[productsQuantity.length];

        double materialTotalCost = 0;
        int panelTotalQuantity = 0;
        for (int i = 0; i < productsQuantity.length; i++) {
            System.out.println("Enter parameters for the product no " + (1+i) + ": ");
            System.out.println("1.Accoustic; \t 2.Deko; \t 3.Samples.");
            System.out.print("Choose the product type: ");
            int type = scanner.nextInt();

            System.out.println("1.White; \t 2.Black; \t 3.Red; \t 4.Yellow; \t 5.Blue; \t 6.Green; \t 7.Orange; \t 8.Purple; \t 9.Grey; \t 10.Brown.");
            System.out.print("Choose the product colour: ");
            int colour = scanner.nextInt();

            System.out.print("Enter product quantity in Pieces: ");
            int pcsQuantity = scanner.nextInt();

            if (type == 1){
                panelQuantityArray[i] = pcsQuantity;
                materialCostArray[i] = pcsQuantity * baseCostAcoustic;
                System.out.println("Material cost for Acoustic panel in color no " +colour+ " is " +materialCostArray[i]+ "EUR");
            } else if (type == 2){
                panelQuantityArray[i] = pcsQuantity;
                materialCostArray[i] = pcsQuantity * baseCostDeko;
                System.out.println("Material cost for Deko panel in color no " +colour+ " is " +materialCostArray[i]+ "EUR");
            } else if (type == 3){
                panelQuantityArray[i] = pcsQuantity;
                materialCostArray[i] = pcsQuantity * baseCostSample;
                System.out.println("Material cost for Samples in color no " +colour+ " is " +materialCostArray[i]+ "EUR");
            }

            materialTotalCost += materialCostArray[i];
            panelTotalQuantity += panelQuantityArray[i];
        }

        System.out.println("Total material Cost is " +materialTotalCost+ "EUR");
        System.out.println("Total panel Quantity is " +panelTotalQuantity+ "pcs");

        int boxesQuantity = 0;
        int palletsQuantity = 0;
        if(panelTotalQuantity<=8){
            boxesQuantity =(int) Math.ceil(panelTotalQuantity/2.00);
        } else {
            palletsQuantity =(int) Math.ceil(panelTotalQuantity/50.00);
        }

        final double baseCostBox = 7.02;
        final double baseCostPallet = 33.06;

        double boxesTotalCost = boxesQuantity*baseCostBox;
        if(boxesQuantity!=0){
            System.out.println("Packaging price for the " +boxesQuantity+ " boxes needed is " +boxesTotalCost+ "EUR");
        }
        double palletsTotalCost = palletsQuantity*baseCostPallet;
        if(palletsQuantity!=0){
            System.out.println("Packaging price for the " +palletsQuantity+ " pallets needed is " +palletsTotalCost+ "EUR");
        }
    }
}

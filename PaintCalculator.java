import java.util.Scanner;

public class PaintCalculator {
    public static void main(String[] args) {

       // Assumption: 1 litre of paint can paint 10 square metres. The smallest paint bucket size is 5 litres. They then increase in size to incorporate 10l, 15l and 20l buckets. I used the internet to find this out.


        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the height of the room in metres: ");

        double roomHeight = scanner.nextDouble();
        if(roomHeight<=0||roomHeight>100){
            System.out.println("That height is invalid. Enter a value between 1 and 100");}

        System.out.println("Please enter the width of the room in metres: ");
        double roomWidth = scanner.nextDouble();
        if(roomWidth<=0||roomWidth>100){
            System.out.println("The width is invalid. Enter a value between 1 and 100");
        }

        System.out.println("Please enter the length of the room in metres: ");

        double roomLength = scanner.nextDouble();
        if(roomLength<=0||roomLength>100){
            System.out.println("The width is invalid. Enter a value between 1 and 100");
        }

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        double roomSurface = roomSurfaceArea(roomHeight,roomWidth,roomLength);
        System.out.println("The height of the room is " + roomHeight + " metres.  The width of the room you specified as " +roomWidth + " metres.  And the length of the room you specified was " + roomLength+ " metres.");
        System.out.println("Total Volume of the room without excluding windows or doorways " + roomSurface + " m³.");
        double floorArea = floorSize(roomHeight,roomWidth);
        System.out.println("The area of your floor is " + floorArea + " metres squared");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("What is the the area in metres which you wish to exclude? This is the total area of windows and doorways in the room");
        double exclusionZone = scanner.nextDouble();
        double areaToPaint =  areaToPaint(roomSurface,floorArea,exclusionZone);
        System.out.println("The area to be painted size is : " + areaToPaint + " metres");
        scanner.close();

        System.out.println("The amount of paint needed in litres to paint this room is: " + paintNeeded(areaToPaint) + " litres");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("The amount of 5 litre paint buckets needed is: " + paintNeeded(areaToPaint)/5 + " buckets");
        System.out.println("The amount of 10 litre paint buckets needed would be " + paintNeeded(areaToPaint)/10 + " buckets");
        System.out.println("The amount of 15 litre paint buckets needed would be " + paintNeeded(areaToPaint)/15 + " buckets");



    }

    public static double paintNeeded(double areaToPaint){
        double paintNeeded=areaToPaint/10;

        return paintNeeded;
    }

    public static double roomSurfaceArea(double roomHeight, double roomLength, double roomWidth) {
        double roomSA = roomHeight * roomLength * roomWidth;
        return roomSA;
    }
    public static double floorSize(double roomHeight,double roomWidth ){
        double floorArea = roomHeight * roomWidth;
        return floorArea;
    }

    public static double areaToPaint(double roomSurface, double floorArea, double exclusionZone) {
        double areaToBePainted = roomSurface - floorArea - exclusionZone;
        return areaToBePainted;
    }

}
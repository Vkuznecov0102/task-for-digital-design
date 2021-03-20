package task;

public class Main {
    public static void main(String[] args) {
        String input = "2[3[x]y]";
        String input2 = "3[xyz]4[xy]z";
        System.out.println(Conversion.convert(input));
        System.out.println(Conversion.convert(input2));
    }
}
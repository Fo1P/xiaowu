package xiaoban;

public class WlieTest {
    public static boolean condition(){
        boolean result=Math.random()<0.99;
        System.out.print(result+",");
        return result;
    }
    public static void main(String[] args){
        while (condition()){
            System.out.println("INside 'while'");
        }
        System.out.println("exited'while'");
    }
}

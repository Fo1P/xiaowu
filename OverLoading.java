package xiaoban;

public class OverLoading {
    static class Tree{
        int height;
        Tree(){
            System.out.println("planting a seedling");
height=0;
        }
        Tree(int initialHeight){
            height=initialHeight;
            System.out.println("creating new tree that is "+height+" feet tall");
        }
        void info(){
            System.out.println("tree is "+height+" feet tall");
        }
        void info(String s){
            System.out.println(s+"There is "+height+" feet tall");
        }
    }

    public static void main(String[] args) {
        for (int i=0;i<5;i++){
            Tree tree=new Tree(i);//输出带参数
            tree.info();
            tree.info("面向对像重载");
        }
        new Tree();//输出不带参数
    }
}

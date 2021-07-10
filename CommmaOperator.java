package xiaoban;

public class CommmaOperator {
    //逗号操作符指在for循环语句中控制表达式初始化和步进过程中用它分开
    //逗号分隔符这是在分割方法（函数）中不同参数
    public static void main(String[] args){
        for (int i=1,j=i+10;i<5;i++,j=i*2){//注意这其中前面初始化值只是初始化，与后面递进没关系
            System.out.println("i="+i+"j="+j);
        }
    }
}
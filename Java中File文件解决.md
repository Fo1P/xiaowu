

# Java中File文件类

**对于程序而言，输入就是读，也就是用来读取数据；输出就是写，也就是用来写入数据**。

## 1.创建文件路径对象

```java
File file=new File(path);
```

path指文件路径

## 2.删除文件

file.delete();

## 3.文档创建

```java
File file=new File(path);
boolean flag=file.mkdir();//文档创建
```

## 4.文档改名

注意文档改名是用新的文件替换原来的文件

```java
File file1=new File("H:\\Cnm1");//文档名字改成Cnm1
boolean flag1= file.renameTo(file1);
```

## 5.文档批量删除(递归)

```java
import java.io.File;

public class Demo04 {
    public static void main(String[] args) {
        String path="H:\\Cnm1";
        File file=new File(path);
        f(file);
    }
   public static void f(File files){
       File[] files1 = files.listFiles();//放入数组将文件
       if (files1.length>0){//如果普通文件里还有多少
           for (File file:files1){//遍历
               f(file);
           }
       }
           files.delete();
  }
}
```

## 6.将路径所有文件放入数组

使用listFiles()方法

```java
File file1=new File("H:\\Cnm1");
File[] files=file.listFiles();
```

## 7.文档归档（read()方法）

### 1.使用java读取文件

FileInputStream流被称为文件字节输入流，意思指对文件数据以字节的形式进行读取操作如读取图片视频等,读取打印在控制台

```java
FileInputStream fis=new FileInputStream("C:\\Users\\WU\\Desktop\\1.txt");
```

2.需要使用数组储存每次读的个数

```java
byte[] bytes=new byte[2];
```

3.i表示返回读取的个数，如果已经读完则返回-1

```
int i = fis.read(bytes);
```

4.示例

abcdefg

```java
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Demo06 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("C:\\Users\\WU\\Desktop\\1.txt");
        byte[] bytes=new byte[2];
        //i表示读取的个数
        int i = fis.read(bytes);
        int i1 = fis.read(bytes);
        int i2 = fis.read(bytes);
        int i3 = fis.read(bytes);
        int i4 = fis.read(bytes);
        int i5 = fis.read(bytes);
        int i6 = fis.read(bytes);

        System.out.println(i);
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(i4);
        System.out.println(i5);
        System.out.println(i6);
       

    }
}
结果：2 2 2 1 -1 -1 -1
```

```
结果：3 3 1 -1 -1 -1 -1
```



```java
byte[] bytes=new byte[3];//结果在上面
```



## 8.读取文件打印(1)

```
例子：abcdefg
```



| a    | b    |
| ---- | ---- |
| c    | d    |
| e    | f    |
| g    | f    |

因为最后一次只取一个，所以倒数第二次就会保留一个并且覆盖

```java
FileInputStream fileInputStream=new FileInputStream("C:\\Users\\WU\\Desktop\\1.txt");
        byte[] bytes=new byte[2];//2代表取值指针为2
        while (fileInputStream.read(bytes)!=-1){
            String s=new String(bytes);
            System.out.println(s);
        }
```

```
ab cd ef gf
```

# 9.读取文件打印优化（2）

优化之后不会出现覆盖，只会查到你想要的

在创建String对象时改变一下数值

```java
String s=new String(bytes,0,count);//0，count一般来说是设置变化
```



```java
public class Demo05 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream=new FileInputStream("C:\\Users\\WU\\Desktop\\1.txt");
        byte[] bytes=new byte[2];
        int count=0;
        while ((count=fileInputStream.read(bytes))!=-1){
            String s=new String(bytes,0,count);
            System.out.println(s);
        }
    }
}
```

```
结果ab cd ef g
```



# 10.输出流FileOutputStream

## 1.写出文件

```java
FileOutputStream fis=new FileOutputStream("C:\\Users\\WU\\Desktop\\1.txt");//写出文件
fOs.write(68);//68是ASCII码 代表D
```

以上代码就是在文档1.txt中写出D

## 2.文件复制

思路：先用输入流读取文件，再用输出流放在另一个地方完成复制

```java
//文件复制
        FileInputStream fileIutputStream=new FileInputStream("H:\\动漫\\小志\\psc (1).jpg");//读取文件
        FileOutputStream fis=new FileOutputStream("H:\\Cnm1\\1.jpg");//写出文件
        byte[] bytes=new byte[2048];
        int count;
        while ((count=fileIntputStream.read(bytes))!=-1) {
            fis.write(bytes,0,count);
        }
```

# 11.搜查盘里图片

思路：先选取文件，将文件放入文件数组，套在循环（循环里的内容是遍历文件），判断是否为文件通过递归，然后就开始判断jpg和png，最后通过输入流读取原文件（图片），再用输出流写出图片，再通过字节数组进行读取，实现复制

```java
import java.io.*;

//搜查文件里所有图总
public class Demo08 {

    public static void main(String[] args) throws IOException {
        File file=new File("C:\\");
        File[] files=file.listFiles();
        f(files);
    }

    private static void f(File[] files) throws IOException {
        for (File  file:files){
            if (file.isDirectory()){
                File[] files1=file.listFiles();
                if (files1!=null){
                    f(files1);
                }
            }
            if ((file.getName().endsWith(".jpg"))||(file.getName().endsWith(".png"))){
                FileInputStream fis=new FileInputStream(file);
                FileOutputStream fos=new FileOutputStream("H:\\Cnm1\\i\\"+file.getName());
                byte[] bytes=new byte[100000];
                int count;
                while ((count=fis.read(bytes))!=-1){
                    fos.write(bytes,0,count);
                }
            }
        }
    }

}
```

# 12.将字符串写在文本上


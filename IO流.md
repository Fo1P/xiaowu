## IO流，什么是io

i:Input

O：output

通过io流可以完成硬盘文件的读和写

## io流的分类

### 一种是安照流的方向进行分类：

 以内存为参照物，往内存里去是，叫做输入(Input),或者叫做读(read)。

从内存中出来，叫做输出(Output)，或者叫做写(writes).

### 另一种方式是按照读取数据方式不同进行分类：

 有的流是按照**字节**的方式读取数据，一次读取**一个字节byte**，等同于一**次读取8个二进制**，这种**流是万能的**，**什么类型的文件**都可以读取。包括：文本文件，图片，声音文件，视频等等

假设文件file1.txt,用**字节流**是这样读的：

a中国bc张三fa

第一次读：一个字节，正好读到‘a’

第二次读：一个字节，正好读到‘中’的一半

第三次读：一个字节，正好读到‘中’的另一半



有的流是按照**字符**的方式进行读取数据的，**一次读取一个字符**，这种流是为了方便**读取普通文本文件而存在的**，这种流不能读取：图片，声音，视频等文件，只能读取纯文本文件，**连word都无法读取**。

假设文件file1.txt,用**字符流**是这样读的：

a中国bc张三fa

第一次读：一个字节，正好读到‘a’

第二次读：一个字节，正好读到‘中’（注意‘中’在文档中占用2个字节）

第三次读：一个字节，正好读到‘国’

综上所述：流分为输入流，输出流，字节流，字符流

java中所有的流都在**:java.io.*下**



**注意：字符输入流用char数组，字节输入流用byte数组**

## java 中io流的四大家族

java.io.InputStream 字节输入流

java.io.OutoutStream 字节输出流

java.io.Reader 字符输入流

java.io.Writer字符输出流

四大家族的首领都是**抽象类(abstract class)**

所有的流都实现了：**java.io.Closeable接口，都是可关闭的，都有close（）方法**。流毕竟是一个管道，这个是内存和硬盘之间的通道，用完之后一定要关闭，否则会浪费很多资源。

所有的**输出流**都实现了：**java.io.Flushable接口，都是可刷新的，都有flush()方法**，输出流在最终输出后，一定要记得flush()刷新一下。这个**刷新表示将管道/通道中剩余未输出的数据强行输出完（清空管道!!）刷新的作用就是清空管道**

注意：**如果没有flush()可能会导致丢失数据**

注意：**java中只要"类名"以Stream结尾的都是字节流，以Reader/Writer结尾的都是字符流**

## java.io包下需要掌握的流

1. 文件专属流java.io.FileInputStream   java.io.FileOutputStream  java.io.FileReader java.io.FileWriter
2. 转换流(将字节流转换为字符流) java.io.InputStreamReader java.io.OutputStreamWriter
3. 缓冲流专属：java.io.BufferedReader java.io.BufferedWriter java.io.BufferedInputStream java.io.BufferedOutputStream
4. 数据流专属：java.io.DataInputStream java.io.DataOutputStream
5. 标准输出流：java.io.PrintWriter java.io.PrintStream
6. 对象专属流：java.io.ObjectInputStream java.ioObjectOutputStream

## FileInputStream

1.文件字节输入流，万能的，**任何类型的文件**都可以采用这个流来读

2.**字节**的方式完成**输入的操作，完成读的操作(硬盘-->内存)**

重点：**read()方法里面不放参数，返回得则是该字节得ASCII码。如果读到空白返回则是-1**

```java
FileInputStream fis=null;
        try {
            //创建字节流输入对象,文件路径(H:\学习io流用\xi.txt)
            //但是idea会自动转换未(H:\\学习io流用\\xi.txt,因为java中\单的是转义字符)
            //采用了绝对路径，要是将\\换成/也是可以的
            //文件内容abc
            fis=new FileInputStream("H:\\学习io流用\\xi.txt");
            //开始读取
            int read = fis.read();
            /*因为文件中第一个字节是a，a的asi码是第97所以返回的是97*/
            System.out.println(read);
            //read()方法每读一次，指针就右移动一格，就是读的第二个字节b，b的asi码为98
            read=fis.read();
            System.out.println(read);//98
            //同理为99
            read= fis.read();
            System.out.println(read);
            //当读到没有字节时，空时,指针依然会有移动，返回则是-1
            read=fis.read();
            System.out.println(read);//-1
            //同理还是-1
            read=fis.read();
            System.out.println(read);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //确保流一定关闭
            if (fis!=null){//这里是为了避免空指针异常
                try {//如果流是空的，就不需要关闭
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
```

```
97 98 99 -1 -1
```

对以上代码进行循环优化

```java
FileInputStream fis=null;
        try {
            fis=new FileInputStream("H:\\学习io流用\\xi.txt");
            while (true){
               int readdata= fis.read();
                if (readdata==-1){
                    break;
                }
                System.out.println(readdata);
            }
            //while循环再改造
          int read= 0;
            while ((read= fis.read())!=-1){
                System.out.println(read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
```

**idea得相对路径：一定是从当前位置作为起点开始寻找。**

**idea得默认路径：一定是在项目得根目录下。**



以上这两种方法需要一个字节一个字节得在硬盘与内存进行交换，下面这种方法减少硬盘与内存得交互：

read(byte[] )：如果read()方法里放入**byte数组**，**则返回的是读到得字节数量，而且每次最多读取得是byte这个数组得长度**

```java
FileInputStream fis=null;
        byte[] bytes=new byte[4];//定义byte数组长度为4
        try {
            fis=new FileInputStream("H:\\学习io流用\\h.txt");//abcdef
            //这个方法最多读取的数量则是数组的长度
            int read = fis.read(bytes);//返回值为4,因为数组长度为4，这里数组存入abcd
            System.out.println(read);
            for (int i:bytes){
                System.out.println(i);//输出a:97b:98c:100d:101
            }
            //返回读取字节存储在byte里的String形式
            System.out.println(new String(bytes));//abcd
            //只返回读取的字节String形式
            System.out.println(new String(bytes,0,read));//read返回值是4,返回的读取的，因为要覆盖所以取0开始到读取的值就是每次读取的值了
            int read1=fis.read(bytes);//返回值为2，因为上面已经读了4个
            //而且这里会覆盖第一次读的，第一次读abcd这里再读了两字节ef，现在数组则为efcd
            System.out.println(read1);//返回2，因为只读取了剩下的2个字节
            for (int i:bytes){
                System.out.println(i);//e:101f:102c:99d:100
            }
            System.out.println(new String(bytes));//fgcd
            //read1为2
            System.out.println(new String(bytes,0,read1));//ef
            //一个字节都没有所以返回值为-1
            int read2=fis.read(bytes);
            System.out.println(read2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
```

### 一次性读取文件索引字节

```java
 //用byte数组一步读出文档所有的字符串
        FileInputStream fis=null;
        byte[] bytes=new byte[4];
        try {
           fis = new FileInputStream("H:\\学习io流用\\h1.txt");
//           while (true){
//               int read = fis.read(bytes);
//               if (read==-1){
//                   break;
//               }
//               System.out.print(new String(bytes,0,read));//不换行就直接每行拼接了
//           }
            //以上方法改进
            int readCount=0;
            while ((readCount=fis.read(bytes))!=-1){
                System.out.print(new String(bytes,0,readCount));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
```

### FileInputStream常用的方法

返回流中剩余的没有读到的字节数量：

```java
int available();
```

```java
 FileInputStream fis=null;
        try {
            fis=new FileInputStream("H:\\学习io流用\\h.txt");//6个字节
            //相当于查总字节数
            System.out.println(fis.available());
            int read = fis.read();//读取一个字节
            System.out.println(read);
            //剩下的字节
            System.out.println(fis.available());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
```

6 97 5

直接不使用循环读出并写出文件中所有字节,但是这种方式**不太适合大文件**，因为**byte数组不适宜太大**。

```java
FileInputStream fis=null;
        try {
            fis=new FileInputStream("H:\\学习io流用\\h.txt");//6个字节
            //使用这个直接打印不需要循环
            byte[] bytes=new byte[fis.available()];//全部字节长度就是byte数组
            int read=fis.read(bytes);//将文件里的东西存储进bytes去
            System.out.println(new String(bytes));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
```

跳过几个字节不读：

```java
int skip(long n);
```

```java
FileInputStream fis=null;
        try {
            fis=new FileInputStream("H:\\学习io流用\\h.txt");//6个字节abcdef
            fis.skip(3);//跳过3个字节，从d开始就是100
            System.out.println(fis.read());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
```

## FileOutputStream

文件字节输出流，负责写，从内存到硬盘

会清空原文件内容的写法:

```java
//开始写文件
        FileOutputStream fos=null;
        try {
            //这种写入文件方式谨慎使用：会将原文件清空再写
            //当路径文件不存在的时候会自动新建
            fos=new FileOutputStream("H:\\学习io流用\\h1.txt");
            byte[] bytes=new byte[]{97,98,99};//分别代表abc
            //开始写入byte数组里的所有字节
            fos.write(bytes);//abc
            //写出bytes数组里的部分字节
            fos.write(bytes,0,2);//写出ab
            //写完一定要刷新
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
```

不会将文件清空的写法:

```java
//开始写文件
        FileOutputStream fos=null;
        try {
            //当路径文件不存在的时候会自动新建
            fos=new FileOutputStream("H:\\学习io流用\\h1.txt",true);
            byte[] bytes=new byte[]{97,98,99};//分别代表abc
            //开始写入byte数组里的所有字节
            fos.write(bytes);//abcababc
            //写出bytes数组里的部分字节
            fos.write(bytes,0,2);//写出abcababcab
            //写完一定要刷新
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
```

**将字符串写入文件：**

```java
//开始写文件
        FileOutputStream fos=null;
        try {
            //当路径文件不存在的时候会自动新建
            fos=new FileOutputStream("H:\\学习io流用\\h1.txt",true);
            String s="最爱小黄";
            byte[] bytes=s.getBytes();
            fos.write(bytes);
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
```

### 文件复制：

```java
 //文件复制，一定要注意一遍复制一边写
        FileInputStream fis=null;
        FileOutputStream fos=null;
        try {
            fis=new FileInputStream("H:\\Cnm1\\服务器入门02.wmv");//读入的需要复制的文件夹
            fos=new FileOutputStream("H:\\服务器02.wmv");//写出被复制输出文件夹位置+复制
            byte[] bytes=new byte[1024*1024];//这里的意思是每次读取1mb(1024*1024字节)
            int readCount=0;
            while ((readCount=fis.read(bytes))!=-1){
                fos.write(bytes,0,readCount);
            }
            //输出流最后一定要刷新
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
```

## FileReader

文件字符输入流，只能读取普通文本，读取文本内容时，方便快捷

```java
FileReader fileReader=null;
        try {
            fileReader=new FileReader("H:\\学习io流用\\h1.txt");
            //因为是字符读取流所以使用字符数组
            char[] chars=new char[4];
            int readCount=0;
            while ((readCount=fileReader.read(chars))!=-1){
                System.out.println(new String(chars,0,readCount));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
```

## FileWriter

文件字符输出流，只能负责输出普通文本。

```java
FileWriter writer=null;
        try {
            writer=new FileWriter("H:\\学习io流用\\h1.txt");//加上true就不会清空原文件
            char[] chars=new char[]{'我','是','你','爹','嘻','嘻'};
            char[] chars1=new char[]{'我','是','你','爹','嘻','嘻'};
            writer.write(chars);
            writer.write(chars,2,3);//从2后面截取三位
            writer.write(chars1);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
```

## 复制普通文本文件

```java
FileWriter writer=null;
        FileReader reader=null;
        try {
            reader=new FileReader("H:\\学习io流用\\h1.txt");//加上true就不会清空原文件
            writer=new FileWriter("H:\\学习io流用\\1.txt");
            char[] chars=new char[1024*512];//读取1m
            int readcount=0;
            while ((readcount=reader.read(chars))!=-1){
                writer.write(chars,0,readcount);
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

```

# 缓冲流

## BufferedReader

带有缓冲区的字符输入流

使用这个流的时候**不需要自定义char数组**，或者说**不需要byte数组**。**自带缓冲**。

==========================================================

当一个流的构造方法中**需要一个流的时候**，这个**被传进来的流叫做节点流**

**外部负责包装**的这个流 的时候叫做**包装流**，还有一个名字叫做**处理流**

关闭流的时候，对于包装流来说，只需要关闭最外层流就行，里面的节点流会自动关闭。

br.readline()方法读取一个文本行，**但不带换行符**。

```java
public static void main(String[] args) throws IOException {
        FileReader reader=new FileReader("H:\\学习io流用\\1.txt");//节点流
        BufferedReader br=new BufferedReader(reader);//包装流
        String s=null;
        while ((s=br.readLine())!=null){
            System.out.println(s);
        }
    }
```

```java
我是你爹嘻嘻你爹嘻我是你爹嘻嘻
```

注意：**Bufferedreader这个流**只能用于接受**Reader型的节点流**，如果是inputStream类型的流则需要**先进行转换**。

### 字节流变成节点流转换

```java
public static void main(String[] args) throws IOException {
        FileInputStream reader=new FileInputStream("H:\\学习io流用\\1.txt");//字节流
        //字节流转换为字符流
        InputStreamReader reader1=new InputStreamReader(reader);
        //字节流放入
        BufferedReader br=new BufferedReader(reader1);//包装流
    BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(new FileInputStream("H:\\学习io流用\\h1.txt")));//组合写法
        String s=null;
        while ((s=br.readLine())!=null){
            System.out.println(s);
        }
    }
```

## BufferedWriter

带有缓冲区的的字符输出流

```java
public static void main(String[] args) throws Exception {
            BufferedWriter b=new BufferedWriter(new FileWriter("H:\\学习io流用\\h3.txt"));
            BufferedWriter v=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("H:\\学习io流用\\h3.txt",true)));
            b.write("hellow world!");
            b.write("\n");
            b.write("就这");
            v.write("hello");
            v.write("\n");
            v.write("就这");
            b.flush();
            b.close();
            v.flush();
            v.close();
    }
```

```
hellow world!
就这hello
就这
```

# 数据流

## DataOutputStream

这个流可以**将数据，连同数据类型**一并写入文件。注意：这个文件**不是普通文本文档**（用记事本打不开）

```java
public static void main(String[] args) throws IOException {
        //创建数据专属字节输出流
        DataOutputStream dos=new DataOutputStream(new FileOutputStream("H:\\学习io流用\\data"));
        //写数据
        byte b=100;
        short s=200;
        int i=300;
        long l=400L;
        float f=3.1f;
        double d=3.14;
        boolean sex=false;
        char c='a';
        //写
        dos.writeByte(b);//将数据以及数据类型一遍写入文件当中
        dos.writeShort(s);
        dos.writeInt(i);
        dos.writeLong(l);
        dos.writeFloat(f);
        dos.writeDouble(d);
        dos.writeBoolean(sex);
        dos.writeChar(c);
        dos.flush();
        dos.close();
    }
```

## DataInputStream

数据字节输入流，DataOutputStream写的文件，只能使用**DataInputStream**去读。并且读得时候你需要**提前知道写入得顺序，读的顺序和写的顺序一致**，才可以正常取出数据。

注意：**一定要按照顺序**

```java
public static void main(String[] args) throws Exception {
        DataInputStream dis=new DataInputStream(new FileInputStream("H:\\\\学习io流用\\\\data"));
        byte b=dis.readByte();

        short s=dis.readShort();
        int i=dis.read();
        long l=  dis.readLong();
        float f = dis.readFloat();
        double d= dis.readDouble();
        boolean sex = dis.readBoolean();
        char c = dis.readChar();
        System.out.println(b);
        System.out.println(s);
        System.out.println(i+1000);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        System.out.println(sex);
        System.out.println(c);
        dis.close();
    }
```

# 标准输出流

标准得字节输出流，默认**输出到控制台**

标准输出流**不需要手动关闭close();**

```java
public static void main(String[] args) {
        //标准输出流联合起来写
        System.out.println("hello，world!");
        //对以上这句话分开写
        PrintStream ps=System.out;
        ps.println("hello world");
        ps.println("xixi");
        //标准输出流不需要close关闭
    }
```

```java
System.exit(0);
```

```java
System.exit(int status).
取值及作用:status由使用者自取，一般可取0,1或者其他数；当其为System.exit(0)时，正常退出当前程序，关闭虚拟机（JVM）；当其为System.exit(1)，或者其他值的时候，则非正常退出程序，关闭虚拟机。
 用法:java中的main方法是静态的，这点和c++不同；其关键字void表示的是没有返回值，不会为操作系统返回退出代码。如果main方法正常退出，则退出代码为“0”，如果希望在终止时返回其他代码，就需要调用System.exit方法。
个人理解:status无论为何值都会退出程序，关闭虚拟机，只不过为“0”时，退出正常，为其他值的时候，退出异常，可以用在catch块中，将System.exit(1)放进去，用来表示非正常退出
```

```java
System.currentTimeMillis();
```

```
在开发过程中，通常很多人都习惯使用new Date()来获取当前时间。new Date()所做的事情其实就是调用了System.currentTimeMillis()。如果仅仅是需要或者毫秒数，那么完全可以使用System.currentTimeMillis()去代替new Date()，效率上会高一点。如果需要在同一个方法里面多次使用new Date()，通常性能就是这样一点一点地消耗掉，这里其实可以声明一个引用。
```

```java
System.gc();
```

```
//System.gc()的源码之后才搞清楚，执行System.gc()函数的作用只是提醒或告诉虚拟机，希望进行一次垃圾回收
```

```java
System.arraycopy(...);
```

```
一、深度复制和浅度复制的区别
Java数组的复制操作可以分为深度复制和浅度复制，简单来说深度复制，可以将对象的值和对象的内容复制;浅复制是指对对象引用的复制。
二、System.arraycopy()方法实现复制
1、System中提供了一个native静态方法arraycopy(),可以使用这个方法来实现数组之间的复制。对于一维数组来说，这种复制属性值传递，修改副本不会影响原来的值。对于二维或者一维数组中存放的是对象时，复制结果是一维的引用变量传递给副本的一维数组，修改副本时，会影响原来的数组。
2、System.arraycopy的函数原型是：
```

### 改变输出流的方向

是标准输出流不像System.out.println("hello，world!");直接输出，而是改变输出到2.txt文件

```java
//标准输出流联合起来写
        System.out.println("hello，world!");
        //对以上这句话分开写
        PrintStream ps=System.out;
        ps.println("hello world");
        ps.println("xixi");
        //标准输出流不需要close关闭
        //标准输出流不再指向控制台，而是指向自己写的文件(由于电脑中没有2
//txt这个文件，所以先用文件字节输出流创建了)
        PrintStream printStream=new PrintStream(new FileOutputStream("H:\\学习io流用\\2.txt"));
        //修改输出方向，将输出方向改到"H:\学习io流用\2.txt"
        System.setOut(printStream);
        //再输出
        System.out.println("hello，world!");
        System.out.println("hello，kitty!");
```

### 记录日志

```java
public class Logger {
    /**记录日志*/
    public static void log(String meg) {
        try {
            //将输出指向一个日志文本
            PrintStream out=new PrintStream(new FileOutputStream("log.txt",true));
            //改变输出方向，不打印在控制台
            System.setOut(out);
            //获取当前时间
            Date data=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
            String strTime=sdf.format(data);
            //输出在out指向的地址
            System.out.println(strTime+":"+meg);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```

# File类

1. File类和四大家族**没有关系**，所以**File类不能完成文件的读和写**。
2. File对象代表什么?**文件和目录经名的抽象表现形式**。C：\Program 这是一个File对象  C:\Program\lan\.. 这也是File对象  File只是一个路径名的**抽象表示形式。**
3. File常用方法

```java
 public static void main(String[] args) throws Exception {
        //创建一个File对象
        File file=new File("H:\\学习io流用\\3");
        //判断该文件是否存在
        System.out.println(file.exists());
       // 如果对象你的文件不存在，则以文件名字进行创建该格式文件
        if (!file.exists()){
            //以文件形式新建
            file.createNewFile();
        }
        //如果3不存在，则以目录的形式进行创建
        if (!file.exists()){
            //以目录形式创建
            file.mkdir();
        }
        //可以创建多重目录吗？
        File file1=new File("H:\\学习io流用\\34\\4\\4\\4\\4\\4");
        if (!file1.exists()){
            //多重目录形式创建
            file1.mkdirs();
        }
        File file2=new File("H:\\学习io流用\\34\\4\\4\\4\\4\\4");
        //获取文件得父路径
        String parew=file2.getParent();//字符串
        System.out.println(parew);
        //getParentFile()方法返回的是File类型的值，而getParent()返回的是字符串类型的值，根据你想获得的值来区别使用，而exists()方法和mkdirs()方法是getParentFile()返回的File类型里面的方法，exists()方法是查看有没有此路径或者文件，mkdirs()方法是若没有此路径用来创建的
        File parentFile=file1.getParentFile();//文件路径类型
        System.out.println("获取绝对路径"+parentFile.getAbsolutePath());
        //获取文件名
        System.out.println("文件名:"+file.getName());
        //判断是否是一个文件
        System.out.println(file.isFile());
        //获取文件最后一次修改时间
        long haoMiao=file.lastModified();
        //将毫秒数转换成日期
        Date time=new Date() ;
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String s=simpleDateFormat.format(time);
        System.out.println(s);
        //获取文件大小
        System.out.println(file.length());
        File file2=new File("H:\\学习io流用\\34\\4\\4\\4\\4\\4");
        File[] files=file2.listFiles();//获取当前文件目录下得所有子文件
        for (File file3 : files) {
            System.out.println(file3.getAbsolutePath());
        }
    }
```

# 目录拷贝


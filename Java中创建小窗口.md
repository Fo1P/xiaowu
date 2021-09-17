# 创建一个小窗口

## 1.创建一个窗口对象

```java
JFrame jf=new JFrame("傻逼");//傻逼是窗口的标题
```

## 2.设置窗口的大小

```java
jf.setSize(300,200)//设置窗口大小
```

## 3.设置窗口的位置

```java
jf.setLocation(range,range1);
```

## 4.让窗口可以看见

```java
jf.setVisible(true);
```

## 5.让窗口可以正常关闭

```java
jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
```


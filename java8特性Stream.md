# JDK8 Stream详解

Stream 是 Java8 中**处理集合**的关键抽象概念，它可以指定你希望对**集合**进行的操作，可以执行非常复杂的查找、过滤和映射数据等操作。使用Stream API 对**集合数据**进行操作，就类似于使用 SQL 执行的数据库查询。也可以使用 Stream API 来并行执行操作。简而言之，Stream API 提供了一种高效且易于使用的处理数据的方式。

## 特点

1. **代码简洁**：函数式编程写出的代码简洁且意图明确，使用stream接口让你从此告别for循环
2. **多核友好**：java函数式编程使得编写并行程序从未如此简单，你需要的全部就是调用以下方法。
3.  不是数据结构，不会保存数据。
4.  **不会修改原来的数据源**，它会将操作后的数据保存到另外一个对象中。（保留意见：毕竟peek方法可以修改流中元素）
5.  **惰性求值**，流在中间处理过程中，只是对操作进行了记录，并不会立即执行，需要等到执行终止操作的时候才会进行实际的计算。

## 流程

```
1）第一步：把集合转换为流stream
2）第二步：操作stream流
stream流在管道中经过中间操作(intermediate operation)的处理，最后由最终操作(terminal operation)得到前面处理结果
```

## 操作符

两种：中间操作符，终止操作符（结束操作）

| Stream操作分类 |                   |                                                              |
| -------------- | ----------------- | ------------------------------------------------------------ |
| 中间操作       | 无状态(Stateless) | unordered() filter() map() mapToInt() mapToLong() mapToDouble() flatMap()flatMapToLong()flatMapToDouble()peek() |
|                | 有状态(Stateful)  | distinct()sorted()limit()skip()                              |
| 结束操作       | 非短路操作        | forEach()forEachOrdered()toArray()reduce()                   |
|                | 短路操作          | anyMatch()allMatch()noneMatch()findFirst()findAny()          |

无状态：指元素的处理不受之前元素的影响

有状态：指该操作只有拿到所有元素之后才能继续下去

非短路操作：指必须处理所有元素才能得到最终元素

短路操作：指遇到某些符合条件的元素就可以得到最终结果，如 A || B，只要A为true，则无需判断B的结果。

## 中间操作符

 

| 流方法   | 含义                                                         | 实例 |
| -------- | ------------------------------------------------------------ | ---- |
| filter   | 用于通过设置条件过滤元素                                     | 1    |
| distinct | 去重，返回一个元素各异（根据流所生成元素的hashCode和equals方法实现）的流 | 2    |
| limit    | 会返回一个不超过给定长度的流，（取前几个）                   | 3    |
| skip     | 扔掉前n个元素                                                | 4    |
| map      | 对流中的元素统一处理                                         | 5    |
| flatMap  | 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。 |      |
|          |                                                              |      |

##### 1

```java
 List<String> strings= Arrays.asList("abc","fqqq","bc","efg","abcd","f","jkl");
        //两个创建流方式,两种都可以
        //1.并行创建
        //strings.parallelStream();
        //2.串行得
//        strings.stream();
        //只使用中间操作符，结果为字符流
        Stream<String> f1 = strings.stream().filter(str -> str.contains("f"));
        //这句话得到意思运用filter方法（中间操作符）设置条件，将含有"f"的字符串，放入集合中
        //collect（终止符）收集，将收集的字符串变成集合元素放入集合，转换为其他形式
        List<String> f = strings.stream().filter(str -> str.contains("f")).collect(Collectors.toList());
        System.out.println(f);
```

[fqqq, efg, f]

##### 2

```java
    public static void distinct(){
        List<String> strings= Arrays.asList("abc","fqqq","bc","efg","abcd","bc","jkl");
        List<String> distinctd=strings.stream().distinct().collect(Collectors.toList());
        System.out.println(distinctd);
    }
```

[abc, fqqq, bc, efg, abcd, jkl]

3

```java

List<String> strings= Arrays.asList("abc","fqqq","bc","efg","abcd","bc","jkl");
        List<String> collect = strings.stream().limit(2).collect(Collectors.toList());
        System.out.println(collect);
```

[abc, fqqq]

4

```java
List<String> strings= Arrays.asList("abc","fqqq","bc","efg","abcd","bc","jkl");
        List<String> collect = strings.stream().skip(2).collect(Collectors.toList());
        System.out.println(collect);
```

[bc, efg, abcd, bc, jkl]

5

```java
//map 对流中所有元素做统一处理
    public static void map(){
        List<String> strings= Arrays.asList("abc","fqqq","bc","efg","abcd","bc","jkl");
        //所有元素加上_a
        List<String> a = strings.stream().map(str -> str.concat("_a")).collect(Collectors.toList());
        System.out.println(a);
    }
```

[abc_a, fqqq_a, bc_a, efg_a, abcd_a, bc_a, jkl_a]
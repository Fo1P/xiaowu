HTML：超文本脚本语言 -决定页面上显示什么内容

CSS：页面上内容显示的风格

JavaScript：页面特效

# HTML/CSS

## B/S软件结构

JAVASE:c/s cilent sever

B/S 浏览器到服务

## 网页组成部分

页面由三部分组成：

1. 内容：是我们在页面中可以看到的数据，我们称之为内容，一般用html展示
2. 表现：指的是这些内容在页面上的展示形式。比如说：颜色，大小。一般使用css来表现
3. 行为：指的是页面中元素与输入设备的响应，javascript

## HTMl简介

Hyper Text Markup Lauguage 超文本标记语言

```html
<!DOCTYPE html><!-约束声明 -->
<html lang="en"><!- html标签代表html的开始 lang="zh_CN表示中文"-->
<head>
    <meta charset="UTF-8"><!- 表示当前页面使用UTF-8集 -->
    <title>Title</title>
</head>
<body>

</body>
</html>
```

## HTML标签介绍

1.标签的格式

<标签名>封装的数据</标签名>

2.标签名大小写不敏感

3.标签拥有自己的属性

​     i:基本属性：bgcolor="red"

​     ii:事件属性: onclick=" alert('你好!')"

4.分为单标签和双标签

​     单标签：<标签名>

​     双标签：<标签名>封装的数据</标签名>

# 常用标签介绍

## font标签

字体标签

## 标题标签

<h1>h1</h1> 
<h2>h2</h2>
<h3>h3</h3>
<h4>h4</h4>
<h5>h5</h5>

## 超链接

<a></a>

href表示连接地址

target表示设置那个目标跳转 _self当前页面跳转 _blank新开页面跳转

## 列表

### 无序列表

type属性可以修改张三前的符号

li是列表项

```html
<ul>
        <li>张三</li>
        <li>张三</li>
        <li>张三</li>
        <li>张三</li>
    </ul>
```

- 张三
- 张三
- 张三
- 张三

### 有序列表

```html
<ol>
        <li>张三</li>
        <li>张三</li>
        <li>张三</li>
        <li>张三</li>
    </ol>
```

1. 张三
2. 张三
3. 张三
4. 张三

## img标签

显示图片

### 路径问题

Java中：相对路径：从工程名开始算

绝对路径：盘符：/目录/文件名

在web中：相对路径：

.    表示当前所在目录

..   表示当前文件所在上一级目录

文件名   表示当前文件所在目录文件，相当于./文件名

## 表格标签*

table标签是表格标签

​       border是设置表格标签

​       width，height分别是宽高

​        aligin

​        cellspacing:

tr是行标签

td是单元格标签

th是表头标签

b:加粗

```html
<body>
    <table border="1" width="300" height="300">
        <tr>
            <td align="center"><b>1.1</b></td>
            <th>1.2</th>
            <td>1.3</td>
        </tr>
        <tr>
            <td>1.1</td>
            <th>1.2</th>
            <td>1.3</td>
        </tr>
        <tr>
            <td>1.1</td>
            <th>1.2</th>
            <td>1.3</td>
        </tr>
    </table>
</body>
```

## 跨行跨列标签*

colspan：属性设置跨列

rowspan：属性设置跨行

```html
<table border="1" width="300" height="300">
        <tr>
            <td colspan="2">1.1</td>//跨两列所以删掉1.2
    
            <td>1.3</td>
        </tr>
        <tr>
            <td>2.1</td>
            <th rowspan="2">2.2</th>跨两行所以删掉3.2
            <td>2.3</td>
        </tr>
        <tr>
            <td>3.1</td>
            
            <td>3.3</td>
        </tr>
    </table>
```

## iframe标签

可以在页面上开辟一个小区域显示一个单独的页面

iframe与a标签组合使用的步骤：

1. 在iframe标签中使用name属性定义一个名称
2. 在a的target标签属性上设置iframe定义的name名称

```html
<br>
    我是一个单独的页面<br/><br/>
    <iframe sec="导航栏制作\shili.html" width="500" height="400" name="abc">

    </iframe>
    <br/>
    <ul>
        <li><a href="H:\HTML实例\暑假作品\practise.html" target="abc">1</a></li>
        <li><a href="H:\HTML实例\幽灵制作\ghost.html" target="abc">2</a></li>
        <li><a href="H:\HTML实例\lanqiao\index.html" target="abc">3</a></li>
    </ul>
```

## 表单标签**

form标签就是表单

​    input type=text 是文本输入框 value设置默认显示内容

​    input type=password 密码输入框

​     input type=radio  是单选框 name属性可以对其进行分组，使得一个组只能选一个 checked=“checked”表示默认选中

​     input type=checkbox 复选框

input type=reset 重置按钮

input type=submit 提交按钮

input type=button 按钮

input type=file 文件上传

input type=hidden 隐藏域 不需要用户参与时使用

select 下拉列表框

option 下拉列表框中的选项 selected="selected"设置默认选中

textarea表示多行文本输入框

  rows 属性可以设置显示几行高度

  cols设置每行可以显示几个字符宽度

```html
 <form>
        用户名称：<input form="text" value="moren"><br/>
        用户密码：<input form="password" value="abc"><br>
        性别：<input type="radio" name="sex">男<input type="radio" name="sex" checked="checked">女
        兴趣爱好：<input type="checkbox" checked="checked">java<input type="checkbox">python<input type="checkbox" checked="checked">js<br>
        国籍：<select>
              <option>--请选择国籍--</option>
              <option>中方</option>
              <option>meiguo</option>
        </select><br>
        自我评价：<textarea rows="10" cols="20"></textarea>
    </form>
```

## 表单格式化*********

form是表单标签 

​    action设置提交的服务器地址

​     method设置提交的方式get(默认)或者post

表单提交的时候，数据没有发送给服务器的三种情况：

1. 表单项没有name属性值
2. 单选，复选(下拉列表中的option标签)都需要添加value属性，以便发送给服务器
3. 表单项不在提交的form标签中

get请求的特点：

1. 浏览器地址栏中的地址是：action属性（url）[+？+请求参数] 请求参数格式是name=value&name=value 例如下面:action=login&sex=girl&country=cn
2. 不安全
3. 它有数据长度限制(ASC11不超过100)

```html
<body>
    <h1 align="center">用户注册</h1>
    <form action="http://localhost:8080" method="get">
        <input type="hidden" name="action" value="login"/>
        <table  align="center">
            <tr>
                <td>用户名称：</td>
                <td><input form="text" value="moren" name="username"><br/></td>
            </tr>
            <tr>
                <td>用户密码：</td>
                <td><input form="password" value="abc" name="password"><br></td>
            </tr>
            <tr>
                <td>性别：</td>
        
                <td><input type="radio" name="sex" value="boy">男<input type="radio" name="sex" checked="checked" value="girl">女</td>
            </tr>
            <tr>
                <td>兴趣爱好</td>
                <td> <input type="checkbox" checked="checked">java<input type="checkbox">python<input type="checkbox" checked="checked">js<br></td>
            </tr>
            <tr>
                <td>国籍：</td>
                <td><select name="country">
                    <option value="none">--请选择国籍--</option>
                    <option value="cn">中方</option>
                    <option value="usa">meiguo</option>
              </select><br></td>
            </tr>
            <tr>
                <td>自我评价：
                </td>
                <td><textarea rows="10" cols="20"></textarea></td>
            </tr>
            <tr>
                <td><input type="reset"></td>
                <td align="center"><input type="submit" ></td>
            </tr>
        </table>
    </form>
</body>
```

post请求的特点：

1. 浏览器地址栏中只有action地址
2. 相对于get请求要安全
3. 理论上没有数据长度限制

## 其他标签

div 默认独占一行

span 它的长度是封装数据长度

p段落标签 默认会在段落的上方或者下方空出一行(已经被占就不再空)

# CSS

## 语法规则

```css
p{
font-size:20px;
}
```

选择器：浏览器根据选择器决定CSS样式影响的html元素(标签)

属性：是你要改变的样式名字，并且每个属性都有一个值。属性和值用冒泡分开，并且由花括号包围，这样就组成了一个完整的样式声明

css注释:/*  */

## 结合方式

第一种在style属性上设置：“key:value:value” 修改标签样式

```html
<div style="border:1px black"></div>
```

第二种在head标签中定义

```html
<head>
<style type="text/css">
    p{
font-size:20px;
}
</style>
</head>
```

第三种外联

## css选择器

标签名选择器

id选择器：可以让我们通过id属性选择性的去使用这个样式

```
#id属性值{
 属性:值；
}
```

class选择器(类选择器)

```html
.class属性值{
  属性：值；
}
```

## 组合选择器

```
选择器1，选择器2，选择器3，{
   属性：值；
}
```

组合选择器可以让多个选择器共用同一个代码

# JavaScript

JavaScript语言诞生主要是完成页面的数据验证。

**Js是弱类型，Java是强类型**

弱类型就是类型可变，强类型就是定义变量的时候，类型已经确定不可改变。

java： int i=12;

javascript: var i;

i=12; 数值型 

i="abc"; 字符串类型

特点:

1. 交互性(信息的动态交互)
2. 安全性(不允许直接访问本地硬盘)
3. 跨平台性

## javascript和html代码的结合方式

### 第一种

只需要在head标签中或者在body标签中，使用sacript标签就好啦

### 第二种

使用script标签引入，src用来引入文件路径或者js代码

## 变量

javascript的变量类型：

1. 数值类型：number
2. 字符串类型：string
3. 对象类型：object
4. 布尔类型：boolean
5. 函数类型：function

javascript的特殊值:

underfined:未定义，所有js变量为赋于初始值时候，默认值

null:空值

NAN:NOT A NUMBER非数，非数值

Js中定义变量的格式：var 变量名=值；

函数**typeof()**:javascript的变量数据类型返回

## 关系运算

等于：== 简单的做字面值比较

全等于：===除了做字面作比较外，还会比较两个变量的数据类型

&&:分两种情况：1.当表达式全为真的时候，返回最后一个表达式的值

2.当表达式中，有一个为假的时候，返回第一个为假的表达式的值

||：1.当表达式全为假返回最后一个表达式的值2.只要有一个表达式为真，就回返回第一个为真的值

并且||和&&有短路

## 数组**

javascript中的数组是不用初始化的,并且通过数组下标进行**赋值**时，最大的下标值，就会**自动给数组扩容操作**

```javascript
<script>
    var arr=[1,"abcs"];//定义一个数组
    arr[0]=1;

    arr[2]="abc";
    alert(arr.length);
    for(var i=0;i<arr.length;i++)
    {
        alert(arr[i]);
    }
</script>
```

## 函数的定义***

```javascript
function 函数名(形参){
    
}
```

```javascript
function sum(num1,num2){
    var result=num1+num2;
    return result;
}
alert(sum(100,50));
```

第二种：

```javascript
var 函数名=function(形参列表){
   函数体
}
```

**js中重载会覆盖上一次的定义，与java不同**

## 函数的arguments隐形函数

在function函数中不需要被定义，但却可以直接用来获取所有参数的变量。像java中的可变长参数。

```javascript
 function fun(){
        for(var i=0;i<arguments.length;i++)
        {
            alert(arguments[i]);

        }
        alert("无参函数fun()");}
        fun(1,"ad",true);
```

## JS中的自定义对象

### 以Object的形式定义

```
var 变量名 =new Object();//实例化对象
变量名.属性名=值;//定义一个属性
变量名.函数名=function(){}//定义一个函数
//访问一个对象
变量名.属性(函数名);
```

```javascript
 var obj=new Object();
    obj.name="华仔";
    obj.age=18;
    obj.fun=function()
    {
        alert("姓名"+this.name+"年龄"+this.age);
    }
    obj.fun();
```

### {}花括号形式定义对象***

```
var 变量名 ={//空对象
    属性名：值,//定义一个属性
    属性名：值,//定义一个属性
    函数名:function(){}//定义一个函数
}
对象的访问
变量名.属性/函数名()；
```

## Js中的事件

**电脑输入设备与页面交互的响应就叫做事件**

常用的事件：

1. onload加载完成事件； 页面加载完成之后，常用于js初始化操作
2. onclick单击事件; 常用于按钮的点击响应操作
3. onblur 失去焦点事件; 常用于输入框失去焦点后验证其输入内容是否合法
4. onchange内容发生改变事件; 常用于下拉列表和输入框内容发生改变后操作
5. onsubmit 表单提交事件; 常用于表单提交前，验证所有表单项是否合法

## 事件的注册

其实就是告诉浏览器，当事件响应后要执行哪些操作代码，叫做事件注册或事件绑定。

静态注册事件：通过html标签的事件属性直接赋予事件响应后的代码

动态注册事件：是指先通过js代码得到标签的dom对象，然后再通过dom对象.事件名=function(){}这种形式赋予事件响应后代码，叫做动态注册

​    动态注册基本步骤:1.获取标签对象2.标签对象.事件名=function(){}

```javascript
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Wu</title>
<script>
   function onloadFun(){
       alert("静态注册事件");
   }
   //动态注册onload事件
   window.onload=function(){
       alert("动态注册事件");
   }
</script>
</head>
<!-- <body onload="onloadFun();"> -->
</body>
</html>
```

## onclick

```html
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Wu</title>
<script>
   function onclickFun(){
       alert("静态注册事件");
   }
   //动态注册onload事件
   window.onload=function(){
       /*
       1.获取标签对象
       */
       var btnObj= document.getElementById("btn");
       alert(btnObj)
       //通过标签对象.事件名=function(){}
       btnObj.onclick=function(){
           alert("动态注册");
       }
}
</script>
</head>
<body>
    <!-- 静态注册事件 -->
    <button onclick="onclickFun();">按钮1</button>
    <button id="btn">按钮2</button>
</body>
</html>
```

## onblur事件

```html
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Wu</title>
<script>
   function onblurFun(){
       //打印方法
       console.log("失去焦点事件");
   }
   //动态注册onload事件
   window.onload=function(){
       /*
       1.获取标签对象
       */
       var btnObj= document.getElementById("password");
       alert(btnObj)
       //通过标签对象.事件名=function(){}
       btnObj.onblur=function(){
           alert("动态注册");
       }
}
</script>
</head>
<body>
    <!-- 静态注册事件 -->
    用户名:<input type="text" onblur="onblurFun();">
    密码：<input type="password" id="password">
</body>
```

## onchange

```html
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Wu</title>
<script>
   function onchangeFun(){
       //打印方法
       console.log("改变事件");
   }
   //动态注册onload事件
   window.onload=function(){
       /*
       1.获取标签对象
       */
       var btnObj= document.getElementById("s101");
       alert(btnObj)
       //通过标签对象.事件名=function(){}
       btnObj.onchange=function(){
           alert("以改变");
       }
}
</script>
</head>
<body>
    <select onchange="onchangeFun();">
        <option>--选择--</option>
        <option>fangfang </option>
        <option>zeze</option>
        <option>ww</option>
    </select>
    <select id="s101">
        <option>--选择--</option>
        <option>fangfang </option>
        <option>zeze</option>
        <option>ww</option>
    </select>
</body>
</html>
```

## onsubmit

```html
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Wu</title>
<script>
   function onsubmitFun(){
       //打印方法
       alert("发现合法");
       return true;
   }
   //动态注册onload事件
   window.onload=function(){
       /*
       1.获取标签对象
       */
       var btnObj= document.getElementById("w");
       alert(btnObj)
       //通过标签对象.事件名=function(){}
       btnObj.onsubmit=function(){
           alert("buhefa");
           return false;
       }
}
</script>
</head>
<body>
    <form action="http://localhost:8080" method="get" onsubmit="return onsubmitFun();">

        <input type="submit" value="静态注册">
    </form>
    <form action="http://localhost:8080" id="w">

        <input type="submit" value="动态注册">
    </form>
</body>
</html>
```

## Dom模型

全称:文档对象模型

就是把文档中的属性，标签，文本转换成为对象来管理，相当于将html代码变成树状图结构，有层级关系，例如<html>就是最大的一级其次是分为<head><body>两级

![屏幕截图 2022-02-06 150743](G:\学习\笔记\JavaWeb\资料图片\屏幕截图 2022-02-06 150743.png)

Document对象的理解：

1. 他管理了所有的HTML文档内容
2. 它是一种树结构关系，有层级关系
3. 它让我们把所有标签都对象化
4. 我们可以通过document访问所有的标签对象

**这个生成的对象存在var或者let里，但是就是指一个标签内的所有属性都是在这个变量内，相当于创建对象**

```javascript
 //1.先获取id对象
        var usernameObj=document.getElementById("username");
        //通过对象usernameObj获取标签值(id,type之类的)
       alert(usernameObj.id);
         alert(usernameObj.type);
//相当于是创建input对象，type,id都是它的属性
    <input type="text" id="username">    
```



## 小案例：验证用户名

```javascript
<script>
   function onclickFun(){
       //1.先获取id对象
       var usernameObj=document.getElementById("username");
       //通过对象usernameObj获取标签值(id,type之类的)
    //    alert(usernameObj.id);
    //    alert(usernameObj.type);
       var usernameText=usernameObj.value;
       //使用正则表达式符合某个规则
       var patt=/^\w{5,12}$/;
       if(patt.test(usernameText)){
           alert("用户合法");
       }else{
           alert("不合法")
       }
   }

</script>
</head>
<body>
    用户名:<input type="text" id="username">
    <button onclick="onclickFun()">校验</button>
</body>
</html>
```

## 正则表达式

表示要求字符串中必须包含e

```javascript
//第一种写法
//var patt=new RegExp("e");
//第二种
var patt=/e/;
   var str="abcd";

   alert(patt.test(str));false
```

表示要求字符串中，是否包含a或b或c

[]表示查找在方括号之间的字符

```javascript
var patt=/[abc]/;
 var str="abcd";
alert(patt.test(str));true
```

表示字符串中是否包含小写字符

```javascript
var patt=/[a-z]/;
alert(patt.test(str));true
//大写
var patt=/[A-Z]/;
//数字
var patt=/[0-9]/;
```

表示字符串中是否包含字母，数字，下划线

```javascript
var patt=/\w/;
```

表示字符串中包含至少一个a

```javascript
var patt=/a+/;
```

表示字符串中包含0个或多个a

```javascript
var patt=/a*/;
```

表示字符串中包含0个或多个a

```javascript
var patt=/a?/;
```

表示要求字符串是否包含连续3个a

```javascript
var patt=/a{3}/;
```

表示要求字符串至少包含3个连续的a或者最多5个连续的a

```javascript
var patt=/a{3,5}/;
```

表示要求字符串至少包含3个连续的a

```javascript
var patt=/a{3,}/;
```

表示要求字符串必须以a结尾

```javascript
var patt=/a$/;
```

表示字符串必须以a打头

```javascript
var patt=/^a/;
```

表示从头到尾部完全匹配,至少3个最多5个全是a

```javascript
var patt=/^a{3,5}$/;
var str="aaaaaaa";false
var patt=/a{3,5}/;
var str="aaaaaaa";true
```

例子：

从头到尾5-12都是字母，数字，下划线

```javascript
var patt=/^\w{5,12}$/;
```

## 验证提示

用innerHTML添加文字

```html
<script>
    function onclickFun(){
        //1.先获取id对象
        var usernameObj=document.getElementById("username");
        //通过对象usernameObj获取标签值(id,type之类的)
     //    alert(usernameObj.id);
     //    alert(usernameObj.type);
        var usernameText=usernameObj.value;
        //使用正则表达式符合某个规则
        var patt=/^\w{5,12}$/;
        var usernameSpan=document.getElementById("usernameSpan");
        //innnerHTML表示起始标签和结束标签的内容,可读。可写
        // alert(usernameSpan.innerHTML);
        usernameSpan.innerHTML="测试"
        if(patt.test(usernameText)){
            alert("用户合法");
            usernameSpan.innerHTML="用户合法"
        }else{
            alert("不合法")
            usernameSpan.innerHTML="用户不合法"
        }
    }
 
 </script>
 </head>
 <body>
     用户名:<input type="text" id="username">
     <span id="usernameSpan" style="color: red;"></span>
     <button onclick="onclickFun()">校验</button>
 </body>
 </html>
```

添加图片

```html
<script>
    function onclickFun(){
        //1.先获取id对象
        var usernameObj=document.getElementById("username");
        //通过对象usernameObj获取标签值(id,type之类的)
     //    alert(usernameObj.id);
     //    alert(usernameObj.type);
        var usernameText=usernameObj.value;
        //使用正则表达式符合某个规则
        var patt=/^\w{5,12}$/;
        var usernameSpan=document.getElementById("usernameSpan");
        //innnerHTML表示起始标签和结束标签的内容,可读。可写
        // alert(usernameSpan.innerHTML);
        usernameSpan.innerHTML="测试"
        if(patt.test(usernameText)){
            alert("用户合法");
            //显示图片
            usernameSpan.innerHTML="<img src="" width=" " height="">"
        }else{
            alert("不合法")
            //显示字体
            usernameSpan.innerHTML="用户不合法"
        }
    }
 
 </script>
 </head>
 <body>
     用户名:<input type="text" id="username">
     <span id="usernameSpan" style="color: red;"></span>
     <button onclick="onclickFun()">校验</button>
 </body>
 </html>
```

## getElementByName

getElementByName()返回的是多个标签对象集合

这个集合操作跟数组一样，集合中每个元素都是dom对象

这个集合中的元素顺序就是在html页面中的从上到下的顺序

```html
<script>
    //全选
    function checkAll(){
        //让所有复选框选中
        var hobbies= document.getElementsByName("hobby");
        // alert(hobbies[1]);
        //checked表示复选框的选中状态，如果选中是true否则为false
        //checked这个属性是可读可写的
        for(var i=0;i<hobbies.length;i++){
            hobbies[i].checked=true;
        }
    }
    //都不选
    function checkNo(){
        var hobbies= document.getElementsByName("hobby");
        
        for(var i=0;i<hobbies.length;i++){
            hobbies[i].checked=false;
        }
    }
    //反选
    function checkReserve(){
        var hobbies= document.getElementsByName("hobby");
        for(var i=0;i<hobbies.length;i++){
            if(hobbies[i].checked==true){
                hobbies[i].checked=false;
            }else{
                hobbies[i].checked=true;
            }
        }
    }

 </script>
 </head>
 <body>
     兴趣爱好:
     <input type="checkbox" name="hobby" value="cpp">c++
     <input type="checkbox" name="hobby" value="java">java
     <input type="checkbox" name="hobby" value="python">python
     <br>
     <button onclick="checkAll()">全选</button>
     <button onclick="checkNo()">全不选</button>
     <button onclick="checkReserve()">反选</button>
 </body>
 </html>
```

## getElementByTagName

是按照标签名查询对象并返回集合

```js
 //全选
    function checkAll(){
        //让所有复选框选中
        var hobbies= document.getElementsByTagName("input");
        // alert(hobbies[1]);
        //checked表示复选框的选中状态，如果选中是true否则为false
        //checked这个属性是可读可写的
        for(var i=0;i<hobbies.length;i++){
            hobbies[i].checked=true;
        }
    }
```

## dom方法三个查询注意事项

document对象的三个查询方法，如果有id属性有限getElementById方法来进行查询，如果没有id，则优先使用getElementByName方法，如果id和name都没，则用getElementByTagName

**以上三个方法，一定要在页面加载完成之后执行，才能查询到标签对象。**

意思就是用动态的话就先要window.onload=function(){}

## 节点的常用属性和方法

节点就是标签对象

```
<input name=" " id=" ">

<br>//这就是两个节点

子节点就是包含在里面的，例如<ul>是<div>的子节点，<li>是<ul>的
<div>
   <ul>
     <li></li>
     <li></li>
    </ul>
</div>
```

通过具体的元素节点调用getElementByTagName()方法，获取当前节点的指定标签名孩子节点

appendChild(oChildNode)方法，可以添加一个子节点，oChildNode就是要添加的孩子节点

属性：

1. childNodes:获取当前节点的所有子节点
2. firstChild:获取当前节点的第一个子节点
3. lastChild；最后一个子节点
4. parentNode:获取当前节点父节点
5. nextSibling:获取当前节点的下一个节点
6. previousSibling:获取当前节点的上一个节点

## createElement

```html
<script>
    //用js创建div标签显示在页面上
   window.onload=function(){
      var dicobj=document.createElement("div");
      dicobj.innerHTML="woei";
      document.body.appendChild(dicobj);
   }

 </script>
```

# jQuery

## 简单介绍

```javascript
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js">
    </script>
```

## 绑定单击事件

```js
<head>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js">
    </script>
<script type="text/javascript">
//  js原生单击事件
//  window.onload=function(){
//     var btnobj=document.getElementById("btnId");
//     btnobj.onclick=function(){
//        alert("js原生");
// }
// }
     $(function (){//表示页面加载，相当于js的window.onload
        var btnobj=$("#btnId");//表示获取id为btnId的对象
        btnobj.click(function (){//绑定单击事件
           alert("jqury单击事件");
        });

     });

 </script>
 </head>
 <body>
     <button id="btnId">sayhello</button>
 </body>
 </html>
```

## 核心函数

$是jquery的核心函数，能完成jequry的很多功能。$()就是

1.()当传入参数为函数时,相当于页面加载完成之后。window.onload=function(){}

2.()传入参数为html标签字符串时，会对我们创建这个html标签对象

```html
<html>
<head>
<meta charset="UTF-8">
<title>Wu</title>
<head>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js">
    </script>
<script type="text/javascript">

    $(function (){
       $("<div><span>我是你爹</span></div>").appendTo("body")
    });
 </script>
 </head>
 <body>
 </body>
 </html>
```

3.()传入参数为选择器字符串时，$("#Id属性值")；id选择器，根据id查询标签对象，$("标签名")；标签名选择器，根据指定的标签名查找标签对象，$(".+class属性值");类型选择器，根据class属性查询对象

4.（）传入参数为dom对象时，他会转换为jquery对象

```js
var btn=document.getElementById("bt");
alert(btn);//js的dom对象
alert($(btn));//jequry对象
```

**通过jequery的包装，使用后的都属于jequry对象**

**jequry对象是dom对象的数组+jquery提供的一系列的功能函数**

## dom对象与jquery对象使用区别

jequry对象不能使用DOM对象的属性和方法

DOM对象也不能使用jequry对象的属性和方法

```html
<script type="text/javascript">

   document.getElementById("testDIv").innerHTML="dom对象可以修改id对象的值";
   $("#testDIv").innerHTML="jqury对象不能修改"

 </script>
 </head>
 <body>
     <div id="testDIv">这里</div>
 </body>
 </html>
```

## DOM对象转为jequry对象

### dom转jqury

1.先通过getElementById获取dom对象

2.再通过$(dom对象)转换为jqury

### jqury转dom

1.先有jqury对象

2.jqury对象[下标]取出相应的dom对象

## jqury基本选择器

id选择器:$("#id名")

标签选择器:$("标签名")

class(类)选择器:$(".类名")

所有元素:$("*")

## 层级选择器

选择id=“one”的下一个div元素

$("#one+div")

选择id=“two”的以后所有元素

$("#two~div")

匹配表单(form)中所有的子级input元素。

```html
jqury:
$("form > input")
html:
<form>
  <label>Name:</label>
  <input name="name" />
  <fieldset>
      <label>Newsletter:</label>
      <input name="newsletter" />
 </fieldset>
</form>
<input name="none" />
```

```html
结果：
[ <input name="name" /> ]
```

在给定的祖先元素(form)下匹配所有的后代元素

找到表单中所有的 input 元素

```html
<form>
  <label>Name:</label>
  <input name="name" />
  <fieldset>
      <label>Newsletter:</label>
      <input name="newsletter" />
 </fieldset>
</form>
<input name="none" />
```

```html
$("form input")
```

```html
[ <input name="name" />, <input name="newsletter" /> ]
```

## 过滤选择器

获取匹配第一个元素

```html
<ul>
    <li>list item 1</li>
    <li>list item 2</li>
    <li>list item 3</li>
    <li>list item 4</li>
    <li>list item 5</li>
</ul>
```

```html
$('li:first');
```

```html
[ <li>list item 1</li> ]
```

去除所有与给定选择器匹配的元素

查找所有未选中的 input 元素

```html
<input name="apple" />
<input name="flower" checked="checked" />
```

```html
$("input:not(:checked)")
```

```html
[ <input name="apple" /> ]
```

匹配所有索引值为偶数的元素，从 0 开始计数

例子：查找表格的1、3、5...行（即索引值0、2、4...）

```html
<table>
  <tr><td>Header 1</td></tr>
  <tr><td>Value 1</td></tr>
  <tr><td>Value 2</td></tr>
</table>
```

```html
$("tr:even")
```

```html
[ <tr><td>Header 1</td></tr>, <tr><td>Value 2</td></tr> ]
```

匹配所有索引值为奇数的元素，从 0 开始计数

查找表格的2、4、6行（即索引值1、3、5...）

```html
<table>
  <tr><td>Header 1</td></tr>
  <tr><td>Value 1</td></tr>
  <tr><td>Value 2</td></tr>
</table>
```

```html
$("tr:odd")
```

```html
[ <tr><td>Value 1</td></tr> ]
```

获取最后个元素

```html
<ul>
    <li>list item 1</li>
    <li>list item 2</li>
    <li>list item 3</li>
    <li>list item 4</li>
    <li>list item 5</li>
</ul>
```

```
$('li:last')
```

```html
[ <li>list item 5</li> ]
```

匹配一个给定索引值的元素(索引值是0开始，真实里的1，类似java数组)

```html
<table>
  <tr><td>Header 1</td></tr>
  <tr><td>Value 1</td></tr>
  <tr><td>Value 2</td></tr>
</table>
```

```h
$("tr:eq(1)")//1就是2
```

```
[ <tr><td>Value 1</td></tr> ]
```

匹配所有大于给定索引值的元素

```html
<table>
  <tr><td>Header 1</td></tr>
  <tr><td>Value 1</td></tr>
  <tr><td>Value 2</td></tr>
</table>
```

```
$("tr:gt(0)")
```

```
[ <tr><td>Value 1</td></tr>, <tr><td>Value 2</td></tr> ]
```

匹配所有小于给定索引值的元素

```
$("tr:lt(2)")
```

## 内容过滤选择器

匹配包含给定文本的元素

```html
<div>John Resig</div>
<div>George Martin</div>
<div>Malcom John Sinclair</div>
<div>J. Ohn
```

```
$("div:contains('John')")
```

```
[ <div>John Resig</div>, <div>Malcom John Sinclair</div> ]
```

匹配所有不包含子元素或者文本的空元素

例:查找所有不包含子元素或者文本的空元素

```html
<table>
  <tr><td>Value 1</td><td></td></tr>
  <tr><td>Value 2</td><td></td></tr>
</table>
```

```
$("td:empty")
```

```
[ <td></td>, <td></td> ]
```

匹配含有选择器所匹配的元素的元素

例子:给所有包含 p 元素的 div 元素添加一个 text 类

```
<div><p>Hello</p></div>
<div>Hello again!</div>
```

```
$("div:has(p)").addClass("test");
```

```
[ <div class="test"><p>Hello</p></div> ]
```

匹配含有子元素或者文本的元素

例子:查找所有含有子元素或者文本的 td 元素

```
<table>
  <tr><td>Value 1</td><td></td></tr>
  <tr><td>Value 2</td><td></td></tr>
</table>
```

```
$("td:parent")
```

```
[ <td>Value 1</td>, <td>Value 2</td> ]
```

## 属性过滤选择器

匹配包含给定属性的元素

例子：查找所有含有 id 属性的 div 元素

```html
<div>
  <p>Hello!</p>
</div>
<div id="test2"></div>
```

```
$("div[id]")
```

```
[ <div id="test2"></div> ]
```

匹配给定的属性是某个特定值的元素

例子:查找所有 name 属性是 newsletter 的 input 元素

```java
<input type="checkbox" name="newsletter" value="Hot Fuzz" />
<input type="checkbox" name="newsletter" value="Cold Fusion" />
<input type="checkbox" name="accept" value="Evil Plans" />
```

```
$("input[name='newsletter']").attr("checked", true);
```

```
[ <input type="checkbox" name="newsletter" value="Hot Fuzz" checked="true" />, <input type="checkbox" name="newsletter" value="Cold Fusion" checked="true" /> ]
```

匹配所有不含有指定的属性，或者属性不等于特定值的元素。

例子：查找所有 name 属性不是 newsletter 的 input 元素

```html
<input type="checkbox" name="newsletter" value="Hot Fuzz" />
<input type="checkbox" name="newsletter" value="Cold Fusion" />
<input type="checkbox" name="accept" value="Evil Plans" />
```

```
$("input[name!='newsletter']").attr("checked", true);
```

```
[ <input type="checkbox" name="accept" value="Evil Plans" checked="true" /> ]
```

匹配给定的属性是以某些值开始的元素

例子:查找所有 name 以 'news' 开始的 input 元素

```html
<input name="newsletter" />
<input name="milkman" />
<input name="newsboy" />
```

```
$("input[name^='news']")
```

```
[ <input name="newsletter" />, <input name="newsboy" /> ]
```

匹配给定的属性是以某些值结尾的元素

例子:查找所有 name 以 'letter' 结尾的 input 元素

```
<input name="newsletter" />
<input name="milkman" />
<input name="jobletter" />
```

```
$("input[name$='letter']")
```

```
[ <input name="newsletter" />, <input name="jobletter" /> ]
```

匹配给定的属性是以包含某些值的元素

例子:查找所有 name 包含 'man' 的 input 元素

```html
<input name="man-news" />
<input name="milkman" />
<input name="letterman2" />
<input name="newmilk" />
```

```
$("input[name*='man']")
```

```
[ <input name="man-news" />, <input name="milkman" />, <input name="letterman2" /> ]
```

复合属性选择器，需要同时满足多个条件时使用。

例子：找到所有含有 id 属性，并且它的 name 属性是以 man 结尾的

```html
<input id="man-news" name="man-news" />
<input name="milkman" />
<input id="letterman" name="new-letterman" />
<input name="newmilk" />
```

```
$("input[id][name$='man']")
```

```
[ <input id="letterman" name="new-letterman" /> ]
```

## 表单过滤器

匹配所有 input, textarea, select 和 button 元素

例子:查找所有的input元素，下面这些元素都会被匹配到。

```html
<form>
    <input type="button" value="Input Button"/>
    <input type="checkbox" />

    <input type="file" />
    <input type="hidden" />
    <input type="image" />

    <input type="password" />
    <input type="radio" />
    <input type="reset" />

    <input type="submit" />
    <input type="text" />
    <select><option>Option</option></select>

    <textarea></textarea>
    <button>Button</button>

</form>
```

```
$(":input")
```

```
[ 
    <input type="button" value="Input Button"/>,
    <input type="checkbox" />,

    <input type="file" />,
    <input type="hidden" />,
    <input type="image" />,

    <input type="password" />,
    <input type="radio" />,
    <input type="reset" />,

    <input type="submit" />,
    <input type="text" />,
    <select><option>Option</option></select>,

    <textarea></textarea>,
    <button>Button</button>,
 ]
```

匹配所有的单行文本框

```
<form>
  <input type="text" />
  <input type="checkbox" />
  <input type="radio" />
  <input type="image" />
  <input type="file" />
  <input type="submit" />
  <input type="reset" />
  <input type="password" />
  <input type="button" />
  <select><option/></select>
  <textarea></textarea>
  <button></button>
</form>
```

```
$(":text")
```

```
[ <input type="text" /> ]
```

匹配所有密码框

```html
<form>
  <input type="text" />
  <input type="checkbox" />
  <input type="radio" />
  <input type="image" />
  <input type="file" />
  <input type="submit" />
  <input type="reset" />
  <input type="password" />
  <input type="button" />
  <select><option/></select>
  <textarea></textarea>
  <button></button>
</form>
```

```
$(":password")
```

```
[ <input type="password" /> ]
```

匹配所有单选按钮

```html
<form>
  <input type="text" />
  <input type="checkbox" />
  <input type="radio" />
  <input type="image" />
  <input type="file" />
  <input type="submit" />
  <input type="reset" />
  <input type="password" />
  <input type="button" />
  <select><option/></select>
  <textarea></textarea>
  <button></button>
</form>
```

```
$(":radio")
```

```
[ <input type="radio" /> ]
```

匹配所有复选框

```html
<form>
  <input type="text" />
  <input type="checkbox" />
  <input type="radio" />
  <input type="image" />
  <input type="file" />
  <input type="submit" />
  <input type="reset" />
  <input type="password" />
  <input type="button" />
  <select><option/></select>
  <textarea></textarea>
  <button></button>
</form>
```

```
$(":checkbox")
```

```
[ <input type="checkbox" /> ]
```

匹配所有提交按钮，理论上只匹配 type="submit" 的input或者button，但是现在的很多浏览器，button元素默认的type即为submit，所以很多情况下，不设置type的button也会成为筛选结果。为了防止歧义或者误操作，建议所有的button在使用时都添加type属性。

```html
<form>
  <input type="text" />
  <input type="checkbox" />
  <input type="radio" />
  <input type="image" />
  <input type="file" />
  <input type="submit" />
  <input type="reset" />
  <input type="password" />
  <input type="button" />
  <select><option/></select>
  <textarea></textarea>
  <button></button>
</form>
```

```
$(":submit")
```

```
[ <input type="submit" />, <button></button> ]
```

匹配所有图像域

```html
<form>
  <input type="text" />
  <input type="checkbox" />
  <input type="radio" />
  <input type="image" />
  <input type="file" />
  <input type="submit" />
  <input type="reset" />
  <input type="password" />
  <input type="button" />
  <select><option/></select>
  <textarea></textarea>
  <button></button>
</form>
```

```
$(":image")
```

```
[ <input type="image" /> ]
```

查找所有重置按钮

```html
<form>
  <input type="text" />
  <input type="checkbox" />
  <input type="radio" />
  <input type="image" />
  <input type="file" />
  <input type="submit" />
  <input type="reset" />
  <input type="password" />
  <input type="button" />
  <select><option/></select>
  <textarea></textarea>
  <button></button>
</form>
```

```
$(":reset")
```

```
[ <input type="reset" /> ]
```

查找所有按钮.

```html
<form>
  <input type="text" />
  <input type="checkbox" />
  <input type="radio" />
  <input type="image" />
  <input type="file" />
  <input type="submit" />
  <input type="reset" />
  <input type="password" />
  <input type="button" />
  <select><option/></select>
  <textarea></textarea>
  <button></button>
</form>
```

```
$(":button")
```

```
[ <input type="button" />,<button></button> ]
```

匹配所有文件域

```
<form>
  <input type="text" />
  <input type="checkbox" />
  <input type="radio" />
  <input type="image" />
  <input type="file" />
  <input type="submit" />
  <input type="reset" />
  <input type="password" />
  <input type="button" />
  <select><option/></select>
  <textarea></textarea>
  <button></button>
</form>
```

```
$(":file")
```

```
[ <input type="file" /> ]
```

匹配所有不可见元素，或者type为hidden的元素

```
$("tr:hidden")
```

匹配所有的可见元素

```
<table>
  <tr style="display:none"><td>Value 1</td></tr>
  <tr><td>Value 2</td></tr>
</table>
```

```
$("tr:visible")
```

```
[ <tr><td>Value 2</td></tr> ]
```


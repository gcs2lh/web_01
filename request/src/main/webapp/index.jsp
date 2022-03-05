<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!ECOTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <title>登入</title>
</head>
<body>
<h1>登入</h1>
     <div style="text-align: center">
          <%--这里的路径需要加上项目对应的路径。或者直接写路径名，不加斜杠/--%>
          <%--${pageContext.request.contextPath}为项目路径--%>
          <form action="${pageContext.request.contextPath}/login" method="post" >
               用户名：<input type="text" name="username"/> <br>
               密码：<input type="password" name="password"/><br>
               爱好：
                   <input type="checkbox" name="hobby" value="编程"/>编程
                   <input type="checkbox" name="hobby" value="唱歌"/>唱歌
                   <input type="checkbox" name="hobby" value="跳舞"/>跳舞
                   <input type="checkbox" name="hobby" value="游泳"/>游泳
                   <br>
                <input type="submit">
          </form>
     </div>
</body>
</html>
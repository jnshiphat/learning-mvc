
<%
    String userName = request.getParameter("userName");
    if(userName == null)
        userName= "";
%>
<form action="logincontrol" method="post">
<table>
    <tr>
        <td>User Name:</td>
        <td><input type="text" name="userName" value='<%=userName%>'/></td>
    </tr>
    <tr>
        <td>Password:</td>
        <td><input type="password" name="password" /></td>
    </tr>
    <tr>
        <td colspan='2'><input type="submit" name="submit" value="Login" /></td>
    </tr>
    <tr>
    <% if(request.getAttribute("error") != null) {%>
        <td colspan='2'><%=(String)request.getAttribute("error")%></td>
    <%}%>
    </tr>
</table>
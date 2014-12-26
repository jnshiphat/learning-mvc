<%
    model.UserBean bean = new model.UserBean();
    RequestDispatcher dispatcher = null;

    if(session.getAttribute("bean") == null) {
        response.sendRedirect("/index");    
    }
    bean = (model.UserBean)session.getAttribute("bean");
    String userName = bean.getUserName();
    
%>
<h1> Home Page </h1>

<h3> Welcome,  </h3><%=userName%> <br />
<a href='logout'>Logout</a>

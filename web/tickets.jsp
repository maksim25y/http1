<%@ page import="service.TicketService" %>
<%@ page import="dto.TicketDto" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Ticket" %><%--
  Created by IntelliJ IDEA.
  User: mudan
  Date: 04.01.2024
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Купленные билеты:</h1>
    <ul>
    <%
        TicketService ticketService = TicketService.getInstance();
        Long flightId = Long.valueOf(request.getParameter("flightId"));
        List<TicketDto>tickets = ticketService.findAllByFlightId(flightId);
        for(TicketDto ticket:tickets){
            out.write(String.format("<li>%s</li>",ticket.getSeatNo()));
        }
    %>
    </ul>
</body>
</html>

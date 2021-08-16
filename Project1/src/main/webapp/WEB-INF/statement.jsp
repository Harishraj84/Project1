<!DOCTYPE html>
<%@ page import="java.util.*,com.example.entity.*" %>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Trans History</title>
        <link href="./css/bootstrap.css" rel="stylesheet">
    </head>

    <body>

        <div class="container">
            <hr /> <h1>
            <div>
                Transactions
            </div> </h1>
            <hr />
            <hr/>
        <a class="btn btn-lg btn-primary" href="statement?filter=all">All</a>&nbsp;
        <a class="btn btn-lg btn-primary" href="statement?filter=top10">Top 10</a>&nbsp;
        
    <hr/>

  
    <%
        List<Txn> txns=(List<Txn>) request.getAttribute("txns");
    %>

            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Trans ID</th>
                        <th>Account</th>
                        <th>Amount</th>
                        <th>Date</th>
                        <th>Type</th>
                    </tr>
                </thead>
                <tbody>
                    <% List<Txn> trans=(ArrayList<Txn>)request.getAttribute("trans"); %>

                            <% for(Txn txn: trans) { %>
                                <tr>
                                    <td>
                                        <%=txn.getTransactionId()%>
                                    </td>
                                    <td>
                                        <%=txn.getAccount()%>
                                    </td>
                                    <td>
                                        <%=txn.getAmount()%>
                                    </td>
                                    <td>
                                        <%=txn.getDate()%>
                                    </td>
                                    <td>
                                        <%=txn.getCreditOrDebit()%>
                                    </td>
                                </tr>
                                <% } %>
                </tbody>
            </table>
            
             <ul class="nav nav-pills">
                <li class="nav-item"><a class="nav-link" href="index.html">Back</a></li>
               
            </ul>

        </div>
        
       

    </body>

    </html>
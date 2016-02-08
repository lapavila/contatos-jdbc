<%-- 
    Document   : index
    Created on : Dec 3, 2015, 10:42:05 AM
    Author     : avila
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Contato</title>

    <jsp:include page="/include/importCSS.jsp" flush="true" />

</head>

<body>

    <div id="wrapper">

        <%-- Navigation --%>
        <jsp:include page="/include/navbar.jsp" flush="true"/>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Clientes</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>

            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Clientes Cadastrados
                        </div>
                        <div class="col-sm-6">
                        </div>
                        <div class="col-sm-6" style="text-align: right;">
                            <a href="<c:url value="/cliente/new"/>"><i class="fa fa-file-o fa-2x"></i></a>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">

                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Nome</th>
                                            <th>Endereço</th>
                                            <th>Telefone</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${requestScope.clientes}" var="cliente">
                                            <tr>
                                                <td>${cliente.id}</td>
                                                <td>${cliente.nome}</td>
                                                <td>${cliente.endereco}</td>
                                                <td>${cliente.telefone}</td>
                                                <td><a href="<c:url value="/cliente/${cliente.id}"/>" class="btn btn-default"><i class="fa fa-pencil fw"></i></a></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>

            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <jsp:include page="/include/importJS.jsp"/>

</body>

</html>


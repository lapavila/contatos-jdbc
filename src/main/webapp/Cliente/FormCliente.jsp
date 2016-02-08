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

        <title>Contatos</title>

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
                    <div class="col-lg-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Cadastro de Cliente
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <form method="POST" action="<c:url value="/cliente"/>">
                                            <input type="hidden" name="id" value="${cliente.id}">
                                            <div class="form-group">
                                                <label>Nome</label>
                                                <input class="form-control" placeholder="Nome" name="nome" value="${cliente.nome}">
                                            </div>
                                            <div class="form-group">
                                                <label>Endereço</label>
                                                <input class="form-control" placeholder="Endereço" name="endereco" value="${cliente.endereco}">
                                            </div>
                                            <div class="form-group">
                                                <label>Telefone</label>
                                                <input class="form-control" placeholder="Telefone" name="telefone" value="${cliente.telefone}">
                                            </div>
                                            <button type="submit" class="btn btn-default btn-primary">Salvar</button>
                                        </form>
                                    </div>
                                    <!-- /.table-responsive -->

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


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- jQuery -->
<script src="<c:url value="/lib/vendor/jquery/dist/jquery.min.js"/>"></script>

<!-- Bootstrap Core JavaScript -->
<script src="<c:url value="/lib/vendor/bootstrap/dist/js/bootstrap.min.js" />"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="<c:url value="/lib/vendor/metisMenu/dist/metisMenu.min.js" />"></script>

<!-- Custom Theme JavaScript -->
<script src="<c:url value="/lib/dist/js/sb-admin-2.js" />"></script>

<script src="<c:url value="/lib/js/tween-min.js" />" type="text/javascript"></script>
<script src="<c:url value="/lib/js/steelseries-min.js" />vendor/" type="text/javascript"></script>
<script src="<c:url value="/lib/js/jquery.sf-flash.min.js" />" type="text/javascript"></script>

<% if (true) {%>
<script src="<c:url value="/lib/app/asterisk-chat.js" />" type="text/javascript"></script>
<script>
    init('<%=request.getContextPath()%>');
</script>
<%}%>

<div class="sf-flash">This is a flash message.</div>
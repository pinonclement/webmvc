<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
		<head>
        	<meta charset="utf-8">
			<jsp:directive.page contentType="text/html;charset=UTF-8" />
			 <spring:url value="/uploadsrt" var="uploadsrt" />
		</head>


<% if ( session.getAttribute("video")!=null){ %>

<p>${video.nom}</p> 
<p>Durée : <c:out value="${video.durée }"/></p>
<p>Arc :  <c:out value="${video.arc}"/></p>


 <video width="640" height="267"  controls="controls" autobuffer="true">
        <source src="/static/video/アグレッシブ烈子（王様のブランチ） episode 49（318放送）.mp4" type="video/mp4">
    </video>
<%} %>













</html>
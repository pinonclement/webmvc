<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
         <jsp:directive.page contentType="text/html;charset=UTF-8" />
        
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">
       
      	<spring:url value="/static/css/bootstrap.css" var="bootstrapCss" />
		<spring:url value="/static/css/bootstrap-responsive.css" var="responsiveCss" />
		 
		<spring:url value="/static/css/custom-styles.css" var="customstylecss" />
		
		<spring:url value="/static/css/font-awesome.css" var="font1css" />
		<spring:url value="/static/css/font-awesome-ie7.css" var="font2css" />

		<spring:url value="/connexion" var="connexion" />
        <spring:url value="/inscription" var="inscription" />
        <spring:url value="/" var="index" />
        <spring:url value="/mdpoublie" var="mdpoublie" />
			<spring:url value="/deco" var="deco" />
			<spring:url value="/favoris" var="favori" />
		<link href="${bootstrapCss}" rel="stylesheet" />
		<link href="${responsiveCss}" rel="stylesheet" />
		
        <link rel="stylesheet" href="${customstylecss}">
        <link rel="stylesheet" href="${font1css}">
        
        <link rel="stylesheet" href="${font2css}">
       
       
       <spring:url value="/static/js/modernizr-2.6.2-respond-1.1.0.min.js" var="modernjs" />
 
		<script src="${modernjs}"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login page</title>
		<link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
		<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
		<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
	
    </head>
    <body>
	   
        <!--[if lt IE 7]>
            <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
        <![endif]-->

        <!-- This code is taken from http://twitter.github.com/bootstrap/examples/hero.html -->
               <spring:url value="/static/picture/gudetama.png" var="gudetamapng" />
				<center><img  src="${gudetamapng}" alt="gudetama" align="middle" style="width:482px;height:169px;"></center>
            <div class="container">

                <div class="row-fluid">
                
                    <div class="span8 offset2">
                        <div class="site-header">
                            <div class="logo">
                                <h1>GUDETAMA FRANCE</h1>
                            </div>
                            <div class="menu">
                                <div class="navbar">
                                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                                        <i class="fw-icon-th-list"></i>
                                    </a>
                                    <div class="nav-collapse collapse">
                                        <ul class="nav">
                                            <li><a href="${index}">ACCUEIL</a></li>                                       
										
											  
											  <li ><a href= "${inscription}">s'enregistrer</a></li>
                                        </ul>
                                    </div><!--/.nav-collapse -->
                                </div>
                                <div class="mini-menu">
            <label>
          <select class="selectnav">
            <option value="#" selected="">Home</option>
            <option value="#">About</option>
            <option value="#">→ Another action</option>
            <option value="#">→ Something else here</option>
            <option value="#">→ Another action</option>
            <option value="#">→ Something else here</option>
            <option value="#">Services</option>
            <option value="#">Work</option>
            <option value="#">Contact</option>
          </select>
          </label>
          </div>

                            </div>
                        </div>

                        <div class="banner-shadow">
                        <div class="banner">
						<div class="contact-info">
                        <h1>CONNECTEZ-VOUS</h1>
						</div>

                           <div class=contact-info id="myCarousel">
								<c:url var="loginUrl" value="/login"/>
						<form action="${loginUrl}" method="post" class="form-horizontal">
											<c:if test="${param.error != null}">
								<div class="alert alert-danger">
									<p>Pseudo et mot de passe invalide</p>
								</div>
							</c:if>
							<c:if test="${param.logout != null}">
								<div class="alert alert-success">
									<p>Login fait avec succès</p>
								</div>
							</c:if>
							<div class=contact-info">
								<label class="input-group-addon" for="username"><i class="fa fa-user"></i></label> 
								<input type="zdaz" class="form-control" id="username" name="ssoId" placeholder="Pseudo..." required>
							</div>
							<div class="ignore-css">
								<label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label> 
								<input type="password" class="form-control" id="password" name="password" placeholder="Pass..." required>
							</div>
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
                               <div class=contact-info">
								<input type="submit"
									class="btn btn-primary btn-sm" value="Log in">
							</div>
                            </div>
                        </div>






<script>
$('#myCarousel').carousel({
    interval: 1800
});
</script>

    </body>
</html>

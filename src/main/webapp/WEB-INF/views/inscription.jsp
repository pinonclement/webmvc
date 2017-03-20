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
                                            <li ><a href="${index}">ACCUEIL</a></li>

                                            <li><a href="${connexion}">Se connecter</a></li>
                                            <li class="active"><a href="#">S'enregistrer</a></li>
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
						 <div class="featured-heading">
                            <div class="row-fluid">
                                    <h1>Créer votre compte</h1>
                                    <section class="webdesigntuts-workshop">                                    
				<form:form method="POST" modelAttribute="user" class="form-horizontal">
				<label class="col-md-3 control-lable" for="email">Email</label>
				<form:input type="text" path="email" id="email" class="form-control input-sm"/>
				<label class="col-md-3 control-lable" for="pseudo">Pseudo</label>
				<form:input type="text" path="ssoId" id="pseudo" class="form-control input-sm"/>
				<label class="col-md-3 control-lable" for="motdepasse">Mot de passe</label>
				<form:input type="text" path="password" id="motdepasse" class="form-control input-sm"/>
				<label class="col-md-3 control-lable" for="userProfiles">Roles</label>
				<form:select path="userProfiles" items="${roles}" multiple="true" itemValue="id" itemLabel="type" class="form-control input-sm"/>
				<input type="submit" value="Register" class="btn btn-primary btn-sm"> or <a href="<c:url value='/hello' />">Cancel</a>
				</form:form>
				</div></div>
</section>
                                   




<spring:url value="/static/js/jquery-1.9.1.js" var="jqueryjs" />
 
<script src="${jqueryjs}"></script>

<spring:url value="/static/js/bootstrap.js" var="bootstrapjs" />
 
<script src="${bootstrapjs}"></script>

<script>
$('#myCarousel').carousel({
    interval: 1800
});
</script>

    </body>
</html>
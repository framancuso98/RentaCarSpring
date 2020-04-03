<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
 	 <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
      integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
      crossorigin="anonymous"
    />
</head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${utente.ruolo.equalsIgnoreCase('admin')}">
	<div class = "container-fluid">
<nav class="navbar navbar-expand-lg navbar-light bg-light" >
  <a class="navbar-brand" href="<c:url value='/login/home' />" >Rental Car</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="<c:url value='/auto/all' />">Lista auto<span class="sr-only">(current)</span></a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="<c:url value='/utente/all' />"> Lista Utenti</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<c:url value='/auto/addAuto' />">Aggiungi Auto</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<c:url value='/utente/addUtente' />">Aggiungi Utente</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<c:url value='/prenotazione/all' />">Lista Prenotazione</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0" action="logout" method="POST">
      <button class="btn btn-dark" type="submit">Logout</button>
    </form>
  </div>
</nav>
<div class="container">
<h1>LISTA AUTO</h1>
<table class = "table table-striped ">
<thead class="thead-dark">
	<tr>
		<th>Costruttore</th>
		<th>Modello</th>
		 <th>Targa</th>
		 <th>Anno Immatricolazione </th>
		 <th>Categoria</th>
		 <th></th>
		 <th></th>
	</tr>
	</thead>
        <tbody>
		<c:forEach items="${listaAuto}" var="auto">
		<tr>
			<td>
				${auto.costruttore}
			</td>
			<td>
				${auto.modello}
			</td>
			<td>
				${auto.targa}
			</td>
			<td>
				${auto.anno}
			</td>
			<td> 
 				${auto.categoria.descrizione}
			</td> 
 			<td> 
 				<form action="all" method="POST"> 
					<input type="submit" class="btn btn-outline-danger"  value="Elimina"> 
 					<input type="hidden" name="id" value="${auto.id}"> 
 				</form>
			</td> 
			<td> 
 				<form action="updateAuto" method="GET">
					<input type="submit" class="btn btn-outline-warning"  value="Modifica"> 
 					<input type="hidden" name="id" value="${auto.id}">
 				</form>
			</td> 
 		</tr> 
		</c:forEach>
		</tbody>
</table>
</div>
</div>
	</c:when>
	<c:otherwise>
	<div class = "container-fluid">
<nav class="navbar navbar-expand-lg navbar-light bg-light" >
  <a class="navbar-brand" href="<c:url value='/login/home' />">Rental Car</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="<c:url value='/auto/all' />">Lista auto<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<c:url value='/utente/profilo' />">Profilo</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0" action="" method="POST">
      <button class="btn btn-dark" type="submit">Logout</button>
    </form>
  </div>
</nav>
<div class="container">
<h1>LISTA AUTO</h1>
<table class = "table table-striped ">
<thead class="thead-dark">
	<tr>
		<th>Costruttore</th>
		<th>Modello</th>
		 <th>Targa</th>
		 <th>Anno Immatricolazione </th>
		 <th>Categoria</th>
		 <th></th>
		 <th></th>
	</tr>
	</thead>
        <tbody>
		<c:forEach items="${listaAuto}" var="auto">
		<tr>
			<td>
				${auto.costruttore}
			</td>
			<td>
				${auto.modello}
			</td>
			<td>
				${auto.targa}
			</td>
			<td>
				${auto.anno}
			</td>
			<td> 
 				${auto.categoria.descrizione}
			</td> 
			
 			<td> 
				<form  action="addPrenotazione" method="POST"> 
					<input type="submit" class="btn btn-outline-danger"  value="Prenota"> 
 					<input type="hidden" name="idAuto" value="${auto.id}">
 					<input type="hidden" name="idUtente" value="${utente.id}"> 
 				</form>
 				</td>
			
 		</tr> 
		</c:forEach>
		</tbody>
</table>
</div>
</div>
	</c:otherwise>
</c:choose>

</body>
</html>
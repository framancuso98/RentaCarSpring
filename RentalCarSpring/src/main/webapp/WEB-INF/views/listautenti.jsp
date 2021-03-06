<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
        <a class="nav-link" href="<c:url value='/utente/all' />">Lista Utenti</a>
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
    <form class="form-inline my-2 my-lg-0" action="" method="POST">
      <button class="btn btn-dark" type="submit">Logout</button>
    </form>
  </div>
</nav>
<h1>LISTA UTENTI</h1>
<table class = "table table-striped ">
<thead class="thead-dark">
	<tr>
		<th>Nome</th>
		<th>Cognome</th>
		 <th>Data di Nascita</th>
		 <th>Elimina Utente </th>
	</tr>
	</thead>
        <tbody>
		<c:forEach items="${lista}" var="utente">
		<tr>
			<td>
				${utente.nome}
			</td>
			<td>
				${utente.cognome}
			</td>
			<td>
				${utente.data_nascita}
			</td>
 			<td> 
 				<form action="all" method="POST"> 
					<input type="submit" class="btn btn-outline-danger"  value="Elimina"> 
 					<input type="hidden" name="id" value="${utente.id}"> 
 				</form>
				</td> 
 		</tr> 
		</c:forEach>
		</tbody>
</table>
</div>


</body>
</html>
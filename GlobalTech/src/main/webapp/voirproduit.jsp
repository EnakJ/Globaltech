<%@page import="metier.entite.Produit" %>
<%
	Produit produit = (Produit) request.getAttribute("produit");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="/css/style.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
	 crossorigin="anonymous">
	 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<title>Voir Produit <%=produit.getDesignation() %></title>
</head>
<body>
<%@include file="header.jsp" %>
	<div class="container col col-10 bg-light shadow-sm border border-primary p-0 rounded">
		<div class="panel panel-primary">
			<div class="panel-heading bg-primary p-1 text-white text-center"><h4 class="text-warning">Voir produit : <%= produit.getDesignation()%></h4></div>
			
				<div class="panel-body">
				<div class="form-control text-warning p-0">
					<img class="ing-fluid" alt="" src="/images/image_hp.png">
				</div>
				<div class="form-control text-warning p-0">
					<label class="col-form-label mx-5 col-3"><h3>ID :</h3></label>
					<label class="col-form-label col-6"><h3><%= produit.getId() %></h3></label>
				</div>
				<div class="form-control text-warning p-0">
					<label class="col-form-label mx-5 col-3"><h3>DESIGNATION :</h3></label>
					<label class="col-form-label col-6"><h3><%= produit.getDesignation() %></h3></label>
				</div>
				<div class="form-control text-warning p-0">
					<label class="col-form-label mx-5 col-3"><h3>PRIX :</h3></label>
					<label class="col-form-label col-6"><h3><%= produit.getPrix()+"  " %> XOF</h3></label>
				</div>
				<div class="form-control text-warning p-0">
					<label class="col-form-label mx-5 col-3"><h3>QUANTITÉ :</h3></label>
					<label class="col-form-label col-6"><h3><%= produit.getQuantite() %></h3></label>
				</div>
				<div class="text-center">
					<button class="btn btn-outline-info my-1 mx-3"><a href="Editer.do?id=<%=produit.getId()%>"><i class="bi bi-pencil-fill text-primary mx-1"></i></a></button>
					<button class="btn btn-outline-primary my-1 mx-3" ><a href="Supprimer.do?id=<%=produit.getId()%>"><i class="bi bi-archive-fill text-danger mx-1"></i></a></button>
				</div>
			</div>
		</div>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" 
	crossorigin="anonymous"></script>
</body>
</html>
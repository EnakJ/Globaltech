<%@page import="web.ProduitModel" import="metier.entite.Produit"%>
<%
	String designation = null;
	int quantite = 0;
	double prix = 0;
	boolean added = false;
	if (request.getAttribute("designation") != null)
	{
		designation =(String) request.getAttribute("designation");
		quantite =(int) request.getAttribute("quantite");
		prix = (double) request.getAttribute("prix");
		added = true;
	} 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Produits</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
	 			crossorigin="anonymous">
	 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body>
<%@include file="header.jsp"%>
	<% if (added){
		%>
		<div class="col col-10 offset-1 alert alert-success alert-dismissible fade show text-center" role="alert">
			<strong>Désignation</strong> : <%=designation %>  |  <strong>Prix</strong>: <%=prix %>  |  <strong>Quantite</strong>  : <%=quantite %> a été ajouté avec succes !
			<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		</div>
	<% }%>
	<div class="container col col-5 bg-light shadow-sm border border-primary p-0 rounded">
		<div class="panel panel-primary">
			<div class="panel-heading bg-primary p-1 text-white text-center"><h6>Ajouter un produit</h6></div>
			<div class="panel-body p-3">
				<form class="form-control" action="Saisie.do" method="POST">
					<div class="input-group my-4">
						<label class="col-form-label mx-3" for="designation">Désignation :</label>
						<input class="form-control" id="designation" type="text" name="designation" placeholder="Désignation" required/>
					</div>
					<div class="input-group my-4">
						<label class="col-form-label mx-3" for="quantite">Quantité :</label>
						<input class="form-control"  type="text" name="quantite" placeholder="Quantité du produit en sctock" required/>
					</div>
					<div class="input-group my-4">
						<label class="col-form-label mx-3" for="prix">Prix :</label>
						<input class="form-control" type="text" name="prix" placeholder="Prix unitaire du produit" required/>
						<span class="input-group-text">XOF</span>
					</div>
					<div class="input-group my-4">
						<label class="col-form-label mx-3" for="image">Photo :</label>
						<input class="form-control"  type="file" name="image" placeholder="telecharger une image..."/>
					</div>
					<div class="text-center">
						<button class="btn btn-primary col-2 shadow-sm" type="submit">Ajouter</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" 
	crossorigin="anonymous"></script>
</body>
</html>
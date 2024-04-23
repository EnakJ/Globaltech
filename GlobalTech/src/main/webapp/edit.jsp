<%@page import="web.ProduitModel" import="metier.entite.Produit"%>
<%
	Produit produit = (Produit) request.getAttribute("produit");
	boolean edited = false;
	if (request.getAttribute("edited") != null)
	edited = (boolean) request.getAttribute("edited");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Produit</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
	 			crossorigin="anonymous">
	 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body>
<%@include file="header.jsp"%>
	<% if (edited){
		%>
		<div class="alert alert-success alert-dismissible fade show text-center" role="alert">
			<strong>Désignation</strong> :  <%=produit.getDesignation() %> |  <strong>Prix</strong>: <%= produit.getPrix() %>  |  <strong>Quantite</strong>  :  <%=produit.getQuantite() %> a été <mark>modifié</mark> avec succes !
			<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		</div>
	<% }%>
	<div class="container col col-5 bg-light shadow-sm border border-primary p-0 rounded">
		<div class="panel panel-primary">
			<div class="panel-heading bg-primary p-1 text-white text-center"><h6>Modifier produit</h6></div>
			<div class="panel-body p-3">
				<form class="form-control" action="Modifier.do" method="POST">
				<input class="form-control" type="hidden" name="id" value="<%=produit.getId() %>" required/>
					<div class="input-group my-4">
						<label class="col-form-label mx-3" for="designation">Désignation :</label>
						<input class="form-control" id="designation" type="text" name="designation" placeholder="Désignation" value="<%=produit.getDesignation() %>" required/>
					</div>
					<div class="input-group my-4">
						<label class="col-form-label mx-3" for="quantite">Quantité :</label>
						<input class="form-control"  type="text" name="quantite" placeholder="Quantité du produit en sctock" value="<%=produit.getQuantite() %>" required/>
					</div>
					<div class="input-group my-4">
						<label class="col-form-label mx-3" for="prix">Prix :</label>
						<input class="form-control" type="text" name="prix" placeholder="Prix unitaire du produit" value="<%=produit.getPrix() %>" required/>
						<span class="input-group-text">XOF</span>
					</div>
					<div class="input-group my-4">
						<label class="col-form-label mx-3" for="image">Photo :</label>
						<input class="form-control"  type="file" name="image" placeholder="telecharger une image..."/>
					</div>
					<div class="text-center">
						<button class="btn btn-primary col-2 shadow-sm" type="submit">Modifier</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" 
	crossorigin="anonymous"></script>
</body>
</html>
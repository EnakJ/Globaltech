<%@page import="web.ProduitModel" import="metier.entite.Produit"%>
<%
	ProduitModel produitmodel;
	Produit p;
	String message = "";
	String mc ="";
	boolean delete = false;
	p = (Produit) request.getAttribute("produit");
	if (request.getAttribute("delete") != null){
	if (((String)request.getAttribute("delete")).equals("true")){delete = true;}
	}
	if (request.getAttribute("model") != null)
	{
		produitmodel =(ProduitModel) request.getAttribute("model");
		mc = produitmodel.getMoClef();
	} else{
		produitmodel = new ProduitModel();
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
<%if (delete){
	%>
	<div class="col col-10 offset-1 alert alert-info alert-dismissible fade show text-center" role="alert">
		<strong>Désignation</strong> : <%=p.getDesignation() %>  |  <strong>Prix</strong>:  <%= p.getPrix() %> |  <strong>Quantite</strong> <%= p.getQuantite() %> :  a été supprimé avec succes !
		<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
	</div>
<%} %>
	<div class="container col col-8 bg-light shadow-sm border border-primary p-0 rounded">
		<div class="panel panel-primary">
			<div class="panel-heading bg-primary p-1 text-white text-center"><h6>Rechercher un produit</h6></div>
			<div class="panel-body p-3">
				<form class="rows-1" action="chercher.do" methode="GET" role="search">
					<label class="form-label mx-1 fs-6">Rechercher par mot clé :</label>
					<input class="form-control my-2" name="mocle" placeholder="mot-clé ..." value="<%=produitmodel.getMoClef() %>"/>
					<button type="submit" class="col-2 btn btn-primary my-3">Chercher</button>
				</form>
				<table class="table table-primary shadow-sm table-striped">
					<thead>
						<tr>
							<th>#</th><th>ID</th><th>Désignation</th><th>Quantité</th><th>Prix (CFA)</th><th>Action</th>
						</tr>
					</thead>
					<tbody>
						<% 
							int i = 0;
							if (produitmodel.getMoClef() == "" || produitmodel.getListProduits().isEmpty())
							{
								message = "Aucun produit selectionné !";
							} else
							for (Produit produit: produitmodel.getListProduits())
							{%>
							<tr>
								<td><%= ++i  %></td><td><%=produit.getId()%></td><td><%=produit.getDesignation()%></td><td><%=produit.getQuantite()%></td><td><%=produit.getPrix()%>
								<td>
								<a href="Editer.do?id=<%=produit.getId()%>&moCle=<%=produitmodel.getMoClef()%>"><i class="bi bi-pencil-fill text-primary mx-1"></i></a>
								<a href="View.do?id=<%=produit.getId()%>&moCle=<%=produitmodel.getMoClef()%>"><i class="bi bi-eye-fill text-success mx-1"></i></a>
								<a onClick="return confirm('Etes-vous sur de vouloir supprimer ?')" href="Supprimer.do?id=<%=produit.getId()%>&moCle=<%=produitmodel.getMoClef()%>"><i class="bi bi-archive-fill text-danger mx-1"></i></a>
								</td>
							</tr>
							<%} %>
					</tbody>
				</table>
				<p style="color:red"><%=message %></p>
			</div>
		</div>
	</div>
	
	<script src="/javascript/produits.js" type="text/javascript"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" 
	crossorigin="anonymous"></script>
</body>
</html>
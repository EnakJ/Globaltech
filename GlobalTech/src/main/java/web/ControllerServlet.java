package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dao.ProduitDaoImpl;
import metier.entite.Produit;

@WebServlet(name="cs", urlPatterns = {"*.do"})

public class ControllerServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		if (path.equals("/index.do"))
		{
			request.getRequestDispatcher("produits.jsp").forward(request, response);
		}
		else
			if (path.equals("/chercher.do"))
			{
				String montCle = request.getParameter("mocle");
				ProduitModel produitModel = new ProduitModel();
				produitModel.setMoClef(montCle);
				ProduitDaoImpl produitdaoimpl = new ProduitDaoImpl();
				produitModel.setListProduits(produitdaoimpl.getProduitsParMC("%"+montCle+"%"));
				request.setAttribute("model", produitModel);
				
				request.getRequestDispatcher("produits.jsp").forward(request, response);
			} else
				if (path.equals("/AjouterProduit.do"))
				{
					request.getRequestDispatcher("ajouter.jsp").forward(request, response);
				}
			else
				if (path.equals("/Editer.do"))
				{
					int id =Integer.parseInt(request.getParameter("id"));
					String mot =(String) request.getParameter("moCle");
					
					ProduitDaoImpl produitdaoimpl = new ProduitDaoImpl();
					Produit produit = produitdaoimpl.getProduitParID(id);
					request.setAttribute("produit", produit);
					
					request.getRequestDispatcher("edit.jsp").forward(request, response);
					
				}
				else
					if (path.equals("/Supprimer.do"))
					{
						String delete = "true";
						int id =Integer.parseInt(request.getParameter("id"));
						String mot =(String) request.getParameter("moCle");
						ProduitModel produitModel = new ProduitModel();
						ProduitDaoImpl produitdaoimpl = new ProduitDaoImpl();
						Produit produit = produitdaoimpl.getProduitParID(id);
						produitdaoimpl.getProduitParID(id);
						produitdaoimpl.deleteProduit(new ProduitDaoImpl().getProduitParID(id));
						produitModel.setListProduits(produitdaoimpl.getProduitsParMC("%"+mot+"%"));
						request.setAttribute("model", produitModel);
						request.setAttribute("produit", produit);
						request.setAttribute("delete", delete);
						
						request.getRequestDispatcher("produits.jsp").forward(request, response);
						
					}
					else
						if (path.equals("/View.do"))
						{
							int id =Integer.parseInt(request.getParameter("id"));
							String mot =(String) request.getParameter("moCle");
							ProduitDaoImpl produitdaoimpl = new ProduitDaoImpl();
							Produit produit = produitdaoimpl.getProduitParID(id);
							
							request.setAttribute("produit", produit);
							
							request.getRequestDispatcher("voirproduit.jsp").forward(request, response);
							
						}
						else
				{
						request.getRequestDispatcher("NotFoundPage.jsp").forward(request, response);
				}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		ProduitDaoImpl produitdaoimpl = new ProduitDaoImpl();
		
		if (path.equals("/Saisie.do"))
		{
			String designation = request.getParameter("designation");
			int quantite =Integer.parseInt(request.getParameter("quantite"));
			double prix = Double.parseDouble(request.getParameter("prix"));
			
			request.setAttribute("designation", designation);
			request.setAttribute("quantite", quantite);
			request.setAttribute("prix", prix);
			
			produitdaoimpl.save(new Produit(designation, prix, quantite));
			
			request.getRequestDispatcher("ajouter.jsp").forward(request, response);
		}
		else
			if (path.equals("/Modifier.do"))
			{
				Produit produit = new Produit();
				produit.setId(Integer.parseInt(request.getParameter("id")));
				produit.setDesignation(request.getParameter("designation"));
				produit.setQuantite(Integer.parseInt(request.getParameter("quantite")));
				produit.setPrix(Double.parseDouble(request.getParameter("prix")));
				
				request.setAttribute("produit", produitdaoimpl.updateProduit(produit));
				request.setAttribute("edited", true);
				
				request.getRequestDispatcher("edit.jsp").forward(request, response);
			}
	}
}

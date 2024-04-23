package dao;

import java.util.ArrayList;
import java.util.List;

import metier.entite.Produit;

public class TestDao {

	public static void main(String[] args) {
		ProduitDaoImpl produitdaoimpl = new ProduitDaoImpl();

		/* Teste methode save()
		Produit p1 = produitdaoimpl.save(new Produit("Dell Inspiron", 550000.0, 25));
		Produit p2 = produitdaoimpl.save(new Produit("Dell Precision", 650000.0, 10));
		Produit p3 = produitdaoimpl.save(new Produit("Dell Latitude Rugged", 850000.0, 5));
		Produit p4 = produitdaoimpl.save(new Produit("Macbook pro 16\"", 900000.0, 8));
		Produit p5 = produitdaoimpl.save(new Produit("Macbook pro 14\"", 900000.0, 18));
		Produit p6 = produitdaoimpl.save(new Produit("Macbook Air", 1200000.0, 8));
		Produit p7 = produitdaoimpl.save(new Produit("Macbook pro M1 2021", 1400000.0, 5));
		Produit p8 = produitdaoimpl.save(new Produit("Macbook pro M2 2022", 1450000.0, 3));
		Produit p9 = produitdaoimpl.save(new Produit("HP Probook", 350000.0, 9));
		Produit p10 = produitdaoimpl.save(new Produit("HP Elitebook", 450000.0, 14));
		Produit p11 = produitdaoimpl.save(new Produit("HP Gamer Victus", 850000.0, 5));
		Produit p12 = produitdaoimpl.save(new Produit("HP Pavillon 15", 550000.0, 5));
		Produit p13 = produitdaoimpl.save(new Produit("ASUS Vivobook 15", 250000.0, 9));
		Produit p14 = produitdaoimpl.save(new Produit("ASUS Vivobook 16", 350000.0, 8));
		Produit p15 = produitdaoimpl.save(new Produit("LENOVO Ultrathin 15", 350000.0, 12));
		Produit p16 = produitdaoimpl.save(new Produit("LENOVO IP 3", 750000.0, 2));
		Produit p17 = produitdaoimpl.save(new Produit("LENOVO GAMING 3", 850000.0, 5));
		Produit p18 = produitdaoimpl.save(new Produit("LENOVO ThinkPad L460", 350000.0, 14));
		Produit p19 = produitdaoimpl.save(new Produit("ACER Aspire", 300000.0, 19));
		Produit p20 = produitdaoimpl.save(new Produit("ACER Chromebook", 400000.0, 9));
		Produit p21 = produitdaoimpl.save(new Produit("Macbook Air M2", 1250000.0, 2));
		*/
//		System.out.println(p1.toString());
//		System.out.println(p2.toString());
//		System.out.println(p3.toString());
//		System.out.println(p4.toString());
		
		/* Teste de la methode getProduits()
		List<Produit> listProduits = new ArrayList();
		listProduits = produitdaoimpl.getProduits();
		if (listProduits.isEmpty())
		{
			System.out.println("Aucun produit trouvé !!!");
		}
		else
		{
			System.out.println("Les produits trouvés :");
		for (Produit produit: listProduits)
		{
			System.out.println("\nID\t: " +produit.getId()
			+"\nDesignation :"+produit.getDesignation()
			+"\nPrix\t:"+produit.getPrix()
			+"\nQuantité :" +produit.getQuantite());
		}
		}
		*/
		
		/* Test de updateProduit() 	*/
		Produit produit = produitdaoimpl.getProduitParID(29);
		System.out.println("AVANT MODIFICATION :");
		System.out.println(produit.toString());
		produit.setDesignation("THOMSON NEO20");
		produitdaoimpl.updateProduit(produit);
		System.out.println("APRES MODIFICATION :");
		System.out.println(produitdaoimpl.getProduitParID(produit.getId()).toString());
	
		
		/* Test methode deleteProduit()
		Produit p = produitdaoimpl.getProduitParID(3);
		System.out.println(produitdaoimpl.deleteProduit(p).toString()+ "\ndeleted successfully !");
		*/
	}

}

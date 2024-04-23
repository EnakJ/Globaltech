package dao;

import java.util.List;

import metier.entite.Produit;

public interface IProduitDao {

	public Produit save(Produit p);
	public List<Produit> getProduitsParMC(String mc);
	public List<Produit> getProduits();
	public Produit getProduitParID(int id);
	public Produit updateProduit(Produit p);
	public Produit deleteProduit(Produit p);
}
 
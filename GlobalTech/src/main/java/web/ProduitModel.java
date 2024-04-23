package web;

import java.util.ArrayList;
import java.util.List;

import metier.entite.Produit;

public class ProduitModel {

	private String moClef = "";
	List<Produit> listProduits = new ArrayList<Produit>();
	
	
	public String getMoClef() {
		return moClef;
	}
	public void setMoClef(String moClef) {
		this.moClef = moClef;
	}
	public List<Produit> getListProduits() {
		return listProduits;
	}
	public void setListProduits(List<Produit> listProduits) {
		this.listProduits = listProduits;
	}
}

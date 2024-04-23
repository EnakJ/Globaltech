package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entite.Produit;

public class ProduitDaoImpl implements IProduitDao {

	@Override
	public Produit save(Produit p) {
		try {
			PreparedStatement ps = SingletonConnection.getConnection().prepareStatement
					("INSERT INTO PRODUIT (DESIGNATION, QUANTITE, PRIX) VALUE (?, ?, ?)");
			ps.setString(1, p.getDesignation());
			ps.setInt(2, p.getQuantite());
			ps.setDouble(3, p.getPrix());
			ps.executeUpdate();
			ps.close();
			
			PreparedStatement ps2 = SingletonConnection.getConnection().prepareStatement
					("SELECT MAX(ID) AS MAXID FROM PRODUIT");
			ResultSet rs = ps2.executeQuery();
			if(rs.next()) {
				p.setId(rs.getInt("MAXID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return p;
	}

	@Override
	public List<Produit> getProduitsParMC(String mc) {
		List <Produit> produits = new ArrayList();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM PRODUIT WHERE DESIGNATION LIKE ?");
			ps.setString(1, mc);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Produit prod = new Produit();
				prod.setId(rs.getInt("ID"));
				prod.setDesignation(rs.getString("DESIGNATION"));
				prod.setQuantite(rs.getInt("QUANTITE"));
				prod.setPrix(rs.getDouble("PRIX"));
				
				produits.add(prod);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return produits;
	}

	@Override
	public List<Produit> getProduits() {
		List <Produit> produits = new ArrayList();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM PRODUIT");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Produit prod = new Produit();
				prod.setId(rs.getInt("ID"));
				prod.setDesignation(rs.getString("DESIGNATION"));
				prod.setQuantite(rs.getInt("QUANTITE"));
				prod.setPrix(rs.getDouble("PRIX"));
				
				produits.add(prod);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produits;
	}

	@Override
	public Produit getProduitParID(int id) {
		Connection connection = SingletonConnection.getConnection();
		Produit produit = new Produit();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement
					("SELECT * FROM PRODUIT WHERE ID=?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				produit.setId(rs.getInt("ID"));
				produit.setDesignation(rs.getString("DESIGNATION"));
				produit.setQuantite(rs.getInt("QUANTITE"));
				produit.setPrix(rs.getDouble("PRIX"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produit;
	}

	@Override
	public Produit updateProduit(Produit p) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("UPDATE PRODUIT SET DESIGNATION = ?, QUANTITE = ?, PRIX = ? WHERE ID=?");
			ps.setString(1, p.getDesignation());
			ps.setInt(2, p.getQuantite());
			ps.setDouble(3, p.getPrix());
			ps.setInt(4, p.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public Produit deleteProduit(Produit p) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("DELETE FROM PRODUIT WHERE ID=?");
			ps.setInt(1, p.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

}

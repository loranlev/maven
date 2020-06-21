package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.config.JDBCConfiguration;
import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO {
	public ArrayList<Ville> getInfoVille() {
		Ville ville = null;
		ArrayList<Ville> villes = new ArrayList<Ville>();
		Connection con = JDBCConfiguration.getConnexionBDD();

		String requete = "SELECT * FROM ville_france";

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(requete);
			while (rs.next()) {
				ville = new Ville();
				ville.setCodeComune(rs.getString(1));
				ville.setCodePostal(rs.getString(3));
				ville.setNomCommune(rs.getString(2));
				ville.setLibelle(rs.getString(4));
				ville.setLigne(rs.getString(5));
				ville.setLatitude(rs.getString(6));
				ville.setLongitude(rs.getString(7));

				villes.add(ville);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return villes;
	}

	@Override
	public void setVille(Ville ville) {

		try {
			Connection con = JDBCConfiguration.getConnexionBDD();
			Statement stmt = con.createStatement();
			stmt.executeUpdate(
					"Insert into ville_france(Code_commune_INSEE,Nom_commune,Libelle_acheminement,Ligne_5,Latitude,Code_postal,Longitude)"
							+ " values(" + ville.getCodeCommune() + ",'" + ville.getNomCommune() + "','"
							+ ville.getLibelle() + "','" + ville.getLigne() + "'," + ville.getLatitude() + ","
							+ ville.getCodePostal() + "," + ville.getLongitude() + ")");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Ville getNCVille(String nomCommune) {
		Ville ville = new Ville();
		Connection con = JDBCConfiguration.getConnexionBDD();

		String requete = "SELECT * FROM ville_france where Nom_commune=" +nomCommune;

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(requete);
			while (rs.next()) {
				ville.setCodeComune(rs.getString(1));
				ville.setCodePostal(rs.getString(3));
				ville.setNomCommune(rs.getString(2));
				ville.setLibelle(rs.getString(4));
				ville.setLigne(rs.getString(5));
				ville.setLatitude(rs.getString(6));
				ville.setLongitude(rs.getString(7));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ville;
	}
	
	@Override
	public Ville getCCVille(String codeCommune) {
		Ville ville = new Ville();
		Connection con = JDBCConfiguration.getConnexionBDD();

		String requete = "SELECT * FROM ville_france where Code_commune_INSEE=" +codeCommune;

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(requete);
			while (rs.next()) {
				ville.setCodeComune(rs.getString(1));
				ville.setCodePostal(rs.getString(3));
				ville.setNomCommune(rs.getString(2));
				ville.setLibelle(rs.getString(4));
				ville.setLigne(rs.getString(5));
				ville.setLatitude(rs.getString(6));
				ville.setLongitude(rs.getString(7));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ville;
	}
	
	public boolean modifierVille(Ville ville) {
		boolean resultat;
		
		try {
			Connection con = JDBCConfiguration.getConnexionBDD();
			Statement stmt = con.createStatement();
			stmt.executeUpdate(
					"UPDATE ville_france SET Code_postal='"+ville.getCodePostal()+"',Nom_commune='"+ville.getNomCommune()+"',Libelle_acheminement='"+ville.getLibelle()+
					"',Code_commune_INSEE='"+ville.getCodeCommune()+"',Ligne_5='"+ville.getLigne()+"',Longitude='"+ville.getLongitude()+"',Latitude='"+ville.getLatitude()+
					"' WHERE Code_commune_INSEE='"+ville.getCodeCommune()+"'");
			
			resultat = true;
		} catch (SQLException e) {
			e.printStackTrace();
			resultat=false;
			return resultat;
		}
		return resultat;
	}
	
	public boolean supprimerVille(String codeCommune) {
		boolean resultat;
		
		try {
			Connection con = JDBCConfiguration.getConnexionBDD();
			Statement stmt = con.createStatement();
			stmt.executeUpdate(
					"DELETE FROM ville_france WHERE Code_commune_INSEE="+codeCommune);
			
			resultat = true;
		} catch (SQLException e) {
			e.printStackTrace();
			resultat=false;
			return resultat;
		}
		return resultat;
	}

}

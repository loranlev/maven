package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.config.JDBCConfiguration;
import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO{
	
	public ArrayList<Ville> getInfoVille() {
		
		ArrayList<Ville> listeville=new ArrayList<Ville>();
		
		Connection con = JDBCConfiguration.getConnection();
		ResultSet resultat = null;
		String requete="SELECT * FROM ville_france";
		
		try {
			Statement stat = con.createStatement();
			resultat = stat.executeQuery(requete);
			
			while(resultat.next()) {
				Ville ville = new Ville();
				ville.setCodePostal(resultat.getString("Code_postal"));
				ville.setCodeComune(resultat.getString("Code_commune_INSEE"));
				ville.setNomCommune(resultat.getString("Nom_commune"));
				ville.setLibelle(resultat.getString("Libelle_acheminement"));
				ville.setLigne(resultat.getString("Ligne_5"));
				ville.setLongitude(resultat.getString("Latitude"));
				ville.setLatitude(resultat.getString("Longitude"));
				listeville.add(ville);
			}
			
		}catch(SQLException e) {
			
		}
		
		return listeville;
	}
	
	
	public void ajouterVille(String codePostal, String codeCommune, String nomCommune, String libelle, String ligne, String longitude, String latitude) {
					
			Connection con = JDBCConfiguration.getConnection();
			int resultat = 0;
			String requete="INSERT INTO ville_france VALUES ("+codePostal+","+codeCommune+","+nomCommune+","+libelle+","+ligne+","+longitude+","+latitude+")";
			
			try {
				Statement stat = con.createStatement();
				resultat = stat.executeUpdate(requete);
				
				stat.close();
				con.close();
				
			}catch(SQLException e) {
				
			}
			
	}

}

package com.blo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.Ville;

@Service
public class VilleBloImpl implements VilleBLO{
	
	@Autowired
	private VilleDAO villeDao;
	
	public ArrayList<Ville> getInfoVille() {
		ArrayList<Ville> listeville;
		
		listeville=villeDao.getInfoVille();
		return listeville;
	}
	
	public void ajouterVille(String codePostal, String codeCommune, String nomCommune, String libelle, String ligne, String longitude, String latitude) {
		
		villeDao.ajouterVille( codePostal,  codeCommune,  nomCommune,  libelle,  ligne,  longitude,  latitude);
	}

}

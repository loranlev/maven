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
	
	public void creerVille(Ville ville) {
		villeDao.setVille(ville);
	}
	
	public Ville getNCVille(String nomCommune) {
		Ville villeNC;
		villeNC=villeDao.getNCVille(nomCommune);
		
		return villeNC;
	}

	public Ville getCCVille(String codeCommune) {
		Ville villeCC;
		villeCC=villeDao.getCCVille(codeCommune);
		
		return villeCC;
	}
	
	public boolean modifierVille(Ville ville) {
		boolean resultat;
		
		resultat=villeDao.modifierVille(ville);
		return resultat;
	}
	
	public boolean supprimerVille(String codeCommune) {
		boolean resultat;
		
		resultat=villeDao.supprimerVille(codeCommune);
		return resultat;
	}

}

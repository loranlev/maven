package com.dao;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleDAO {

	public ArrayList<Ville> getInfoVille();
	
	public void setVille(Ville ville);
	
	public Ville getNCVille(String nomCommune);
	
	public Ville getCCVille(String codeCommune);
	
	public boolean modifierVille(Ville ville);
	
	public boolean supprimerVille(String codeCommune);

	
}

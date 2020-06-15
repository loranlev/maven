package com.blo;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleBLO {

	public ArrayList<Ville> getInfoVille();

	public void creerVille(Ville ville);
	
	public Ville getNCVille(String nomCommune);
	
	public Ville getCCVille(String codeCommune);
	
	public boolean modifierVille(Ville ville);
	
	public boolean supprimerVille(String codeCommune);
}

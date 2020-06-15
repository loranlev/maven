package com.controller;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;
import com.fasterxml.jackson.databind.util.JSONPObject;

//import com.blo.VilleBLO;

@RestController
//@RequestMapping("/path")
class VilleController {

	@Autowired
	VilleBLO villeService;

	// Methode GET
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> appelGet(@RequestParam(required = false, value = "codePostal") String monParam)
			throws ClassNotFoundException, SQLException {
		System.out.println("Appel GET info");
		System.out.println("param = " + monParam);
		ArrayList<Ville> ville = villeService.getInfoVille();
		return ville;
	}

	// Methode POST
	@RequestMapping(value = "/villeADD", method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<Ville> appelPost(@RequestBody Ville ville)
			throws ClassNotFoundException, SQLException {
		System.out.println("Appel POST");
		villeService.creerVille(ville);
		ArrayList<Ville> ville1 =null;
		return ville1;
	}
	

	// Methode GET
	@RequestMapping(value = "/villeNC", method = RequestMethod.GET)
	@ResponseBody
	public Ville appelGetNC(@RequestParam(required = true, value = "nomCommune") String nomCommune)
			throws ClassNotFoundException, SQLException {
		System.out.println("Appel GET NC");
		System.out.println("param = " + nomCommune);
		Ville villeNC = villeService.getNCVille(nomCommune);
		return villeNC;
	}
	
	// Methode GET
	@RequestMapping(value = "/villeCC", method = RequestMethod.GET)
	@ResponseBody
	public Ville appelGetCC(@RequestParam(required = true, value = "codeCommune") String codeCommune)
			throws ClassNotFoundException, SQLException {
		System.out.println("Appel GET CC");
		System.out.println("param = " + codeCommune);
		Ville villeCC = villeService.getCCVille(codeCommune);
		return villeCC;
	}

	
	// Methode PUT
	@RequestMapping(value = "/villePUT", method = RequestMethod.PUT)
	@ResponseBody
	public boolean appelUpdate(@RequestBody Ville ville, @RequestParam(required = true, value = "codeCommune") String codeCommune)
			throws ClassNotFoundException, SQLException {
		System.out.println("Appel PUT");
		System.out.println("param = " + codeCommune);
		boolean resultat = villeService.modifierVille(ville);
		return resultat;
	}
		
		
		// Methode PUT
	@RequestMapping(value = "/villeDELETE", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean appelDelete(@RequestParam(required = true, value = "codeCommune") String codeCommune)
			throws ClassNotFoundException, SQLException {
		System.out.println("Appel DELETE");
		System.out.println("param = " + codeCommune);
		boolean resultat = villeService.supprimerVille(codeCommune);
		return resultat;
	}	

}

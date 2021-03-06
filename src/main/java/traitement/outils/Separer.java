package traitement.outils;

import java.util.ArrayList;
import traitement.entity.Additif;
import traitement.entity.Allergene;
import traitement.entity.Categorie;
import traitement.entity.Ingredient;
import traitement.entity.Marque;
import traitement.entity.Produit;


/**
 * @author helvin
 * Separe une ligne et insere les morceaux dans un produit pour le créer.
 */

public class Separer {
	
	public static Produit Separateur(String chaine) {

		String[] chaines = chaine.split("\\|");

		String categorie = chaines[0];
		String marque = chaines[1];
		String nom = chaines[2];
		String grade = chaines[3];
		ArrayList<Ingredient> ingredients = Recette.SepIng(chaines[4]);
		double energie = Nutriment.extraire(chaines, 5);
		double graisse = Nutriment.extraire(chaines, 6);
		double sucre = Nutriment.extraire(chaines, 7);
		double fibre = Nutriment.extraire(chaines, 8);
		double proteine = Nutriment.extraire(chaines, 9);
		double sel = Nutriment.extraire(chaines, 10);
		double vitA = Nutriment.extraire(chaines, 11);
		double vitD = Nutriment.extraire(chaines, 12);
		double vitE = Nutriment.extraire(chaines, 13);
		double vitK = Nutriment.extraire(chaines, 14);
		double vitC = Nutriment.extraire(chaines, 15);
		double vitB1 = Nutriment.extraire(chaines, 16);
		double vitB2 = Nutriment.extraire(chaines, 17);
		double vitPp = Nutriment.extraire(chaines, 18);
		double vitB6 = Nutriment.extraire(chaines, 19);
		double vitB9 = Nutriment.extraire(chaines, 20);
		double vitB12 = Nutriment.extraire(chaines, 21);
		double ca = Nutriment.extraire(chaines, 22);
		double mg = Nutriment.extraire(chaines, 23);
		double iron = Nutriment.extraire(chaines, 24);
		double fer = Nutriment.extraire(chaines, 25);
		double betaCaro = Nutriment.extraire(chaines, 26);
		double huilePalme = chaines.length >= 28 ? Nutriment.extraire(chaines, 27) : 0.0;
		ArrayList<Allergene> allergenes = chaines.length >= 29 ? Recette.SepAllergene(chaines[28]) : null;
		ArrayList<Additif> additifs = chaines.length >= 30 ? Recette.SepAdditif(chaines[29]) : null;

		Produit prod = new Produit(new Categorie(categorie), new Marque(marque), nom, grade, ingredients, allergenes,
				additifs, energie, graisse, sucre, fibre, proteine, sel, vitA, vitD, vitE, vitK, vitC, vitB1, vitB2,
				vitPp, vitB6, vitB9, vitB12, ca, mg, iron, fer, betaCaro, huilePalme);
		return prod;
	}
}

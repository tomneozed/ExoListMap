import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Carte 
{
	CouleurEnum couleur;
	ValeurEnum valeur;
	
	public Carte()
	{
		
	}
	
	
	public Carte(CouleurEnum c, ValeurEnum v)
	{
		this.couleur = c;
		this.valeur = v;
	}
	
	public void setCouleur(CouleurEnum c)
	{
		this.couleur = c;
	}
	
	public void setValeur(ValeurEnum v)
	{
		this.valeur = v;
	}
	
	public CouleurEnum getCouleur()
	{
		return this.couleur;
	}
	
	public ValeurEnum getValeur()
	{
		return this.valeur;
	}
	
	public void description()
	{
		System.out.println(this.getValeur() + " de " + this.getCouleur());
	}
	
	public static List paquetComplet()
	{
		ArrayList paquet = new ArrayList();
		
		for(CouleurEnum c : CouleurEnum.values())
		{
			for(ValeurEnum v : ValeurEnum.values())
			{
				paquet.add(new Carte(c,v));
				//System.out.println("Couleur : " + c + "  valeur : " + v);
			}
		}
		return paquet;
	}
	
	public HashMap distribution(List paquet)
	{
		HashMap<String , List<Carte>> hm = new HashMap<String, List<Carte>>();
		
		ArrayList cartesDistribuees = new ArrayList();
		
		ArrayList j1 = new ArrayList();
		ArrayList j2 = new ArrayList();
		ArrayList j3 = new ArrayList();
		ArrayList j4 = new ArrayList();
		
		Random hasard = new Random();
		
		int i = 0, j = 0, a = 0;
		for(int k = 0; k < paquet.size(); k++)
		{
			do
			{
				a = nombreAleatoire(0, 51, hasard);
			}while(cartesDistribuees.contains(a) == true);
			
			System.out.println("k : "+ k + " a : " + a);
			switch(i)
			{
			case 0 :
				j1.add(j, paquet.get(a));
				break;
			case 1 :
				j2.add(j, paquet.get(a));
				break;
			case 2 :
				j3.add(j, paquet.get(a));
				break;
			case 3 :
				j4.add(j, paquet.get(a));
				break;
				
			}
			i++;
			if(i == 4)
			{
				i = 0;
				j++;
			}
		}
		hm.put("Joueur 1", j1);
		hm.put("Joueur 2", j2);
		hm.put("Joueur 3", j3);
		hm.put("Joueur 4", j4);
		
		return hm;
	}
	
	public void mainJoueur(int joueur, HashMap hm)
	{
		System.out.println("\nMain du joueur " + (joueur) + " :");
		for(int l = 0; l < ((List) hm.get("Joueur 1")).size(); l++)
		{
			((Carte) ((List) hm.get("Joueur " + (joueur))).get(l)).description();
		}
	
	}
	
	public void partie()
	{
		Carte c = new Carte();
		ArrayList a = new ArrayList();
		HashMap d = new HashMap();
		
		a = (ArrayList) c.paquetComplet();
		
		d = c.distribution(a);
		
		c.mainJoueur(1, d);
		c.mainJoueur(2, d);
		c.mainJoueur(3, d);
		c.mainJoueur(4, d);
	}
	
	/********************************************************
	 * Retourne un nombre al�atoire entre min et max		*
	 * @param min											*	
	 * @param max											*
	 * @param hasard										*
	 * @return nombreHasard									*
	 *******************************************************/
	public int nombreAleatoire(int min, int max, Random hasard)
	{
		if(min > max)
			throw new IllegalArgumentException("Min > Max");
		
		long range = (long)max - (long)min +1;
		long fraction = (long)(range * hasard.nextDouble());
		int nombreHasard = (int)(fraction + min);
		
		return nombreHasard;
		
	}
	
	public void rangerCartesJoueur(int joueur, HashMap hm)
	{
		int temp;
		
		for(int l = 0; l < ((List) hm.get("Joueur 1")).size(); l++)
		{
			for(int j = l+1; j < ((List) hm.get("Joueur 1")).size(); j++)
			{
				if(((Carte) ((List) hm.get("Joueur " + (joueur))).get(l)) > ((Carte) ((List) hm.get("Joueur " + (joueur))).get(j)))
			}
			((Carte) ((List) hm.get("Joueur " + (joueur))).get(l));
		}
		
	}
	
	
	
	
	
	
}

interface IFilePriorite
{
	//Ajouter un noeud ayant une certaine valeur
	void Ajouter(int noeud, int valeur);
	
	//retourne le noeud de plus petite valeur
	int SupprimerMin();
	
	//Reduit la valeur associe au noeud
	void Decroitre(int noeud, int valeur);
	
	boolean EstVide();
	
	void Vider();
}
import java.util.Iterator;
import java.util.ArrayList;

// Cet objet represente un chemin dans le graphe
public class Chemin
{
	ArrayList<Integer> chemin = new ArrayList<Integer>();
	double cout;

	public Chemin()
	{

	}

	public void Ajouter(int n)
	{
		chemin.add(n);
	}

	public void SetCout(double c){cout = c;}
	public double GetCout(){return cout;}
	public ArrayList<Integer> GetNodes(){return chemin;}

	public String toString()
	{
		String ch = "Chemin Cout" + cout + " noeuds:";
		for(int i=0;i<chemin.size();i++)
			ch = ch + chemin.get(i) + "-";
		return ch;
	}
}

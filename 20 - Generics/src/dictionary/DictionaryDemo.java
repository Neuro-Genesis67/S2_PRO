package dictionary;

public class DictionaryDemo {
	
	public static void main(String[] args) {
		GenericDictionary<Integer, String> dic = new GenericDictionary<>();
		System.out.println("er den tom?");
		System.out.println(dic.isEmpty());
		dic.put(1, "Abemad gennem historien");
		dic.put(2, "Stærke knuder til gæve sømænd");
		dic.put(3, "tovflætning 101");
		dic.put(4, "Tag springet, trampolin for begyndere");
		dic.put(5, "Brystfødning for dyr");
		System.out.println("objekter indsat i ordbog");
		System.out.println(dic);
		System.out.println("hiv key 2 ud");
		System.out.println(dic.get(2));
		System.out.println("fjern key 2");
		System.out.println(dic.remove(2));
		System.out.println("objekter i ordbog (igen)");
		System.out.println(dic);
		System.out.println("liste størrelse");
		System.out.println(dic.size());
		
		
	}
}

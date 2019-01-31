package opgave_1;

public class Besvarelser_3 {

	// Template Method.
	//

	// Hvad opnår vi ved at bruge Template Method?
	//
	// - Kodegenbrug
	// - Minimering a duplicate code
	// - Mulighed for at gøre brug a hooks (subklasserne har mulighed for
	// individuelt at implementere en ekstra metode)

	// Hvilke dele består Template Method af?
	//
	// - En superklasse som indeholder en metode som kører nogle andre metoder.
	// - Subklasser som override nogle af de metoder som køres fra superklassens
	// metode.
	// - En hook, som er en metode som kun køres, hvis en subklasse har defineret en
	// handling for denne, ellers gør den ikke noget som udgangspunkt.
	// Hooken giver subklasserne mulighed for at anvende en ekstra metode, som ikke
	// er del af det sæt af standard metoder der køres i subklassen.
	// -
	//

	// Forklar med egne ord ”Hollywood princippet”
	//
	// - You don't call us, we call you.
	// -Objektet kalder sine metoder, og i disse metoder bliver der kaldt

}

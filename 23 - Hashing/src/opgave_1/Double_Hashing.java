package opgave_1;

public class Double_Hashing {
	// Double hashing er når man bruger to hash-metoder til at finde én key.
	// Hash 1: tal Mod 10
	// Hash 2: 4 - (tal mod 4)

	// ---------------A----B----C----D----E----F----G
	// Aktuelle tal: 4371 1323 6173 4199 4344 9679 1989
	//
	// | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |
	// | n | n | n | n | n | n | n | n | n | n | n |
	// | n | n | n | n | n | n | n | n | n | n | n |
	// | n | n | n | n | n | n | n | n | n | n | n |
	// | n | n | n | n | n | n | n | n | n | n | n |
	// | n | n | n | n | n | n | n | n | n | n | n |
	// | n | n | n | n | n | n | n | n | n | n | n |

	// Kan godt blive til en uendelig løkke.
	// Man kunne evt. sige at hvis man rammer det index man først fandt en kollision
	// på, skal der bruges en ny hashing metode.
}

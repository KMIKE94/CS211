public class cryptography {
	public static long p, g, gmodp; // in public key cryptography there are
												// three numbers which relate to p, g, gmodp(g % p)
	public static long c1, c2; // c1 and c2 relate to the reply message 

	public static void main(String[] args) {
		publicKeys(24852977, 2744, 8414508);
		reply(15268076, 743675);
		message();

	}

	public static void publicKeys(long P, long G, long GmodP) { // each number must be a long because numbers get big
																						// for more secure messages
		p = P;
		g = G;
		gmodp = GmodP;
	}

	public static void reply(long C1, long C2) {
		c1 = C1;
		c2 = C2;
	}

	public static void message() {
		long result = 0;
		long privateKey = 0;
		
		for (int x = 0; x < p; x++) {
			// the equation for finding the message is ((c1 ^ p -1 -x) % p) * c2 % p
			result = modPow(c1, p - 1 - x, p);
			result = result * c2;
			result = result % p;
			
			if (modPow(g, x, p) == gmodp) { // if ((g ^ x) % p) equals the third number in our public key then x 
															// is our private key, there are other x values that will be true but 
															// we can just take the first
				privateKey = x;
				break;
			}
		}

		System.out.println("Message number := " + result);
		System.out.println("Private Key := " + privateKey);
	}

	public static long modPow(long number, long power, long modulus) { // Java doesn't modulus big powers well so 
																				// this recursive method is used to break the sum into smaller pieces 
		if (power == 0)
			return 1;
		else if (power % 2 == 0) { // if power is even
		
			long halfpower = modPow(number, power / 2, modulus); // half the power
			return modMult(halfpower, halfpower, modulus); // then multiply the half power by itself then modulus it
			
		} else {
		
			long halfpower = modPow(number, power / 2, modulus); // half the power
			long firstbit = modMult(halfpower, halfpower, modulus); // multiply the half power by itself and modulus it again
			return modMult(firstbit, number, modulus); // then multiply this by the number and modulus it
			
		}

	}

	public static long modMult(long first, long second, long modulus) {
		if (second == 0)
			return 0;
		else if (second % 2 == 0) { // if even
		
			long half = modMult(first, second / 2, modulus); // half the power
			return (half + half) % modulus; 
			
		} else {
		
			long half = modMult(first, second / 2, modulus);
			return (half + half + first) % modulus;
		
		}
	}
}

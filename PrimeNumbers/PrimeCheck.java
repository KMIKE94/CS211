public class PrimeCheck {
	
	public static void primeCheck(int range) { 
		boolean[] myArray = new boolean[(int) (2*range*Math.log(range))];
		int[] numArray = new int[(int) (2*range*Math.log(range))];
		for (int fill = 0; fill < numArray.length; fill++) {
			numArray[fill] = 1 + fill;
		}
		long start = System.currentTimeMillis();
		
		for (int j = 2; j < 24; j++) {
			for (int i = 0; i < numArray.length; i++) {
				if (numArray[i] % j == 0) {
					numArray[i] = 0;
					myArray[i] = true;
				}
				
				numArray[1] = 2;
				numArray[2] = 3;
				numArray[4] = 5;
				numArray[6] = 7;
				numArray[10] = 11;
				numArray[12] = 13;
			}
		}
		int[] checkPrime = new int[(int) (2*range*Math.log(range))];
		int index=0;
		for (int count = 0; count < numArray.length; count++) {
			
			if(numArray[count] > 0 && numArray[count]!=1){
				checkPrime[index] = numArray[count];
				index = index + 1;
			}
			
		}
		System.out.println("The " + range + "th prime is " + checkPrime[range-1]);
		
		long elapsed = System.currentTimeMillis() - start;
		System.out.println("The answer took " + elapsed + " milliseconds to compute" );
	}

}

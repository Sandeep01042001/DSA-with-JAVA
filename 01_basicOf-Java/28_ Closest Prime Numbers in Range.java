class Solution {
    public int[] closestPrimes(int left, int right) {
        if (left > right) return new int[]{-1, -1};
        boolean [] isPrime = new boolean[right+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i = 2; i*i <= right; i++){
            if(isPrime[i]){
                for(int j = 2 * i; j<=right; j+=i){
                isPrime[j] =  false;
                }
            }
        }
        ArrayList<Integer> primeNumber = new ArrayList<>();
        for(int i = left; i<=right; i++){
            if(isPrime[i] == true){
                primeNumber.add(i);
            }
        }
        System.out.println(primeNumber.size());
        
        if(primeNumber.size() < 2){
            return new int []{-1, -1};
        }
        int minDiff = Integer.MAX_VALUE;
        int num1 = -1;
        int num2 = -1;
        for (int i = 1; i < primeNumber.size(); i++) {
            int diff = primeNumber.get(i) - primeNumber.get(i-1);
            if (diff < minDiff) {
                minDiff = diff;
                num1 = primeNumber.get(i-1);
                num2 = primeNumber.get(i);
            }
        }
        
        return new int []{num1, num2};
    }
}

class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        final int MOD = 1_000_000_007;
        long[] people = new long[n + 1]; 
        people[1] = 1; 

        long sharing = 0;
        for (int day = 2; day <= n; day++) {
            if (day - delay >= 1) sharing = (sharing + people[day - delay]) % MOD;
            if (day - forget >= 1) sharing = (sharing - people[day - forget] + MOD) % MOD;

            people[day] = sharing;
        }

        long result = 0;
        for (int day = n - forget + 1; day <= n; day++) {
            if (day >= 1) result = (result + people[day]) % MOD;
        }

        return (int) result;
    }
}

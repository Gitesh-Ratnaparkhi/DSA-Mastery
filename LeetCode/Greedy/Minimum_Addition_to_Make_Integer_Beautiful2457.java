// 2457. Minimum Addition to Make Integer Beautiful
// Link -> https://leetcode.com/problems/minimum-addition-to-make-integer-beautiful/description/?envType=daily-question&envId=2026-07-26
// Approach -> Greedy [Medium]
// Code ->
class Solution {
    public long makeIntegerBeautiful(long n, int target) {

        long sum = 0;
        long temp = n;
        while(temp > 0){
            sum+= temp%10;
            temp /= 10;
        }
        if(sum <= target) return 0;

        long carry = 0;
        temp = n;
        StringBuilder sb = new StringBuilder();
        while(temp > 0){
            long val = temp%10 + carry;
            long rem = 10 - val;
            carry = rem == 10 ? 0 : 1;
            if(sum - val + carry <= target){
                if(rem == 10) sb.append((char) ('0'));
                else sb.append((char) (rem + '0'));
                break;
            }else{
                sum = sum - val + carry;
            }
            if(rem == 10) sb.append((char) ('0'));
            else sb.append((char) (rem + '0'));
            temp /= 10;
        }
        long ans = Long.parseLong(sb.reverse().toString());
        return ans;
    }
}

// Time Complexity: O(log₁₀ n)
// Space Complexity: O(log₁₀ n)
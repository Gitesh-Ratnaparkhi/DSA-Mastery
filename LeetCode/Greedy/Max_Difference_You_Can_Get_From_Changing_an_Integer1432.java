// 1432. Max Difference You Can Get From Changing an Integer
// Link -> https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer/
// Approach -> Greedy [MEDIUM]
// Code ->
class Solution {
    public int maxDiff(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int prev = -1;
        boolean flag = false;
        for(int i=0; i<arr.length; i++){
            if(arr[i] != '9' && !flag){
                prev = arr[i];
                arr[i] = '9';
                flag = true;
            }else if(flag && arr[i] == prev){
                arr[i] = '9';
            }
        }
        int max = Integer.parseInt(new String(arr));
        arr = String.valueOf(num).toCharArray();

        prev = -1;
        flag = false;
        boolean gflag = arr[0] == '1' ? true : false;
        for(int i=0; i<arr.length; i++){
            if(!gflag){
                if(i == 0 && arr[0]-'0' > 1 && !flag){
                    prev = arr[i];
                    arr[i] = '1';
                    flag = true;
                }else if(flag && arr[i] == prev){
                    arr[i] = '1';
                }
            }
            if(gflag){     
                if(arr[i]- '0' > 1 && !flag){
                    prev = arr[i];
                    arr[i] = '0';
                    flag = true;
                }
                else if(flag && arr[i] == prev) arr[i] = '0'; 
            }
        }
        int min = Integer.parseInt(new String(arr));
        return max - min;

    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(n)


// Same Approach -> One pass Solution
// Code ->
class Solution {
    public int maxDiff(int num) {
        String s = String.valueOf(num);
        char[] maxArr = s.toCharArray();
        char[] minArr = s.toCharArray();

        char maxTarget = ' ';
        boolean maxFound = false;

        char minTarget = ' ';
        char minReplacement = ' ';
        boolean minFound = false;

        for (int i = 0; i < maxArr.length; i++) {
            if (!maxFound && maxArr[i] != '9') {
                maxTarget = maxArr[i];
                maxArr[i] = '9';
                maxFound = true;
            } else if (maxFound && maxArr[i] == maxTarget) {
                maxArr[i] = '9';
            }

            if (!minFound) {
                if (i == 0 && minArr[i] > '1') {
                    minTarget = minArr[i];
                    minReplacement = '1';
                    minArr[i] = '1';
                    minFound = true;
                } else if (i > 0 && minArr[i] > '1' && minArr[i] != minArr[0]) {
                    minTarget = minArr[i];
                    minReplacement = '0';
                    minArr[i] = '0';
                    minFound = true;
                }
            } else if (minArr[i] == minTarget) {
                minArr[i] = minReplacement;
            }
        }

        int max = Integer.parseInt(new String(maxArr));
        int min = Integer.parseInt(new String(minArr));
        return max - min;
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(n)
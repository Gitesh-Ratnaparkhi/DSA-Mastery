// Insert Interval
// Link -> https://www.naukri.com/code360/problems/insert-interval_1102297?leftPanelTabValue=PROBLEM
// Level -> Easy
// Topic -> Array
// Code ->

public class Insert_Interval 
{
    public static ArrayList<ArrayList<Integer>> insertInterval(ArrayList<ArrayList<Integer>> intervals, ArrayList<Integer> newInterval)
    {
        int i = 0;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int n = intervals.size();
        while (i < n){
            if (intervals.get(i).get(1) < newInterval.get(0)) ans.add(intervals.get(i));   
            else if (intervals.get(i).get(0) > newInterval.get(1)) break;
            else {
                newInterval.set(0,Math.min(newInterval.get(0), intervals.get(i).get(0)));
                newInterval.set(1,Math.max(newInterval.get(1), intervals.get(i).get(1)));
            }
            i++;
        }
        ans.add(newInterval);
        while (i < n){
            ans.add(intervals.get(i));
            i++;
        }
        return ans;
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(n)
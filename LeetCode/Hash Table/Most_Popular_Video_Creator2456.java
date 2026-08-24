// 2456. Most Popular Video Creator

// Link -> https://leetcode.com/problems/most-popular-video-creator/description/?envType=daily-question&envId=2026-07-26

// Approach -> Hash Table
// Simple store the views and video_id bases on their creater. 

// Code ->
class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        int n = ids.length;
        Map<String, List<List<Object>>> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!mp.containsKey(creators[i])) {
                List<List<Object>> list = new ArrayList<>();
                List<Object> row = new ArrayList<>();

                row.add(ids[i]);
                row.add(views[i]);

                list.add(row);
                mp.put(creators[i], list);
            } else {
                List<List<Object>> list = mp.get(creators[i]);

                List<Object> row = new ArrayList<>();
                row.add(ids[i]);
                row.add(views[i]);

                list.add(row);
            }
        }

        long mostp = 0;

        for (Map.Entry<String, List<List<Object>>> e : mp.entrySet()) {

            List<List<Object>> li = e.getValue();

            long totalViews = 0;

            for (List<Object> row : li) {
                int videoViews = (Integer) row.get(1);
                totalViews += videoViews;
            }

            mostp = Math.max(mostp, totalViews);
        }

        List<List<String>> ans = new ArrayList<>();

        for (Map.Entry<String, List<List<Object>>> e : mp.entrySet()) {

            String creator = e.getKey();
            List<List<Object>> li = e.getValue();

            long totalViews = 0;
            int maxViews = -1;
            String bestId = "";

            for (List<Object> row : li) {

                String videoId = (String) row.get(0);
                int videoViews = (Integer) row.get(1);

                totalViews += videoViews;

                if (videoViews > maxViews ||
                        (videoViews == maxViews &&
                                videoId.compareTo(bestId) < 0)) {

                    maxViews = videoViews;
                    bestId = videoId;
                }
            }

            if (totalViews == mostp) {
                List<String> result = new ArrayList<>();
                result.add(creator);
                result.add(bestId);

                ans.add(result);
            }
        }

        return ans;
    }
}

// Time Complexity -> O(n)
// Space Complexity -> O(n)
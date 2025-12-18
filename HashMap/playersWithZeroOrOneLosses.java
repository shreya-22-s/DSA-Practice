class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {

        HashSet<Integer> winners = new HashSet<>();
        HashMap<Integer, Integer> loss = new HashMap<>();

        for (int[] m : matches) {
            winners.add(m[0]);
            loss.put(m[1], loss.getOrDefault(m[1], 0) + 1);
        }

        List<Integer> zeroLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();

        for (int w : winners) {
            if (!loss.containsKey(w)) {
                zeroLoss.add(w);
            }
        }

        for (int player : loss.keySet()) {
            if (loss.get(player) == 1) {
                oneLoss.add(player);
            }
        }

        Collections.sort(zeroLoss);
        Collections.sort(oneLoss);

        List<List<Integer>> result = new ArrayList<>();
        result.add(zeroLoss);
        result.add(oneLoss);

        return result;
    }
}

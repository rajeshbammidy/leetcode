class Solution {
    /**
     * The idea is to create adjacencyMap using the emailIds and we have to perform the DFS on it to find the
     * individual connected components.
     *
     * The adjacencyMap looks like the below:
     * {johnnybravo@mail.com=[], johnsmith@mail.com=[john_newyork@mail.com, john00@mail.com], john00@mail.com=[johnsmith@mail.com], john_newyork@mail.com=[johnsmith@mail.com], mary@mail.com=[]}
     */
    private HashMap<String, ArrayList<String>> adjacencyMap;
    private HashSet<String> visited;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        adjacencyMap = new HashMap<>();
        visited = new HashSet<>();
        for (List<String> account : accounts) {
            buildAdjacencyMap(account);
        }
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            String email = account.get(1);
            if (!visited.contains(email)) {
                dfs(email, temp);
                temp.sort(null);
                List<String> sortedList = new ArrayList<>();
                sortedList.add(name);
                sortedList.addAll(temp);
                result.add(sortedList);
                temp.clear();
            }
        }
        return result;


    }

    private void dfs(String email, List<String> temp) {
        visited.add(email);
        temp.add(email);
        for (String nextEmail : adjacencyMap.get(email)) {
            if (!visited.contains(nextEmail))
                dfs(nextEmail, temp);
        }
    }

    private void buildAdjacencyMap(List<String> account) {
        for (int i = 1; i < account.size(); i++) {
            String current = account.get(i);
            String next = (i + 1) < account.size() ? account.get(i + 1) : null;
            if (adjacencyMap.get(current) == null) {
                adjacencyMap.put(current, new ArrayList<>());
            }
            if (next != null)
                adjacencyMap.get(current).add(next);
            if (next != null && adjacencyMap.get(next) == null) {
                adjacencyMap.put(next, new ArrayList<>());
                adjacencyMap.get(next).add(current);
            } else if (adjacencyMap.get(next) != null) {
                adjacencyMap.get(next).add(current);
            }
        }
    }
}
class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if (numRows == 0) return list;
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list.add(list1);
        if (numRows == 1) return list;
        List<Integer> list2 = new ArrayList<>();
        list2.addAll(Arrays.asList(1,1));
        list.add(list2);
       
        if (numRows == 2) return list;
        for (int i = 3; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    temp.add(1);
                    continue;
                }
                int sum = list.get(i - 2).get(j - 1) + list.get(i - 2).get(j);
                temp.add(sum);
            }
            list.add(temp);
        }
        return list;
    }
}

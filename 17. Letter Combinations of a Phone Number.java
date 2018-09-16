// 使用循环而非递归

class Solution {
    String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new ArrayList<String>();

        List<String> list = new ArrayList<>();
        list.add("");

        for (char c : digits.toCharArray()) {
            if (c > '9' || c < '2')
                continue;
            List<String> temp = new ArrayList<>();
            for (String s : list)
                for (char x : dict[c - '0'].toCharArray())
                    temp.add(s + x);
            list = temp;
        }
        return list;
    }
}

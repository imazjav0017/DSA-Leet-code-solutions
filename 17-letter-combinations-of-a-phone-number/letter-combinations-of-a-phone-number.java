class Solution {

    String[] map = {
        "", "", "abc", "def",
        "ghi", "jkl", "mno",
        "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();

        if (digits.length() == 0)
            return res;

        StringBuilder path = new StringBuilder();

        backtrack(digits, 0, path, res);

        return res;
    }

    void backtrack(String digits, int index,
                   StringBuilder path, List<String> res) {

        if (index == digits.length()) {
            res.add(path.toString());
            return;
        }

        String options = map[digits.charAt(index) - '0'];

        for (char c : options.toCharArray()) {

            // CHOOSE
            path.append(c);

            // EXPLORE
            backtrack(digits, index + 1, path, res);

            // UNDO
            path.deleteCharAt(path.length() - 1);
        }
    }
}

class Solution {

    String[] below20 = {
        "", "One", "Two", "Three", "Four", "Five",
        "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen",
        "Eighteen", "Nineteen"
    };

    String[] tens = {
        "", "", "Twenty", "Thirty", "Forty",
        "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    // Converts numbers from 0 to 999
    String helper(int num) {
        if (num == 0) return "";

        if (num < 20) {
            return below20[num];
        }

        if (num < 100) {
            return (tens[num / 10] + " " +
                    helper(num % 10)).trim();
        }

        return (below20[num / 100] + " Hundred " +
                helper(num % 100)).trim();
    }

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        String[] units = {"", "Thousand", "Million", "Billion"};

        String result = "";
        int index = 0;

        while (num > 0) {
            int part = num % 1000;

            if (part != 0) {
                String words = helper(part);

                if (!units[index].isEmpty()) {
                    words += " " + units[index];
                }

                result = words + " " + result;
            }

            num /= 1000;
            index++;
        }

        return result.trim();
    }
}

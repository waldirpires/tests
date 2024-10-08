package blip;

import java.util.HashMap;
import java.util.Map;

/**
 * You are in charge of a display advertising program. Your ads are displayed on websites all over the internet.
 * You have some CSV input data that counts how many times that users have clicked on an ad on each individual domain.
 * Every line consists of a click count and a domain name, like this:
 * <p>
 * counts = [ "900,google.com",
 * "60,mail.yahoo.com",
 * "10,mobile.sports.yahoo.com",
 * "40,sports.yahoo.com",
 * "300,yahoo.com",
 * "10,stackoverflow.com",
 * "20,overflow.com",
 * "5,com.com",
 * "2,en.wikipedia.org",
 * "1,m.wikipedia.org",
 * "1,mobile.sports",
 * "1,google.co.uk"]
 * <p>
 * Write a function that takes this input as a parameter and returns a data structure containing the number of clicks that were recorded on each domain AND each subdomain under it.
 * For example, a click on "mail.yahoo.com" counts toward the totals for "mail.yahoo.com", "yahoo.com", and "com". (Subdomains are added to the left of their parent domain. So "mail" and "mail.yahoo" are not valid domains.
 * Note that "mobile.sports" appears as a separate domain near the bottom of the input.)
 * <p>
 * Sample output (in any order/format):
 * <p>
 * calculateClicksByDomain(counts) =>
 * com:                     1345
 * google.com:              900
 * stackoverflow.com:       10
 * overflow.com:            20
 * yahoo.com:               410
 * mail.yahoo.com:          60
 * mobile.sports.yahoo.com: 10
 * sports.yahoo.com:        50
 * com.com:                 5
 * org:                     3
 * wikipedia.org:           3
 * en.wikipedia.org:        2
 * m.wikipedia.org:         1
 * mobile.sports:           1
 * sports:                  1
 * uk:                      1
 * co.uk:                   1
 * google.co.uk:            1
 * <p>
 * Input
 * String[] counts = {
 * "900,google.com",
 * "60,mail.yahoo.com",
 * "10,mobile.sports.yahoo.com",
 * "40,sports.yahoo.com",
 * "300,yahoo.com",
 * "10,stackoverflow.com",
 * "20,overflow.com",
 * "5,com.com",
 * "2,en.wikipedia.org",
 * "1,m.wikipedia.org",
 * "1,mobile.sports",
 * "1,google.co.uk"
 * };
 */

public class Solution2 {

    public Map<String, Integer> calculateClicksByDomain(String[] counts) {
        // Implementation
        Map<String, Integer> clicksPerDomain = new HashMap<>();

        for (String s : counts) {
            String[] values = s.split(",");
            // retrieve the domain and click count
            int count = Integer.parseInt(values[0]);
            String domain = values[1];
            clicksPerDomain.put(domain,
                    clicksPerDomain.getOrDefault(domain, 0) + count);
            // process subdomains
            String subdomain = domain.substring(domain.indexOf(".") + 1);
            // while it contains Strings to process
            while (!subdomain.isEmpty()) {
                clicksPerDomain.put(subdomain,
                        clicksPerDomain.getOrDefault(subdomain, 0) + count);
                // validate if more iterations are needed
                if (!subdomain.contains(".")) {
                    break;
                }
                // update subdomain to the next
                subdomain = subdomain.substring(subdomain.indexOf(".") + 1);
            }
        }

        return clicksPerDomain;
    }

    public static void main(String[] args) {
        String[] counts = {
                "900,google.com",
                "60,mail.yahoo.com",
                "10,mobile.sports.yahoo.com",
                "40,sports.yahoo.com",
                "300,yahoo.com",
                "10,stackoverflow.com",
                "20,overflow.com",
                "5,com.com",
                "2,en.wikipedia.org",
                "1,m.wikipedia.org",
                "1,mobile.sports",
                "1,google.co.uk"
        };

        Solution2 e = new Solution2();
        Map<String, Integer> result = e.calculateClicksByDomain(counts);

        for (String k : result.keySet()) {
            System.out.println(k + "\t:" + result.get(k));
        }
    }
}

package easy.uniqueemailaddresses;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet(emails.length);
//        StringBuffer buff=new StringBuffer(100)
        for (String email : emails) {
            int at = email.indexOf('@');
            String domain = email.substring(at);
            int plus = email.indexOf('+');
            if (plus == -1) plus = at;
            String local = email.substring(0,plus).replace(".", "");
            uniqueEmails.add(local+domain);
//            buff.delete(0, buff.size());
        }
        return uniqueEmails.size();
    }
}

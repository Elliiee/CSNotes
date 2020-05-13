import java.util.ArrayList;
import java.util.List;

public class _93RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> addresses = new ArrayList<>();
        StringBuilder tempAddress = new StringBuilder();
        doRestore(0, tempAddress, addresses, s);
        return addresses;
    }

    private void doRestore(int k, StringBuilder tempAddress, List<String> addresses, String s){
        if (k == 4 || s.length() == 0){
            if (k == 4 && s.length() == 0){
                addresses.add(tempAddress.toString());
            }
            return;
        }
        for (int i = 0; i < s.length() && i <= 2; i++){
            if (i != 0 && s.charAt(0) == '0'){
                break;
            }
            String part = s.substring(0, i + 1);
            if (Integer.valueOf(part) <= 255){
                if (tempAddress.length() != 0){
                    part = "." + part;
                }
                tempAddress.append(part);
                doRestore(k + 1, tempAddress, addresses, s.substring(i + 1));
                tempAddress.delete(tempAddress.length() - part.length(), tempAddress.length());
            }
        }
    }
}
/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.
A valid IP address consists of exactly four integers (each integer is between 0 and 255) separated by single points.
 */

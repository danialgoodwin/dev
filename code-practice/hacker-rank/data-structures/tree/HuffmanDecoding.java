// Source: https://www.hackerrank.com/challenges/tree-huffman-decoding
public class HuffmanDecoding {

    public static String decodeHuff(Node huffRoot, String encoded) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < encoded.length();) {
            Node element = huffRoot;
            while (element.right != null) {
                boolean isGoLeft = encoded.charAt(i) == '0';
                element = isGoLeft ? element.left : element.right;
                i++;
            }
            sb.append(element.data);
        }
        return sb.toString();
    }

    public static class Node {
        int freq;
        char data;
        Node left;
        Node right;
    }

}

import java.io.*;
import java.util.Hashtable;

public class HuffmanAppl {
    public static void main(String[] args) {
        HuffmanList freqList = new HuffmanList();
        Hashtable<Character, String> hm = new Hashtable<Character, String>();
        readToLinkedList("input.txt",freqList);
        HuffmanList sortedByIncreasing = freqList.sortList();
        sortedByIncreasing.constructTree();
        sortedByIncreasing.encodeTree();
        sortedByIncreasing.createCodeTable(hm);
        compressFile("input.txt",hm);
    }


    public static void readToLinkedList(String fileName,HuffmanList freqList) {
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            int c = 0;
            while((c = br.read()) != -1)
            {
                char ch = (char) c;
                freqList.add(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void compressFile(String inputFileName, Hashtable<Character, String> hm) {
        try {
            FileReader inputStream = new FileReader(inputFileName);
            FileWriter fileWriter=new FileWriter("output.txt",true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            int c;
            while ((c = inputStream.read()) != -1) {
                char key = (char)c;
                printWriter.print(hm.get(key));
                }
            printWriter.close();

        }catch (IOException e){
            e.printStackTrace();

        }
    }
}

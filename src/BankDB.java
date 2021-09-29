import java.io.File;
import java.io.FileOutputStream;

public class BankDB {
    /**Takes record of ATM and adds it to a txt file using a loop system that looks through the file and stops when i is = to the length of then writes
     * whatever is in the variable acsessing the method in a comma delimited format
     * 
     * @param fileName 
     * @param values
     * @throws Exception
     */
    public void addRecord(BankDbFile fileName, String[] values) throws Exception {
        String line = new String();
         
        for (int i = 0; i < values.length; i++){
            line += values[i] + ",";
        }
        
        line = line.substring(0, line.length() - 1);
        line += System.lineSeparator();

        File record = new File(fileName.getFileAddress());
        
        FileOutputStream output = new FileOutputStream(record, true);
        output.write(line.getBytes());
        output.close();
    }
}
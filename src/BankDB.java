import java.io.File;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BankDB {
    //#region Public Methods
    /**Appends a file with a comma delimited line using the string values from an array.
     * 
     * @param bankDbFile The BankDbFile to update.
     * @param values The list of values to add.
     * @throws IOException
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
    
    /**Pulls the next id to use based on the last record of the file.
     * 
     * @param bankDbFile The file name to read.
     * @return The next id.
     * @throws IOException
     */
    public int getNextId(BankDbFile bankDbFile) throws IOException {
        /**Logic:
         * Use the getLastRecord private method to pull the last record, which returns all fields
         * in an array.
         * If the array is empty, then just return 0 to be used as the first id.
         * If then array is not empty, then since all files have the id in the first column,
         * just return the first column of the array.
         */
        String[] record = getLastRecord(bankDbFile);
        int nextId = 0;
        
        if(record.length != 0) {
            nextId = Integer.parseInt(record[0]) + 1;
        }
        
        return nextId;
    }
    
    /**Updates a specific field in a record in a file that matches the column id.
     * 
     * @param bankDbFile The BankDbFile to update. 
     * @param recordId The ID of the record to update.
     * @param columnIndexToUpdate The index of the column to update.
     * @param newValue The value to update field to.
     * @return true if update occurred, false if id not found.
     * @throws IOException
     */
    public boolean updateRecordField(BankDbFile bankDbFile, int recordId, int columnIndexToUpdate, String newValue) throws IOException {
        /**Logic:
         * Open the file with write access.
         * Read the file line by line into a record array.
         * For each line, if the id matches
         *      Replace the value with the new value and reconstruct the String line from the array.
         *      Use a flag to check if a value has been udpated so the rest of the checks can be skipped.
         * Add the line to a buffer - make sure to add a line separator at the end.
         * Replace all the data in the file using the buffer.
         * Close the file.
         */

        return false;
    }

    /**Pulls the first record from a db file that matches the value on a specific column.
     * 
     * @param bankDbFile The file to read.
     * @param columnIndexToMatch The index of the column to match.
     * @param matchValue The value to match in the column.
     * @return The record in a String array. If a record is not matched, an empty String array is returned.
     * @throws IOException
     */
    public String[] getRecord(BankDbFile bankDbFile, int columnIndexToMatch, String matchValue) throws IOException {
        /**Logic:
         * Open the file and loop through it.
         * For each line in the file
         *      Split the comma delimited line into a String array (hint: use the string split method)
         *      Check if the matchValue is the same as the current value in the column to match
         *      If matched, then exit the loop because only the first record match is returned.
         * Return the array.
         */
        
        return new String[0];
    }

    /**Pulls all records from a db file based on a column match.
     * 
     * @param bankDbFile the file to read.
     * @param columnIndex The index of the column to read.
     * @param matchValue The value to match to the colum.
     * @return An ArrayList of Strings with all the records matched. If no records are matched,
     * then an empty ArrayList is returned.
     * @throws IOException
     */
    public ArrayList<String[]> getRecords(BankDbFile bankDbFile, int columnIndex, String matchValue) throws IOException {
        /**Logic:
         * Open the file and loop through it.
         * For each line in the file
         *      Split the comma delimited line into a String array (hint: use the string split method)
         *      Check if the matchValue is the same as the current value in the column to match
         *      If matched, then add the array to the ArrayList.
         * Return the ArrayList.
         */        
        
        return new ArrayList<String[]>();
    }
    //#endregion


    //#region Private Methods
    /**Pulls the last line from a comma delimited file and splits it into an array.
     * 
     * @param bankDbFile The file name to read.
     * @return The comma delimited values in an String array, or an empty array if the file is empty.
     * @throws IOException
     */
    private String[] getLastRecord(BankDbFile bankDbFile) throws IOException {
        /**Logic:
         * Open the file and loop throuhg each line.
         * Once the last line is reached, split the line into an array (hint: use the string split method).
         * Return the array.
         */
        
        //loop through file to get last line.
        String currentLine;
        String lastLine = null;
        
        BufferedReader br = new BufferedReader(new FileReader((bankDbFile.getFileAddress())));

        while((currentLine = br.readLine()) != null) {
            lastLine = currentLine;
        }

        //split comma delimited line into array
        String[] record = new String[0];

        if(lastLine != null) {
            record = lastLine.split(",");
        }

        return record;
    }
    //#endregion
}
public class BankDbFile {
    
    private String _fileName;
    private String _fileAddress;
    
    public String getFileName(){
        return _fileName;
    }

    public String getFileAddress(){
        return _fileAddress;
    }

    private BankDbFile(String fileName){
        _fileName = fileName;
        _fileAddress = System.getProperty("user.dir") + "\\bankDB\\" + _fileName;
    }

    public static BankDbFile getAccount(){
        return new BankDbFile("account.txt");
    }

    public static BankDbFile getClient(){
        return new BankDbFile("client.txt");
    }

    public static BankDbFile getLedger(){
        return new BankDbFile("ledger.txt");
    }

}

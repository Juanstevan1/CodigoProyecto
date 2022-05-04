public class App {
    private int tpoints =0;
    private String name;
    private String userName;
    private String password;
    private String mail;
    private long number;
    private String code;
    public int indice;


    public App (String codigo, int tpoint, String name, String password, String mail, long number, String userName){
        this.code = codigo;
        this.tpoints = tpoint;
        this.name = name;
        this.password = password;
        this.mail = mail;
        this.number = number;
        this.userName = userName;
    }

    public int indice() {
        return indice;
    }

    public String getUserName() {
        return userName;
    }

    public String getCode() {
        return code;
    }

    public String getPassword() {
        return password;
    }

    public long getNumber() {
        return number;
    }

    public int getTpoints() {
        return tpoints;
    }

    public String getMail() {
        return mail;
    }

    public String getName() {
        return name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTpoints(int tpoints) {
        this.tpoints = tpoints;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setindice(int check) {
        indice = check;
    }
}

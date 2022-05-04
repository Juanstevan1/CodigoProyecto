public class Machine {
    private int setPoint;
    private int plastico;  //2
    private int vidrio;   //1
    private int pila;    //1
    private boolean check;

    public Machine(boolean a){
        this.check =a;
    }
    public Machine(int setPoint, int plastico, int vidrio, int pila){
        this.setPoint = setPoint;
        this.plastico = plastico;
        this.vidrio = vidrio;
        this.pila = pila;
    }

    public boolean isCheck() {
        return check;
    }

    public int getPila() {
        return pila;
    }

    public int getPlastico() {
        return plastico;
    }

    public int getSetPoint() {
        return setPoint;
    }

    public int getVidrio() {
        return vidrio;
    }

    public void setPila(int pila) {
        this.pila = pila;
    }

    public void setPlastico(int plastico) {
        this.plastico = plastico;
    }

    public void setSetPoint(int setPoint) {
        this.setPoint = setPoint;
    }

    public void setVidrio(int vidrio) {
        this.vidrio = vidrio;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}

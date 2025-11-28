public class Prueba {
    private int x;
    public Prueba(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public static void main(String[] args) {
        System.out.println("Esto es una prueba");
    }

    public void increment(){
        x++;
    }
}

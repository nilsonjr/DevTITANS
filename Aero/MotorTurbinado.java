public class MotorTurbinado extends Motor {
    public MotorTurbinado(String modelo, float potencia) {
        super(modelo, potencia);
    }

    public void ligar() {
        super.ligar();
        System.out.println("TRUMMMMMMM....");
    }

    public float getPotencia() {
        return (super.getPotencia() * 1.2f);
    }
}

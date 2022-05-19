public class Aviao {
    private String modelo;
    private String identificador;
    private boolean motor;
    private float altura;

    public Aviao(String modelo, String identificador) {
        setModelo(modelo);
        setIdentificador(identificador);
        setMotor(false);
        setAltura(0.0f);
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setMotor(boolean motor) {
        this.motor = motor;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getModelo() {
        return this.modelo;
    }

    public String getIdentificador() {
        return this.identificador;
    }

    public boolean getMotor() {
        return this.motor;
    }

    public float getAltura() {
        return this.altura;
    }

    public void ligarMotor() {
        setMotor(true);
        System.out.println("Vrummmmmmm");
    }

    public void desligarMotor() {
        setMotor(false);
    }

    public void imprimaOk() {
        System.out.println("Ok");
    }

    public void descreve() {
        System.out.printf("Modelo: %s\nIdentificador: %s\nMotor: %b\nAltura: %.2f\n",
                modelo, identificador, motor, altura);
    }

    public void imprimeEstadoMotor() {
        System.out.printf("O motor esta %s..\n", motor ? "ligado" : "desligado");
    }
}
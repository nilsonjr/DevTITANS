public class Aviao {
    private String modelo;
    private String identificador;
    private boolean motor;
    private float altura;

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

    public void imprimaOk() {
        System.out.println("Ok");
    }

    public void descreve() {
        System.out.printf("Modelo: %s\nIdentificador: %s\nMotor: %b\nAltura: %.2f\n",
                modelo, identificador, motor, altura);
    }
}
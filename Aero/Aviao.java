public class Aviao {
    private String modelo;
    private String identificador;
    private boolean motor;
    private float altura;
    private float velocidade;

    private final float INCREMENTO_DE_VELOCIDADE = 50.0f;
    private final float VELOCIDADE_ZERO = 0.0f;
    private final boolean MOTOR_LIGADO = true;
    private final boolean MOTOR_DESLIGADO = false;

    public Aviao(String modelo, String identificador) {
        setModelo(modelo);
        setIdentificador(identificador);
        setMotor(MOTOR_DESLIGADO);
        setAltura(VELOCIDADE_ZERO);
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

    private void setVelocidade(float velocidade) {
        this.velocidade = velocidade;
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

    public float getVelocidade() {
        return this.velocidade;
    }

    public void ligarMotor() {
        setMotor(MOTOR_LIGADO);
        System.out.println("Vrummmmmmm");
    }

    public void desligarMotor() {
        setMotor(MOTOR_DESLIGADO);
    }

    public void acelerar() {
        if (getMotor()) {
            setVelocidade(getVelocidade() + INCREMENTO_DE_VELOCIDADE);
            imprimeVelocidade();
        } else {
            System.out.println("ERRO: Motor desligado");
        }
    }

    public void desacelerar() {
        if (getMotor()) {
            setVelocidade(getVelocidade() - INCREMENTO_DE_VELOCIDADE);
            if (getVelocidade() < VELOCIDADE_ZERO) {
                setVelocidade(VELOCIDADE_ZERO);
            }
            imprimeVelocidade();
        } else {
            System.out.println("ERRO: Motor desligado");
        }
    }

    public void imprimaOk() {
        System.out.println("Ok");
    }

    public void descreve() {
        System.out.printf("Modelo: %s\nIdentificador: %s\nMotor: %b\nAltura: %.2f\n",
                getModelo(), getIdentificador(), getMotor(), getAltura());
    }

    public void imprimeEstadoMotor() {
        System.out.printf("O motor esta %s..\n", getMotor() ? "ligado" : "desligado");
    }

    public void imprimeVelocidade() {
        System.out.printf("Aviao a %.1f km/h\n", getVelocidade());
    }
}
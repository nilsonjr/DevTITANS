public class Motor {
    private String modelo;
    private float potencia;
    private boolean ativo;

    private final boolean MOTOR_ATIVO = true;
    private final boolean MOTOR_INATIVO = false;

    public Motor (String modelo, float potencia) {
        setModelo(modelo);
        setPotencia(potencia);
        setAtivo(MOTOR_INATIVO);
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPotencia(float potencia) {
        this.potencia = potencia;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getModelo() {
        return this.modelo;
    }

    public float getPotencia() {
        return this.potencia;
    }

    public boolean getAtivo() {
        return this.ativo;
    }

    public void ligar() {
        setAtivo(MOTOR_ATIVO);
        System.out.println("....VRUMMMM!!");
    }

    public void desligar() {
        setAtivo(MOTOR_INATIVO);
        System.out.println("mmmmm....");
    }
}
public class Motor {
    private String modelo;
    private float potencia;
    private boolean ativo;

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
    }

    public void desligar() {
    }
}
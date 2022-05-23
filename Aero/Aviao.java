import java.util.ArrayList;
import java.util.Iterator;

public class Aviao {
    private String modelo;
    private String identificador;
    private Motor motorDireito;
    private Motor motorEsquerdo;
    private float altura;
    private float velocidade;
    private boolean emVoo;
    private ArrayList<Passageiro> listaPassageiros;

    private final int MOTORES_DESLIGADOS = 0;
    private final int TAG_MOTOR_ESQUERDO = 1;
    private final int TAG_MOTOR_DIREITO = 2;
    private final int MOTORES_LIGADOS = TAG_MOTOR_DIREITO + TAG_MOTOR_ESQUERDO;
    private final float VELOCIDADE_ZERO = 0.0f;
    private final float VELOCIDADE_DE_VOO = 200.0f;
    private final boolean EM_VOO = true;
    private final boolean EM_SOLO = false;

    public Aviao(String modelo, String identificador, Motor motorEsquerdo, Motor motorDireito) {
        setModelo(modelo);
        setIdentificador(identificador);
        setMotorEsquerdo(motorEsquerdo);
        setMotorDireito(motorDireito);
        setAltura(VELOCIDADE_ZERO);
        setListaPassageiros(new ArrayList<Passageiro>());
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setMotorDireito(Motor motorDireito) {
        this.motorDireito = motorDireito;
    }

    public void setMotorEsquerdo(Motor motorEsquerdo) {
        this.motorEsquerdo = motorEsquerdo;
    }

    private void setEmVoo(boolean emVoo) {
        this.emVoo = emVoo;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    private void setVelocidade(float velocidade) {
        this.velocidade = velocidade;
    }

    private void setListaPassageiros(ArrayList<Passageiro> listaPassageiros) {
        this.listaPassageiros = listaPassageiros;
    }

    private float getPotenciaTotal() {
        return getMotorDireito().getPotenciaEfetiva() + getMotorEsquerdo().getPotenciaEfetiva();
    }

    public String getModelo() {
        return this.modelo;
    }

    public String getIdentificador() {
        return this.identificador;
    }

    public int getEstadoMotor() {
        return (getMotorDireito().getAtivoAsInt() * TAG_MOTOR_DIREITO +
                getMotorEsquerdo().getAtivoAsInt() * TAG_MOTOR_ESQUERDO);
    }

    public Motor getMotorDireito() {
        return this.motorDireito;
    }

    public Motor getMotorEsquerdo() {
        return this.motorEsquerdo;
    }

    public boolean getEmVoo() {
        return this.emVoo;
    }

    public float getAltura() {
        return this.altura;
    }

    public float getVelocidade() {
        return this.velocidade;
    }

    public ArrayList<Passageiro> getListaPassageiros() {
        return this.listaPassageiros;
    }

    public void ligarMotores() {
        getMotorDireito().ligar();
        getMotorEsquerdo().ligar();
    }

    public void desligarMotores() {
        getMotorDireito().desligar();
        getMotorEsquerdo().desligar();
    }

    public void acelerar() {
        if (getEstadoMotor() != MOTORES_DESLIGADOS) {
            setVelocidade(getVelocidade() + getPotenciaTotal());
            imprimeVelocidade();
        } else {
            System.out.println("ERRO: Motor desligado");
        }

        atualizarStatusVoo();
    }

    public void desacelerar() {
        if (getEstadoMotor() != MOTORES_DESLIGADOS) {
            setVelocidade(getVelocidade() - getPotenciaTotal());
            if (getVelocidade() < VELOCIDADE_ZERO) {
                setVelocidade(VELOCIDADE_ZERO);
            }
            imprimeVelocidade();
        } else {
            System.out.println("ERRO: Motor desligado");
        }

        atualizarStatusVoo();
    }

    public void atualizarStatusVoo() {
        if (getEmVoo() == EM_VOO) {
            if (getVelocidade() < VELOCIDADE_DE_VOO) {
                setEmVoo(EM_SOLO);
                System.out.println("Estou aterrissando...");
            } else {
                System.out.println("Estou voando...");
            }
        } else {
            if (getVelocidade() < VELOCIDADE_DE_VOO) {
                System.out.println("Estou em solo...");
            } else {
                setEmVoo(EM_VOO);
                System.out.println("Estou decolando...");
            }
        }
    }

    public void imprimaOk() {
        System.out.println("Ok");
    }

    public void descreve() {
        System.out.printf("Modelo: %s\nIdentificador: %s\nEstado do Motor: %d\nAltura: %.2f\n",
                getModelo(), getIdentificador(), getEstadoMotor(), getAltura());
    }

    public void imprimeEstadoMotor() {
        int estadoMotores = getEstadoMotor();
        switch (estadoMotores) {
            case MOTORES_LIGADOS:
                System.out.println("Os motores estão ligados...");
                break;
            case MOTORES_DESLIGADOS:
                System.out.println("Os motores estão desligados...");
                break;
            default:
                System.out.printf("Apenas o motor %s está ligado...\n",
                        estadoMotores == TAG_MOTOR_DIREITO ? "direito" : "esquerdo");
                break;
        }
    }

    public void imprimeVelocidade() {
        System.out.printf("Aviao a %.1f km/h\n", getVelocidade());
    }

    public boolean embarcarPassageiro(Passageiro passageiro) {
        if (getEmVoo() == EM_VOO) {
            System.out.println(
                    "Protocolos de segurança não permitem embarques com a aeronave em movimento.");
            return false;
        }

        return getListaPassageiros().add(passageiro);
    }

    public void desembarcarPassageiros() {
        if (getEmVoo() == EM_VOO) {
            System.out.println(
                    "Protocolos de segurança não permitem desembarques com a aeronave em movimento.");
            return;
        }

        Iterator<Passageiro> iterador = getListaPassageiros().iterator();
        Passageiro passageiro;

        while (iterador.hasNext()) {
            passageiro = iterador.next();
            System.out.printf("%s %s desembarcou da aeronave!\n",
                    passageiro.getPrimeiroNome(), passageiro.getUltimoNome());
            iterador.remove();
        }
    }

    public Passageiro buscarPassageiroPorCPF(String cpf) {
        for (Passageiro passageiro : getListaPassageiros()) {
            if (cpf.equals(passageiro.getCpf())) {
                return passageiro;
            }
        }

        return null;
    }

    public void imprimirListaDePassageiros() {
        getListaPassageiros().forEach((passageiro) -> imprimeInfoPassageiro(passageiro));
    }

    private void imprimeInfoPassageiro(Passageiro passageiro) {
        System.out.printf("Passageiro: %s %s | CPF: %s\n",
                passageiro.getPrimeiroNome(), passageiro.getUltimoNome(), passageiro.getCpf());
    }
}
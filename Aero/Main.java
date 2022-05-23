public class Main {
    public static void main(String[] args) {
        MotorTurbinado motorEsquerdo = new MotorTurbinado("Oberursel Ur.I", 50.0f);
        MotorTurbinado motorDireito = new MotorTurbinado("Le Rhône 9j", 50.0f);
        Passageiro passageiro1 = new Passageiro("Benedict", "Cumberbatch", "111.222.333-44");
        Passageiro passageiro2 = new Passageiro("Benedict", "Wong", "222.333.444-55");
        Passageiro passageiro3 = new Passageiro("Benedict", "Arnold", "333.444.555-66");
        Passageiro passageiro4 = new Passageiro("Benedict", "Allen", "444.555.666-77");
        Passageiro passageiro5 = new Passageiro("Benedict", "Samuel", "555.666.777-88");

        Aviao aviao = new Aviao("Fokker Dr.I", "Baron", motorEsquerdo, motorDireito);
    
        aviao.imprimaOk();
        aviao.descreve();

        System.out.println("Testando motoroes....");
        aviao.ligarMotores();
        aviao.imprimeEstadoMotor();
        aviao.desligarMotores();
        aviao.imprimeEstadoMotor();
        aviao.ligarMotores();
        aviao.acelerar();
        aviao.acelerar();
        aviao.desligarMotores();
        aviao.acelerar();
        aviao.ligarMotores();
        aviao.desacelerar();
        aviao.desacelerar();
        aviao.desacelerar();
        aviao.desligarMotores();
        aviao.desacelerar();

        System.out.println("Iniciando embarque de passageiros....");
        aviao.embarcarPassageiro(passageiro1);
        aviao.embarcarPassageiro(passageiro2);
        aviao.embarcarPassageiro(passageiro3);
        aviao.embarcarPassageiro(passageiro4);
        aviao.embarcarPassageiro(passageiro5);

        aviao.ligarMotores();
        for (int i = 0; i < 5; ++i) {
            aviao.acelerar();
        }

        aviao.embarcarPassageiro(passageiro1);
        System.out.println("Verificação de passageiros....");
        aviao.imprimirListaDePassageiros();
        aviao.desembarcarPassageiros();

        for (int i = 0; i < 6; ++i) {
            aviao.desacelerar();
        }

        aviao.desembarcarPassageiros();
    }
}
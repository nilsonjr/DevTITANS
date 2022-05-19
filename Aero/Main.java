public class Main {
    public static void main(String[] args) {
        Aviao aviao = new Aviao("Fokker Dr.I", "Baron");
    
        aviao.imprimaOk();
        aviao.descreve();

        aviao.ligarMotor();
        aviao.imprimeEstadoMotor();
        aviao.desligarMotor();
        aviao.imprimeEstadoMotor();

        aviao.ligarMotor();
        aviao.acelerar();
        aviao.acelerar();
        aviao.desligarMotor();
        aviao.acelerar();
        aviao.ligarMotor();
        aviao.desacelerar();
        aviao.desacelerar();
        aviao.desacelerar();
        aviao.desligarMotor();
        aviao.desacelerar();

        aviao.ligarMotor();
        for (int i = 0; i < 5; ++i) {
            aviao.acelerar();
        }
        for (int i = 0; i < 6; ++i) {
            aviao.desacelerar();
        }
    }
}
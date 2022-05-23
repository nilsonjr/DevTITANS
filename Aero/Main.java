public class Main {
    public static void main(String[] args) {
        Motor motor1 = new Motor("Oberursel Ur.I", 50.0f);
        Motor motor2 = new Motor("Le Rhône 9j", 50.0f);

        Aviao aviao = new Aviao("Fokker Dr.I", "Baron", motor1, motor2);
    
        aviao.imprimaOk();
        aviao.descreve();

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

        aviao.ligarMotores();
        for (int i = 0; i < 5; ++i) {
            aviao.acelerar();
        }
        for (int i = 0; i < 6; ++i) {
            aviao.desacelerar();
        }
    }
}
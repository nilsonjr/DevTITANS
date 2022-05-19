public class Main {
    public static void main(String[] args) {
        Aviao aviao = new Aviao();
        aviao.imprimaOk();

        aviao.setModelo("Fokker Dr.I");
        aviao.setIdentificador("Baron");
        aviao.setMotor(true);
        aviao.setAltura(2.95f);

        aviao.descreve();
    }
}
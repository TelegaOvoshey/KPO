public class Main {

    public static void main(String[] args) {
        Methods methods = new Methods();
        methods.createTree(2,10);

        System.out.println(methods.getGraf());
        System.out.println(methods.getHangingChild());
    }
}

public class Main {
    public static void main(String[] args) {
        int m=5;
        int N=20;
        int R=100;
        Methods methods = new Methods(N,m);
        methods.createTree(false);

        System.out.println(methods.getGraf());
        System.out.println("\n");
        System.out.println(methods.getHangingChild());
        System.out.println("-----"+N+"------");
        System.out.println("-----"+methods.getCountHangingNodes()+"------");
        System.out.println("-----"+methods.getAlpha()+"------");
        StringBuilder stringBuilder = new StringBuilder();
        double midleValueAlpha=0;
        double midleValueVertex=0;
        stringBuilder.append("№").append("_|_").append("N").append("_|_").append("P").append("_|_").append("ALFA").append("\n");
        for (int i=0;i<R;i++){
            methods= new Methods(N,m);
            methods.createTree(false);
            int countHangingNodes = methods.getCountHangingNodes();
            double alpha=methods.getAlpha();
            stringBuilder.append(i).append("_|_").append(N).append("_|_").append(countHangingNodes).append("_|_").append(String.format("%(.2f",alpha)).append("\n");

            midleValueVertex +=countHangingNodes;
            midleValueAlpha += alpha;
        }
        midleValueVertex = midleValueVertex/R;
        midleValueAlpha = midleValueAlpha/R;
        System.out.println(stringBuilder.toString());
        System.out.println("Среднее число вершин = "+N);
        System.out.println("Среднее число висячих вершин = "+String.format("%(.2f",midleValueVertex));
        System.out.println("Среднее число значений alpha = "+String.format("%(.2f",midleValueAlpha));
    }
}

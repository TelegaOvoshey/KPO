import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int m=5;
        int N=200;
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
        double midleValueLayouts=0;
        ArrayList<Double> listAlpha = new ArrayList<>();
        stringBuilder.append("№").append("__|__").append("N").append("__|__").append("P").append("__|__").append("ALPHA").append("\n");
        for (int i=0;i<R;i++){
            methods= new Methods(N,m);
            methods.createTree(false);
            int countHangingNodes = methods.getCountHangingNodes();
            double alpha=methods.getAlpha();
            int countLayouts = methods.getCountLayouts();
            stringBuilder.append(i).append("_|_").append(N).append("_|_").append(countHangingNodes).append("_|_").append(countLayouts).append("_|_").append(String.format("%(.2f",alpha)).append("\n");
            midleValueVertex +=countHangingNodes;
            listAlpha.add(alpha);
            midleValueAlpha += alpha;
            midleValueLayouts +=countLayouts;
        }
        midleValueVertex = midleValueVertex/R;
        midleValueAlpha = midleValueAlpha/R;
        midleValueLayouts = midleValueLayouts/R;

        System.out.println(stringBuilder.toString());
        System.out.println("Среднее число вершин = "+N);
        System.out.println("Среднее число висячих вершин = "+String.format("%(.2f",midleValueVertex));
        System.out.println("Среднее число значений alpha = "+String.format("%(.2f",midleValueAlpha));
        System.out.println("Среднее число вершин = "+String.format("%(.2f",midleValueLayouts));
        System.out.println("Значение дисперсии alpha = "+String.format("%(.5f",methods.getAlphaDispersion(listAlpha)));

        System.out.println("Кол-ва случайных значений при m-1");
        StringBuilder stringBuilder1 = new StringBuilder();
        for (Integer integer: methods.getCountRndm()) {
           stringBuilder1.append(integer).append("\n");
        }
        System.out.println(stringBuilder1.toString());
    }
}

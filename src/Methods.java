
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

    public class Methods {

        private int Layers=1;
        private ArrayList<Node> nodeList = new ArrayList<>();



        public int getRandomNumbChild(int m){
            Random random = new Random();
            int NumbChild = random.nextInt(m);
            return NumbChild;
        }

        public void createTree(int m,int N){
            int parentId = 0;
            int childId = 1;
            int countLayers=0;
            boolean proof = true;
            boolean hang;
            while (proof){
                if (countLayers==0){
                    nodeList.add(new Node(parentId,childId,countLayers,false));
                    childId++;parentId++;countLayers++;
                }else {
                    for (int i=0;i<getCountChildOnLayers(countLayers-1);i++){
                        int rdm = getRandomNumbChild(m);
                        if (rdm == 0)hang = true;
                        else hang = false;
                        for (int j = 0; j <= rdm; j++){
                            if (childId>N){
                                proof=false;
                            }else {
                                nodeList.add(new Node(parentId,childId,countLayers,hang));
                                childId++;
                            }
                        }
                        parentId++;
                    }
                    countLayers++;
                }
            }
            for (Node node :nodeList) {
                if (node.getLayers() == countLayers-1){
                    node.setHang(true);
                }
            }
        }


        public String getHangingChild() {
            StringBuilder stringBuilder = new StringBuilder();
            for (Node node:nodeList) {
                if (node.isHang()){
                    stringBuilder.append(node.toString());
                }
            }
            return stringBuilder.toString();
        }

        public String getGraf(){
            StringBuilder stringBuilder = new StringBuilder();
            for (Node node: nodeList) {
                stringBuilder.append(node.toString());
            }
            return stringBuilder.toString();
        }

        private int getCountChildOnLayers(int layers){
            int countChildren=0;

            for (int i=0; i<nodeList.size();i++){
                if (nodeList.get(i).getLayers() == layers){
                    countChildren++;
                }
            }
            return countChildren;
        }

    }


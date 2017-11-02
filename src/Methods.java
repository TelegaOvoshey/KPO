
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
            int layers=1;
            while (childId<= N){
                if (layers==1){
                    nodeList.add(new Node(parentId,childId,layers));
                    childId++;parentId++;layers++;
                }else {
                    for (int i=0;i<getCountChildOnLayers(layers-1);i++){
                        for (int j = 0; j < getRandomNumbChild(m); j++){
                            nodeList.add(new Node(parentId,childId,layers));
                            childId++;
                        }
                        parentId++;
                    }
                    layers++;
                }
            }
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



import java.util.ArrayList;
import java.util.List;
import java.util.Random;

    public class Methods {

        private int Layers=1;
        private ArrayList<Node> nodeList = new ArrayList<>();



        public int getRandomNumbChild(int m, boolean first){
            Random random = new Random();
            int NumbChild;
            if (first) {
               NumbChild = random.nextInt(m-1)+1;
            }
            else NumbChild = random.nextInt(m)+1;
            return NumbChild;
        }

        public void createTree(int m,int N){
            int parentId = 0;
            int childId = 1;
            int countLayers=0;
            boolean proof = true;
            int rdm;
            while (proof){
                if (countLayers==0){
                    rdm = getRandomNumbChild(m,true);
                    nodeList.add(new Node(parentId,childId,countLayers,rdm));
                    childId++;countLayers++;
                }else {
                    for (Node node:getParentOnLayers(countLayers-1)) {
                        for(int i=0;i<node.getCountChild();i++){
                            if (childId>N) proof = false;
                            else{
                            rdm = getRandomNumbChild(m,false);
                            nodeList.add(new Node(node.getId(),childId ,countLayers, rdm));
                            childId++;
                            }
                        }
                    }
                    countLayers++;
                }
            }
            for (Node node :nodeList) {
                if (node.getLayers() == countLayers-1){
                    node.setCountChild(0);
                }
            }
        }


        public ArrayList<Node> getParentOnLayers(int layers){
            ArrayList<Node> arrayPid = new ArrayList<Node>();
            for(Node node: nodeList){
                if (node.getLayers() == layers){
                    arrayPid.add(node);
                }
            }
            return arrayPid;
        }


        public String getHangingChild() {
            StringBuilder stringBuilder = new StringBuilder();
            for (Node node:nodeList) {
                if (node.getCountChild()==0){
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
                    countChildren +=nodeList.get(i).getCountChild();
                }
            }
            return countChildren;
        }

    }


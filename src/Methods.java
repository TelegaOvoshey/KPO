
import java.util.ArrayList;
import java.util.Random;

    public class Methods {

        private ArrayList<Node> nodeList = new ArrayList<>();



        public void createTree(int m,int N, boolean deterministic){
            int childId = 1;
            int countLayers=0;
            int countCh = m;
            boolean proof = true;
            while (proof){
                if (countLayers==0){
                    if (deterministic){
                        countCh = getRandomNumbChild(m,true);
                    }
                    nodeList.add(new Node(0,childId,countLayers,countCh));
                    childId++;countLayers++;
                }else {
                    for (Node node:getParentOnLayers(countLayers-1)) {
                        if (node.getCountChild()!=0){
                            for(int i=0;i<node.getCountChild();i++){
                                if (childId>N) proof = false;
                                else {
                                    if (deterministic) {
                                        countCh = getRandomNumbChild(m, false);
                                    }
                                    nodeList.add(new Node(node.getId(), childId, countLayers, countCh));
                                    childId++;
                                }
                            }
                        }

                    }
                    proofExistChild(countLayers);
                    countLayers++;
                }
            }
            repairCountChild();
        }

        private void repairCountChild(){
            for (Node node:nodeList) {
                int iterator=0;
                for (Node bufNode: nodeList){
                    if (node.getId() == bufNode.getPid()){
                        iterator++;
                    }
                }
                node.setCountChild(iterator);
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

        public int getRandomNumbChild(int m, boolean first){
            Random random = new Random();
            int NumbChild;
            if (first) {
                NumbChild = random.nextInt(m)+1;
            }
            else{ NumbChild = random.nextInt(m+1);
            }
            return NumbChild;
        }

        private void proofExistChild(int countLayers){
            boolean allZero=false;
            for (Node node:getParentOnLayers(countLayers)) {
                if (node.getCountChild()==0){
                    allZero=true;
                }else allZero=false;
            }
            if (allZero){
                for (Node node: nodeList){
                    if (node.equals(getParentOnLayers(countLayers).get(0))){
                        node.setCountChild(1);
                    }
                }
            }
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


    }


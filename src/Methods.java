
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

    public class Methods {

        private ArrayList<Node> nodeList = new ArrayList<>();

        private int N;
        private int m;

        public Methods(int N, int m) {
            this.N = N;
            this.m = m;
        }

        public void createTree(boolean deterministic){
            int childId = 1;
            int countLayers=0;
            int countCh = m;
            boolean proof = true;
            while (proof){
                if (countLayers==0){
                    if (!deterministic){
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
                                    if (!deterministic) {
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

        public double getAlpha(){
            return (double)N/getCountHangingNodes();
        }

        public double getAlphaDispersion(List<Double> listAlpha){
            double D;
            double squareAlpha=0;
            double squareMidle=0;
            for (double v:listAlpha) {
                squareAlpha +=Math.pow(v,2);
                squareMidle +=v;
            }
            squareAlpha = squareAlpha/listAlpha.size();
            squareMidle = Math.pow((squareMidle /listAlpha.size()),2);
            D = squareAlpha - squareMidle;
            return D;
        }

        public int getCountHangingNodes(){
            int countHangingNodes =0;
            for (Node node:nodeList) {
                if (node.getCountChild()==0){
                    countHangingNodes++;
                }
            }
            return countHangingNodes;
        }

        public int getCountLayouts(){
            int bufCount=0;
            for (Node node: nodeList) {
                if (node.getLayers()>bufCount) bufCount = node.getLayers();
            }
            return bufCount;
        }
        public ArrayList<Integer> getCountRndm(){
            ArrayList <Integer> integers = new ArrayList<>();

            for (int i =0;i<m;i++){
                int bufInt=0;
                for (Node node:nodeList) {
                    if (node.getCountChild() == i){
                        bufInt++;
                    }
                }
                integers.add(i,bufInt);
            }
           return integers;
        }

        private ArrayList<Node> getParentOnLayers(int layers){
            ArrayList<Node> arrayPid = new ArrayList<>();
            for(Node node: nodeList){
                if (node.getLayers() == layers){
                    arrayPid.add(node);
                }
            }
            return arrayPid;
        }

        private int getRandomNumbChild(int m, boolean first){
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
                allZero = node.getCountChild() == 0;
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


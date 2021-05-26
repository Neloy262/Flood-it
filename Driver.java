import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;
import java.applet.Applet;
import java.awt.*;
class Driver{
    public static void main(String[] args) {
        int steps=0;
        int board [][]=new int[6][6];
        ArrayList<Pair> Area1=new ArrayList<>();
        ArrayList<String> AreaS=new ArrayList<>();
        ArrayList<String> printPath=new ArrayList<>();
        Random rand=new Random();
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
              board[i][j]=rand.nextInt(3);
            }
        }
        board[5][2]=0;
        System.out.println("");
      
        Pair initial=new Pair(0, 0);
        Area1.add(initial);
        AreaS.add(initial.tostring());
        State firstState=new State(Area1, AreaS,board);
        firstState.viewBoard();
        System.out.println("");
        System.out.println("Initial State");
        System.out.println("");
        AStar aStar=new AStar();
        ArrayList checkArray= create();
        State finalState=aStar.Search(firstState,checkArray);
        while(finalState.parent!=null){
            //System.out.println(finalState.toString());
            printPath.add(finalState.toString());
            finalState=finalState.parent;
            steps++;
        }
        for(int i=(printPath.size())-1;i>=0;i--){
            System.out.println(printPath.get(i));
        }
        System.out.println("Steps taken:"+steps);

    }
    
    
     static ArrayList create() {
        String s = "";
        ArrayList<String> str=new ArrayList<>();
        for(int k=0;k<3;k++){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                s += k + " ";
            }
            s += "\n";
        }
        str.add(s);
        s = "";
    }
        return str;
    }
}
class HeuiristicComp implements Comparator<State>{

    @Override
    public int compare(State o1, State o2) {
        if(o1.f<o2.f){
            return 1;
        }
        else if(o1.f>o2.f){
            return -1;
        }
        return 0;
    }
    

}
/*
121121
021220
201110
101121
020212
122110
*/
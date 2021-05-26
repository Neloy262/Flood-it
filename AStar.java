import java.util.ArrayList;
import java.util.PriorityQueue;

class AStar {
    PriorityQueue<State> pQueue = new PriorityQueue<State>(5,new HeuiristicComp());
    ArrayList<String>visited=new ArrayList<>();
    int flag1,flag2=0;
    State Search(State start,ArrayList arr){
        start.g=0;
        start.f=start.g+start.h;
        pQueue.add(start);
        while(!pQueue.isEmpty()){
             flag1=flag2=0;
             State process=pQueue.remove();
             //System.out.println(process.toString());
             visited.add(process.toString());
             //ArrayList<State>arrayList=new ArrayList<>();
             State one=new State();
             State two=new State();
             if(process.board[0][0]==0){
                 one=process.genState(process.board[0][0],1);
                 two=process.genState(process.board[0][0],2);
             }
             else if(process.board[0][0]==1){
                 one=process.genState(process.board[0][0],0);
                 two=process.genState(process.board[0][0],2);
             }
             else if(process.board[0][0]==2){
                 one=process.genState(process.board[0][0],0);
                 two=process.genState(process.board[0][0],1);
             }
         one.g=one.parent.g+1;
         two.g=two.parent.g+1;
         one.f=one.g+one.h;
         two.f=two.g+two.h;
         if(arr.contains(one.toString())){
             //System.out.println(one.toString());
            return one;
         }
         if(arr.contains(two.toString())){
            //System.out.println(two.toString());
           return two;
        }
         
        if(!visited.contains(one.toString())){
            pQueue.add(one);
        }
        if(!visited.contains(two.toString())){
            pQueue.add(two);
        }

        }
        return null;
    }
    boolean isEqual(int a[][],int b[][]){
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                if(a[i][j]!=b[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    
}
import java.util.ArrayList;

class State {
    public
    int g;
    int f;
    int h;
    ArrayList<Pair> Area=new ArrayList<>();
    ArrayList<String> AreaString=new ArrayList<>();
    int [][]board=new int[6][6];
    State parent;
    State(){

    }
    State(ArrayList Area,ArrayList AreaString,int [][]board){
        this.Area=Area;
        this.AreaString=AreaString;
        this.board=board;
        this.parent=null;
        this.h=0;
    }
    State genState(int topleft,int color){
        int rowC,colC,row,col;
        ArrayList<Pair> childArea=new ArrayList<>();
        ArrayList<String> childAreaString=new ArrayList<>();
        int [][]childboard=new int[6][6];
        for(int i=0;i<Area.size();i++){
            childArea.add(Area.get(i));
            childAreaString.add(AreaString.get(i));
        }
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                childboard[i][j]=board[i][j];
            }
        }

        State newState=new State(childArea,childAreaString,childboard);
        for(int i=0;i<Area.size();i++){
            Pair p= (Pair) Area.get(i);
            rowC=p.geti();
            colC=p.getj();
            row=rowC;
            col=colC;
            //check up
            if(rowC>0){
                Pair check=new Pair(row-1, col);
                if(!AreaString.contains(check.tostring())){
                if(board[row-1][col]==topleft){
                   // Pair np=new Pair(row-1, col);
                    newState.Area.add(check);
                    newState.AreaString.add(check.tostring());
                    Area.add(check);
                    AreaString.add(check.tostring());
                }
            }
            }
            //check left
            if(colC>0){
                Pair check=new Pair(row, col-1);
                if(!AreaString.contains(check.tostring())){
                if(board[row][col-1]==topleft){
                   // Pair np=new Pair(row, col-1);
                    Area.add(check);
                    AreaString.add(check.tostring());
                    newState.Area.add(check);
                    newState.AreaString.add(check.tostring());
                }
            }
            }
            //check right
            if(colC<5){
                Pair check=new Pair(row, col+1);
                if(!AreaString.contains(check.tostring())){
                if(board[row][col+1]==topleft){
                   // Pair np=new Pair(row, col+1);
                    Area.add(check);
                    AreaString.add(check.tostring());
                    newState.Area.add(check);
                    newState.AreaString.add(check.tostring());
                }
            }
            }
            //check down
            if(rowC<5){
                Pair check=new Pair(row+1, col);
                if(!AreaString.contains(check.tostring())){
                if(board[row+1][col]==topleft){
                   // Pair np=new Pair(row, col+1);
                    Area.add(check);
                    AreaString.add(check.tostring());
                    newState.Area.add(check);
                    newState.AreaString.add(check.tostring());
                }
            }
            }

        }
        for(int i=0;i<Area.size();i++){
            Pair k=(Pair)Area.get(i);
            newState.board[k.i][k.j]=color;
        }
     
       //newState.h=newState.HeuristicValue2();
       newState.h=Area.size();
       newState.parent=this;
       return newState;
        
    }
    void viewBoard(){
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
    }

    int HeuristicValue(){
        return Area.size();
    }
    int HeuristicValue2(){
        int count=0;
        int val=HeuristicValue();
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                if(board[i][j]==0||board[i][j]==1||board[i][j]==2){
                    count++;
                    if(count>=2){
                        return val-(count*count);
                    }
                }
            }
        }
        return val-(count*count);
    }
    public String toString() {
        String s = "";
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                s += board[i][j] + " ";
            }
            s += "\n";
        }
        return s;
    }
 
    
}
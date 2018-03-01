package enhon.number_of_paths;

import java.util.ArrayDeque;
import java.util.Arrays;

public class NumberOfPaths {
    public static void main(String[] args) {
        //先定义一个邻接矩阵用来表示有向无环图
        //邻接矩阵用两个数组保存数据。一个一维数组存储图中顶点信息，一个二维数组存储图中边或弧的信息
        int[] vertex={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int[][] matrix={
               //0 1 2 3 4 5 6 7 8 9 10  11 12 13 14 15
                {0,1,0,0,1,0,0,0,0,0, 0, 0, 0, 0, 0, 0},
                {1,0,1,0,0,1,0,0,0,0, 0, 0, 0, 0, 0, 0},
                {0,1,0,1,0,0,1,0,0,0, 0, 0, 0, 0, 0, 0},
                {0,0,1,0,0,0,0,1,0,0, 0, 0, 0, 0, 0, 0},
                {1,0,0,0,0,1,0,0,0,0, 0, 0, 0, 0, 0, 0},
                {0,1,0,0,1,0,1,0,0,1, 0, 0, 0, 0, 0, 0},
                {0,0,1,0,0,1,0,1,0,0, 1, 0, 0, 0, 0, 0},
                {0,0,0,1,0,0,1,0,0,0, 0, 0, 0, 0, 0, 0},
                {0,0,0,0,0,0,0,0,0,1, 0, 0, 1, 0, 0, 0},
                {0,0,0,0,0,1,0,0,1,0, 1, 0, 0, 1, 0, 0},
                {0,0,0,0,0,0,1,0,0,1, 0, 1, 0, 0, 1, 0},
                {0,0,0,0,0,0,0,0,0,0, 1, 0, 0, 0, 0, 1},
                {0,0,0,0,0,0,0,0,1,0, 0, 0, 0, 1, 0, 0},
                {0,0,0,0,0,0,0,0,0,1, 0, 0, 1, 0, 1, 0},
                {0,0,0,0,0,0,0,0,0,0, 1, 0, 0, 1, 0, 1},
                {0,0,0,0,0,0,0,0,0,0, 0, 1, 0, 0, 1, 0},
        };
        int[] step={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};//初始化 我给的初始化值是-1
        int[] pathNum={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};//初始化 我给的初始化值是-1
        pathNum[0]=1;
        step[0]=0;
        ArrayDeque<Integer> deque=new ArrayDeque<Integer>();//从节点0一次扩展 也就是0节点就是起点  所以先把0放到队列中
        deque.add(0);
        while (!deque.isEmpty()){
            int from=deque.poll();
            for(int i=1;i<vertex.length;++i){//0是起点 不需要遍历
                int temp=step[from]+1;
                if(matrix[from][i]==1){//邻接点 连通
                    if(step[i]==-1||step[i]>temp){//i尚未到达或者发现有更短的路径（权值不一样才有可能）
                        step[i]=temp;
                        pathNum[i]=pathNum[from];
                        deque.add(i);
                    }else if(step[i]==temp){//之前i点就到达过 但是最短路径一样
                        pathNum[i]+=pathNum[from];
                    }
                }
            }
        }
        //最后如果pathNum[n-1]==-1就说明从0出发到N点的话 是到达不了的
        System.out.println(Arrays.toString(pathNum));
    }

}
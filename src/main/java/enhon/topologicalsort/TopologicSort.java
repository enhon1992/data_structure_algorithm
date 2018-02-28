package enhon.topologicalsort;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * 拓扑排序
 */
public class TopologicSort {


    /**
     * 获取邻接矩阵每个顶的入度 返回的数组的下标就是顶点
     * @param matrix
     */
    private static int[] getInDegree(int[][] matrix){
        int[] indegree=new int[matrix.length];
        for(int i=0;i<matrix.length;++i){
            for(int j=0;j<matrix.length;++j){
                indegree[j]+=matrix[i][j];
            }
        }
        return  indegree;
    }

    private  static  void getTopologicSortSequence(int[] indegree,int[][] matrix){
        int[] topologicSortSequence=new int[indegree.length];
        int inx=0;
        ArrayDeque<Integer> deque=new ArrayDeque<Integer>();
        for(int i=0;i<indegree.length;++i){
            if(indegree[i]==0){
                deque.add(i);
            }
        }
        while (!deque.isEmpty()){
            int cur=deque.poll();
            topologicSortSequence[inx++]=cur;
            for(int i=0;i<indegree.length;++i){
                if(matrix[cur][i]!=0){
                    indegree[i]--;
                    if(indegree[i]==0){
                        deque.add(i);
                    }
                }
            }
        }
        System.out.println(Arrays.toString(topologicSortSequence));
    }
    public static void main(String[] args) {
        //先定义一个邻接矩阵用来表示有向无环图
        //邻接矩阵用两个数组保存数据。一个一维数组存储图中顶点信息，一个二维数组存储图中边或弧的信息
        int[] vertex={0,1,2,3,4,5,6,7,8,9,10,11,12};
        int[][] matrix={
                //0 1 2 3 4 5 6 7 8 9 10  11 12
                {0,1,0,0,0,1,1,0,0,0, 0, 0, 0},
                {0,0,0,0,0,0,0,0,0,0, 0, 0, 0},
                {1,0,0,1,0,0,0,0,0,0, 0, 0, 0},
                {0,0,0,0,0,1,0,0,0,0, 0, 0, 0},
                {0,0,0,0,0,0,0,0,0,0, 0, 0, 0},
                {0,0,0,0,1,0,0,0,0,0, 0, 0, 0},
                {0,0,0,0,1,0,0,0,0,1, 0, 0, 0},
                {0,0,0,0,0,0,1,0,0,0, 0, 0, 0},
                {0,0,0,0,0,0,0,1,0,0, 0, 0, 0},
                {0,0,0,0,0,0,0,0,0,0, 1, 1, 1},
                {0,0,0,0,0,0,0,0,0,0, 0, 0, 0},
                {0,0,0,0,0,0,0,0,0,0, 0, 0, 1},
                {0,0,0,0,0,0,0,0,0,0, 0, 0, 0},
        };
        int[] indegree=getInDegree(matrix);
        getTopologicSortSequence(indegree,matrix);
        /**
         * [2, 8, 0, 3, 7, 1, 5, 6, 4, 9, 10, 11, 12] 这个打印的结果
         * [2, 8, 0, 3, 7, 1, 5, 6, 9, 4, 11, 10, 12] 这个也是一种拓扑排序的序列
         */
    }
}
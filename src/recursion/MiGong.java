package recursion;

/**
 * 使用递归来解决迷宫问题
 * @author coderhu1
 * @create 2020-09-02 15:27
 */
public class MiGong {
    public static void main(String[] args) {
        //先创建一个二维数据，模拟迷宫
        //地图
        int[][] map = new int[8][7];
        //使用1表示墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        //当前地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");

            }
            System.out.println();
        }

        //设置障碍物点
        map[3][1] = 1;
        map[3][2] = 1;
        //产生回溯的障碍点
//        map[1][2] = 1;
//        map[2][2] = 1;

        //使用递归给小球找路
//        setWay(map,1,1);
        //修改策略后的探路递归
        setWay2(map,1,1);

        //输出新的地图，小球走过，并标识过的递归
        System.out.println("地图的情况");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    //探路时一种重复的过程，可以使用递归
    //1.map表示地图
    //2.i，j表示出发点（在地图上）
    //3.如果小球能到map[6][5]位置，则说明通路找到
    //4.约定：当map[i][j] 为0表示该点没有走过，为1表示墙，为2表示通路可以走，3表示该点已经走过，但是走不通
    //5.在走迷宫时，需要确定一个策略 下-》右-》上-》左，如果该点走不通，再回溯
    /**
     *
     * @param map 表示地图
     * @param i 从哪个位置开始找
     * @param j
     * @return 如果找到通路，就返回true，否则返回false
     */
    public static boolean setWay(int[][] map, int i, int j){
        if(map[6][5] == 2){//通路已经找到ok
            return true;
        }else{
            if(map[i][j] == 0){ //如果当前这个点还没有走过
                map[i][j] = 2; //假设该店可以走通
                //使用 下 右 上 左 的策略
                if(setWay(map,i+1,j)){ //先向下走
                    return true;
                } else if (setWay(map,i,j+1)){
                    return true;
                } else if (setWay(map,i-1,j)){
                    return true;
                } else if (setWay(map,i,j-1)){
                    return true;
                } else {
                    //说明该店是走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            } else {//如果该店不是通路 为 1 2 3 都为不可用
                return false;
            }
        }
    }

    //修改找路的策略，先上 右 下 左
    public static boolean setWay2(int[][] map, int i, int j){
        if(map[6][5] == 2){//通路已经找到ok
            return true;
        }else{
            if(map[i][j] == 0){ //如果当前这个点还没有走过
                map[i][j] = 2; //假设该店可以走通
                //使用 上 右 下 左 的策略
                if(setWay2(map,i-1,j)){ //先向下走
                    return true;
                } else if (setWay2(map,i,j+1)){
                    return true;
                } else if (setWay2(map,i+1,j)){
                    return true;
                } else if (setWay2(map,i,j-1)){
                    return true;
                } else {
                    //说明该店是走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            } else {//如果该店不是通路 为 1 2 3 都为不可用
                return false;
            }
        }
    }
}

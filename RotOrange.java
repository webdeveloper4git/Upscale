package upscale;

import java.util.LinkedList;
import java.util.Queue;
public class RotOrange 
{
    public final static int R = 3;
    public final static int C = 5;
    static class Ele
    {
        int x = 0;
        int y = 0;
        Ele(int x,int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    static boolean isValid(int i, int j)
    {
        return (i >= 0 && j >= 0 && i < R && j < C);
    }
    static boolean isDelim(Ele temp)
    {
        return (temp.x == -1 && temp.y == -1);
    }
    static int rotOranges(int arr[][])
    {
        Queue<Ele> Q=new LinkedList<>();
        Ele temp; 
        int ans = 0;
        for (int i=0; i < R; i++)
           for (int j=0; j < C; j++)
               if (arr[i][j] == 2)
                   Q.add(new Ele(i,j));
        Q.add(new Ele(-1,-1));
        while(!Q.isEmpty())
        {
            boolean flag = false;
            while(!isDelim(Q.peek()))
            {
                temp = Q.peek();
                if(isValid(temp.x+1, temp.y) && arr[temp.x+1][temp.y] == 1)
                {
                    if(!flag)
                    {
                        ans++;
                        flag = true;
                    }
                    arr[temp.x+1][temp.y] = 2;
                    temp.x++;
                    Q.add(new Ele(temp.x,temp.y));
                    temp.x--;
                }
                if (isValid(temp.x-1, temp.y) && arr[temp.x-1][temp.y] == 1)
                 {
                        if (!flag)
                        {
                            ans++;
                            flag = true;
                        }
                        arr[temp.x-1][temp.y] = 2;
                        temp.x--;
                        Q.add(new Ele(temp.x,temp.y));
                        temp.x++;
                 }
                 if (isValid(temp.x, temp.y+1) && arr[temp.x][temp.y+1] == 1) {
                        if(!flag)
                        {
                            ans++;
                            flag = true;
                        }
                        arr[temp.x][temp.y+1] = 2;
                        temp.y++;
                        Q.add(new Ele(temp.x,temp.y));
                        temp.y--;
                    }
                 if (isValid(temp.x, temp.y-1) && arr[temp.x][temp.y-1] == 1) 
                 {
                        if (!flag)
                        {
                            ans++;
                            flag = true;
                        }
                        arr[temp.x][temp.y-1] = 2;
                        temp.y--;
                        Q.add(new Ele(temp.x,temp.y));
                 }
                 Q.remove();
                  
            }
            Q.remove();
            if (!Q.isEmpty()) 
            {
                Q.add(new Ele(-1,-1));
            }
        }
        return ans;
    }
    static int numfresh(int arr[][])
    {
        int f_num=0;
        for(int i=0;i<R;i++)
        {
        for(int j=0;j<C;j++)
            {
                if(arr[i][j]==1)
                    f_num++;
            }
        }
        return f_num;
    }
    static int numrotten(int arr[][])
    {
        int r_num=0;
        for(int i=0;i<R;i++)
        {
        for(int j=0;j<C;j++)
            {
                if(arr[i][j]==2)
                    r_num++;
            }
        }
        return r_num;
    }
    public static void main(String[] args) 
    {
        int arr[][] = { {2, 1, 0, 2, 1},
                        {1, 0, 1, 2, 1},
                        {1, 0, 0, 2, 1}};
        int ans = rotOranges(arr);
        int f_num= numfresh(arr);
        int r_num= numrotten(arr);
        System.out.println("time frames: " + ans);
        System.out.println("fresh: " + f_num);
        System.out.println("Rotten oranges: " + r_num);

    }
 
}
package eg.edu.alexu.csd.datastructure.iceHockey;

import java.awt.Point;

public class FindPlayers implements IPlayersFinder {
	private static int y_min ,y_max,x_min,x_max,count;
	@Override
	public Point[] findPlayers(String[] photo, int team, int threshold) {
		Point [] centers = new Point [50*50];
    	int test;
		int i , j ;
		int x1=0,y1=0;
        int box=threshold/4;
		int flag=0 ;
		int n = photo.length;
		int m = photo[0].length();
		int [][] sparse = new int[n][m];
		
		if(sparse.length!=0) {
		for(i=0 ; i<n ; i++) {
			for(j=0 ; j<m ; j++) {
				test =Character.getNumericValue(photo[i].charAt(j)); 
				if(test == team) {
				sparse[i][j] = test;
				}else {
				sparse[i][j] = 0;
				}
			}
		}
		
		for(i=0 ; i<n ; i++) {
			for(j=0 ; j<m ; j++) {
				x_max=0 ;
				y_max=0 ;
				x_min=50 ;
				y_min=50 ;
				if(sparse[i][j]==team) {
					sparse[i][j]= -team;
					Test(i,j,sparse,team);
			}
				if(count >= box ) {
					x1=x_min+x_max+1;
					y1=y_min+y_max+1;
					if(x1!=51 || y1!=51 ) {
					centers[flag]= new Point(x1,y1);
					flag++;
					}
				}
		}
		}
		}
		Point [] points = new Point [flag];
        System.arraycopy(centers, 0, points, 0,flag);
        sort(points);
        return points ;
	}

public static void sort (Point [] points) {
    Point temp ; 		
	if(points.length!=0)
		for(int g=0 ;g<points.length-1;g++) {
			for(int h=g+1;h<points.length;h++) {
				if (points[g].x>points[h].x) {
                    temp = points[g];
                    points[g] = points[h];
                    points[h] = temp ;
				}else if (points[g].x==points[h].x) {
                    if (points[g].y>points[h].y) {
                        temp = points[g];
                        points[g] = points[h];
                        points[h] = temp ;
                    }
                }
			}
		}
		
		
	}

public static void Test (int i,int j,int[][] sparse,int team) {
	if (i<y_min) y_min = i;
    if (i>y_max) y_max = i;
    if (j<x_min) x_min = j;
    if (j>x_max) x_max = j;
    count++;
    if(j< sparse[i].length-1 && sparse[i][j+1]==team) {
    	sparse[i][j+1]= -team;
        Test(i,j+1,sparse,team);
     }
    if(j>0 && sparse[i][j-1]==team) {
    	sparse[i][j-1]= -team;
        Test(i,j-1,sparse,team);
     }
    if(i< sparse.length-1 && sparse[i+1][j]==team) {
    	sparse[i+1][j]= -team;
        Test(i+1,j,sparse,team);
     }
    if(i>0 && sparse[i-1][j]==team) {
    	sparse[i-1][j]= -team;
        Test(i-1,j,sparse,team);
     }
}



}

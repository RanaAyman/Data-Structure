package eg.edu.alexu.csd.datastructure.iceHockey;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class IUnitTestCases {

	@SuppressWarnings("deprecation")
	@Test
	public void test1() {
		FindPlayers f = new FindPlayers();
        String []pic1 = {
                "33JUBU33",
                "3U3O4433",
                "O33P44NB",
                "PO3NSDP3",
                "VNDSD333",
                "OINFD33X"};
        Point [] Points_test1 = {new Point (4,5),new Point (13,9),new Point (14,2)};
        assertEquals(Points_test1,f.findPlayers(pic1,3,16));
	}

	 @SuppressWarnings("deprecation")
		@Test
	     public void test2() {
		 FindPlayers f = new FindPlayers();
	     String [] pic2 ={
            "11111",
            "11111",
            "11111"};
         Point [] points_test2 = { new Point (5,3)};
         assertEquals(points_test2,f.findPlayers(pic2,1,4));
}
     @SuppressWarnings("deprecation")
	@Test
     public void test3() {
      FindPlayers f = new FindPlayers();
      String []pic3 = {
      		"11111",
      		"1AAA1",
      		"1A1A1",
      		"1AAA1",
      		"11111"};
      Point [] Points_test3 = {new Point (5,5),new Point (5,5)};
      assertEquals(Points_test3,f.findPlayers(pic3,1,3));
      

	}
     @SuppressWarnings("deprecation")
 	 @Test
      public void test4() {
     FindPlayers f = new FindPlayers();
     String [] pic4 ={
             "11111",
             "11111",
             "11111"};
     Point [] points_test4= {};
     assertEquals(points_test4,f.findPlayers(pic4,3,1));
     }
}

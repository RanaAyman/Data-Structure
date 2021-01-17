package eg.edu.alexu.csd.datastructure.FinalAssignment_cs24;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TreeDictionary_Test {

	@Test
	void test1() {
		TreeDictionary<String, Integer> T =new TreeDictionary<String, Integer>();
		assertThrows(java.lang.RuntimeException.class,() -> T.set(null,500),"Error : Key or Value is NULL ! (invalid Key or Value)!");
		assertTrue(T.isEmpty());
		assertEquals(null,T.set("water", 100));
		assertEquals(null,T.set("apple", 5));
		assertEquals(null,T.set("mango", 24));
		assertEquals(24,T.set("mango", 70));
		assertEquals(70,T.get("mango"));
		assertEquals(null,T.set("guava", 13));
		assertEquals(null,T.set("pineapple", 17));
		assertThrows(java.lang.RuntimeException.class,() -> T.set("test",null),"Error : Key or Value is NULL ! (invalid Key or Value)!");
		assertEquals(null,T.set("strawberry", 37));
		assertEquals(37,T.set("strawberry", 13));
		
		
		assertThrows(java.lang.RuntimeException.class,() -> T.get(null),"Error : Key or Value is NULL ! (invalid Key or Value)!");
		assertEquals(13,T.get("strawberry"));
		assertEquals(null,T.get("Does't exist"));
		assertEquals(100,T.get("water"));
		
		assertEquals(6,T.size);
		assertFalse(T.isEmpty());
		
		assertThrows(java.lang.RuntimeException.class,() -> T.remove(null),"Error : Key or Value is NULL ! (invalid Key or Value)!");
		assertEquals(null,T.remove("Does't exist"));
		assertEquals(5,T.remove("apple"));
		assertEquals(null,T.get("apple"));
		
		assertEquals(100,T.remove("water"));
		assertEquals(null,T.get("water"));
		
		assertEquals(4,T.size);
		assertEquals(13,T.remove("guava"));
		assertEquals(3,T.size);
		assertEquals(null,T.set("siri", 708));
		assertEquals(4,T.size);
		assertEquals(708,T.remove("siri"));
		assertEquals(70,T.remove("mango"));
		assertEquals(2,T.size);
		assertEquals(13,T.remove("strawberry"));
		assertEquals(17,T.remove("pineapple"));
		assertEquals(0,T.size);
		assertTrue(T.isEmpty());
	}
	
	@Test
	void test2() {
		TreeDictionary<Integer, Integer> T =new TreeDictionary<Integer, Integer>();
		assertThrows(java.lang.RuntimeException.class,() -> T.set(null,500),"Error : Key or Value is NULL ! (invalid Key or Value)!");
		assertTrue(T.isEmpty());
		assertEquals(null,T.set(28,280));
		assertEquals(null,T.set(24,240));
		assertEquals(null,T.set(14,140));
		assertEquals(null,T.set(19,190));
		assertEquals(null,T.set(94, 940));
		assertEquals(null,T.set(17, 170));
		assertEquals(170,T.set(17, 171));
		assertThrows(java.lang.RuntimeException.class,() -> T.set(5000,null),"Error : Key or Value is NULL ! (invalid Key or Value)!");
		assertThrows(java.lang.RuntimeException.class,() -> T.get(null),"Error : Key or Value is NULL ! (invalid Key or Value)!");
		assertEquals(171,T.get(17));
		assertEquals(null,T.get(5000));
		assertEquals(280,T.get(28));
		
		assertEquals(6,T.size);
		assertFalse(T.isEmpty());
		
		assertThrows(java.lang.RuntimeException.class,() -> T.remove(null),"Error : Key or Value is NULL ! (invalid Key or Value)!");
		assertEquals(null,T.remove(5000));
		assertEquals(190,T.remove(19));
		assertEquals(null,T.get(19));
		
		assertEquals(280,T.remove(28));
		assertEquals(null,T.get(28));
		
		assertEquals(4,T.size);
	}
	
	@Test
	void test3() {
		TreeDictionary<String, String> T =new TreeDictionary<String, String>();
		assertThrows(java.lang.RuntimeException.class,() -> T.set(null,"test"),"Error : Key or Value is NULL ! (invalid Key or Value)!");
		assertTrue(T.isEmpty());
		assertEquals(null,T.set("one","un"));
		assertEquals(null,T.set("two","deux"));
		assertEquals(null,T.set("three","trois"));
		assertEquals(null,T.set("four","quater"));
		assertEquals(null,T.set("five", "cinq"));
		assertEquals(null,T.set("six", "six"));
		assertEquals("six",T.set("six", "6"));
		assertThrows(java.lang.RuntimeException.class,() -> T.set("test2",null),"Error : Key or Value is NULL ! (invalid Key or Value)!");
		assertThrows(java.lang.RuntimeException.class,() -> T.get(null),"Error : Key or Value is NULL ! (invalid Key or Value)!");
		assertEquals("cinq",T.get("five"));
		assertEquals("6",T.get("six"));
		assertEquals(null,T.get("test"));
		assertEquals("trois",T.get("three"));
		
		assertEquals(6,T.size);
		assertFalse(T.isEmpty());
		
		assertThrows(java.lang.RuntimeException.class,() -> T.remove(null),"Error : Key or Value is NULL ! (invalid Key or Value)!");
		assertEquals(null,T.remove("test2"));
		assertEquals("deux",T.remove("two"));
		assertEquals(null,T.get("two"));
		
		assertEquals("quater",T.remove("four"));
		assertEquals(null,T.get("four"));
		
		assertEquals(4,T.size);
	}
	
	@Test
	void test4() {
		TreeDictionary<Integer, Boolean> T =new TreeDictionary<Integer, Boolean>();
		assertThrows(java.lang.RuntimeException.class,() -> T.set(null,false),"Error : Key or Value is NULL ! (invalid Key or Value)!");
		assertTrue(T.isEmpty());
		assertEquals(null,T.set(1,true));
		assertEquals(null,T.set(2,true));
		assertEquals(null,T.set(3,false));
		assertEquals(null,T.set(4,true));
		assertEquals(null,T.set(5, false));
		assertEquals(null,T.set(6, false));
		assertEquals(false,T.set(6, true));
		assertEquals(true,T.get(6));
		assertThrows(java.lang.RuntimeException.class,() -> T.set(100,null),"Error : Key or Value is NULL ! (invalid Key or Value)!");
		assertThrows(java.lang.RuntimeException.class,() -> T.get(null),"Error : Key or Value is NULL ! (invalid Key or Value)!");
		assertEquals(false,T.get(5));
		assertEquals(null,T.get(500));
		assertEquals(false,T.get(3));
		
		assertEquals(6,T.size);
		assertFalse(T.isEmpty());
		
		assertThrows(java.lang.RuntimeException.class,() -> T.remove(null),"Error : Key or Value is NULL ! (invalid Key or Value)!");
		assertEquals(null,T.remove(700));
		assertEquals(true,T.remove(2));
		assertEquals(null,T.get(2));
		
		assertEquals(true,T.remove(4));
		assertEquals(null,T.get(4));
		
		assertEquals(4,T.size);
	}


}

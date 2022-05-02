package ar.edu.unlp.info.oo2.accesobd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProxyTest {
    private DatabaseAccess database;
    private Proxy proxyDB;

    @BeforeEach
    void setUp() throws Exception {
        this.database = new DatabaseRealAccess();
        this.proxyDB = new Proxy(this.database,"C4ptu$!");
    }

    @Test
    void testGetSearchResultsNoAuth() {
        assertEquals(null, this.proxyDB.getSearchResults("select * from comics where id=1"));
        assertEquals(null, this.proxyDB.getSearchResults("select * from comics where id=10"));
    }

    @Test
    void testInsertNewRowNoAuth() {
        assertEquals(-1, this.proxyDB.insertNewRow(Arrays.asList("Patoruzú", "La flor")));
        assertEquals(null, this.proxyDB.getSearchResults("select * from comics where id=3"));
    }
    
    @Test
    void wrongPassword() {
    	this.proxyDB.logIn("Captus!");
        assertEquals(null, this.proxyDB.getSearchResults("select * from comics where id=1"));
        assertEquals(null, this.proxyDB.getSearchResults("select * from comics where id=10"));
    }
    
    @Test
    void testLoggedInGetSearchResults() {
    	this.proxyDB.logIn("C4ptu$!");
        assertEquals(Arrays.asList("Spiderman", "Marvel"), this.proxyDB.getSearchResults("select * from comics where id=1"));
        assertEquals(Collections.emptyList(), this.proxyDB.getSearchResults("select * from comics where id=10"));
    }

    @Test
    void testLoggedInInsertNewRow() {
    	this.proxyDB.logIn("C4ptu$!");
        assertEquals(3, this.proxyDB.insertNewRow(Arrays.asList("Patoruzú", "La flor")));
        assertEquals(Arrays.asList("Patoruzú", "La flor"), this.proxyDB.getSearchResults("select * from comics where id=3"));
    }
    
    @Test
    void logOut() {
    	this.proxyDB.logIn("C4ptu$!");
        assertEquals(Arrays.asList("Spiderman", "Marvel"), this.proxyDB.getSearchResults("select * from comics where id=1"));
        assertEquals(Collections.emptyList(), this.proxyDB.getSearchResults("select * from comics where id=10"));
    	this.proxyDB.logOut();;
        assertEquals(null, this.proxyDB.getSearchResults("select * from comics where id=1"));
        assertEquals(null, this.proxyDB.getSearchResults("select * from comics where id=10"));
    }
    
}
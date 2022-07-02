package com.stackroute.project.wishlist;

import com.stackroute.project.common.messages.BaseResponse;
import com.stackroute.project.dto.WishListDTO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DataModelTest {

    @Test
    public void testDtoEqualsMethod(){
        WishListDTO w=new WishListDTO(100,1,"http://test1.com");
        assertTrue(w.equals(new WishListDTO(100,1,"http://test1.com")));
    }
    @Test
    public void testDtoEqualsMethodNullValue(){
        WishListDTO w=new WishListDTO(100,1,"http://test1.com");
        assertTrue(!w.equals(null));
        assertTrue(!w.equals(new WishListDTO(100,1,"http://test2.com")));
        assertTrue(!w.equals(new WishListDTO(100,0,"http://test1.com")));
        assertTrue(!w.equals(new WishListDTO(101,0,"http://test1.com")));
    }
    @Test
    public void testDtoHashCode(){
        WishListDTO w=new WishListDTO(100,1,"http://test1.com");
        assertEquals(w.hashCode(),(new WishListDTO(100,1,"http://test1.com")).hashCode());
    }
    @Test
    public void testBaseResponse(){
        BaseResponse b=new BaseResponse();
        b.setMessage("test");
        b.setStatus(101);
        assertEquals(b.getMessage(),"test");
    }
}

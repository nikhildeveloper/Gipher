package com.stackroute.project.wishlist;

import com.stackroute.project.common.messages.BaseResponse;
import com.stackroute.project.common.messages.CustomMessage;
import com.stackroute.project.dto.WishListDTO;
import com.stackroute.project.service.WishlistService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
//@ExtendWith(SpringExtension.class)
//@TestPropertySource(properties = "spring.mongodb.embedded.version=3.5.5")
public class WishlistServiceTest {


    @Autowired
    WishlistService wishlistService;

    @Test
    public void testCreateWishList(){
        WishListDTO w=new WishListDTO(100,1,"http://test1.com");
        BaseResponse baseResponse=wishlistService.createWishList(w);
        assertEquals(baseResponse.getStatus(), HttpStatus.CREATED.value());
        assertTrue(baseResponse.getMessage().contains(CustomMessage.SAVE_SUCCESS_MESSAGE));
    }
    @Test
    public void testGetWishList(){
        WishListDTO w=new WishListDTO(102,2,"http://test1.com");
        wishlistService.createWishList(w);
        List<WishListDTO> res=wishlistService.getWishList(2);
        assertTrue(res.size()==1);
        wishlistService.deleteWishList(0);
    }
    @Test
    public void testDeleteWishList(){
        WishListDTO w=new WishListDTO(103,1,"http://test1.com");
        BaseResponse baseResponse=wishlistService.deleteWishList(0);
        assertEquals(baseResponse.getStatus(),HttpStatus.CREATED.value());
        assertTrue(baseResponse.getMessage().contains(CustomMessage.DELETE_SUCCESS_MESSAGE));
    }
}

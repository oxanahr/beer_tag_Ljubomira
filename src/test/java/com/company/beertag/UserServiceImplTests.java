package com.company.beertag;

import com.company.beertag.models.Beer;
import com.company.beertag.models.users.User;
import com.company.beertag.models.users.UserType;
import com.company.beertag.repositories.UserRepository;
import com.company.beertag.services.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTests {
    @Mock
    UserRepository mockRepository;

    @InjectMocks
    UserServiceImpl service;

    @Test
    public void add_Should_AddInRepository_When_UserIsValid() {
        //Arrange
        User user=new User(1,"Martin", UserType.VISITOR,"1234");

        //Act
        service.add(user);

        //
        Mockito.verify(mockRepository,Mockito.times(1)).add(user);
    }


    @Test
    public void addBeer_Should_AddInRepository_When_BeerIsValid() {
        //Arrange
        Beer beer=new Beer(1,"Martin" );
        User user=new User(1,"Martin", UserType.VISITOR,"1234");
        service.add(user);

        //Act
        service.addBeer(1,beer);

        //
        Mockito.verify(mockRepository,Mockito.times(1)).addBeer(1,beer);
    }

    @Test
    public void getAll_Should_ReturnFromRepository() {
         //Act
        service.getAll();

        //
        Mockito.verify(mockRepository,Mockito.times(1)).getAll();
    }

    @Test
    public void getAllBeers_Should_ReturnFromRepository_WhenUserIsValid() {
        //Arrange
        User user=new User(1,"Martin", UserType.VISITOR,"1234");
        service.add(user);

        //Act
        service.getAllBeers(1);

        //
        Mockito.verify(mockRepository,Mockito.times(1)).getAllBeers(1);
    }


}

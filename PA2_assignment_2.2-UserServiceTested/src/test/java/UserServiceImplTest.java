import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class UserServiceImplTest {
    private static final String NEW_PASSWORD = "123456";

    /**
     * @verifies get user new password and update user when all parameters are correct
     * @see UserServiceImpl#assignPassword(User)
     */
    @Test
    public void assignPassword_shouldGetUserNewPasswordAndUpdateUserWhenAllParametersAreCorrect() throws Exception {
        //arrange
        User user = mock(User.class);
        UserDAO userDAO = mock(UserDAO.class);
        SecurityService securityService = mock(SecurityService.class);
        UserServiceImpl sut = new UserServiceImpl(userDAO, securityService);

        when(securityService.md5(user.getPassword())).thenReturn(NEW_PASSWORD); //String passwordMd5 là 1 indirect input nên là mới dùng when then

        //act
        sut.assignPassword(user);

        //assert
        verify(user).setPassword(NEW_PASSWORD);
        verify(userDAO).updateUser(user);
    }
}

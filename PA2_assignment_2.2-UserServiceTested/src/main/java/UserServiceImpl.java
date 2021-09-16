public class UserServiceImpl {
    private UserDAO userDAO;
    private SecurityService securityService;

    /**
     *
     * @param user
     * @throws Exception
     * @should get user new password and update user when all parameters are correct
     */
    public void assignPassword(User user) throws Exception {
        String passwordMd5 = securityService.md5(user.getPassword());
        user.setPassword(passwordMd5);
        userDAO.updateUser(user);
    }

    public UserServiceImpl(UserDAO dao, SecurityService security) {
        this.userDAO = dao;
        this.securityService = security;
    }
}

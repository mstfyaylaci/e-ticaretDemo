package Business.Abstracts;

import Entities.Concretes.User;

public interface UserService {
    void add(User user);
    void signIn(User user,String email,String password);

    void  emailAccept(User user );
    void  linkClick(User user);
}

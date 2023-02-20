import Business.Concretes.UserManager;
import Core.Concretes.GoogleManagerAdapter;
import Core.Concretes.ICloudManagerAdapter;
import DataAccess.Concretes.HiberanateUserDao;
import Entities.Concretes.User;

public class Main {
    public static void main(String[] args) {

        User user=new User(1,"Mustafa","Yaylacı","mustafayaylaci4269@gmail.com","123456");

        UserManager userManager=new UserManager(new HiberanateUserDao(),new GoogleManagerAdapter());
        userManager.add(user);
        userManager.emailAccept(user);
        userManager.linkClick(user);

       userManager.signIn(user,"mustafayaylaci4269@gmail.com","123456");
    }
}
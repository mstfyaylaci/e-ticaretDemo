package Business.Concretes;

import Business.Abstracts.UserService;
import Core.Abstracts.SignUpService;
import DataAccess.Abstracts.UserDao;
import Entities.Concretes.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserManager implements UserService {

   private UserDao userDao;
   private SignUpService signUpService;

    public UserManager(UserDao userDao, SignUpService signUpService) {
        this.userDao = userDao;
        this.signUpService = signUpService;
    }

    @Override
    public void add(User user) {


      final  String regex="^[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
      final Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(user.getEmail());


       if (matcher.matches()){
           System.out.println(user.getEmail()+" E-posta geçerli formatta");
       }
       else{
           System.out.println("E-posta formatı geçersiz");
           return;
       }
        if (user.getFirstName().length()<2 || user.getLastName().length()<2){
            System.out.println(user.getFirstName()+" "+user.getLastName()+" Kayıt başarısız isim veya soyisim en az 2 karakter uzunluğunda olmalıdır ");
            return;
        }
        if ( user.getPassword().length()<6){
            System.out.println("Şifre en az 6 karakter uzunluğunda olmalıdır");
            return;
        }

        userDao.add(user);
        signUpService.signUpToSytem(user.getEmail());

    }

    @Override
    public void signIn(User user, String email, String password) {
        if (user.getEmail()==email && user.getPassword()==password){
            System.out.println(user.getEmail()+"hesabına  giriş yapıldı ");
        }
        else
            System.out.println("Email ve şifrenizi tekrar kontrol ediniz");
    }

    @Override
    public void emailAccept(User user) {
        System.out.println(user.getEmail()+" e-postanıza doğrulama kodu gönderildi");
    }

    @Override
    public void linkClick(User user) {
        System.out.println(user.getFirstName()+" üyeliğiniz onaylandı");
    }
}

package Core.Concretes;

import Core.Abstracts.SignUpService;
import emailServices.GoogleManager;

public class GoogleManagerAdapter implements SignUpService {

  GoogleManager googleManager=new GoogleManager();
    @Override
    public void signUpToSytem(String message) {
        googleManager.signUpGoogle(message);

    }
}

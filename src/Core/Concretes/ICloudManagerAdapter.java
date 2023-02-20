package Core.Concretes;

import Core.Abstracts.SignUpService;
import emailServices.ICloudManager;

public class ICloudManagerAdapter implements SignUpService {

    ICloudManager iCloudManager=new ICloudManager();
    @Override
    public void signUpToSytem(String message) {
        iCloudManager.signUpICloud(message);
    }
}

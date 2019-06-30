package facebookauth.devlibs.com.flutter_facebook_auth;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import io.flutter.app.FlutterActivity;
import io.flutter.plugins.GeneratedPluginRegistrant;

public class MainActivity extends FlutterActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    GeneratedPluginRegistrant.registerWith(this);
  }


  public void generateKeyHash() {

    try {

      PackageInfo info = getPackageManager().getPackageInfo( getPackageName(), PackageManager.GET_SIGNATURES);

      for (Signature signature : info.signatures) {

        MessageDigest md = MessageDigest.getInstance("SHA");

        md.update(signature.toByteArray());

        Log.d(">>>>>KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));

      }


    } catch (PackageManager.NameNotFoundException e) {

      Log.i(">>>>>>",e.toString());


    } catch (NoSuchAlgorithmException e) {

      Log.i(">>>>",e.toString());


    }

  }
}

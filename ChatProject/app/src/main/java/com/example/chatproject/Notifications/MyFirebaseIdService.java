package com.example.chatproject.Notifications;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessagingService;

//import com.google.firebase.iid.FirebaseInstanceIdService;
//
//public class MyFirebaseIdService extends FirebaseInstanceIdService {

//@Override
//public void onTokenRefresh() {
//        super.onTokenRefresh();
//        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
//
//        String refreshToken = FirebaseInstanceId.getInstance().getToken();
//        if (firebaseUser != null){
//        updateToken(refreshToken);
//        }
//        }


public class MyFirebaseIdService extends FirebaseMessagingService {

    @Override
    public void onNewToken(String refreshToken) {
        super.onNewToken(refreshToken);
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if (firebaseUser != null){
            updateToken(refreshToken);
        }
    }

    private void updateToken(String refreshToken) {
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Tokens");
        Token token = new Token(refreshToken);
        reference.child(firebaseUser.getUid()).setValue(token);
    }

}

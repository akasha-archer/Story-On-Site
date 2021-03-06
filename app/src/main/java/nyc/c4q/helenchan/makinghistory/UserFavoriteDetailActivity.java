package nyc.c4q.helenchan.makinghistory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;

public class UserFavoriteDetailActivity extends AppCompatActivity {

    private TextView usernameTextView;
    private ImageView userPhotoDetailImageView;
    private DatabaseReference ref;

    private String TAG = "UserPhotoDetailActivity";
    private String userPhotoDetailUrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_photo_detail);

        usernameTextView = (TextView) findViewById(R.id.username);
        userPhotoDetailImageView = (ImageView) findViewById(R.id.user_photo_detail);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey("UserPhotoUri")) {
                userPhotoDetailUrl = extras.getString("UserPhotoUri");

                usernameTextView.setText(SignInActivity.mUsername);
                Glide.with(getApplicationContext())
                        .load(userPhotoDetailUrl)
                        .override(1200, 1200)
                        .centerCrop()
                        .into(userPhotoDetailImageView);
            }
        }
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.user_favorite_detail_menu, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case (R.id.user_share):
//                //do stuff
//                return true;

//            case (R.id.user_unfavorite):
//                AlertDialog.Builder builder = new AlertDialog.Builder(this);
//                builder.setMessage("Are you sure you want to unfavorite this picture?");
//                builder.setCancelable(true);
//
//                builder.setPositiveButton(
//                        "Yes",
//                        new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
////                                unfavoriteUserPhoto();
//
//                                Intent intent = new Intent(getApplicationContext(), UserProfileActivity.class);
//                                startActivity(intent);
//                                finish();
//                            }
//                        });
//
//                builder.setNegativeButton(
//                        "Cancel",
//                        new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                dialogInterface.cancel();
//                            }
//                        });
//
//                AlertDialog deleteAlert = builder.create();
//                deleteAlert.show();
//        }
//        return super.onOptionsItemSelected(item);
//    }

//    public void unfavoriteUserPhoto() {
//        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
//        Log.i(TAG, "photo url: " + userPhotoDetailUrl);
//
//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
//        Query photoQuery = ref.child("Users").child(uid).child("UserFavorites").orderByChild("url").equalTo(userPhotoDetailUrl);
//        photoQuery.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot photoSnapshot : dataSnapshot.getChildren()) {
//                    photoSnapshot.getRef().removeValue();
//                    Log.i(TAG, "photo removed " + userPhotoDetailUrl);
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                Log.e(TAG, "onCancelled", databaseError.toException());
//            }
//        });
//    }
}

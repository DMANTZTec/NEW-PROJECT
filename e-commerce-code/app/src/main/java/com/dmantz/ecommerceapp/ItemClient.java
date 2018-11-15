package com.dmantz.ecommerceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseReference;
import com.nex3z.notificationbadge.NotificationBadge;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

public class ItemClient extends AppCompatActivity {


    //  ProgressDialog mProgressDialog;

    private String TAG = "PRODUCT INFORMATION";
    //  String itemUrl = "http://192.168.100.5:8080/UserApp/saveOrder";

    //  String jsonData = null;


    Button addtocartbtn;
    Button buyNow;

    Firebase url, url2;
    DatabaseReference mFirebase, rootRef;

    TextView mTextView, itemCountText;

    NotificationBadge mBadge;

    int count = 0;


    String itemName;
    String itemPrice;
    String itemSize;
    String itemId;
    String itemDescription;
    String itemImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_client);
        getItemInformation();
        Firebase.setAndroidContext(this);


        buyNow = findViewById(R.id.buyNow);
        mTextView = findViewById(R.id.itemInfo);
        addtocartbtn = findViewById(R.id.addtocart);
        mBadge = findViewById(R.id.actionbar_notification_textview);

        url = new Firebase("https://ecapplication-7c0cf.firebaseio.com/name/-LOw1zFfkeJ5tC1E4uA8");
        url2 = new Firebase("https://ecapplication-7c0cf.firebaseio.com/name/-LOwEbY70jY3l6hy26Vg");

        addtocartbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = getIntent().getStringExtra("productName");
                Firebase firebase = url.child("name");
                Map newUserData = new HashMap();

                firebase.push().setValue(itemName);
                firebase.updateChildren(newUserData);


                mBadge.setNumber(++count);


                Toast toast = Toast.makeText(getApplicationContext(), "Item added to cart", Toast.LENGTH_SHORT);
                toast.show();


            }
        });



    /*    try {
            Log.d(TAG, "onCreate: entered into try block");
            InputStream is = getAssets().open("itemInformation.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsonData = new String(buffer, "UTF-8");
            Log.d(TAG, "got information" + jsonData);


        } catch (IOException ex) {
            ex.printStackTrace();

        }


        try {
            org.json.JSONObject storejsonObj = new org.json.JSONObject(jsonData.toString());

            org.json.JSONArray jsonarrayObj = storejsonObj.getJSONArray("productInformation");
            Log.d(TAG, "got product object with json data" + jsonarrayObj);


            //    ArrayList<ItemDetailPoJoClass> itemDetail = new ArrayList<>();

            for (int i = 0; i < jsonarrayObj.length(); i++) {

                Log.d(TAG, "entered into for loop");
                ItemDetailPoJoClass obj = new ItemDetailPoJoClass();

                obj.setItemName((String) jsonarrayObj.getJSONObject(i).get("itemName"));
                obj.setItemDescription((String) jsonarrayObj.getJSONObject(i).get("itemDescription"));
                obj.setItemId((String) jsonarrayObj.getJSONObject(i).get("itemId"));
                obj.setItemSize((String) jsonarrayObj.getJSONObject(i).get("itemSize"));
                obj.setItemPrice((String) jsonarrayObj.getJSONObject(i).get("itemPrice"));


                Log.d(TAG, "itemname" + obj.getItemName());
                Log.d(TAG, "itemdescription" + obj.getItemDescription());

                //  itemDetail.add(obj);

                String name = obj.getItemName();
                mName.setText(name);
                String itemDesc = obj.getItemDescription();
                mDescription.setText(itemDesc);
                String itemsize = obj.getItemSize();
                mSize.setText(itemsize);

                String itemid = obj.getItemId();
                mId.setText(itemid);
                String itemprice = obj.getItemPrice();
                mPrice.setText(itemprice);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

*/

        buyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                url2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String value = dataSnapshot.getValue(String.class);


                        Intent intent = new Intent(ItemClient.this, PaymentClient.class);

                        intent.putExtra("cartDetails", value);
                        intent.putExtra("itemName", itemName);
                        intent.putExtra("itemImage", itemImage);
                        intent.putExtra("itemId", itemId);
                        intent.putExtra("itemPrice", itemPrice);
                        intent.putExtra("itemSize", itemSize);

                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });


            }
        });


    }


    private void getItemInformation() {

        if (getIntent().hasExtra("productName") && getIntent().hasExtra("productSize") && getIntent().hasExtra("productPrice") && getIntent().hasExtra("productId") && getIntent().hasExtra("productDescription") && getIntent().hasExtra("productUrl")) {
            itemName = getIntent().getStringExtra("productName");
            itemPrice = String.valueOf(getIntent().getDoubleExtra("productPrice", 0.00));
            itemSize = getIntent().getStringExtra("productSize");
            itemId = String.valueOf(getIntent().getIntExtra("productId", 0));
            itemDescription = getIntent().getStringExtra("productDescription");
            itemImage = getIntent().getStringExtra("productUrl");


            setItemInformation(itemName, itemSize, itemPrice, itemId, itemDescription, itemImage);
        }


    }


    /*   private void updateCartCount(){

           if(mBadge == null) return;
           runOnUiThread(new Runnable() {
               @Override
               public void run() {

               }
           });
       }
   */
    private void setItemInformation(String itemName, String itemSize, String itemPrice, String itemId, String itemDescription, String itemImage) {

        TextView mName = findViewById(R.id.product_name);
        mName.setText(itemName);


        TextView mId = findViewById(R.id.product_id);
        mId.setText(itemId);


        TextView mPrice = findViewById(R.id.product_price);
        mPrice.setText(itemPrice);

        TextView mSize = findViewById(R.id.product_size);
        mSize.setText(itemSize);

        TextView mDescription = findViewById(R.id.product_description);
        mDescription.setText(itemDescription);

        ImageView mImageView = findViewById(R.id.image_product);
        Picasso.get().load(itemImage).fit().into(mImageView);


    }


}




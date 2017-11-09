package com.example.david.david_madlibs;
import android.content.res.AssetManager;
import java.io.InputStream;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import java.io.IOException;
import android.util.Log;
import android.widget.Toast;



public class second_activity extends AppCompatActivity {
    public Story story;
    EditText editText;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);
        Intent intent = getIntent();
        String filename = intent.getStringExtra("filename");
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);

        // code to get the right story
        AssetManager assetManager = getAssets();
        InputStream inputStream = null;
        try {
            inputStream = assetManager.open(filename);
        } catch (IOException e) {
            Log.e("message: ", e.getMessage());
        }
        story = new Story(inputStream);

        // get the placeholder for the correct story
        editText.setHint(story.getNextPlaceholder());
        button.setText("remaining words: " + story.getPlaceholderRemainingCount());

    }

        protected void onSaveInstanceState(Bundle out) {
            super.onSaveInstanceState(out);
            String buttonstring = button.getText().toString();
            String hint = editText.getHint().toString();
            out.putSerializable("story", story);
            out.putString("button", buttonstring);
            out.putString("hint", hint);


        }
        protected void onRestoreInstanceState(Bundle in) {
            super.onRestoreInstanceState(in);
            story = (Story) in.getSerializable("story");
            button.setText(in.getString("button"));
            editText.setHint(in.getString("hint"));
        }


    public void clicked(View view) {

        String word = editText.getText().toString();
        if (word.length() == 0){
            Toast.makeText(getApplicationContext(), "a " + story.getNextPlaceholder() + " needs to have at least 1 character", Toast.LENGTH_SHORT).show();
        }
        else {
            if(story.getPlaceholderRemainingCount() > 1) {
                story.fillInPlaceholder(word);
                editText.setText("");
                editText.setHint(story.getNextPlaceholder());
                if (story.getPlaceholderRemainingCount() >= 2) {
                    button.setText("remaining words: " + story.getPlaceholderRemainingCount() );
                }
                else{
                    button.setText("go to story");
                }
            }
            else if(story.getPlaceholderRemainingCount() == 1) {
                button.setText("Go to Story");
                story.fillInPlaceholder(word);
                Intent intent = new Intent(this, third_activity.class);
                String storyText = story.toString();
                intent.putExtra("story", storyText);
                // starts the new activity
                startActivity(intent);
                finish();
            }




        }





    }
}
